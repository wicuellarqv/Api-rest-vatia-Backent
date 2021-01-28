package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.Cantidad60Meses;
import com.vatia.apirest.model.PreciosContratos;

public interface PrecioContratoRepository extends JpaRepository<PreciosContratos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_precios_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	 List<PreciosContratos> getAllPrecio(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_precios_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	int deleteId(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_precios_contratos WHERE num_id_precio_contrato = ?1", nativeQuery = true)
	int deleteIdPrecio(@Param(value = "id") Integer id);
	
}
