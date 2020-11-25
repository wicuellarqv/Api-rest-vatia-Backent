package com.vatia.apirest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Empresa;
import com.vatia.apirest.repository.EmpresaRepository;
import com.vatia.apirest.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
    private EmpresaRepository empresaRepository;


	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresaRepository.findAll();
	}

	@Override
	public void save(Empresa empresa) {
		// TODO Auto-generated method stub
		empresaRepository.save(empresa);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		empresaRepository.deleteById(id);
	}

}
