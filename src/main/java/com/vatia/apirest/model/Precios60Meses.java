package com.vatia.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_precios_60_meses")
@XmlRootElement
public class Precios60Meses implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "dtm_periodo")
	private String dtmPeriodo;
	
	@Column(name = "num_precio_periodo")
	private Double numPrecioPeriodo;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "id_contrato_60_meses", referencedColumnName = "id")
	private Contratos60Meses contratos60Meses;
	
	public Precios60Meses() {
		
	}

	public Precios60Meses(Integer id, String dtmPeriodo, Double numPrecioPeriodo, Contratos60Meses contratos60Meses) {
		super();
		this.id = id;
		this.dtmPeriodo = dtmPeriodo;
		this.numPrecioPeriodo = numPrecioPeriodo;
		this.contratos60Meses = contratos60Meses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDtmPeriodo() {
		return dtmPeriodo;
	}

	public void setDtmPeriodo(String dtmPeriodo) {
		this.dtmPeriodo = dtmPeriodo;
	}

	public Double getNumPrecioPeriodo() {
		return numPrecioPeriodo;
	}

	public void setNumPrecioPeriodo(Double numPrecioPeriodo) {
		this.numPrecioPeriodo = numPrecioPeriodo;
	}

	public Contratos60Meses getContratos60Meses() {
		return contratos60Meses;
	}

	public void setContratos60Meses(Contratos60Meses contratos60Meses) {
		this.contratos60Meses = contratos60Meses;
	}

	@Override
	public String toString() {
		return "Precios60Meses [id=" + id + ", dtmPeriodo=" + dtmPeriodo + ", numPrecioPeriodo=" + numPrecioPeriodo
				+ "]";
	}
}
