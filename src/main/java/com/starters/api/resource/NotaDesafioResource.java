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

import com.starters.api.model.NotaDesafio;
import com.starters.api.repository.NotaDesafioRepository;

@RestController
@RequestMapping("/notas")
public class NotaDesafioResource {

	@Autowired
	private NotaDesafioRepository notaDesafioRepository;

	@GetMapping
	public List<NotaDesafio> listar() {
		return notaDesafioRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<NotaDesafio> adicionar(@RequestBody NotaDesafio notaDesafio){
		
		notaDesafioRepository.save(notaDesafio);
		return ResponseEntity.status(HttpStatus.CREATED).body(notaDesafio);
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		notaDesafioRepository.deleteById(codigo);
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
	public ResponseEntity<?> editar (@RequestBody NotaDesafio notaDesafio,@PathVariable Long codigo){
		Optional<NotaDesafio> notaDesafioBuscado = notaDesafioRepository.findById(codigo);
		BeanUtils.copyProperties(notaDesafio, notaDesafioBuscado.get(),"codigo");
		notaDesafioRepository.save(notaDesafioBuscado.get());
		return ResponseEntity.ok(notaDesafioBuscado.get());
	}

}
