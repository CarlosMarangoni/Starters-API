package com.starters.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"submissao_desafio_codigo"})})
public class NotaDesafio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToOne
	@NotNull
	private SubmissaoDesafio submissaoDesafio;
	
	@Min(1)
	@Max(3)
	@NotNull
	private int notaQualidadeDoCodigo;
	
	@Min(1)
	@Max(3)
	@NotNull
	private int notaQuantidadeEntregada;

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

	public int getNotaQualidadeDoCodigo() {
		return notaQualidadeDoCodigo;
	}

	public void setNotaQualidadeDoCodigo(int notaQualidadeDoCodigo) {
		this.notaQualidadeDoCodigo = notaQualidadeDoCodigo;
	}

	public int getNotaQuantidadeEntregada() {
		return notaQuantidadeEntregada;
	}

	public void setNotaQuantidadeEntregada(int notaQuantidadeEntregada) {
		this.notaQuantidadeEntregada = notaQuantidadeEntregada;
	}
	
	
	
}
