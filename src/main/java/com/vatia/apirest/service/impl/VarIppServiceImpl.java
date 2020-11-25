package com.vatia.apirest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.VarIpp;
import com.vatia.apirest.repository.VarIppRepository;
import com.vatia.apirest.service.VarIppService;

import net.minidev.json.JSONObject;

@Service
public class VarIppServiceImpl implements VarIppService{

	@Autowired       
    private VarIppRepository varIppRepository;
	
	@Override
	public List<VarIpp> findAll() {
		// TODO Auto-generated method stub
		return this.varIppRepository.findAll();
	}

	@Override
	public List<VarIpp> findAllAnio(Integer desde, Integer hasta) {
		// TODO Auto-generated method stub
		return varIppRepository.getAllAnio(desde, hasta);
	}
	
	@Override
	public VarIpp findAnio(Integer anio) {
		// TODO Auto-generated method stub
		return this.varIppRepository.getVarIppAnio(anio);
	}

	@Override
	public JSONObject calcularVarIppAnio(Integer anio) {
		return varIppRepository.getVariacionIppAnio((anio-1), anio);
	}

	@Override
	public void save(VarIpp varIpp) {
		 this.varIppRepository.save(varIpp);
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
