package com.vatia.apirest.modelBI;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.vatia.apirest.pkBI.ClientePk;

@Entity
@Immutable
@Table(name = "STG_DIM_CLIENTE")
@IdClass(ClientePk.class)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CLIENTE",updatable = false, insertable= false)
	private String ID_CLIENTE;
	@Column(name="ID_INTERNO",updatable = false, insertable= false)
	private String ID_INTERNO;
	@Column(name="NIT_CEDULA",updatable = false, insertable= false)
	private String NIT_CEDULA;
	@Column(name="CODIGO_SIC",updatable = false, insertable= false)
	private String CODIGO_SIC;
	@Column(name="NOMBRE_RAZON_SOCIAL",updatable = false, insertable= false)
	private String NOMBRE_RAZON_SOCIAL;
	@Column(name="NOMBRE_FACTURACION",updatable = false, insertable= false)
	private String nombreFacturacion;
	@Column(name="FECHA_SISTEMA",updatable = false, insertable= false)
	private String FECHA_SISTEMA;
	@Column(name="ID_ESTADO_CLI",updatable = false, insertable= false)
	private String ID_ESTADO_CLI;
	@Column(name="FECHA_ESTADO_CLI",updatable = false, insertable= false)
	private String FECHA_ESTADO_CLI;
	@Column(name="ID_ESTADO_HIS_MER",updatable = false, insertable= false)
	private String ID_ESTADO_HIS_MER;
	@Id
	@Column(name="FECHA_ESTADO_HIS_MER",updatable = false, insertable= false)
	private String FECHA_ESTADO_HIS_MER;
	@Column(name="NOM_ESTADO_HIS_MER",updatable = false, insertable= false)
	private String NOM_ESTADO_HIS_MER;
	@Column(name="ID_GR_CLI",updatable = false, insertable= false)
	private String ID_GR_CLI;
	@Column(name="NOM_GR_CLI",updatable = false, insertable= false)
	private String NOM_GR_CLI;
	@Column(name="ID_MUNICIPIO",updatable = false, insertable= false)
	private String ID_MUNICIPIO;
	@Column(name="NOM_MUNICIPIO",updatable = false, insertable= false)
	private String NOM_MUNICIPIO;
	@Column(name="ID_DEPARTAMENTO",updatable = false, insertable= false)
	private String ID_DEPARTAMENTO;
	@Column(name="NOM_DEPARTAMENTO",updatable = false, insertable= false)
	private String NOM_DEPARTAMENTO;
	@Column(name="ID_AGE_MEN",updatable = false, insertable= false)
	private String ID_AGE_MEN;
	@Column(name="NOM_AGE_MEN",updatable = false, insertable= false)
	private String NOM_AGE_MEN;
	@Column(name="ESTADO_AGE_MEN",updatable = false, insertable= false)
	private String ESTADO_AGE_MEN;
	@Column(name="ID_OFERTA",updatable = false, insertable= false)
	private String ID_OFERTA;
	@Column(name="APLICA_BOLSA",updatable = false, insertable= false)
	private String APLICA_BOLSA;
	@Column(name="TIPO_CONTRATO",updatable = false, insertable= false)
	private String TIPO_CONTRATO;
	@Column(name="NOMBRE_ESTADO_CLIENTE",updatable = false, insertable= false)
	private String NOMBRE_ESTADO_CLIENTE;
	@Column(name="CATEGORIA_CLIENTE",updatable = false, insertable= false)
	private String CATEGORIA_CLIENTE;
	
	public Cliente() {};
	
	public Cliente(String iD_CLIENTE, String iD_INTERNO, String nIT_CEDULA, String cODIGO_SIC,
			String nOMBRE_RAZON_SOCIAL, String nOMBRE_FACTURACION, String fECHA_SISTEMA, String iD_ESTADO_CLI,
			String fECHA_ESTADO_CLI, String iD_ESTADO_HIS_MER, String fECHA_ESTADO_HIS_MER, String nOM_ESTADO_HIS_MER,
			String iD_GR_CLI, String nOM_GR_CLI, String iD_MUNICIPIO, String nOM_MUNICIPIO, String iD_DEPARTAMENTO,
			String nOM_DEPARTAMENTO, String iD_AGE_MEN, String nOM_AGE_MEN, String eSTADO_AGE_MEN, String iD_OFERTA,
			String aPLICA_BOLSA, String tIPO_CONTRATO, String nOMBRE_ESTADO_CLIENTE, String cATEGORIA_CLIENTE) {
		super();
		ID_CLIENTE = iD_CLIENTE;
		ID_INTERNO = iD_INTERNO;
		NIT_CEDULA = nIT_CEDULA;
		CODIGO_SIC = cODIGO_SIC;
		NOMBRE_RAZON_SOCIAL = nOMBRE_RAZON_SOCIAL;
		nombreFacturacion = nOMBRE_FACTURACION;
		FECHA_SISTEMA = fECHA_SISTEMA;
		ID_ESTADO_CLI = iD_ESTADO_CLI;
		FECHA_ESTADO_CLI = fECHA_ESTADO_CLI;
		ID_ESTADO_HIS_MER = iD_ESTADO_HIS_MER;
		FECHA_ESTADO_HIS_MER = fECHA_ESTADO_HIS_MER;
		NOM_ESTADO_HIS_MER = nOM_ESTADO_HIS_MER;
		ID_GR_CLI = iD_GR_CLI;
		NOM_GR_CLI = nOM_GR_CLI;
		ID_MUNICIPIO = iD_MUNICIPIO;
		NOM_MUNICIPIO = nOM_MUNICIPIO;
		ID_DEPARTAMENTO = iD_DEPARTAMENTO;
		NOM_DEPARTAMENTO = nOM_DEPARTAMENTO;
		ID_AGE_MEN = iD_AGE_MEN;
		NOM_AGE_MEN = nOM_AGE_MEN;
		ESTADO_AGE_MEN = eSTADO_AGE_MEN;
		ID_OFERTA = iD_OFERTA;
		APLICA_BOLSA = aPLICA_BOLSA;
		TIPO_CONTRATO = tIPO_CONTRATO;
		NOMBRE_ESTADO_CLIENTE = nOMBRE_ESTADO_CLIENTE;
		CATEGORIA_CLIENTE = cATEGORIA_CLIENTE;
	}

	public String getID_CLIENTE() {
		return ID_CLIENTE;
	}

	public void setID_CLIENTE(String iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}

	public String getID_INTERNO() {
		return ID_INTERNO;
	}

	public void setID_INTERNO(String iD_INTERNO) {
		ID_INTERNO = iD_INTERNO;
	}

	public String getNIT_CEDULA() {
		return NIT_CEDULA;
	}

	public void setNIT_CEDULA(String nIT_CEDULA) {
		NIT_CEDULA = nIT_CEDULA;
	}

	public String getCODIGO_SIC() {
		return CODIGO_SIC;
	}

	public void setCODIGO_SIC(String cODIGO_SIC) {
		CODIGO_SIC = cODIGO_SIC;
	}

	public String getNOMBRE_RAZON_SOCIAL() {
		return NOMBRE_RAZON_SOCIAL;
	}

	public void setNOMBRE_RAZON_SOCIAL(String nOMBRE_RAZON_SOCIAL) {
		NOMBRE_RAZON_SOCIAL = nOMBRE_RAZON_SOCIAL;
	}

	public String getNombreFacturacion() {
		return nombreFacturacion;
	}

	public void setNombreFacturacion(String nombreFacturacion) {
		this.nombreFacturacion = nombreFacturacion;
	}

	public String getFECHA_SISTEMA() {
		return FECHA_SISTEMA;
	}

	public void setFECHA_SISTEMA(String fECHA_SISTEMA) {
		FECHA_SISTEMA = fECHA_SISTEMA;
	}

	public String getID_ESTADO_CLI() {
		return ID_ESTADO_CLI;
	}

	public void setID_ESTADO_CLI(String iD_ESTADO_CLI) {
		ID_ESTADO_CLI = iD_ESTADO_CLI;
	}

	public String getFECHA_ESTADO_CLI() {
		return FECHA_ESTADO_CLI;
	}

	public void setFECHA_ESTADO_CLI(String fECHA_ESTADO_CLI) {
		FECHA_ESTADO_CLI = fECHA_ESTADO_CLI;
	}

	public String getID_ESTADO_HIS_MER() {
		return ID_ESTADO_HIS_MER;
	}

	public void setID_ESTADO_HIS_MER(String iD_ESTADO_HIS_MER) {
		ID_ESTADO_HIS_MER = iD_ESTADO_HIS_MER;
	}

	public String getFECHA_ESTADO_HIS_MER() {
		return FECHA_ESTADO_HIS_MER;
	}

	public void setFECHA_ESTADO_HIS_MER(String fECHA_ESTADO_HIS_MER) {
		FECHA_ESTADO_HIS_MER = fECHA_ESTADO_HIS_MER;
	}

	public String getNOM_ESTADO_HIS_MER() {
		return NOM_ESTADO_HIS_MER;
	}

	public void setNOM_ESTADO_HIS_MER(String nOM_ESTADO_HIS_MER) {
		NOM_ESTADO_HIS_MER = nOM_ESTADO_HIS_MER;
	}

	public String getID_GR_CLI() {
		return ID_GR_CLI;
	}

	public void setID_GR_CLI(String iD_GR_CLI) {
		ID_GR_CLI = iD_GR_CLI;
	}

	public String getNOM_GR_CLI() {
		return NOM_GR_CLI;
	}

	public void setNOM_GR_CLI(String nOM_GR_CLI) {
		NOM_GR_CLI = nOM_GR_CLI;
	}

	public String getID_MUNICIPIO() {
		return ID_MUNICIPIO;
	}

	public void setID_MUNICIPIO(String iD_MUNICIPIO) {
		ID_MUNICIPIO = iD_MUNICIPIO;
	}

	public String getNOM_MUNICIPIO() {
		return NOM_MUNICIPIO;
	}

	public void setNOM_MUNICIPIO(String nOM_MUNICIPIO) {
		NOM_MUNICIPIO = nOM_MUNICIPIO;
	}

	public String getID_DEPARTAMENTO() {
		return ID_DEPARTAMENTO;
	}

	public void setID_DEPARTAMENTO(String iD_DEPARTAMENTO) {
		ID_DEPARTAMENTO = iD_DEPARTAMENTO;
	}

	public String getNOM_DEPARTAMENTO() {
		return NOM_DEPARTAMENTO;
	}

	public void setNOM_DEPARTAMENTO(String nOM_DEPARTAMENTO) {
		NOM_DEPARTAMENTO = nOM_DEPARTAMENTO;
	}

	public String getID_AGE_MEN() {
		return ID_AGE_MEN;
	}

	public void setID_AGE_MEN(String iD_AGE_MEN) {
		ID_AGE_MEN = iD_AGE_MEN;
	}

	public String getNOM_AGE_MEN() {
		return NOM_AGE_MEN;
	}

	public void setNOM_AGE_MEN(String nOM_AGE_MEN) {
		NOM_AGE_MEN = nOM_AGE_MEN;
	}

	public String getESTADO_AGE_MEN() {
		return ESTADO_AGE_MEN;
	}

	public void setESTADO_AGE_MEN(String eSTADO_AGE_MEN) {
		ESTADO_AGE_MEN = eSTADO_AGE_MEN;
	}

	public String getID_OFERTA() {
		return ID_OFERTA;
	}

	public void setID_OFERTA(String iD_OFERTA) {
		ID_OFERTA = iD_OFERTA;
	}

	public String getAPLICA_BOLSA() {
		return APLICA_BOLSA;
	}

	public void setAPLICA_BOLSA(String aPLICA_BOLSA) {
		APLICA_BOLSA = aPLICA_BOLSA;
	}

	public String getTIPO_CONTRATO() {
		return TIPO_CONTRATO;
	}

	public void setTIPO_CONTRATO(String tIPO_CONTRATO) {
		TIPO_CONTRATO = tIPO_CONTRATO;
	}

	public String getNOMBRE_ESTADO_CLIENTE() {
		return NOMBRE_ESTADO_CLIENTE;
	}

	public void setNOMBRE_ESTADO_CLIENTE(String nOMBRE_ESTADO_CLIENTE) {
		NOMBRE_ESTADO_CLIENTE = nOMBRE_ESTADO_CLIENTE;
	}

	public String getCATEGORIA_CLIENTE() {
		return CATEGORIA_CLIENTE;
	}

	public void setCATEGORIA_CLIENTE(String cATEGORIA_CLIENTE) {
		CATEGORIA_CLIENTE = cATEGORIA_CLIENTE;
	}
}
