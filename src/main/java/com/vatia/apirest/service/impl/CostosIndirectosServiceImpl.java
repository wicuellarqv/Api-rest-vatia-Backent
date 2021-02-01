package com.vatia.apirest.service.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Costos_indirectos;
import com.vatia.apirest.model.Cuentas_CeCos_CostInd;
import com.vatia.apirest.repository.CostosIndirectosRepository;
import com.vatia.apirest.repository.CuentasCecosCostIndRepository;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.CostosIndirectosService;

@Service
public class CostosIndirectosServiceImpl implements CostosIndirectosService{
	@Autowired
    private CostosIndirectosRepository CostosIndirectosRepository;
	
	@Autowired
    private CuentasCecosCostIndRepository CuentasCecosCostIndRepository;

	@Override
	public List<Costos_indirectos> getAllPeriodo(String mes, String ano) {

		return this.CostosIndirectosRepository.getAllPeriodo(mes, ano);
	}
	
	
	@Override
	public String saveCostoInditecto(JSONObject obj) {
		
		try {
		
		Cuentas_CeCos_CostInd cuentas_CeCos_CostInd = new Cuentas_CeCos_CostInd();

		cuentas_CeCos_CostInd.setIdCostoInd(0);
		
		if(obj.get("cuentaContable") != null) {
			cuentas_CeCos_CostInd.setCuentaContable(obj.get("cuentaContable").toString());
		}
		
		if(obj.get("centroCosto") != null) {
			cuentas_CeCos_CostInd.setCentroCosto(obj.get("centroCosto").toString());
		}
		
		CuentasCecosCostIndRepository.save(cuentas_CeCos_CostInd);
		
		return "Se ha guardado con éxito !";
		
		} catch (Exception e) {
			return "Error al guardar :"+e;
		}

	}
	    
}
