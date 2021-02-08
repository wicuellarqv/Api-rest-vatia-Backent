package com.vatia.apirest.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.vatia.apirest.model.Costos_indirectos;
import com.vatia.apirest.model.Cuentas_CeCos_CostInd;


public interface CostosIndirectosService {
	
	public List<Costos_indirectos> getAllPeriodo(String mes, String ano);
	
	public String deleteCenCost(Integer id);
	
	public String saveCostoInditecto(JSONObject obj);
	
	public String validaCuenCenC(JSONObject obj);
	
	public List<Cuentas_CeCos_CostInd> getAllCuentasCecos();
	
		
}
