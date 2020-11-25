package com.vatia.apirest.service;

import java.util.List;
import java.util.Map;
import com.vatia.apirest.model.VarIpc;

import net.minidev.json.JSONObject;

public interface VarIpcService {
	
	public List<VarIpc> findAll();
	
	public List<VarIpc> findAllAnio(Integer desde, Integer hasta);
	
	public VarIpc findAnio(Integer anio);
	
	public JSONObject calcularVarIpcAnio(Integer anio);

	public void save(VarIpc varIpc);

	public void deleteById(Integer id);

	public void updateVarIpc(Map<String, Object> request);
}
