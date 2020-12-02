package com.vatia.apirest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.type.DateType;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_fechas_corte_contratos")
@XmlRootElement

public class FechasCorteContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_fecha_corte")
    private Integer idFechaCorte;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_fecha_corte")
    private String desc_fecha_corte;

	public Integer getIdFechaCorte() {
		return idFechaCorte;
	}

	public void setIdFechaCorte(Integer idFechaCorte) {
		this.idFechaCorte = idFechaCorte;
	}

	public String getDesc_fecha_corte() {
		return desc_fecha_corte;
	}

	public void setDesc_fecha_corte(String desc_fecha_corte) {
		this.desc_fecha_corte = desc_fecha_corte;
	}

	
    
}

    