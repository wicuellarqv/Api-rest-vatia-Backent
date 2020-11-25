package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.Fuente;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposContratos;

public interface ContratoService {
	
	public List<TiposMercados> getAllTipoMercado();

	public List<TiposContratos> getAllTipoContrato();
	
	public List<ModalidadesContratos> getAllModalidadContrato();
	
	
	public List<Fuente> getAllTipoPrecio(); 
	
	public List<Fuente> getAllTipoCantidad();  
	
	public List<Fuente> getAllTipoGarantia();   
	
	public List<Fuente> getAllEntregaGarantia(); 
		
	public List<Fuente> getAllSicContrato();
	
	public List<Fuente> getAllSicComprador();
	
	public List<Fuente> getAllSicVendedor();
	
}
