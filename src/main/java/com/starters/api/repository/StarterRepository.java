package com.starters.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starters.api.model.Starter;

public interface StarterRepository extends JpaRepository<Starter, Long>{

}
