package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vatia.apirest.model.Cantidad60Meses;

public interface Cantidad60MesesRepository extends CrudRepository<Cantidad60Meses,Integer> {

	@Query(value = "SELECT *" + 
			"  FROM dbo.tbl_cantidad_60_meses where id_contrato_60_meses = :id ", nativeQuery = true)
	public List<Cantidad60Meses> nativeFindByContratos60Meses(Integer id);
	
	public Cantidad60Meses findById(int id);
	
	@Query(value = "SELECT *" + 
			"  FROM dbo.tbl_cantidad_60_meses where id_contrato_60_meses = :id and dtm_periodo = :periodo", nativeQuery = true)
	public Cantidad60Meses findByDtmPeriodoAndContratoNative(Integer id,String periodo);
}
