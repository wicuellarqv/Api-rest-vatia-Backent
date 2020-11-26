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
@Table(name = "tbl_tipos_garantias")
@XmlRootElement

public class TiposGarantias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_tipo_garantia")
    private Integer idTipoGarantia;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_tipo_garantia")
    private String descTipoGarantia;

	public Integer getIdTipoGarantia() {
		return idTipoGarantia;
	}

	public void setIdTipoGarantia(Integer idTipoGarantia) {
		this.idTipoGarantia = idTipoGarantia;
	}

	public String getDescTipoGarantia() {
		return descTipoGarantia;
	}

	public void setDescTipoGarantia(String descTipoGarantia) {
		this.descTipoGarantia = descTipoGarantia;
	}

	 
}

    