package com.vatia.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vatia.apirest.model.Fuente;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.repository.FuenteRepository;
import com.vatia.apirest.repository.ModalidadContratoRepository;
import com.vatia.apirest.repository.TipoCantidadRepository;
import com.vatia.apirest.repository.TipoContratoRepository;
import com.vatia.apirest.repository.TipoGarantiasRepository;
import com.vatia.apirest.repository.TiposMercadosRepository;
import com.vatia.apirest.service.ContratoService;


@Service
public class ContratoServiceImpl implements ContratoService {
	@Autowired
    private FuenteRepository fuenteRepository;
	
	@Autowired
    private TiposMercadosRepository tiposMercadosRepository;
	
	@Autowired
    private TipoContratoRepository tipoContratoRepository; 
	
	@Autowired
    private ModalidadContratoRepository modalidadContratoRepository;
	
	@Autowired
    private TipoGarantiasRepository tipoGarantiasRepository;
	
	@Autowired
    private TipoCantidadRepository tipoCantidadRepository;
	
	
	
	
	@Override
	public List<TiposMercados> getAllTipoMercado() {
		// TODO Auto-generated method stub
		return this.tiposMercadosRepository.findAll();
	}	
	
	@Override
	public List<TiposContratos> getAllTipoContrato() {
		// TODO Auto-generated method stub
		return this.tipoContratoRepository.findAll();
	}
	
	@Override
	public List<ModalidadesContratos> getAllModalidadContrato() {
		// TODO Auto-generated method stub
		return this.modalidadContratoRepository.findAll();
	} 
	
	@Override
	public List<TiposGarantias> getAllTipoGarantia() {
		// TODO Auto-generated method stub
		return this.tipoGarantiasRepository.findAll();
	} 
	
	@Override
	public List<TiposCantidad> getAllTipoCantidad() {
		// TODO Auto-generated method stub
		return this.tipoCantidadRepository.findAll();
	} 
	
	
	
	
	
	
	
	
	@Override
	public List<Fuente> getAllTipoPrecio() {
		// TODO Auto-generated method stub
		return this.fuenteRepository.findAll();
	}	
	

	@Override
	public List<Fuente> getAllSicContrato() {
		// TODO Auto-generated method stub
		return this.fuenteRepository.findAll();
	} 
	
	@Override
	public List<Fuente> getAllSicComprador() {
		// TODO Auto-generated method stub
		return this.fuenteRepository.findAll();
	} 
	
	@Override
	public List<Fuente> getAllSicVendedor() {
		// TODO Auto-generated method stub
		return this.fuenteRepository.findAll();
	}	

}
