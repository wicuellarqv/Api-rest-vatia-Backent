package com.vatia.apirest.service.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.FechaPresupuesto;
import com.vatia.apirest.repository.FechaPresupuestoRepository;
import com.vatia.apirest.service.FechaPresupuestoService;

@Service
public class FechaPresupuestoServiceImpl implements FechaPresupuestoService{
	@Autowired
    private FechaPresupuestoRepository fechaPresupuestoRepository;
	
	
	@Override
	public List<FechaPresupuesto> getAllFechaPresupuesto() {
		List<FechaPresupuesto> fechaPresupuesto = null;
		try {

			fechaPresupuesto = fechaPresupuestoRepository.findAll();
		
		} catch (Exception e) {
			System.out.print(" Error en CuentasCecosCost: " + e);
		}

		return fechaPresupuesto;
	}
	
	@Override
	public String saveFechaPresupuesto(JSONObject obj) {
		
		try {
		
		FechaPresupuesto fechaPresupuesto = new FechaPresupuesto();

		fechaPresupuesto.setIdFPresupuesto(0);
		
		if(obj.get("ano") != null) {
			fechaPresupuesto.setAno(obj.get("ano").toString());
		}
		
		if(obj.get("fecha") != null) {
			fechaPresupuesto.setFecha(obj.get("fecha").toString());
		}
			
		fechaPresupuestoRepository.save(fechaPresupuesto);
		
		return "Se ha guardado con éxito !";
		
		} catch (Exception e) {
			return "Error al guardar :"+e;
		}

	}
	
	@Override
	public String updateFechaPresupuesto(JSONObject obj) {
		String fecha = null ;
		int id = 0;
		try {
		
		if(obj.get("idFechaPresupuesto") != null) {
			id = Integer.parseInt(obj.get("idFechaPresupuesto").toString());
		}
		
		if(obj.get("fecha") != null) {
			fecha = obj.get("fecha").toString();
		}			
		
		fechaPresupuestoRepository.updateFecha(fecha,id);
		
		return "Se Actualizo con éxito !";
		
		} catch (Exception e) {
			return "Error al guardar :"+e;
		}

	}

}

