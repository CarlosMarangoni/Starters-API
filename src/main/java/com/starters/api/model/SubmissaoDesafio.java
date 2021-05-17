package com.starters.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"starter_codigo","desafio_codigo"})})
public class SubmissaoDesafio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "starter_codigo")
	@NotNull
	private Starter starter;
	
	@ManyToOne
	@JoinColumn(name = "desafio_codigo")
	@NotNull
	private Desafio desafio;
	
	@NotNull
	private String endRepositorio;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

	public String getEndRepositorio() {
		return endRepositorio;
	}

	public void setEndRepositorio(String endRepositorio) {
		this.endRepositorio = endRepositorio;
	}
	
	
}
