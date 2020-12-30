package com.vatia.apirest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_estados_cliente")
@XmlRootElement
public class EstadosCliente implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "create_at")
	private Date createAt;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
	private List<CategoriaEstado> categorias_estados;
	
	public EstadosCliente() {
		
	}

	public EstadosCliente(long id, String nombre, Date createAt, List<CategoriaEstado> categorias_estados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.createAt = createAt;
		this.categorias_estados = categorias_estados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<CategoriaEstado> getCategorias_estados() {
		return categorias_estados;
	}

	public void setCategorias_estados(List<CategoriaEstado> categorias_estados) {
		this.categorias_estados = categorias_estados;
	}

}
