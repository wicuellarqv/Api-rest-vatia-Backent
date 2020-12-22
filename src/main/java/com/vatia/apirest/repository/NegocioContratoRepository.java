package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.NegociacionesContratos;

public interface NegocioContratoRepository extends JpaRepository<NegociacionesContratos, Integer>{
	
}
