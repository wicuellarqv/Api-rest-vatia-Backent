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
	public Date FECHA;
	@Column(name = "VERSION", updatable = false, insertable = false)
	public String VERSION;
	@Column(name = "AGENTE", updatable = false, insertable = false)
	public String AGENTE;
	@Id
	@Column(name = "PLANTA", updatable = false, insertable = false)
	public String planta;
	@Column(name = "NOMBRE", updatable = false, insertable = false)
	public String nombre;
	@Column(name = "CAPACIDAD_INSTAL", updatable = false, insertable = false)
	public Double CAPACIDAD_INSTAL;
	@Column(name = "DESPACHO_CENTRAL", updatable = false, insertable = false)
	public String DESPACHO_CENTRAL;
	@Column(name = "TIPO", updatable = false, insertable = false)
	public String TIPO;
	@Column(name = "TIPO_TECNOLOGIA", updatable = false, insertable = false)
	public String TIPO_TECNOLOGIA;
	@Column(name = "EXPLOT_COMERCIAL", updatable = false, insertable = false)
	public String EXPLOT_COMERCIAL;
	@Column(name = "SUB_MER_CON_ASO", updatable = false, insertable = false)
	public String SUB_MER_CON_ASO;
	@Column(name = "USUARIO", updatable = false, insertable = false)
	public String USUARIO;
	@Column(name = "FECHA_SISTEMA", updatable = false, insertable = false)
	public String FECHA_SISTEMA;

	public Capains() {
	}

	public Capains(Date fECHA, String vERSION, String aGENTE, String planta, String nombre, Double cAPACIDAD_INSTAL,
			String dESPACHO_CENTRAL, String tIPO, String tIPO_TECNOLOGIA, String eXPLOT_COMERCIAL,
			String sUB_MER_CON_ASO, String uSUARIO, String fECHA_SISTEMA) {
		super();
		FECHA = fECHA;
		VERSION = vERSION;
		AGENTE = aGENTE;
		this.planta = planta;
		this.nombre = nombre;
		CAPACIDAD_INSTAL = cAPACIDAD_INSTAL;
		DESPACHO_CENTRAL = dESPACHO_CENTRAL;
		TIPO = tIPO;
		TIPO_TECNOLOGIA = tIPO_TECNOLOGIA;
		EXPLOT_COMERCIAL = eXPLOT_COMERCIAL;
		SUB_MER_CON_ASO = sUB_MER_CON_ASO;
		USUARIO = uSUARIO;
		FECHA_SISTEMA = fECHA_SISTEMA;
	}

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}

	public String getVERSION() {
		return VERSION;
	}

	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}

	public String getAGENTE() {
		return AGENTE;
	}

	public void setAGENTE(String aGENTE) {
		AGENTE = aGENTE;
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

	public Double getCAPACIDAD_INSTAL() {
		return CAPACIDAD_INSTAL;
	}

	public void setCAPACIDAD_INSTAL(Double cAPACIDAD_INSTAL) {
		CAPACIDAD_INSTAL = cAPACIDAD_INSTAL;
	}

	public String getDESPACHO_CENTRAL() {
		return DESPACHO_CENTRAL;
	}

	public void setDESPACHO_CENTRAL(String dESPACHO_CENTRAL) {
		DESPACHO_CENTRAL = dESPACHO_CENTRAL;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public String getTIPO_TECNOLOGIA() {
		return TIPO_TECNOLOGIA;
	}

	public void setTIPO_TECNOLOGIA(String tIPO_TECNOLOGIA) {
		TIPO_TECNOLOGIA = tIPO_TECNOLOGIA;
	}

	public String getEXPLOT_COMERCIAL() {
		return EXPLOT_COMERCIAL;
	}

	public void setEXPLOT_COMERCIAL(String eXPLOT_COMERCIAL) {
		EXPLOT_COMERCIAL = eXPLOT_COMERCIAL;
	}

	public String getSUB_MER_CON_ASO() {
		return SUB_MER_CON_ASO;
	}

	public void setSUB_MER_CON_ASO(String sUB_MER_CON_ASO) {
		SUB_MER_CON_ASO = sUB_MER_CON_ASO;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public String getFECHA_SISTEMA() {
		return FECHA_SISTEMA;
	}

	public void setFECHA_SISTEMA(String fECHA_SISTEMA) {
		FECHA_SISTEMA = fECHA_SISTEMA;
	};
}
