package com.vatia.apirest.service;

import java.util.List;
import com.vatia.apirest.model.EmpresaPlanta;

public interface EmpresaPlantaService {
	

	public List<EmpresaPlanta> findAll();

	public EmpresaPlanta save(EmpresaPlanta empresaPlanta);

	public void deleteById(Integer id);
}
