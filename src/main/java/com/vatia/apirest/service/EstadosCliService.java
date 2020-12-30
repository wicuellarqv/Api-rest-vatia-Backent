package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.CategoriaCliente;
import com.vatia.apirest.model.CategoriaEstado;
import com.vatia.apirest.model.EstadosCliente;

public interface EstadosCliService {
	
	public List<EstadosCliente> getAllEstadosCli();

	public EstadosCliente createEstado(EstadosCliente estadosCliente);
	
	public Boolean updateEstado(EstadosCliente estadosCliente);
	
	public Boolean deleteEstado(EstadosCliente estadosCliente);
	
	public List<CategoriaEstado> getAllCategoriasEstados();
	
	public CategoriaEstado saveCategoriaEstado(CategoriaEstado categoriaEstado);
	
	public Boolean deleteCategoriaEstado(CategoriaEstado categoriaEstado);
}
