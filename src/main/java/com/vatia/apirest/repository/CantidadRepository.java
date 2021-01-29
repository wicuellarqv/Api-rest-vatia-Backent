package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.CantidadesContratos;
import com.vatia.apirest.model.PreciosContratos;

public interface CantidadRepository extends JpaRepository<CantidadesContratos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_cantidad_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	 List<CantidadesContratos> getAllCantidad(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_cantidad_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	int deleteId(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_cantidad_contratos WHERE num_id_cantidad_contrato = ?1", nativeQuery = true)
	int deleteIdCant(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_cantidad_contratos SET num_id_tipo_cantidad = 2 where num_id_contrato = 69 ", nativeQuery = true)
	int updateTipoCan(@Param(value = "tipoCantidad") Integer tipoCantidad, @Param(value = "idcontrato") Integer idcontrato);
	
}
