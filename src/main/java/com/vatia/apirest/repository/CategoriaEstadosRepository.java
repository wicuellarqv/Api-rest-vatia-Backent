package com.vatia.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.vatia.apirest.model.CategoriaCliente;
import com.vatia.apirest.model.CategoriaEstado;

public interface CategoriaEstadosRepository extends CrudRepository<CategoriaEstado, Integer> {

}
