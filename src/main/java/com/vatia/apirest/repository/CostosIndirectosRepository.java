package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.vatia.apirest.model.Costos_indirectos;

public interface CostosIndirectosRepository extends JpaRepository<Costos_indirectos, Integer>{
	
	@Query(value = "SELECT * FROM tbl_costos_indirectos I WHERE I.str_mes_costo_ind=?1 AND I.str_year_costo_ind=?2", nativeQuery = true)
	List<Costos_indirectos> getAllPeriodo (String mes, String ano);
	
}
