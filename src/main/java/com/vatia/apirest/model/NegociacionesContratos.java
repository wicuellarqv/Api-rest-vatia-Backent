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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.type.DateType;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_negoc_contratos")
@XmlRootElement

public class NegociacionesContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_negoc_contrato")
    private Integer idNegContrato;
    
    @Basic(optional = false)
    @Column(name = "str_desc_negoc_contrato")
    private String descNegContrato;
    
    @Basic(optional = false)
    @Column(name = "str_sigla_negoc_contrato")
    private String siglaNegContrato;
    
    
    
 public NegociacionesContratos() {
	}

NegociacionesContratos(Integer idNegContrato, String descNegContrato, String siglaNegContrato) {
		super();
		this.idNegContrato = idNegContrato;
		this.descNegContrato = descNegContrato;
		this.siglaNegContrato = siglaNegContrato;
	}

	public Integer getIdNegContrato() {
		return idNegContrato;
	}

	public void setIdNegContrato(Integer idNegContrato) {
		this.idNegContrato = idNegContrato;
	}

	public String getDescNegContrato() {
		return descNegContrato;
	}

	public void setDescNegContrato(String descNegContrato) {
		this.descNegContrato = descNegContrato;
	}

	public String getSiglaNegContrato() {
		return siglaNegContrato;
	}

	public void setSiglaNegContrato(String siglaNegContrato) {
		this.siglaNegContrato = siglaNegContrato;
	}

	
    
}

    