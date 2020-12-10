package com.vatia.apirest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_contratos")
@XmlRootElement

public class Contratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_contrato")
    private Integer idContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "num_id_mod_contrato")
    private Integer idModalidadContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_agnte_ccial_comp")
    private Integer idAgenteComprador;
    
    @Basic(optional = false)
    @Column(name = "num_id_agnte_ccial_vend")
    private Integer idAgenteVendedor;
      
    @Column(name = "str_codigo_sic_contrato")
    private String codSicContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_tipo_contrato")
    private Integer idTipoContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_tipo_mercado")
    private Integer idTipoMercado;
    
    @Basic(optional = false)
    @Column(name = "dtm_periodo_inicio")
    private String fecPeriodoInicio;
    
    @Basic(optional = false)
    @Column(name = "dtm_periodo_fin")
    private String fecPeriodoFin;
    
    @Basic(optional = false)
    @Column(name = "str_estado")
    private String estadoContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_fecha_corte")
    private Integer idFechaCorte;
        
    @Basic(optional = false)
    @Column(name = "str_nombre_contacto")
    private String nombreContacto;
    
    @Basic(optional = false)
    @Column(name = "str_tel_contacto")
    private String telContacto;
    
    @Basic(optional = false)
    @Column(name = "str_email_contacto")
    private String emailContacto;
    
    @Basic(optional = false)
    @Column(name = "str_fecha_firma")
    private String fechaFirmaContrato;
    
    @Column(name = "str_doc_contacto")
    private String docContacto;
    
    
	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public Integer getIdModalidadContrato() {
		return idModalidadContrato;
	}

	public void setIdModalidadContrato(Integer idModalidadContrato) {
		this.idModalidadContrato = idModalidadContrato;
	}

	public Integer getIdAgenteComprador() {
		return idAgenteComprador;
	}

	public void setIdAgenteComprador(Integer idAgenteComprador) {
		this.idAgenteComprador = idAgenteComprador;
	}

	public Integer getIdAgenteVendedor() {
		return idAgenteVendedor;
	}

	public void setIdAgenteVendedor(Integer idAgenteVendedor) {
		this.idAgenteVendedor = idAgenteVendedor;
	}

	public String getCodSicContrato() {
		return codSicContrato;
	}

	public void setCodSicContrato(String codSicContrato) {
		this.codSicContrato = codSicContrato;
	}

	public Integer getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public Integer getIdTipoMercado() {
		return idTipoMercado;
	}

	public void setIdTipoMercado(Integer idTipoMercado) {
		this.idTipoMercado = idTipoMercado;
	}

	public String getFecPeriodoInicio() {
		return fecPeriodoInicio;
	}

	public void setFecPeriodoInicio(String fecPeriodoInicio) {
		this.fecPeriodoInicio = fecPeriodoInicio;
	}

	public String getFecPeriodoFin() {
		return fecPeriodoFin;
	}

	public void setFecPeriodoFin(String fecPeriodoFin) {
		this.fecPeriodoFin = fecPeriodoFin;
	}

	public String getEstadoContrato() {
		return estadoContrato;
	}

	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
    
	
	public Integer getIdFechaCorte() {
		return idFechaCorte;
	}

	public void setIdFechaCorte(Integer idFechaCorte) {
		this.idFechaCorte = idFechaCorte;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelContacto() {
		return telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public String getFechaFirmaContrato() {
		return fechaFirmaContrato;
	}

	public void setFechaFirmaContrato(String fechaFirmaContrato) {
		this.fechaFirmaContrato = fechaFirmaContrato;
	}

	public String getDocContacto() {
		return docContacto;
	}

	public void setDocContacto(String docContacto) {
		this.docContacto = docContacto;
	}

	public ModalidadesContratos getModalidadContrato() {
		return modalidadContrato;
	}

	public void setModalidadContrato(ModalidadesContratos modalidadContrato) {
		this.modalidadContrato = modalidadContrato;
	}

	public TiposContratos getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TiposContratos tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public TiposMercados getTipoMercado() {
		return tipoMercado;
	}

	public void setTipoMercado(TiposMercados tipoMercado) {
		this.tipoMercado = tipoMercado;
	}

	public AgentesComerciales getAgentesCcialesComp() {
		return agentesCcialesComp;
	}

	public void setAgentesCcialesComp(AgentesComerciales agentesCcialesComp) {
		this.agentesCcialesComp = agentesCcialesComp;
	}

	public AgentesComerciales getAgentesCcialesVend() {
		return agentesCcialesVend;
	}

	public void setAgentesCcialesVend(AgentesComerciales agentesCcialesVend) {
		this.agentesCcialesVend = agentesCcialesVend;
	}

	public FechasCorteContratos getFechasCorteCont() {
		return fechasCorteCont;
	}

	public void setFechasCorteCont(FechasCorteContratos fechasCorteCont) {
		this.fechasCorteCont = fechasCorteCont;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@ManyToOne
	@JoinColumn(name="num_id_mod_contrato", referencedColumnName = "num_id_mod_contrato", insertable=false,updatable=false)
	ModalidadesContratos modalidadContrato;
	
	@ManyToOne
	@JoinColumn(name="num_id_tipo_contrato", referencedColumnName = "num_id_tipo_contrato", insertable=false,updatable=false)
	TiposContratos tipoContrato;
	
	@ManyToOne
	@JoinColumn(name="num_id_tipo_mercado", referencedColumnName = "num_id_tipo_mercado", insertable=false,updatable=false)
	TiposMercados tipoMercado;
	
	@ManyToOne
	@JoinColumn(name="num_id_agnte_ccial_comp", referencedColumnName = "num_id_agente_ccial", insertable=false,updatable=false)
	AgentesComerciales agentesCcialesComp;
	
	@ManyToOne
	@JoinColumn(name="num_id_agnte_ccial_vend", referencedColumnName = "num_id_agente_ccial", insertable=false,updatable=false)
	AgentesComerciales agentesCcialesVend;
	
	@ManyToOne
	@JoinColumn(name="num_id_fecha_corte", referencedColumnName = "num_id_fecha_corte", insertable=false,updatable=false)
	FechasCorteContratos fechasCorteCont;
	
}

    