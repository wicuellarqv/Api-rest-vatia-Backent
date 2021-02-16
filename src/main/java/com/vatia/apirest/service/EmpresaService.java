package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.Empresa;

public interface EmpresaService {
	

	public List<Empresa> findAll();

	public Empresa save(Empresa empresa);

	public void deleteById(Integer id);
}
