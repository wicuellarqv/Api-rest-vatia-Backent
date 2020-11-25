package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.TiposContratos;

public interface TipoContratoRepository extends JpaRepository<TiposContratos, Integer>{
	
}
