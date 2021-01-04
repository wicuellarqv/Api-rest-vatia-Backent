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
@Table(name = "tbl_precios_contratos")
@XmlRootElement

public class PreciosContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_precio_contrato")
    private Integer idPrecioContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "num_id_contrato")
    private Integer idContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_tipo_precio")
    private Integer idTipoPrecio;
    
    @Column(name = "dtm_mes_base")
    private String mesBase;
    
    @Basic(optional = false)
    @Column(name = "num_precio_referencia")
    private BigDecimal precioReferencia;
      
    @Basic(optional = false)
    @Column(name = "dtm_periodo_precio")
    private String fecPeriodoPrecio;
        
    @Basic(optional = false)
    @Column(name = "num_precio_periodo")
    private BigDecimal precioPeriodo;
        
    @Basic(optional = false)
    @Column(name = "num_id_formula_precio")
    private Integer formulaPrecio;
    
    
     

	public PreciosContratos() {
	 }

	public PreciosContratos(Integer idPrecioContrato, Integer idContrato, Integer idTipoPrecio, String mesBase,
			BigDecimal precioReferencia, String fecPeriodoPrecio, BigDecimal precioPeriodo, Integer formulaPrecio) {
		super();
		this.idPrecioContrato = idPrecioContrato;
		this.idContrato = idContrato;
		this.idTipoPrecio = idTipoPrecio;
		this.mesBase = mesBase;
		this.precioReferencia = precioReferencia;
		this.fecPeriodoPrecio = fecPeriodoPrecio;
		this.precioPeriodo = precioPeriodo;
		this.formulaPrecio = formulaPrecio;
	}

	public Integer getIdPrecioContrato() {
		return idPrecioContrato;
	}

	public void setIdPrecioContrato(Integer idPrecioContrato) {
		this.idPrecioContrato = idPrecioContrato;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public Integer getIdTipoPrecio() {
		return idTipoPrecio;
	}

	public void setIdTipoPrecio(Integer idTipoPrecio) {
		this.idTipoPrecio = idTipoPrecio;
	}

	public String getMesBase() {
		return mesBase;
	}

	public void setMesBase(String mesBase) {
		this.mesBase = mesBase;
	}

	public BigDecimal getPrecioReferencia() {
		return precioReferencia;
	}

	public void setPrecioReferencia(BigDecimal precioReferencia) {
		this.precioReferencia = precioReferencia;
	}

	public String getFecPeriodoPrecio() {
		return fecPeriodoPrecio;
	}

	public void setFecPeriodoPrecio(String fecPeriodoPrecio) {
		this.fecPeriodoPrecio = fecPeriodoPrecio;
	}

	public BigDecimal getPrecioPeriodo() {
		return precioPeriodo;
	}

	public void setPrecioPeriodo(BigDecimal precioPeriodo) {
		this.precioPeriodo = precioPeriodo;
	}

	public Integer getFormulaPrecio() {
		return formulaPrecio;
	}

	public void setFormulaPrecio(Integer formulaPrecio) {
		this.formulaPrecio = formulaPrecio;
	}

	public Contratos getContratosPrecios() {
		return contratosPrecios;
	}

	public void setContratosPrecios(Contratos contratosPrecios) {
		this.contratosPrecios = contratosPrecios;
	}

	public TiposPrecio getTiposPrecios() {
		return tiposPrecios;
	}

	public void setTiposPrecios(TiposPrecio tiposPrecios) {
		this.tiposPrecios = tiposPrecios;
	}

	public FormulasPrecios getFormulas_precio() {
		return formulas_precio;
	}

	public void setFormulas_precio(FormulasPrecios formulas_precio) {
		this.formulas_precio = formulas_precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne
	@JoinColumn(name="num_id_contrato", referencedColumnName = "num_id_contrato", insertable=false,updatable=false)
	Contratos contratosPrecios;
    
	@ManyToOne
	@JoinColumn(name="num_id_tipo_precio", referencedColumnName = "num_id_tipo_precio", insertable=false,updatable=false)
	TiposPrecio tiposPrecios;

	@ManyToOne
	@JoinColumn(name="num_id_formula_precio", referencedColumnName = "num_id_formula_precio", insertable=false,updatable=false)
	FormulasPrecios formulas_precio;
	
}

    