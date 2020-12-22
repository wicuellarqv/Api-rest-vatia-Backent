package com.vatia.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categoria_cliente")
public class CategoriaCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	Integer id;
	
	@Column(name = "id_cliente")
	private String idCliente;
	
	@Column(name = "nom_cliente")
	private String nombreCliente;
	
	@Column(name = "fecha_presupuesto")
	private String fechaPresupuesto;
	
	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	public CategoriaCliente() {
		
	}

	public CategoriaCliente(Integer id, String idCliente, String nombreCliente, String fechaPresupuesto,
			Categoria categoria) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaPresupuesto = fechaPresupuesto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFechaPresupuesto() {
		return fechaPresupuesto;
	}

	public void setFechaPresupuesto(String fechaPresupuesto) {
		this.fechaPresupuesto = fechaPresupuesto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
