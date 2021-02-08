package com.vatia.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vatia.apirest.model.FechaPresupuesto;

public interface FechaPresupuestoRepository extends JpaRepository<FechaPresupuesto, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_fecha_presupuesto SET str_fecha = ?1 WHERE num_id_fecha_presupuesto =?2", nativeQuery = true)
	int updateFecha(@Param(value = "fecha") String fecha, @Param(value = "id") Integer id);
	
}

