package com.starters.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/desafios")
public class DesafioResource {

	@Autowired
	private DesafioRepository desafioRepository;

	@GetMapping
	public List<Desafio> listar() {
		return desafioRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Desafio> adicionar(@RequestBody Desafio desafio){
		
		desafioRepository.save(desafio);
		return ResponseEntity.status(HttpStatus.CREATED).body(desafio);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		desafioRepository.deleteById(codigo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long codigo) {
		Optional<Desafio> desafio = desafioRepository.findById(codigo);
		if(desafio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(desafio.get());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> editar (@RequestBody Desafio desafio,@PathVariable Long codigo){
		Optional<Desafio> desafioBuscado = desafioRepository.findById(codigo);
		BeanUtils.copyProperties(desafio, desafioBuscado.get(),"codigo");
		desafioRepository.save(desafioBuscado.get());
		return ResponseEntity.ok(desafioBuscado.get());
	}

}