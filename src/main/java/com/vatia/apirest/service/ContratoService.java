package com.vatia.apirest.service;

import java.util.List;
import java.util.Map;

import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.EntregasGarantias;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;

public interface ContratoService {
	
	public List<TiposMercados> getAllTipoMercado();

	public List<TiposContratos> getAllTipoContrato();
	
	public List<ModalidadesContratos> getAllModalidadContrato();
	
	public List<TiposGarantias> getAllTipoGarantia(); 
	
	public List<EntregasGarantias> getAllEntregaGarantia(); 
	
	public List<TiposCantidad> getAllTipoCantidad(); 
	
	public List<TiposPrecio> getAllTipoPrecio(); 
	
	public List<FechasCorteContratos> getAllFechaCorte();
	
	public List<FormulasPrecios> getAllFormulaPrecio();
		
	public AgentesComerciales getAllSicAgenteComercial(String valor);
	
	public void saveContrato (Map<String, Object> request);
	
}
