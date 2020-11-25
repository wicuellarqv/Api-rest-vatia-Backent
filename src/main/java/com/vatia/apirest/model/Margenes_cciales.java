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
/**
 * @author Qvision
 *
 */
@Entity
@Table(name = "tbl_margenes_cciales")
@XmlRootElement

public class Margenes_cciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_margenes_cciales")
    private Integer idMargenesCciales;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation   
    @Basic(optional = false)
    @Column(name = "num_precio_venta_merc_reg")
    private BigDecimal precVentaMercReg;
    
    @Basic(optional = false)
    @Column(name = "num_precio_fijo_merc_no_reg")
    private BigDecimal precFijoMercNoReg;
    
    @Basic(optional = false)
    @Column(name = "num_precio_bolsa_merc_no_reg")
    private BigDecimal precBolsaMercNoReg;
 
    @Basic(optional = false)
    @Column(name = "num_rezagos_tarifarios")
    private String rezagosTarifarios;
    
    @Basic(optional = false)
    @Column(name = "dtm_fecha_captura")
    private Date fechaCapturaMargenesCciales;
    
    @Basic(optional = true)
    @Column(name = "dtm_version")
    private String version;

    @Basic(optional = true)
    @Column(name = "dtm_ano")
    private String ano;
    
    @Basic(optional = true)
    @Column(name = "dtm_mes")
    private String mes;
    
        
    public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public Margenes_cciales() {
    }   
    

    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Margenes_cciales(Integer idMargenesCciales) {
        this.idMargenesCciales = idMargenesCciales;
    }
    
    public void setidMargenesCciales(Integer idMargenesCciales) {
		this.idMargenesCciales = idMargenesCciales;
	}
    
    public Integer getidMargenesCciales() {
        return idMargenesCciales;
    }
    
    public void setprecVentaMercReg(BigDecimal precVentaMercReg) {
		this.precVentaMercReg = precVentaMercReg;
	}
    
    public BigDecimal getprecVentaMercReg() {
        return precVentaMercReg;
    }
   
    
    public void setprecFijoMercNoReg(BigDecimal precFijoMercNoReg) {
		this.precFijoMercNoReg = precFijoMercNoReg;
	}
    
    public BigDecimal getprecFijoMercNoReg() {
        return precFijoMercNoReg;
    }
    
    
    public void setprecBolsaMercNoReg(BigDecimal precBolsaMercNoReg) {
		this.precBolsaMercNoReg = precBolsaMercNoReg;
	}
    
    public BigDecimal getprecBolsaMercNoReg() {
        return precBolsaMercNoReg;
    }
    
    
    public void setrezagosTarifarios(String rezagosTarifarios) {
		this.rezagosTarifarios = rezagosTarifarios;
	}
    
    public String getrezagosTarifarios() {
        return rezagosTarifarios;
    }
    
    
    public void setfechaCapturaMargenesCciales(Date fechaCapturaMargenesCciales) {
		this.fechaCapturaMargenesCciales = fechaCapturaMargenesCciales;
	}
    
    public Date getfechaCapturaMargenesCciales() {
        return fechaCapturaMargenesCciales;
    }
    
    }

