package com.starters.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"submissao_desafio_codigo"})})
public class NotaDesafio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToOne
	private SubmissaoDesafio submissaoDesafio;
	
	private double notaQualidadeDoCodigo;
	
	private double notaQuantidadeEntregada;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public SubmissaoDesafio getSubmissaoDesafio() {
		return submissaoDesafio;
	}

	public void setSubmissaoDesafio(SubmissaoDesafio submissaoDesafio) {
		this.submissaoDesafio = submissaoDesafio;
	}

	public double getNotaQualidadeDoCodigo() {
		return notaQualidadeDoCodigo;
	}

	public void setNotaQualidadeDoCodigo(double notaQualidadeDoCodigo) {
		this.notaQualidadeDoCodigo = notaQualidadeDoCodigo;
	}

	public double getNotaQuantidadeEntregada() {
		return notaQuantidadeEntregada;
	}

	public void setNotaQuantidadeEntregada(double notaQuantidadeEntregada) {
		this.notaQuantidadeEntregada = notaQuantidadeEntregada;
	}
	
	
	
}
