package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vatia.apirest.model.Ipc;
import com.vatia.apirest.model.Margenes_cciales;

public interface MComercialesRepository extends JpaRepository<Margenes_cciales, Integer>{
	
	@Query(value = "SELECT * FROM tbl_margenes_cciales I WHERE I.dtm_fecha_captura BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Margenes_cciales> getAllAnio (String desde, String hasta);
	
	@Query(value = "SELECT * FROM tbl_margenes_cciales I WHERE I.dtm_fecha_captura BETWEEN ?1 AND ?2 AND dtm_version = ?3", nativeQuery = true)
	List<Margenes_cciales> getAllAnioV (String desde, String hasta, String version);
	
}
