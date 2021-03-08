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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_planta_cant_contrato")
@XmlRootElement
public class PlantaCantContrato implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	Integer id;
	
	@Column(name = "planta")
	private String planta;
	
	@Column(name = "nombre_planta")
	private String nombrePlanta;
	
	@Column(name = "cantidad_cubierta")
	private Integer cantidadCubierta;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "contrato", referencedColumnName = "num_id_contrato")
	private Contratos contrato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "create_at")
	private Date createAt;
	
	public PlantaCantContrato() {
		
	}

	public PlantaCantContrato(Integer id, String planta, String nombrePlanta, Integer cantidadCubierta,
			Contratos contrato, Date createAt) {
		super();
		this.id = id;
		this.planta = planta;
		this.nombrePlanta = nombrePlanta;
		this.cantidadCubierta = cantidadCubierta;
		this.contrato = contrato;
		this.createAt = createAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getNombrePlanta() {
		return nombrePlanta;
	}

	public void setNombrePlanta(String nombrePlanta) {
		this.nombrePlanta = nombrePlanta;
	}

	public Integer getCantidadCubierta() {
		return cantidadCubierta;
	}

	public void setCantidadCubierta(Integer cantidadCubierta) {
		this.cantidadCubierta = cantidadCubierta;
	}

	public Contratos getContrato() {
		return contrato;
	}

	public void setContrato(Contratos contrato) {
		this.contrato = contrato;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
