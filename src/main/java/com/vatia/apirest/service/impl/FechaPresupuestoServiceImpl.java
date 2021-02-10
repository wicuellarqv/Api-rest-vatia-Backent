package com.vatia.apirest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.FechaPresupuesto;
import com.vatia.apirest.repository.FechaPresupuestoRepository;
import com.vatia.apirest.service.FechaPresupuestoService;

@Service
public class FechaPresupuestoServiceImpl implements FechaPresupuestoService {
	@Autowired
	private FechaPresupuestoRepository fechaPresupuestoRepository;

	@Override
	public List<FechaPresupuesto> getAllFechaPresupuestoByAnio(String ano) {
		return fechaPresupuestoRepository.findByAno(ano);		 
	}

	@Override
	public FechaPresupuesto saveFechaPresupuesto(FechaPresupuesto fechaPresupuesto) {
		List<FechaPresupuesto> listAnio = fechaPresupuestoRepository.findByAno(fechaPresupuesto.getAno());
		if(listAnio.size() > 0) {
			return null;
		}else {
			return fechaPresupuestoRepository.save(fechaPresupuesto);
		}
		

	}

	@Override
	public FechaPresupuesto updateFechaPresupuesto(FechaPresupuesto fechaPresupuesto) {
		FechaPresupuesto updatefechaPresupuesto = new FechaPresupuesto();
		updatefechaPresupuesto.setIdFPresupuesto(fechaPresupuesto.getIdFPresupuesto());
		updatefechaPresupuesto.setAno(fechaPresupuesto.getAno());
		updatefechaPresupuesto.setAno(fechaPresupuesto.getFecha());
		fechaPresupuestoRepository.save(updatefechaPresupuesto);
		return updatefechaPresupuesto;
	}

	@Override
	public void deleteFechaPresupuesto(FechaPresupuesto fechaPresupuesto) {
		fechaPresupuestoRepository.deleteById(fechaPresupuesto.getIdFPresupuesto());
	}

	@Override
	public List<FechaPresupuesto> getAllFechaPresupuesto() {
		return fechaPresupuestoRepository.findAll();
	}

}
