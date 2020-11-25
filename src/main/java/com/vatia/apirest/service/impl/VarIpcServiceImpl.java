package com.vatia.apirest.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.VarIpc;
import com.vatia.apirest.repository.VarIpcRepository;
import com.vatia.apirest.service.VarIpcService;

import net.minidev.json.JSONObject;

@Service
public class VarIpcServiceImpl implements VarIpcService{
	
	@Autowired       
    private VarIpcRepository varIpcRepository;

	@Override
	public List<VarIpc> findAll() {
		// TODO Auto-generated method stub
		return this.varIpcRepository.findAll();
	}

	@Override
	public List<VarIpc> findAllAnio(Integer desde, Integer hasta) {
		// TODO Auto-generated method stub
		return varIpcRepository.getAllAnio(desde, hasta);
	}
	
	@Override
	public VarIpc findAnio(Integer anio) {
		// TODO Auto-generated method stub
		return this.varIpcRepository.getVarIpcAnio(anio);
	}

	@Override
	public JSONObject calcularVarIpcAnio(Integer anio) {
		return varIpcRepository.getVariacionIpcAnio((anio-1), anio);
	}

	@Override
	public void save(VarIpc varIpc) {
		 this.varIpcRepository.save(varIpc);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVarIpc(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
	}

}
