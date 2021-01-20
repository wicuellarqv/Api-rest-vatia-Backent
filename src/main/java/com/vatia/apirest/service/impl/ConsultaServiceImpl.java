package com.vatia.apirest.service.impl;


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

@Service
public class ConsultaServiceImpl implements ConsultaService{
	@Autowired
	private ConsultaRepository consultaRepository;
	//@Autowired
	
	
	@Override
	public List<JsonObject> contratos(JSONObject obj) {
		String tipoMercado =  obj.get("contratoSic").toString();
		
		return this.consultaRepository.findAll(tipoMercado);
	}
	
	/**
	 * 
	 */
	@Override
	public ContratoDetailResponse findById(String idContrato) {
		String queryResult = this.consultaRepository.detalle(idContrato);
		String [] args = queryResult.split(",");
		ContratoDetailResponse cdr = new ContratoDetailResponse(args);
		return cdr;
	}
	
	
	
}
