package com.vatia.apirest.service;


import java.util.List;

import com.vatia.apirest.model.Categoria;
import com.vatia.apirest.model.CategoriaCliente;

public interface CategoriaService {
	
	public List<Categoria> getAllCategorias();

	public Categoria saveCategoria(Categoria categoria);
	
	public Boolean deleteCategoria(Categoria categoria);
	
	public Boolean updateCategoria(Categoria categoria);
	
	public List<CategoriaCliente> getAllCategoriasClientes();
	
	public CategoriaCliente saveCategoriaCliente(CategoriaCliente categoriaCliente);
	
	public Boolean deleteCategoriaCliente(CategoriaCliente categoriaCliente);
}
