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
@Table(name = "tbl_empresa_planta")
@XmlRootElement
public class EmpresaPlanta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "FECHA")
	private String fecha;
	@Column(name = "PLANTA")
	private String planta;
	@Column(name = "AGENTE")
	private String agente;
	@Column(name = "VERSION")
	private String version;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "CAPACIDAD_INSTAL")
	private String capacidad;
	@Column(name = "DESPACHO_CENTRAL")
	private String despachoCentral;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "TIPO_TECNOLOGIA")
	private String tipoTecnologia;
	@Column(name = "EXPLOT_COMERCIAL")
	private String explotComercial;
	@Column(name = "SUB_MER_CON_ASO")
	private String subMerConAso;

	@ManyToOne()
	@JoinColumn(name = "empresa", referencedColumnName = "id")
	private Empresa empresa;

	public EmpresaPlanta() {

	}

	public EmpresaPlanta(Integer id, String fecha, String planta, String agente, String version, String nombre,
			String capacidad, String despachoCentral, String tipo, String tipoTecnologia, String explotComercial,
			String subMerConAso, Empresa empresa) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.planta = planta;
		this.agente = agente;
		this.version = version;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.despachoCentral = despachoCentral;
		this.tipo = tipo;
		this.tipoTecnologia = tipoTecnologia;
		this.explotComercial = explotComercial;
		this.subMerConAso = subMerConAso;
		this.empresa = empresa;
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

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getDespachoCentral() {
		return despachoCentral;
	}

	public void setDespachoCentral(String despachoCentral) {
		this.despachoCentral = despachoCentral;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoTecnologia() {
		return tipoTecnologia;
	}

	public void setTipoTecnologia(String tipoTecnologia) {
		this.tipoTecnologia = tipoTecnologia;
	}

	public String getExplotComercial() {
		return explotComercial;
	}

	public void setExplotComercial(String explotComercial) {
		this.explotComercial = explotComercial;
	}

	public String getSubMerConAso() {
		return subMerConAso;
	}

	public void setSubMerConAso(String subMerConAso) {
		this.subMerConAso = subMerConAso;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
