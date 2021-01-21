package com.vatia.apirest.service;

import java.util.List;
import com.vatia.apirest.modelBI.Cliente;

public interface BIService {
	
	public List<Cliente> getAllClientes();
	
	public List<Object> getLikeClientesByRazonSocial(String razonSocial);

}
