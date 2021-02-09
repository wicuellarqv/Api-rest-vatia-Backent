package com.vatia.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.vatia.apirest.model.Cuentas_CeCos_CostInd;

public interface CuentasCecosCostIndRepository extends JpaRepository<Cuentas_CeCos_CostInd, Integer>{
	
	@Query(value = "SELECT TOP (1) num_id_cuenta_ceco FROM tbl_cuentas_cecos_cost_ind WHERE str_centro_costo=?1 AND str_cuenta_contable=?2", nativeQuery = true)
	 String validaIdCenco(@Param(value = "centro_costo") String centro_costo, @Param(value = "cuenta_contable") String cuenta_contable);
	
}

