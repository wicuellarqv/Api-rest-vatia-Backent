package com.vatia.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.vatia.apirest.model.Contratos60Meses;

public interface Contratos60MesesRepository extends CrudRepository<Contratos60Meses,Integer> {

	public Contratos60Meses findById(int id);
	
	public Contratos60Meses findByNumCodContrato(Integer codContrato);
}
