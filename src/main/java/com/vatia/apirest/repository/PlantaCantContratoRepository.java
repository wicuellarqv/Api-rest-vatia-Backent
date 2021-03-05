package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.vatia.apirest.model.PlantaCantContrato;

public interface PlantaCantContratoRepository extends CrudRepository<PlantaCantContrato, Integer> {

	@Query(value = "SELECT *" + 
			"  FROM dbo.tbl_planta_cant_contrato where contrato = :idContrato", nativeQuery = true)
	public List<PlantaCantContrato> nativeFindByIdContrato(Integer idContrato);
}
