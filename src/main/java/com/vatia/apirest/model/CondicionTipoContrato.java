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
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.type.DateType;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_condiciones_tipos_contratos")
@XmlRootElement

public class CondicionTipoContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_condicion_tipo_contrato")
    private Integer idCondicionTipoContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_condicion_tipo_contrato")
    private String descCondicionTipoContrato;


    @Basic(optional = false)
    @Column(name = "str_formula_condicion_tipo_contrato")
    private String formulaCondicionTipoContrato;


    
    public Integer getIdCondicionTipoContrato() {
		return idCondicionTipoContrato;
	}

	public void setIdCondicionTipoContrato(Integer idCondicionTipoContrato) {
		this.idCondicionTipoContrato = idCondicionTipoContrato;
	}

	public String getDescCondicionTipoContrato() {
		return descCondicionTipoContrato;
	}

	public void setDescCondicionTipoContrato(String descCondicionTipoContrato) {
		this.descCondicionTipoContrato = descCondicionTipoContrato;
	}

	public String getFormulaCondicionTipoContrato() {
		return formulaCondicionTipoContrato;
	}

	public void setFormulaCondicionTipoContrato(String formulaCondicionTipoContrato) {
		this.formulaCondicionTipoContrato = formulaCondicionTipoContrato;
	}
	   
	 
}

    