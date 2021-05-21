package com.starters.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.api.model.Desafio;
import com.starters.api.repository.DesafioRepository;

@Service
public class DesafioService {

	@Autowired
	private DesafioRepository desafioRepository;
	
	public void salvar(@Valid Desafio desafio) {
		desafioRepository.save(desafio);		
	}

	public void excluir(Long codigo) {
		desafioRepository.deleteById(codigo);
		
	}
	
	

	
}
