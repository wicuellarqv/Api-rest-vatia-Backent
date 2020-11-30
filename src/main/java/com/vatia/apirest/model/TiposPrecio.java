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
@Table(name = "tbl_tipos_precio")
@XmlRootElement

public class TiposPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_tipo_precio")
    private Integer idTipoPrecio;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_tipo_precio")
    private String descTipoPrecio;

	public Integer getIdTipoPrecio() {
		return idTipoPrecio;
	}

	public void setIdTipoPrecio(Integer idTipoPrecio) {
		this.idTipoPrecio = idTipoPrecio;
	}

	public String getDescTipoPrecio() {
		return descTipoPrecio;
	}

	public void setDescTipoPrecio(String descTipoPrecio) {
		this.descTipoPrecio = descTipoPrecio;
	}

	
	 
    
}

    