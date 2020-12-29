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
@Table(name = "tbl_garantias_contratos")
@XmlRootElement

public class GarantiasContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_garantia_contrato")
    private Integer idGarantiaContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "num_id_contrato")
    private Integer idContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_tipo_garantia")
    private Integer idTipoGarantia;
      
    @Basic(optional = false)
    @Column(name = "dtm_fecha_inicio_garantia")
    private String fechaEntregaInicioGarantia;
    
    @Basic(optional = false)
    @Column(name = "dtm_fecha_fin_garantia")
    private String fechaEntregaFinGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_cantidad_garantia")
    private Integer cantidadGarantia;
            
    @Basic(optional = false)
    @Column(name = "str_ipp_actualizacion_garantia")
    private String ippActGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_valor_garantia")
    private Integer valorGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_tasa_garantia")
    private Integer tasaGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_iva_garantia")
    private Integer ivaGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_prima_garantia")
    private Integer primaGarantia;
    
    @Basic(optional = false)
    @Column(name = "num_costo_garantia")
    private Integer costoGarantia;
    

	public Integer getIdGarantiaContrato() {
		return idGarantiaContrato;
	}


	public void setIdGarantiaContrato(Integer idGarantiaContrato) {
		this.idGarantiaContrato = idGarantiaContrato;
	}


	public Integer getIdContrato() {
		return idContrato;
	}


	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}


	public Integer getIdTipoGarantia() {
		return idTipoGarantia;
	}


	public void setIdTipoGarantia(Integer idTipoGarantia) {
		this.idTipoGarantia = idTipoGarantia;
	}


	public String getFechaEntregaInicioGarantia() {
		return fechaEntregaInicioGarantia;
	}


	public void setFechaEntregaInicioGarantia(String fechaEntregaInicioGarantia) {
		this.fechaEntregaInicioGarantia = fechaEntregaInicioGarantia;
	}


	public String getFechaEntregaFinGarantia() {
		return fechaEntregaFinGarantia;
	}


	public void setFechaEntregaFinGarantia(String fechaEntregaFinGarantia) {
		this.fechaEntregaFinGarantia = fechaEntregaFinGarantia;
	}


	public Integer getCantidadGarantia() {
		return cantidadGarantia;
	}


	public void setCantidadGarantia(Integer cantidadGarantia) {
		this.cantidadGarantia = cantidadGarantia;
	}


	public String getIppActGarantia() {
		return ippActGarantia;
	}


	public void setIppActGarantia(String ippActGarantia) {
		this.ippActGarantia = ippActGarantia;
	}


	public Integer getValorGarantia() {
		return valorGarantia;
	}


	public void setValorGarantia(Integer valorGarantia) {
		this.valorGarantia = valorGarantia;
	}


	public Integer getTasaGarantia() {
		return tasaGarantia;
	}


	public void setTasaGarantia(Integer tasaGarantia) {
		this.tasaGarantia = tasaGarantia;
	}


	public Integer getIvaGarantia() {
		return ivaGarantia;
	}


	public void setIvaGarantia(Integer ivaGarantia) {
		this.ivaGarantia = ivaGarantia;
	}


	public Integer getPrimaGarantia() {
		return primaGarantia;
	}


	public void setPrimaGarantia(Integer primaGarantia) {
		this.primaGarantia = primaGarantia;
	}


	public Integer getCostoGarantia() {
		return costoGarantia;
	}


	public void setCostoGarantia(Integer costoGarantia) {
		this.costoGarantia = costoGarantia;
	}


	@ManyToOne
	@JoinColumn(name="num_id_contrato", referencedColumnName = "num_id_contrato", insertable=false,updatable=false)
	Contratos contratosGarantias;

	
	@ManyToOne
	@JoinColumn(name="num_id_tipo_garantia", referencedColumnName = "num_id_tipo_garantia", insertable=false,updatable=false)
	TiposGarantias tiposGarantia;
        
}

    