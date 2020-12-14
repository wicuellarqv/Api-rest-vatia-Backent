package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.FechasCorteContratos;

@Repository
public interface FechaCorteRepository extends JpaRepository<FechasCorteContratos, Integer>{
	

}