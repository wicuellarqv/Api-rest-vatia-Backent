package com.vatia.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vatia.apirest.modelBI.Capains;
import com.vatia.apirest.modelBI.Cliente;

public interface BIService {

	public List<Cliente> getAllClientes();
	
	public List<Object> getCagoriasCliente();

	public List<Cliente> getClienteById(String id);

	public List<Object> getLikeClientesByRazonSocial(String razonSocial);

	public Page<Cliente> getLikeClientesByRazonPage(int page, int size, String razonSocial);

	public Page<Cliente> getLikeClientesByCategoriaPage(int page, int size, String categoria);

	public Page<Cliente> getLikeClientesByCatAndRazPage(int page, int size, String categoria, String razonSocial);
	
	public List<Capains> getPlantasLike(String planta);
}
