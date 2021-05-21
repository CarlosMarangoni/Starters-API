package com.starters.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.api.model.Starter;
import com.starters.api.repository.StarterRepository;

@Service
public class StarterService {

	@Autowired
	private StarterRepository starterRepository;
	
	public void salvar(@Valid Starter starter) {
		starterRepository.save(starter);		
	}

	public void excluir(Long codigo) {
		starterRepository.deleteById(codigo);
		
	}
	
	

	
}
