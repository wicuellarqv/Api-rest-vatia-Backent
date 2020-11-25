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
@Entity
@Table(name = "tbl_costos_indirectos")
@XmlRootElement

public class Costos_indirectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_costo")
    private Integer idCostoInd;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_year_costo_ind")
    private String yearCostoInd;
    
    @Basic(optional = false)
    @Column(name = "str_mes_costo_ind")
    private String mesCostoInd;
    
    @Basic(optional = false)
    @Column(name = "str_cuenta_contable")
    private String cuentaContable;
    
    @Column(name = "str_desc_cuenta_contable")
    private String descCuentaContable;
    
    @Basic(optional = false)
    @Column(name = "num_valor_cuenta")
    private BigDecimal valorCuenta;
    
    @Basic(optional = false)
    @Column(name = "dtm_fecha_captura_costo_ind")
    private Date fechaCapturaCostoInd;
    
    
    public Costos_indirectos() {
    }

    public Costos_indirectos(Integer idCostoInd) {
        this.idCostoInd = idCostoInd;
    }
    
    public void setidCostoInd(Integer idCostoInd) {
		this.idCostoInd = idCostoInd;
	}
    
    public Integer getidCostoInd() {
        return idCostoInd;
    }

    
    public void setyearCostoInd(String yearCostoInd) {
		this.yearCostoInd = yearCostoInd;
	}
    
    public String getyearCostoInd() {
        return yearCostoInd;
    }
        
    
    public void setmesCostoInd(String mesCostoInd) {
  		this.mesCostoInd = mesCostoInd;
  	}
      
      public String getmesCostoInd() {
          return mesCostoInd;
      }
      
    public void setcuentaContable(String cuentaContable) {
    	this.cuentaContable = cuentaContable;
    }
        
      public String getcuentaContable() {
           return cuentaContable;
      }

      
    public void setdescCuentaContable(String descCuentaContable) {
      	this.descCuentaContable = descCuentaContable;
      }
          
      public String getdescCuentaContable() {
          return descCuentaContable;
        }
      
      
    public void setvalorCuenta(BigDecimal valorCuenta) {
  		this.valorCuenta = valorCuenta;
  	}
      
      public BigDecimal getvalorCuenta() {
          return valorCuenta;
      }
      
      
     public void setfechaCapturaCostoInd(Date fechaCapturaCostoInd) {
  		this.fechaCapturaCostoInd = fechaCapturaCostoInd;
  	}
      
      public Date getfechaCapturaCostoInd() {
          return fechaCapturaCostoInd;
      }      
      
    }

