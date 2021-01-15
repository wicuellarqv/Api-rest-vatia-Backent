package com.vatia.apirest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_contratos_60_meses")
@XmlRootElement
public class Contratos60Meses implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	Integer id;
	
	@Column(name = "num_cod_contrato")
	private Integer numCodContrato;
	
	@Column(name = "num_id_agente_comprador")
	private Integer numIdAgenteComprador;
	
	@Column(name = "num_id_agente_vendedor")
	private Integer numIdAgenteVendedor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contratos60Meses")
	private List<Precios60Meses> precios60Meses;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contratos60Meses")
	private List<Cantidad60Meses> cantidad60Meses;
	
	public Contratos60Meses() {
		
	}

	public Contratos60Meses(Integer id, Integer numCodContrato, Integer numIdAgenteComprador,
			Integer numIdAgenteVendedor, List<Precios60Meses> precios60Meses, List<Cantidad60Meses> cantidad60Meses) {
		super();
		this.id = id;
		this.numCodContrato = numCodContrato;
		this.numIdAgenteComprador = numIdAgenteComprador;
		this.numIdAgenteVendedor = numIdAgenteVendedor;
		this.precios60Meses = precios60Meses;
		this.cantidad60Meses = cantidad60Meses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumCodContrato() {
		return numCodContrato;
	}

	public void setNumCodContrato(Integer numCodContrato) {
		this.numCodContrato = numCodContrato;
	}

	public Integer getNumIdAgenteComprador() {
		return numIdAgenteComprador;
	}

	public void setNumIdAgenteComprador(Integer numIdAgenteComprador) {
		this.numIdAgenteComprador = numIdAgenteComprador;
	}

	public Integer getNumIdAgenteVendedor() {
		return numIdAgenteVendedor;
	}

	public void setNumIdAgenteVendedor(Integer numIdAgenteVendedor) {
		this.numIdAgenteVendedor = numIdAgenteVendedor;
	}

	public List<Precios60Meses> getPrecios60Meses() {
		return precios60Meses;
	}

	public void setPrecios60Meses(List<Precios60Meses> precios60Meses) {
		this.precios60Meses = precios60Meses;
	}

	public List<Cantidad60Meses> getCantidad60Meses() {
		return cantidad60Meses;
	}

	public void setCantidad60Meses(List<Cantidad60Meses> cantidad60Meses) {
		this.cantidad60Meses = cantidad60Meses;
	}

	@Override
	public String toString() {
		return "Contratos60Meses [id=" + id + ", numCodContrato=" + numCodContrato + ", numIdAgenteComprador="
				+ numIdAgenteComprador + ", numIdAgenteVendedor=" + numIdAgenteVendedor + "]";
	}
}
