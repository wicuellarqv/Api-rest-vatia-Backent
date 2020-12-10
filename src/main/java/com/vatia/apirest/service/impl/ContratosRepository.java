package com.vatia.apirest.service.impl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.Contratos;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Integer>{

}
