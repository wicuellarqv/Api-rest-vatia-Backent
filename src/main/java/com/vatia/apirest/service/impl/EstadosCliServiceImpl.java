package com.vatia.apirest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.model.EstadosCliente;
import com.vatia.apirest.repository.EstadosCliRepository;
import com.vatia.apirest.service.EstadosCliService;

@Service
public class EstadosCliServiceImpl implements EstadosCliService {
	
	@Autowired
	EstadosCliRepository estadosCliRepository;

	@Override
	public List<EstadosCliente> getAllEstadosCli() {
		List<EstadosCliente> estadosCliente = new ArrayList<EstadosCliente>();
		try {
			estadosCliente = (List<EstadosCliente>) estadosCliRepository.findAll();
			return estadosCliente;
		} catch (Exception e) {
			System.out.println(e.toString());
			return estadosCliente;
		}
	}

	@Override
	public EstadosCliente createEstado(EstadosCliente estadosCliente) {
		EstadosCliente response = new EstadosCliente();
		try {
			EstadosCliente newEstadoCliente = new EstadosCliente();
			newEstadoCliente.setNombre(estadosCliente.getNombre());
			newEstadoCliente.setCreateAt(new Date());
			response = estadosCliRepository.save(newEstadoCliente);
			return response;
		} catch (Exception e) {
			response.setId(0);
			return response;
		}
	}

	@Override
	public Boolean updateEstado(EstadosCliente estadosCliente) {
		Boolean status = true;
		try {
			estadosCliRepository.updateEstadosClienteNative(estadosCliente.getNombre(), estadosCliente.getId());
			return status;
		} catch (Exception e) {
			System.out.println(e.toString());
			status = false;
			return status;
		}
	}

	@Override
	public Boolean deleteEstado(EstadosCliente estadosCliente) {
		Boolean status = true;
		try {
			estadosCliRepository.deleteById(estadosCliente.getId());
			return status;
		} catch (Exception e) {
			System.out.println(e.toString());
			status = false;
			return status;
		}
	}

}
