package com.starters.api.controller.dto;

public class TokenDto {

	private String token;
	private String tipo;

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	
}
