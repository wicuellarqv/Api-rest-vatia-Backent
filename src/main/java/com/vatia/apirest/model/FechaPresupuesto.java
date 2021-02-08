package com.vatia.apirest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.type.DateType;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_fecha_presupuesto")
@XmlRootElement

public class FechaPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_fecha_presupuesto")
    private Integer idFPresupuesto;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "str_ano")
    private String ano;
    
    @Column(name = "str_fecha")
    private String fecha;

	public FechaPresupuesto() {

	}


	public FechaPresupuesto(Integer idFPresupuesto, String ano, String fecha) {
		super();
		this.idFPresupuesto = idFPresupuesto;
		this.ano = ano;
		this.fecha = fecha;
	}


	public Integer getIdFPresupuesto() {
		return idFPresupuesto;
	}


	public void setIdFPresupuesto(Integer idFPresupuesto) {
		this.idFPresupuesto = idFPresupuesto;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



    }

