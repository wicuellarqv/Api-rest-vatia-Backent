package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.CantidadesContratos;

public interface CantidadRepository extends JpaRepository<CantidadesContratos, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_cantidad_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	int deleteId(@Param(value = "id") Integer id);
	
}
