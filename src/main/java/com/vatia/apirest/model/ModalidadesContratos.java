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
@Table(name = "tbl_mods_contratos")
@XmlRootElement

public class ModalidadesContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_mod_contrato")
    private Integer idModalidadContrato;
    
    @Basic(optional = false)
    @Column(name = "str_desc_mod_contrato")
    private String descModContrato;
    
    @Basic(optional = false)
    @Column(name = "str_sigla_mod_contrato")
    private String siglaModContrato;

	public Integer getIdModalidadContrato() {
		return idModalidadContrato;
	}

	public void setIdModalidadContrato(Integer idModalidadContrato) {
		this.idModalidadContrato = idModalidadContrato;
	}	

	public String getDescModContrato() {
		return descModContrato;
	}

	public void setDescModContrato(String descModContrato) {
		this.descModContrato = descModContrato;
	}

	public String getSiglaModContrato() {
		return siglaModContrato;
	}

	public void setSiglaModContrato(String siglaModContrato) {
		this.siglaModContrato = siglaModContrato;
	}



    
}

    