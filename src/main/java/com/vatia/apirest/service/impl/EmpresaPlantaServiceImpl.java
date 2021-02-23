package com.vatia.apirest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.EmpresaPlanta;
import com.vatia.apirest.repository.EmpresaPlantaRepository;
import com.vatia.apirest.service.EmpresaPlantaService;

@Service
public class EmpresaPlantaServiceImpl implements EmpresaPlantaService{
	
	@Autowired
    private EmpresaPlantaRepository empresaPlantaRepository;


	@Override
	public List<EmpresaPlanta> findAll() {
		// TODO Auto-generated method stub
		return (List<EmpresaPlanta>) empresaPlantaRepository.findAll();
	}

	@Override
	public EmpresaPlanta save(EmpresaPlanta empresaPlanta) {
		return empresaPlantaRepository.save(empresaPlanta);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		empresaPlantaRepository.deleteById(id);
	}

}
