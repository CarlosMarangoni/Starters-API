package com.starters.api.resource;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.starters.api.model.SubmissaoDesafio;
import com.starters.api.repository.SubmissaoDesafioRepository;
import com.starters.api.service.SubmissaoDesafioService;

@RestController
@RequestMapping("/submissoes")
public class SubmissaoDesafioResource {

	@Autowired
	private SubmissaoDesafioRepository submissaoDesafioRepository;
	@Autowired
	private SubmissaoDesafioService submissaoDesafioService;

	@GetMapping
	public Page<SubmissaoDesafio> listar(@PageableDefault(sort = "codigo",direction = Direction.ASC) Pageable paginacao) {
		return submissaoDesafioRepository.findAll(paginacao);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SubmissaoDesafio adicionar(@Valid @RequestBody SubmissaoDesafio submissaoDesafio){		
		return submissaoDesafioService.salvar(submissaoDesafio);		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		submissaoDesafioService.excluir(codigo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long codigo) {
		Optional<SubmissaoDesafio> submissaoDesafio = submissaoDesafioRepository.findById(codigo);
		if(submissaoDesafio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(submissaoDesafio.get());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar (@Valid @RequestBody SubmissaoDesafio submissaoDesafio,@PathVariable Long codigo){
		Optional<SubmissaoDesafio> submissaoDesafioBuscado = submissaoDesafioRepository.findById(codigo);
		if(submissaoDesafioBuscado.isEmpty()) {
			throw new NoSuchElementException("No resource found with id " + codigo);
		}
		BeanUtils.copyProperties(submissaoDesafio, submissaoDesafioBuscado.get(),"codigo");
		submissaoDesafioService.salvar(submissaoDesafioBuscado.get());
		return ResponseEntity.ok(submissaoDesafioBuscado.get());
	}

}
