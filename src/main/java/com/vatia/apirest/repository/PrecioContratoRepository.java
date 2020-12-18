package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.PreciosContratos;

public interface PrecioContratoRepository extends JpaRepository<PreciosContratos, Integer>{
	
}
