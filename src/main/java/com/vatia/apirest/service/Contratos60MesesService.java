package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.Cantidad60Meses;
import com.vatia.apirest.model.Contratos60Meses;
import com.vatia.apirest.model.Precios60Meses;

public interface Contratos60MesesService {

	public Contratos60Meses saveContrato60Meses(Contratos60Meses contratos60Meses);

	public Boolean DeleteContrato60Meses(Contratos60Meses contratos60Meses);

	public List<Contratos60Meses> getAllContrato60Meses();
	
	public Contratos60Meses Contrato60MesesFindByCodContrato(Integer codContrato);

	public Precios60Meses savePrecios60Meses(Precios60Meses precios60Meses);

	public Boolean DeletePrecios60Meses(Precios60Meses precios60Meses);

	public List<Precios60Meses> getAllPrecios60Meses();

	public Cantidad60Meses saveCantidad60Meses(Cantidad60Meses cantidad60Meses);

	public Boolean DeleteCantidad60Meses(Cantidad60Meses cantidad60Meses);

	public List<Cantidad60Meses> getAllCantidad60Meses();
	
	public List<Cantidad60Meses> getCantidad60MesesByContrato(Integer id);
	
	public Cantidad60Meses getCantidad60MesesById(int id);
	
	public Cantidad60Meses getCantidad60MesesByPeriodoAndContrato(String periodo,Integer idContrato);
	
	public Precios60Meses getPrecios60MesesByPeriodoAndContrato(String periodo,Integer idContrato);
}
