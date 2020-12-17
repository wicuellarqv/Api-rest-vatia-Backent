package com.vatia.apirest.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.repositoryBI.ClienteRepository;
import com.vatia.apirest.service.BIService;


@Service
public class BIServiceImpl implements BIService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@Override
	public List<Object> getLikeClientes(String nombreLike) {
		
		return (List<Object>) clienteRepository.nativeFindByLikeCliente(nombreLike);
	}

	
}

