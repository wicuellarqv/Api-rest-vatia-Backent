package com.vatia.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.model.Cantidad60Meses;
import com.vatia.apirest.model.Contratos60Meses;
import com.vatia.apirest.model.Precios60Meses;
import com.vatia.apirest.repository.Cantidad60MesesRepository;
import com.vatia.apirest.repository.Contratos60MesesRepository;
import com.vatia.apirest.repository.Precios60MesesRepository;
import com.vatia.apirest.service.Contratos60MesesService;

@Service
public class Cont60MesesServiceImpl implements Contratos60MesesService {

	@Autowired
	private Contratos60MesesRepository contratos60MesesRepository;

	@Autowired
	private Precios60MesesRepository precios60MesesRepository;

	@Autowired
	private Cantidad60MesesRepository cantidad60MesesRepository;

	@Override
	public Contratos60Meses saveContrato60Meses(Contratos60Meses contratos60Meses) {
		Contratos60Meses newContratos60Meses = new Contratos60Meses();
		newContratos60Meses.setNumCodContrato(contratos60Meses.getNumCodContrato());
		newContratos60Meses.setNumIdAgenteComprador(contratos60Meses.getNumIdAgenteComprador());
		newContratos60Meses.setNumIdAgenteVendedor(contratos60Meses.getNumIdAgenteVendedor());
		return contratos60MesesRepository.save(contratos60Meses);
	}

	@Override
	public Boolean DeleteContrato60Meses(Contratos60Meses contratos60Meses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contratos60Meses> getAllContrato60Meses() {
		return (List<Contratos60Meses>) contratos60MesesRepository.findAll();
	}

	@Override
	public Contratos60Meses Contrato60MesesFindByCodContrato(Integer codContraro) {
		return contratos60MesesRepository.findByNumCodContrato(codContraro);
	}

	@Override
	public Precios60Meses savePrecios60Meses(Precios60Meses precios60Meses) {
		return precios60MesesRepository.save(precios60Meses);
	}

	@Override
	public Boolean DeletePrecios60Meses(Precios60Meses precios60Meses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Precios60Meses> getAllPrecios60Meses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cantidad60Meses saveCantidad60Meses(Cantidad60Meses cantidad60Meses) {
		return cantidad60MesesRepository.save(cantidad60Meses);
	}

	@Override
	public Boolean DeleteCantidad60Meses(Cantidad60Meses cantidad60Meses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cantidad60Meses> getAllCantidad60Meses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cantidad60Meses> getCantidad60MesesByContrato(Integer id) {
		return cantidad60MesesRepository.nativeFindByContratos60Meses(id);
	}

	@Override
	public Cantidad60Meses getCantidad60MesesById(int id) {
		return cantidad60MesesRepository.findById(id);
	}

	@Override
	public Cantidad60Meses getCantidad60MesesByPeriodoAndContrato(String periodo, Integer idContrato) {
		return cantidad60MesesRepository.findByDtmPeriodoAndContratoNative(idContrato, periodo);
	}

	@Override
	public Precios60Meses getPrecios60MesesByPeriodoAndContrato(String periodo, Integer idContrato) {
		return precios60MesesRepository.findByDtmPeriodoAndContratoNative(idContrato, periodo);
	}

}
