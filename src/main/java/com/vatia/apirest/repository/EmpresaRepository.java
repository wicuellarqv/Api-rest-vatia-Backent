package com.vatia.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
