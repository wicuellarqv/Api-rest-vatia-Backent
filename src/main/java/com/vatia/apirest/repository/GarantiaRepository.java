package com.vatia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vatia.apirest.model.GarantiasContratos;

@Repository
public interface GarantiaRepository extends JpaRepository<GarantiasContratos, Integer>{

}
