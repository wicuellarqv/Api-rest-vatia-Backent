package com.vatia.apirest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Costos_indirectos;
import com.vatia.apirest.repository.CostosIndirectosRepository;
import com.vatia.apirest.service.CostosIndirectosService;

@Service
public class CostosIndirectosServiceImpl implements CostosIndirectosService{
	@Autowired
    private CostosIndirectosRepository CostosIndirectosRepository;

	@Override
	public List<Costos_indirectos> getAllPeriodo(String mes, String ano) {

		return this.CostosIndirectosRepository.getAllPeriodo(mes, ano);
	}
	    
}
