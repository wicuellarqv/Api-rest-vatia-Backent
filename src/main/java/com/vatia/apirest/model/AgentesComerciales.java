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
@Table(name = "tbl_agentes_comerciales")
@XmlRootElement

public class AgentesComerciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_agente_ccial")
    private Integer idAgenteCcial;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "str_nombre_agente_ccial")
    private String nombreAgenteCcial;
    
    @Basic(optional = false)
    @Column(name = "str_codigo_sic_agente_ccial")
    private String codSicAgenteCcial;

    @Basic(optional = false)
    @Column(name = "str_nombre_corto_agente_ccial")
    private String nombreCortoAgenteCcial;

	public Integer getIdAgenteCcial() {
		return idAgenteCcial;
	}

	public void setIdAgenteCcial(Integer idAgenteCcial) {
		this.idAgenteCcial = idAgenteCcial;
	}

	public String getNombreAgenteCcial() {
		return nombreAgenteCcial;
	}

	public void setNombreAgenteCcial(String nombreAgenteCcial) {
		this.nombreAgenteCcial = nombreAgenteCcial;
	}

	public String getCodSicAgenteCcial() {
		return codSicAgenteCcial;
	}

	public void setCodSicAgenteCcial(String codSicAgenteCcial) {
		this.codSicAgenteCcial = codSicAgenteCcial;
	}

	public String getNombreCortoAgenteCcial() {
		return nombreCortoAgenteCcial;
	}

	public void setNombreCortoAgenteCcial(String nombreCortoAgenteCcial) {
		this.nombreCortoAgenteCcial = nombreCortoAgenteCcial;
	}
    
	
	   
    
}

    