package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.GarantiasResponse;
import com.vatia.apirest.utils.PreciosResponse;
import com.vatia.apirest.utils.TipoCantidadResponse;
import com.vatia.apirest.utils.fechaPagoResponse;

public interface ConsultaService {
	
	public List<ConsultaContratosResponse> contratos(JSONObject obj);
	public ContratoDetailResponse findById(String idContrato);
	public List<PreciosResponse> preciosContrato(String idContrato);
	public List<TipoCantidadResponse> tipoCantidad(String idContrato);
	public List<GarantiasResponse> garantias(String idContrato);
	public List<fechaPagoResponse> fechaPago (String idContrato);
}
