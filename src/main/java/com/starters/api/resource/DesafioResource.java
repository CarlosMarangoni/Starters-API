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

import com.starters.api.model.Desafio;
import com.starters.api.repository.DesafioRepository;
import com.starters.api.service.DesafioService;

@RestController
@RequestMapping("/desafios")
public class DesafioResource {

	@Autowired
	private DesafioRepository desafioRepository;
	
	@Autowired
	private DesafioService desafioService;

	@GetMapping
	public Page<Desafio> listar(@PageableDefault(sort = "codigo",direction = Direction.ASC) Pageable paginacao) {
		
		
		return desafioRepository.findAll(paginacao); 
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long codigo) {
		Optional<Desafio> desafio = desafioRepository.findById(codigo);
		if(desafio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(desafio.get());
	}
	

	@PostMapping
	public ResponseEntity<Desafio> adicionar(@Valid @RequestBody Desafio desafio){
		
		desafioService.salvar(desafio);
		return ResponseEntity.status(HttpStatus.CREATED).body(desafio);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		desafioService.excluir(codigo);
	}
	
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar (@Valid @RequestBody Desafio desafio,@PathVariable Long codigo){
		Optional<Desafio> desafioBuscado = desafioRepository.findById(codigo);
		if(desafioBuscado.isEmpty()) {
			throw new NoSuchElementException("No resource found with id " + codigo);
		}
		BeanUtils.copyProperties(desafio, desafioBuscado.get(),"codigo");
		desafioService.salvar(desafioBuscado.get());
		return ResponseEntity.ok(desafioBuscado.get());
	}

}
