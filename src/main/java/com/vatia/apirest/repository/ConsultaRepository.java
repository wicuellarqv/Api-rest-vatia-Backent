package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.google.gson.JsonObject;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.utils.PreciosResponse;

public interface ConsultaRepository extends JpaRepository<Contratos, Integer>{
	/**
	 * Conulta Contratos segun campos (...) 
	 */
	final String VALUEQUERY = "SELECT * FROM tbl_contratos as C INNER JOIN tbl_tipos_mercados as TM ON "
			+ "C.num_id_tipo_mercado = :tipoMercado";
	/**
	 * Consulta Contrato a Detalle segun el num_id_contrato
	 */
	final String QUERY_DETAIL_CONTRACT = "Select C.num_id_contrato as id_contrato,C.num_contrato, "
			+ "C.str_codigo_sic_contrato as codigo_sic, NC.str_desc_negoc_contrato as negocio_contrato, "
			+ "ACC.str_nombre_agente_ccial as comprador, ACV.str_nombre_agente_ccial as vendedor,"
			+ "	C.str_estado as estado, C.dtm_periodo_inicio as fecha_inicio, "
			+ "C.dtm_periodo_fin as fecha_fin, CTC.str_desc_condicion_tipo_contrato as condicion, "
			+ "CTC.str_formula_condicion_tipo_contrato as formula, "
			+ " C.str_tel_contacto as tel_contacto, C.str_nombre_contacto as nombre_contacto, "
			+ "	C.str_fecha_firma as fecha_firma, C.str_doc_contacto as documento,"
			+ "	C.str_email_contacto as email_contacto"
			+ "	from tbl_contratos as C"
			+ "		inner join tbl_negoc_contratos as NC ON NC.num_id_negoc_contrato = C.num_id_negoc_contrato"
			+ "		inner join tbl_agentes_comerciales as ACC ON ACC.num_id_agente_ccial = C.num_id_agnte_ccial_comp"
			+ "		inner join tbl_agentes_comerciales as ACV ON ACV.num_id_agente_ccial = C.num_id_agnte_ccial_vend"
			+ "		inner join tbl_condiciones_tipos_contratos as CTC ON  CTC.num_id_condicion_tipo_contrato = C.num_id_condicion_tipo_contrato"
			+ "		inner join tbl_tipos_mercados as TM ON TM.num_id_tipo_mercado = C.num_id_tipo_mercado"
			+ " where C.num_id_contrato = :idContrato";
			
	 final String PRECIOS_CONTRATOS = "SELECT PC.dtm_mes_base as periodo_negociacion, FP.str_formula_precio as formula,"
	 		+ "	PC.dtm_periodo_precio as periodo_precio, PC.num_precio_referencia as precio_referencia"
	 		+ "  FROM [webapp_tradebalance].[dbo].[tbl_tipos_precio] as TP"
	 		+ "	  inner JOIN tbl_precios_contratos as PC ON  PC.num_id_tipo_precio= TP.num_id_tipo_precio"
	 		+ "	  inner Join tbl_formulas_precios as FP ON FP.num_id_formula_precio = PC.num_id_formula_precio"
	 		+ "  WHERE PC.num_id_contrato = :idContrato";
	 
	 final String TIPO_CANTIDAD = "Select TC.str_desc_tipo_cantidad as tipoCantidad, CC.dtm_fecha_cantidad as fecha, "
	 		+ " CC.num_h1 as hora1, CC.num_h2 as hora2, "
	 		+ "	CC.num_h3 as hora3, CC.num_h4 as hora4, CC.num_h5 as hora5, CC.num_h6 as hora6 "
	 		+ "from tbl_tipos_cantidad as TC "
	 		+ "	inner join tbl_cantidad_contratos as CC ON TC.num_id_tipo_cantidad = CC.num_id_tipo_cantidad "
	 		+ "where CC.num_id_contrato = :idContrato";
	
	final String TIPO_GARANTIA = "Select TG.str_desc_tipo_garantia, GC.num_cantidad_garantia as cantidad, GC.num_tasa_garantia as tasa, "
			+ "	GC.num_iva_garantia as iva, GC.num_prima_garantia as prima, GC.num_costo_garantia as costo, "
			+ "	GC.num_valor_garantia as valor, dtm_fecha_inicio_garantia as fecha_inicio, dtm_fecha_fin_garantia as fecha_fin, "
			+ "	dtm_fecha_entrega_garantia as fecha_entrega "
			+ "from tbl_garantias_contratos as GC "
			+ "	inner join tbl_contratos as C ON GC.num_id_contrato = C.num_id_contrato "
			+ "	inner join tbl_tipos_garantias as TG ON GC.num_id_tipo_garantia = TG.num_id_tipo_garantia"
			+ "where C.num_id_contrato = :idContrato";
	
	@Query(value = VALUEQUERY, nativeQuery = true)
	public List<JsonObject> filtro(String tipoMercado);
	
	@Query(value= QUERY_DETAIL_CONTRACT, nativeQuery = true)
	public String detalle(String idContrato);
	
	@Query(value = PRECIOS_CONTRATOS, nativeQuery=true)
	public List<String> precios(String idContrato);
	
	@Query(value = TIPO_CANTIDAD, nativeQuery=true)
	public List<String> cantidad (String idContrato); 
	
	@Query(value= TIPO_GARANTIA, nativeQuery = true)
	public List<String> garantia (String idContrato);
	
	
}
