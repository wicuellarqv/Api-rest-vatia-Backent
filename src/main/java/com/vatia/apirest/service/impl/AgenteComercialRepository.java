package com.vatia.apirest.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.AgentesComerciales;

@Repository
public interface AgenteComercialRepository extends JpaRepository<AgentesComerciales, Integer>{
	
	@Query(value = "SELECT * FROM tbl_agentes_comerciales I WHERE I.str_codigo_sic_agente_ccial=?1 ", nativeQuery = true)
	List<AgentesComerciales> findAllCod (String valor);

}