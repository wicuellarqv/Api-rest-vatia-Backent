package com.vatia.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_empresa")
@XmlRootElement
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String nit;
	@Column
	private String actividad;

	public Empresa() {
		
	}
	
	public Empresa(Integer id, String name, String nit, String actividad) {
		super();
		this.id = id;
		this.name = name;
		this.nit = nit;
		this.actividad = actividad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}


}
