package com.starters.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.api.model.SubmissaoDesafio;
import com.starters.api.repository.SubmissaoDesafioRepository;

@Service
public class SubmissaoDesafioService {

	@Autowired
	private SubmissaoDesafioRepository submissaoDesafioRepository;
	
	public SubmissaoDesafio salvar(@Valid SubmissaoDesafio submissaoDesafio) {
		return submissaoDesafioRepository.save(submissaoDesafio);		
	}

	public void excluir(Long codigo) {
		submissaoDesafioRepository.deleteById(codigo);
		
	}
	
	

	
}
