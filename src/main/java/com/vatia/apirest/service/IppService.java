package com.vatia.apirest.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vatia.apirest.model.Ipp;

public interface IppService {
	public List<Ipp> findAll();
	
	public List<Ipp> findAllAnio(Integer desde, Integer hasta);
	
	public Ipp findIppAnio(Integer anio);
	
	public String getIppAnioMes(Integer anio, String mes);
	
	public void save(Ipp ipp);

	public void deleteById(Integer id);

	public void updateIpp(Integer fuente, float ipc, int anio, int _int_mes);
	  
}
