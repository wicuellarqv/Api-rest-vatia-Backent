package com.vatia.apirest.modelBI;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "STG_CAPAINS")
public class Capains implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "FECHA", updatable = false, insertable = false)
	public Date fecha;
	@Column(name = "VERSION", updatable = false, insertable = false)
	public String version;
	@Column(name = "AGENTE", updatable = false, insertable = false)
	public String agente;
	@Id
	@Column(name = "PLANTA", updatable = false, insertable = false)
	public String planta;
	@Column(name = "NOMBRE", updatable = false, insertable = false)
	public String nombre;
	@Column(name = "CAPACIDAD_INSTAL", updatable = false, insertable = false)
	public Double capacidadInstall;
	@Column(name = "DESPACHO_CENTRAL", updatable = false, insertable = false)
	public String despachoCentral;
	@Column(name = "TIPO", updatable = false, insertable = false)
	public String tipo;
	@Column(name = "TIPO_TECNOLOGIA", updatable = false, insertable = false)
	public String tipoTecnologia;
	@Column(name = "EXPLOT_COMERCIAL", updatable = false, insertable = false)
	public String explotComercial;
	@Column(name = "SUB_MER_CON_ASO", updatable = false, insertable = false)
	public String subMerConAso;
	@Column(name = "USUARIO", updatable = false, insertable = false)
	public String usuario;
	@Column(name = "FECHA_SISTEMA", updatable = false, insertable = false)
	public String fechaSistema;

	public Capains() {
	}

	public Capains(Date fecha, String version, String agente, String planta, String nombre, Double capacidadInstall,
			String despachoCentral, String tipo, String tipoTecnologia, String explotComercial, String subMerConAso,
			String usuario, String fechaSistema) {
		super();
		this.fecha = fecha;
		this.version = version;
		this.agente = agente;
		this.planta = planta;
		this.nombre = nombre;
		this.capacidadInstall = capacidadInstall;
		this.despachoCentral = despachoCentral;
		this.tipo = tipo;
		this.tipoTecnologia = tipoTecnologia;
		this.explotComercial = explotComercial;
		this.subMerConAso = subMerConAso;
		this.usuario = usuario;
		this.fechaSistema = fechaSistema;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCapacidadInstall() {
		return capacidadInstall;
	}

	public void setCapacidadInstall(Double capacidadInstall) {
		this.capacidadInstall = capacidadInstall;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFechaSistema() {
		return fechaSistema;
	}

	public void setFechaSistema(String fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

}
