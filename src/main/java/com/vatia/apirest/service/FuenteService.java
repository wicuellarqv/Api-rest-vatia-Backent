package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.Fuente;

public interface FuenteService {
	public List<Fuente> findAll();

	public void save(Fuente fuente);

	public void deleteById(Integer id);
}
