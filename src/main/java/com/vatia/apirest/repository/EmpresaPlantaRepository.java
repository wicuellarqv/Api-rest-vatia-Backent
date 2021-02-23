package com.vatia.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.EmpresaPlanta;

@Repository
public interface EmpresaPlantaRepository extends CrudRepository<EmpresaPlanta, Integer> {

}
