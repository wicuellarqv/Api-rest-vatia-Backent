package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.vatia.apirest.model.Costos_indirectos;


public interface CostosIndirectosService {
	
	public List<Costos_indirectos> getAllPeriodo(String mes, String ano);
	
	public String saveCostoInditecto(JSONObject obj);
	
		
}
