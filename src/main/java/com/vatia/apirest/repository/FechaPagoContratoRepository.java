package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.FechasPagoContratos;

public interface FechaPagoContratoRepository extends JpaRepository<FechasPagoContratos, Integer>{
	
}
