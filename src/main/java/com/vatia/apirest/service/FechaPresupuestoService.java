package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.vatia.apirest.model.FechaPresupuesto;


public interface FechaPresupuestoService {
	
	
	public String saveFechaPresupuesto(JSONObject obj);
	
	public String updateFechaPresupuesto(JSONObject obj);
	
	public List<FechaPresupuesto> getAllFechaPresupuesto();
	
		
}
