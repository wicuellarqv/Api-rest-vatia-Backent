package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.vatia.apirest.model.Precios60Meses;

public interface Precios60MesesRepository extends CrudRepository<Precios60Meses,Integer> {

	@Query(value = "SELECT *" + 
			"  FROM dbo.tbl_precios_60_meses where id_contrato_60_meses = :id and dtm_periodo = :periodo", nativeQuery = true)
	public Precios60Meses findByDtmPeriodoAndContratoNative(Integer id,String periodo);
}
