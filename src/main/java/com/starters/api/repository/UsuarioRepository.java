package com.starters.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starters.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
}
