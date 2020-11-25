package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.Margenes_cciales;

public interface MComercialesService {
	
	public List<Margenes_cciales> findAllAnio(String desde, String hasta);
	
	public List<Margenes_cciales> findAllAnioV(String desde, String hasta, String version);
		
	public void save(Margenes_cciales tbl_margenes_cciales);

	public void deleteById(Integer id);
	
}
