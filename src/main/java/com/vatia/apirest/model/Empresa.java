package com.vatia.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String nit;

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
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", name=" + name + ", nit=" + nit + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getNit()=" + getNit() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
