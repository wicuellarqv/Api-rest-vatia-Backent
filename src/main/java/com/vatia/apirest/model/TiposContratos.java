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
@Table(name = "tbl_tipos_contratos")
@XmlRootElement

public class TiposContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_tipo_contrato")
    private Integer idTipoContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_tipo_contrato")
    private String descTipoContrato;
    
    @Basic(optional = false)
    @Column(name = "str_sigla_tipo_contrato")
    private String siglaTipoContrato;

	public Integer getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getDescTipoContrato() {
		return descTipoContrato;
	}

	public void setDescTipoContrato(String descTipoContrato) {
		this.descTipoContrato = descTipoContrato;
	}

	public String getSiglaTipoContrato() {
		return siglaTipoContrato;
	}

	public void setSiglaTipoContrato(String siglaTipoContrato) {
		this.siglaTipoContrato = siglaTipoContrato;
	}

    
    
    
}

    