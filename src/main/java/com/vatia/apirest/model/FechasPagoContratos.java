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
@Table(name = "tbl_fechas_pago_contratos")
@XmlRootElement

public class FechasPagoContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_fecha_pago")
    private Integer idFechaPago;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "num_id_contrato")
    private Integer idContrato;

    
    @Basic(optional = false)
    @Column(name = "str_periodo_pago")
    private String periodoPago;
    
    
    @Basic(optional = false)
    @Column(name = "dtm_fecha_pago_periodo")
    private String fechaPagoPeriodo;
        
      
    public Integer getIdFechaPago() {
		return idFechaPago;
	}


	public void setIdFechaPago(Integer idFechaPago) {
		this.idFechaPago = idFechaPago;
	}


	public Integer getIdContrato() {
		return idContrato;
	}


	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}


	public String getPeriodoPago() {
		return periodoPago;
	}


	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
	}


	public String getFechaPagoPeriodo() {
		return fechaPagoPeriodo;
	}


	public void setFechaPagoPeriodo(String fechaPagoPeriodo) {
		this.fechaPagoPeriodo = fechaPagoPeriodo;
	}


	@ManyToOne
	@JoinColumn(name="num_id_contrato", referencedColumnName = "num_id_contrato", insertable=false,updatable=false)
	Contratos fechasPagoContrato;
}

    