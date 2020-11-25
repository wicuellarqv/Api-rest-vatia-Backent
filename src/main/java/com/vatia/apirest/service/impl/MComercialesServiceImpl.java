package com.vatia.apirest.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Margenes_cciales;
import com.vatia.apirest.repository.MComercialesRepository;
import com.vatia.apirest.service.MComercialesService;

@Service
public class MComercialesServiceImpl implements MComercialesService{
	@Autowired
    private MComercialesRepository MComercialesRepository;

	@Override
	public List<Margenes_cciales> findAllAnio(String desde, String hasta) {
		// TODO Auto-generated method stub
		desde = desde+" 00:00:00";
		hasta = hasta+" 23:59:59";
		return this.MComercialesRepository.getAllAnio(desde, hasta);
	}
	
	@Override
	public List<Margenes_cciales> findAllAnioV(String desde, String hasta, String version) {
		// TODO Auto-generated method stub
		desde = desde+" 00:00:00";
		hasta = hasta+" 23:59:59";
		return this.MComercialesRepository.getAllAnioV(desde, hasta, version);
	}

	@Override
	public void save(Margenes_cciales Margenes_cciales) {
		// TODO Auto-generated method stub
		java.util.Date fecha = new Date();
		Margenes_cciales.setfechaCapturaMargenesCciales(fecha);
		this.MComercialesRepository.save(Margenes_cciales);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.MComercialesRepository.deleteById(id);
	}

    
}
