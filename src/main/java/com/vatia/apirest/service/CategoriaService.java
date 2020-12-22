package com.vatia.apirest.service;


import java.util.List;

import com.vatia.apirest.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> getAllCategorias();

	public Categoria saveCategoria(Categoria categoria);
	
	public Boolean deleteCategoria(Categoria categoria);
	
	public Boolean updateCategoria(Categoria categoria);
}
