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

import com.starters.api.model.Starter;
import com.starters.api.repository.StarterRepository;
import com.starters.api.service.StarterService;

@RestController
@RequestMapping("/starters")
public class StarterResource {

	@Autowired
	private StarterRepository starterRepository;
	
	@Autowired
	private StarterService starterService;

	@GetMapping
	public Page<Starter> listar(@PageableDefault(sort = "codigo",direction = Direction.ASC) Pageable paginacao) {
		
		return starterRepository.findAll(paginacao);
	}

	@PostMapping
	public ResponseEntity<Starter> adicionar(@Valid @RequestBody Starter starter){
		
		starterService.salvar(starter);
		return ResponseEntity.status(HttpStatus.CREATED).body(starter);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		starterService.excluir(codigo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long codigo) {
		Optional<Starter> starter = starterRepository.findById(codigo);
		if(starter.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(starter.get());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar (@Valid @RequestBody Starter starter,@PathVariable Long codigo){
		Optional<Starter> starterBuscado = starterRepository.findById(codigo);
		if(starterBuscado.isEmpty()) {
			throw new NoSuchElementException("No resource found with id " + codigo);
		}
		BeanUtils.copyProperties(starter, starterBuscado.get(),"codigo");
		starterService.salvar(starterBuscado.get());
		return ResponseEntity.ok(starterBuscado.get());
	}

}
