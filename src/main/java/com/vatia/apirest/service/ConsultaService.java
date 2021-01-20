package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;
import com.vatia.apirest.utils.ContratosRequest;

public interface ConsultaService {
	
	public List<JsonObject> contratos(JSONObject obj);
	public ContratoDetailResponse findById(String idContrato);
	
	
}
