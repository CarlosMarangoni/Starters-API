package com.starters.api.resource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

@RestController
@RequestMapping("/starters")
public class StarterResource {

	@Autowired
	private StarterRepository starterRepository;

	@GetMapping
	public List<Starter> listar() {
		return starterRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Starter> adicionar(@Valid @RequestBody Starter starter){
		
		starterRepository.save(starter);
		return ResponseEntity.status(HttpStatus.CREATED).body(starter);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		starterRepository.deleteById(codigo);
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
	public ResponseEntity<?> editar (@RequestBody Starter starter,@PathVariable Long codigo){
		Optional<Starter> starterBuscado = starterRepository.findById(codigo);
		if(starterBuscado.isEmpty()) {
			throw new NoSuchElementException("No resource found with id " + codigo);
		}
		BeanUtils.copyProperties(starter, starterBuscado.get(),"codigo");
		starterRepository.save(starterBuscado.get());
		return ResponseEntity.ok(starterBuscado.get());
	}

}
