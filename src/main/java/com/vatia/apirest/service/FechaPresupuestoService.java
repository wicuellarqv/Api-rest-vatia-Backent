package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.vatia.apirest.model.FechaPresupuesto;


public interface FechaPresupuestoService {
	
	
	public FechaPresupuesto saveFechaPresupuesto(FechaPresupuesto fechaPresupuesto);
	
	public FechaPresupuesto updateFechaPresupuesto(FechaPresupuesto fechaPresupuesto);
	
	public void deleteFechaPresupuesto(FechaPresupuesto fechaPresupuesto);
	
	public List<FechaPresupuesto> getAllFechaPresupuesto();
	
	public List<FechaPresupuesto> getAllFechaPresupuestoByAnio(String ano);
	
		
}
