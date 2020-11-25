package com.vatia.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.model.Fuente;
import com.vatia.apirest.repository.FuenteRepository;
import com.vatia.apirest.service.FuenteService;

@Service
public class FuenteServiceImpl implements FuenteService {
	@Autowired
    private FuenteRepository fuenteRepository;
	
	@Override
	public List<Fuente> findAll() {
		// TODO Auto-generated method stub
		return this.fuenteRepository.findAll();
	}

	@Override
	public void save(Fuente fuente) {
		// TODO Auto-generated method stub
		this.fuenteRepository.save(fuente);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.fuenteRepository.deleteById(id);
	}

}
