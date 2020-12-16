package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.CantidadesContratos;

public interface CantidadRepository extends JpaRepository<CantidadesContratos, Integer>{
	
}
