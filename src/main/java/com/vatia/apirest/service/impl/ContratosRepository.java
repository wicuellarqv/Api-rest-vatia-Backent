package com.vatia.apirest.service.impl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.Contratos;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_contratos WHERE num_id_contrato = (SELECT MAX(num_id_contrato) FROM tbl_contratos)", nativeQuery = true)
	Contratos findAllMax ();
}
