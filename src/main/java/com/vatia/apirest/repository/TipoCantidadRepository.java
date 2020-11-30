package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.TiposCantidad;

public interface TipoCantidadRepository extends JpaRepository<TiposCantidad, Integer>{
	
}
