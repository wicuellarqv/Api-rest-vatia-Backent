package com.vatia.apirest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.Contratos;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_contratos WHERE str_llave = ?1", nativeQuery = true)
	Contratos findAllMax (String llave);
	
	@Query(value = "SELECT num_id_contrato FROM tbl_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	Integer findIdCod (Integer cod);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	int deleteId(@Param(value = "id") Integer id);	
	
	@Query(value = "SELECT  TOP 1  num_contrato FROM tbl_contratos WHERE num_contrato = ?1", nativeQuery = true)
	String idContrato (Integer id);
	
	@Query(value = "SELECT TOP 1 str_codigo_sic_contrato FROM tbl_contratos WHERE str_codigo_sic_contrato = ?1", nativeQuery = true)
	String contratoSic (String id);
}
