package com.vatia.apirest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.vatia.apirest.repository.ConsultaRepository;
import com.vatia.apirest.service.ConsultaService;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.GarantiasResponse;
import com.vatia.apirest.utils.PreciosResponse;
import com.vatia.apirest.utils.TipoCantidadResponse;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	@Autowired
	private ConsultaRepository consultaRepository;
	// @Autowired
	/**
	 * Query a obtener	
	 * select 
		c.num_id_contrato id_contrato, 
		c.num_contrato num_contrato,
		c.str_codigo_sic_contrato cod_sic_contrato,
		nc.str_desc_negoc_contrato negociacion,
		tc.str_desc_tipo_contrato tipo_contrato,
		ctc.str_desc_condicion_tipo_contrato condicion,
		tm.str_desc_tipo_mercado tipo_mercado,
		--c.num_id_agnte_ccial_comp id_comprador,
		a.str_nombre_agente_ccial comprador,
		--c.num_id_agnte_ccial_vend id_vendedor,
		ag.str_nombre_agente_ccial vendedor,
		c.dtm_periodo_fin fecha_fin,
		c.dtm_periodo_inicio fecha_inicio,
		c.str_estado estado
		from tbl_contratos c 
		inner join tbl_condiciones_tipos_contratos ctc on c.num_id_condicion_tipo_contrato=ctc.num_id_condicion_tipo_contrato
		inner join tbl_negoc_contratos nc on c.num_id_negoc_contrato=nc.num_id_negoc_contrato
		inner join tbl_tipos_contratos tc on c.num_id_tipo_contrato=tc.num_id_tipo_contrato
		inner join tbl_agentes_comerciales a on c.num_id_agnte_ccial_comp=a.num_id_agente_ccial
		inner join tbl_agentes_comerciales ag on c.num_id_agnte_ccial_vend= ag.num_id_agente_ccial
		inner join tbl_tipos_mercados tm on c.num_id_tipo_mercado=tm.num_id_tipo_mercado

	 * @param obj
	 * @return
	 */
	public String createQuery(JSONObject obj) {
		String codcontrato = obj.get("codcontrato").toString();
		String nombreCliente = obj.get("nombreCliente").toString();
		String contratoSic = obj.get("contratoSic").toString();
		String estado = obj.get("estado").toString();
		String query = "Select * from tbl_contratos C";
		if(!codcontrato.isEmpty()) {
			query+="where C.num_id_contrato = " + codcontrato;
		}
		
		return query;
		
	}
	
	@Override
	public List<JsonObject> contratos(JSONObject obj) {
		String tipoMercado = obj.get("contratoSic").toString();

		return this.consultaRepository.filtro(tipoMercado);
	}

	/**
	 * 
	 */
	@Override
	public ContratoDetailResponse findById(String idContrato) {
		String queryResult = this.consultaRepository.detalle(idContrato);
		String[] args = queryResult.split(",");
		ContratoDetailResponse cdr = new ContratoDetailResponse(args);
		cdr.setPrecios(this.preciosContrato(idContrato));
		cdr.setCantidad(this.tipoCantidad(idContrato));
		cdr.setGarantias(this.garantias(idContrato));
		return cdr;
	}

	@Override
	public List<PreciosResponse> preciosContrato(String idContrato) {
		List<PreciosResponse> precios = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.precios(idContrato);
		for (String object : resulQuery) {
			precios.add(new PreciosResponse(object.split(",")));
		}
		return precios;
	}
	
	@Override
	public List<TipoCantidadResponse> tipoCantidad(String idContrato) {
		List<TipoCantidadResponse> cantidad = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.cantidad(idContrato);
		for (String object : resulQuery) {
			cantidad.add(new TipoCantidadResponse(object.split(",")));
		}
		return cantidad;
	}
	
	@Override
	public List<GarantiasResponse> garantias(String idContrato) {
		List<GarantiasResponse> garantia = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.cantidad(idContrato);
		for (String object : resulQuery) {
			garantia.add(new GarantiasResponse(object.split(",")));
		}
		return garantia;
	}
}
