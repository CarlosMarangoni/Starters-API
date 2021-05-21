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

import com.starters.api.model.NotaDesafio;
import com.starters.api.repository.NotaDesafioRepository;
import com.starters.api.service.NotaDesafioService;

@RestController
@RequestMapping("/notas")
public class NotaDesafioResource {

	@Autowired
	private NotaDesafioRepository notaDesafioRepository;
	
	@Autowired
	private NotaDesafioService notaDesafioService;

	@GetMapping
	public Page<NotaDesafio> listar(@PageableDefault(sort = "codigo",direction = Direction.ASC) Pageable paginacao) {
		return notaDesafioRepository.findAll(paginacao);
	}

	@PostMapping
	public ResponseEntity<NotaDesafio> adicionar(@Valid @RequestBody NotaDesafio notaDesafio){
		
		notaDesafioService.salvar(notaDesafio);
		return ResponseEntity.status(HttpStatus.CREATED).body(notaDesafio);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		notaDesafioService.excluir(codigo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long codigo) {
		Optional<NotaDesafio> notaDesafio = notaDesafioRepository.findById(codigo);
		if(notaDesafio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(notaDesafio.get());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar (@Valid @RequestBody NotaDesafio notaDesafio,@PathVariable Long codigo){
		Optional<NotaDesafio> notaDesafioBuscado = notaDesafioRepository.findById(codigo);
		if(notaDesafioBuscado.isEmpty()) {
			throw new NoSuchElementException("No resource found with id " + codigo);
		}
		BeanUtils.copyProperties(notaDesafio, notaDesafioBuscado.get(),"codigo");
		notaDesafioService.salvar(notaDesafioBuscado.get());
		return ResponseEntity.ok(notaDesafioBuscado.get());
	}

}
