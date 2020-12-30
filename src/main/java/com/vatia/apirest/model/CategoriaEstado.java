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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_categoria_estado")
@XmlRootElement
public class CategoriaEstado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	@ManyToOne()
	@JoinColumn(name = "estado", referencedColumnName = "id")
	private EstadosCliente estado;
	
	public CategoriaEstado() {
		
	}

	public CategoriaEstado(Integer id, Categoria categoria, EstadosCliente estado) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public EstadosCliente getEstado() {
		return estado;
	}

	public void setEstado(EstadosCliente estado) {
		this.estado = estado;
	}

	
}
