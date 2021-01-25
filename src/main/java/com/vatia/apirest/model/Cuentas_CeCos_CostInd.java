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
@Table(name = "tbl_cuentas_cecos_cost_ind")
@XmlRootElement

public class Cuentas_CeCos_CostInd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_cuenta_ceco")
    private Integer idCostoInd;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
    @Column(name = "str_cuenta_contable")
    private String cuentaContable;
    
    @Basic(optional = false)
    @Column(name = "str_centro_costo")
    private String centroCosto;

	public Cuentas_CeCos_CostInd() {

	}

	public Cuentas_CeCos_CostInd(Integer idCostoInd, String cuentaContable, String centroCosto) {
		super();
		this.idCostoInd = idCostoInd;
		this.cuentaContable = cuentaContable;
		this.centroCosto = centroCosto;
	}

	public Integer getIdCostoInd() {
		return idCostoInd;
	}

	public void setIdCostoInd(Integer idCostoInd) {
		this.idCostoInd = idCostoInd;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}
    
         
      
    }

