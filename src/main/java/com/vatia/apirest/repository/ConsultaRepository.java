package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vatia.apirest.model.Categoria;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;

public interface ConsultaRepository extends JpaRepository<Contratos, Integer>{
	final String VALUEQUERY = "SELECT * FROM tbl_contratos as C INNER JOIN tbl_tipos_mercados as TM ON "
			+ "C.num_id_tipo_mercado = :tipoMercado";
	
	final String QUERY_DETAIL_CONTRACT = "Select C.num_id_contrato as id_contrato,C.num_contrato, "
			+ "C.str_codigo_sic_contrato as codigo_sic, NC.str_desc_negoc_contrato as negocio_contrato, "
			+ "ACC.str_nombre_agente_ccial as comprador, ACV.str_nombre_agente_ccial as vendedor,"
			+ "	C.str_estado as estado, C.dtm_periodo_inicio as fecha_inicio, "
			+ "C.dtm_periodo_fin as fecha_fin, CTC.str_desc_condicion_tipo_contrato as condicion, "
			+ "CTC.str_formula_condicion_tipo_contrato as formula"
			+ "	from tbl_contratos as C"
			+ "		inner join tbl_negoc_contratos as NC ON NC.num_id_negoc_contrato = C.num_id_negoc_contrato"
			+ "		inner join tbl_agentes_comerciales as ACC ON ACC.num_id_agente_ccial = C.num_id_agnte_ccial_comp"
			+ "		inner join tbl_agentes_comerciales as ACV ON ACV.num_id_agente_ccial = C.num_id_agnte_ccial_vend"
			+ "		inner join tbl_condiciones_tipos_contratos as CTC ON  CTC.num_id_condicion_tipo_contrato = C.num_id_condicion_tipo_contrato"
			+ "		inner join tbl_tipos_mercados as TM ON TM.num_id_tipo_mercado = C.num_id_tipo_mercado"
			+ " where C.num_id_contrato = :idContrato";
			
	
	//public JsonElement findById(int id);
	@Query(value = VALUEQUERY, nativeQuery = true)
	public List<JsonObject> findAll(String tipoMercado);
	
	@Query(value= QUERY_DETAIL_CONTRACT, nativeQuery = true)
	public String detalle(String idContrato);
	
	
	
	
}
