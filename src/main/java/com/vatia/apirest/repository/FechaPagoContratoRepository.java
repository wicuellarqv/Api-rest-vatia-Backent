package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.CantidadesContratos;
import com.vatia.apirest.model.FechasPagoContratos;

public interface FechaPagoContratoRepository extends JpaRepository<FechasPagoContratos, Integer>{
	
	
	@Query(value = "SELECT * FROM tbl_fechas_pago_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	 List<FechasPagoContratos> getAllFechaP(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_fechas_pago_contratos WHERE num_id_contrato = ?1", nativeQuery = true)
	int deleteId(@Param(value = "id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tbl_fechas_pago_contratos WHERE num_id_fecha_pago = ?1", nativeQuery = true)
	int deleteIdFecha(@Param(value = "id") Integer id);
	
}
