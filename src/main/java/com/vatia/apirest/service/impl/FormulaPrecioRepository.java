package com.vatia.apirest.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.FormulasPrecios;

@Repository
public interface FormulaPrecioRepository extends JpaRepository<FormulasPrecios, Integer>{
	

}