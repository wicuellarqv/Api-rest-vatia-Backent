package com.vatia.apirest.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.repositoryBI.ClienteRepository;
import com.vatia.apirest.service.BIService;
import com.vatia.apirest.utils.CheckPageable;


@Service
public class BIServiceImpl implements BIService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@Override
	public List<Object> getLikeClientesByRazonSocial(String razonSocial) {
		
		return (List<Object>) clienteRepository.nativeFindByLikeClienteRazonSocial(razonSocial);
	}

	@Override
	public List<Cliente> getClienteById(String id) {
		return clienteRepository.findByIdCliente(id);
	}

	@Override
	public Page<Cliente> getLikeClientesByRazonPage(int page,int size, String razonSocial) {
		return clienteRepository.nativeFindByLikeClienteRazonPage(CheckPageable.size(page,size),razonSocial);
	}

	@Override
	public Page<Cliente> getLikeClientesByCategoriaPage(int page,int size,String categoria) {
		return clienteRepository.nativeFindByLikeClienteCatPage(CheckPageable.size(page,size), categoria);
	}

	@Override
	public Page<Cliente> getLikeClientesByCatAndRazPage(int page,int size,String categoria, String razonSocial) {
		return clienteRepository.nativeFindByLikeClienteCatAndRazPage(CheckPageable.size(page,size), categoria, razonSocial);
	}

	@Override
	public List<Object> getCagoriasCliente() {
		return clienteRepository.nativeCategoriasCliente();
	}

	
}

