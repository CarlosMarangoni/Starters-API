package com.starters.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starters.api.model.Starter;
import com.starters.api.repository.StarterRepository;

@RestController
@RequestMapping("/starters")
public class StarterResource {
	
	@Autowired
	private StarterRepository starterRepository;
	
	@GetMapping
	public List<Starter> listar(){
		return starterRepository.findAll();		
	}

}
