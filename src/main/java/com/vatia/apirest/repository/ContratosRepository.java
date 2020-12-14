package com.vatia.apirest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.Contratos;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_contratos WHERE str_llave = ?1", nativeQuery = true)
	Contratos findAllMax (String llave);
	
	@Query(value = "SELECT num_id_contrato FROM tbl_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	Integer findIdCod (Integer cod);
}
