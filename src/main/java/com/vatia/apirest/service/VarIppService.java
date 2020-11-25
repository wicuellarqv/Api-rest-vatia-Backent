package com.vatia.apirest.service;

import java.util.List;
import java.util.Map;
import com.vatia.apirest.model.VarIpp;
import net.minidev.json.JSONObject;

public interface VarIppService {
	
	public List<VarIpp> findAll();
	
	public List<VarIpp> findAllAnio(Integer desde, Integer hasta);
	
	public VarIpp findAnio(Integer anio);
	
	public JSONObject calcularVarIppAnio(Integer anio);

	public void save(VarIpp varIpp);

	public void deleteById(Integer id);

	public void updateVarIpc(Map<String, Object> request);
}
