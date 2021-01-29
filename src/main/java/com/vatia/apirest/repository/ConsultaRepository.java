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
	final String QUERY_DETAIL_CONTRACT = "Select distinct\r\n"
			+ "C.num_id_contrato as id_contrato,\r\n"
			+ "C.num_contrato,  \r\n"
			+ "C.str_codigo_sic_contrato as codigo_sic, \r\n"
			+ "NC.str_desc_negoc_contrato as negocio_contrato,  \r\n"
			+ "ACC.str_nombre_agente_ccial as comprador, \r\n"
			+ "ACV.str_nombre_agente_ccial as vendedor, \r\n"
			+ "C.str_estado as estado, \r\n"
			+ "C.dtm_periodo_inicio as fecha_inicio,  \r\n"
			+ "C.dtm_periodo_fin as fecha_fin, \r\n"
			+ "CTC.str_desc_condicion_tipo_contrato as condicion,  \r\n"
			+ "C.str_tel_contacto as tel_contacto, \r\n"
			+ "C.str_nombre_contacto as nombre_contacto,  \r\n"
			+ "C.str_fecha_firma as fecha_firma,\r\n"
			+ "C.str_doc_contacto as documento, \r\n"
			+ "C.str_email_contacto as email_contacto,\r\n"
			+ "tc.str_desc_tipo_contrato as tipo_contrato,\r\n"
			+ "tm.str_desc_tipo_mercado as tipo_mercado,\r\n"
			+ "tp.str_desc_tipo_precio as tipo_precio,\r\n"
			+ "fp.str_desc_formula_precio as formula_precio,\r\n"
			+ "tca.str_desc_tipo_cantidad as tipo_cantidad,\r\n"
			+ "tga.str_desc_tipo_garantia as tipo_garantia\r\n"
			+ "from tbl_contratos as C \r\n"
			+ "	inner join tbl_negoc_contratos as NC ON NC.num_id_negoc_contrato = C.num_id_negoc_contrato \r\n"
			+ "	inner join tbl_agentes_comerciales as ACC ON ACC.num_id_agente_ccial = C.num_id_agnte_ccial_comp \r\n"
			+ "	inner join tbl_agentes_comerciales as ACV ON ACV.num_id_agente_ccial = C.num_id_agnte_ccial_vend \r\n"
			+ "	inner join tbl_condiciones_tipos_contratos as CTC ON  CTC.num_id_condicion_tipo_contrato = C.num_id_condicion_tipo_contrato \r\n"
			+ "	inner join tbl_tipos_mercados as TM ON TM.num_id_tipo_mercado = C.num_id_tipo_mercado \r\n"
			+ "	inner join tbl_tipos_contratos tc on c.num_id_tipo_contrato=tc.num_id_tipo_contrato\r\n"
			+ "	inner join tbl_precios_contratos pc on c.num_id_contrato=pc.num_id_contrato\r\n"
			+ "	inner join tbl_cantidad_contratos cc on c.num_id_contrato=cc.num_id_contrato\r\n"
			+ "	inner join tbl_garantias_contratos gc on c.num_id_contrato=gc.num_id_contrato\r\n"
			+ "	inner join tbl_tipos_precio tp on tp.num_id_tipo_precio=pc.num_id_tipo_precio\r\n"
			+ "	inner join tbl_formulas_precios fp on fp.num_id_formula_precio=pc.num_id_formula_precio\r\n"
			+ "	inner join tbl_tipos_cantidad tca on cc.num_id_tipo_cantidad=tca.num_id_tipo_cantidad\r\n"
			+ "	inner join tbl_tipos_garantias tga on tga.num_id_tipo_garantia = gc.num_id_tipo_garantia\r\n"
			+ "where C.num_id_contrato = :idContrato";
			
	 final String PRECIOS_CONTRATOS = "SELECT  \r\n"
	 		+ "dtm_mes_base as periodo_negociacion,  \r\n"
	 		+ "dtm_periodo_precio as periodo_precio,  \r\n"
	 		+ "num_precio_referencia as precio_referencia,\r\n"
	 		+ "num_precio_periodo as precio,\r\n"
	 		+ "PC.dtm_mes_base as mes_referencia\r\n"
	 		+ "FROM [webapp_tradebalance].[dbo].[tbl_tipos_precio] as TP  \r\n"
	 		+ "inner Join tbl_precios_contratos as PC ON  PC.num_id_tipo_precio= TP.num_id_tipo_precio  \r\n"
	 		+ "inner Join tbl_formulas_precios as FP ON FP.num_id_formula_precio = PC.num_id_formula_precio  \r\n"
	 		+ "WHERE PC.num_id_contrato = :idContrato";
	 
	 final String TIPO_CANTIDAD = "Select \r\n"
	 		+ "TC.str_desc_tipo_cantidad as tipoCantidad, \r\n"
	 		+ "CC.dtm_fecha_cantidad as fecha,  \r\n"
	 		+ "CC.num_h1 as hora1, \r\n"
	 		+ "CC.num_h2 as hora2,  \r\n"
	 		+ "CC.num_h3 as hora3, \r\n"
	 		+ "CC.num_h4 as hora4, \r\n"
	 		+ "CC.num_h5 as hora5, \r\n"
	 		+ "CC.num_h6 as hora6,  \r\n"
	 		+ "CC.num_h7 as hora7, \r\n"
	 		+ "CC.num_h8 as hora8,  \r\n"
	 		+ "CC.num_h9 as hora9, \r\n"
	 		+ "CC.num_h10 as hora10, \r\n"
	 		+ "CC.num_h11 as hora11, \r\n"
	 		+ "CC.num_h11 as hora12, \r\n"
	 		+ "CC.num_h13 as hora13, \r\n"
	 		+ "CC.num_h14 as hora14, \r\n"
	 		+ "CC.num_h15 as hora15,  \r\n"
	 		+ "CC.num_h16 as hora16, \r\n"
	 		+ "CC.num_h17 as hora17, \r\n"
	 		+ "CC.num_h18 as hora18, \r\n"
	 		+ "CC.num_h19 as hora19,\r\n"
	 		+ "CC.num_h20 as hora20, \r\n"
	 		+ "CC.num_h21 as hora21, \r\n"
	 		+ "CC.num_h22 as hora22, \r\n"
	 		+ "CC.num_h23 as hora23, \r\n"
	 		+ "CC.num_h24 as hora24\r\n"
	 		+ "from tbl_tipos_cantidad as TC  \r\n"
	 		+ "inner join tbl_cantidad_contratos as CC ON TC.num_id_tipo_cantidad = CC.num_id_tipo_cantidad  \r\n"
	 		+ "where CC.num_id_contrato = :idContrato";
	
	final String TIPO_GARANTIA = "Select \r\n"
			+ "TG.str_desc_tipo_garantia as tipo_garantia,\r\n"
			+ "GC.num_tasa_garantia as tasa,  \r\n"
			+ "GC.num_iva_garantia as iva, \r\n"
			+ "GC.num_prima_garantia as prima, \r\n"
			+ "GC.num_costo_garantia as costo,  \r\n"
			+ "GC.num_valor_garantia as valor, \r\n"
			+ "dtm_fecha_inicio_garantia as fecha_inicio, \r\n"
			+ "dtm_fecha_fin_garantia as fecha_fin,  \r\n"
			+ "dtm_fecha_entrega_garantia as fecha_entrega,\r\n"
			+ "GC.str_ipp_actualizacion_garantia as ipp_garantia,\r\n"
			+ "GC.num_cantidad_garantia as cantidad\r\n"
			+ "from tbl_garantias_contratos as GC  \r\n"
			+ "inner join tbl_contratos as C ON GC.num_id_contrato = C.num_id_contrato  \r\n"
			+ "inner join tbl_tipos_garantias as TG ON GC.num_id_tipo_garantia = TG.num_id_tipo_garantia  \r\n"
			+ "where C.num_id_contrato = :idContrato";
	
	final String FECHA_PAGO = "SELECT [num_id_fecha_pago]\r\n"
			+ "      ,[dtm_fecha_pago_periodo]\r\n"
			+ "      ,[num_id_contrato]\r\n"
			+ "      ,[str_periodo_pago]\r\n"
			+ "  FROM [webapp_tradebalance].[dbo].[tbl_fechas_pago_contratos]\r\n"
			+ "  where num_id_contrato = :idContrato";
	
	
	@Query(value= QUERY_DETAIL_CONTRACT, nativeQuery = true)
	public String detalle(String idContrato);
	
	@Query(value = PRECIOS_CONTRATOS, nativeQuery=true)
	public List<String> precios(String idContrato);
	
	@Query(value = TIPO_CANTIDAD, nativeQuery=true)
	public List<String> cantidad (String idContrato); 
	
	@Query(value= TIPO_GARANTIA, nativeQuery = true)
	public List<String> garantia (String idContrato);
	
	@Query(value= FECHA_PAGO, nativeQuery = true)
	public List<String> fechaPago (String idContrato);
	
	
}
