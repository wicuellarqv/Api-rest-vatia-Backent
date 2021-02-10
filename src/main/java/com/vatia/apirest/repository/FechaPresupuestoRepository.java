package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatia.apirest.model.FechaPresupuesto;

public interface FechaPresupuestoRepository extends JpaRepository<FechaPresupuesto, Integer>{
	
	public List<FechaPresupuesto> findByAno(String ano);
	
	public FechaPresupuesto findById(int id);
}

