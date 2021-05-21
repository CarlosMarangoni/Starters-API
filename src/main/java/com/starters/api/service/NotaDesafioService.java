package com.starters.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.api.model.NotaDesafio;
import com.starters.api.repository.NotaDesafioRepository;

@Service
public class NotaDesafioService {

	@Autowired
	private NotaDesafioRepository notaDesafioRepository;
	
	public void salvar(@Valid NotaDesafio notaDesafio) {
		notaDesafioRepository.save(notaDesafio);		
	}

	public void excluir(Long codigo) {
		notaDesafioRepository.deleteById(codigo);
		
	}
	
	

	
}
