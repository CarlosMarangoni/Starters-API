package com.starters.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationService autenticacaoService;
	
	
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	
	
	//Configuracoes de Autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/submissoes").hasAnyAuthority("STARTER")
		.antMatchers(HttpMethod.POST).hasAnyAuthority("INSTRUTOR")
		.antMatchers(HttpMethod.GET).hasAnyAuthority("INSTRUTOR")
		.anyRequest().authenticated();
	}
	
	//Configuracoes de recursos estaticos(js,css,imagens,etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
		
	
}
