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
@Table(name = "tbl_formulas_precios")
@XmlRootElement

public class FormulasPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_formula_precio")
    private Integer id_formula_precio;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_desc_formula_precio")
    private String descFormulaPrecio;

    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_formula_precio")
    private String formulaPrecio;
    
    

	public FormulasPrecios() {
	}


	public FormulasPrecios(Integer id_formula_precio, String descFormulaPrecio, String formulaPrecio) {
		super();
		this.id_formula_precio = id_formula_precio;
		this.descFormulaPrecio = descFormulaPrecio;
		this.formulaPrecio = formulaPrecio;
	}


	public Integer getId_formula_precio() {
		return id_formula_precio;
	}


	public void setId_formula_precio(Integer id_formula_precio) {
		this.id_formula_precio = id_formula_precio;
	}


	public String getDescFormulaPrecio() {
		return descFormulaPrecio;
	}


	public void setDescFormulaPrecio(String descFormulaPrecio) {
		this.descFormulaPrecio = descFormulaPrecio;
	}


	public String getFormulaPrecio() {
		return formulaPrecio;
	}


	public void setFormulaPrecio(String formulaPrecio) {
		this.formulaPrecio = formulaPrecio;
	}
	
    
    
	 
}

    