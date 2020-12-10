package com.vatia.apirest.model;

public class SaveResponse {
	
	private Integer codigoContrato;
	private String codigoSicContrato;
	private String msg;
	private boolean estado;
	
	
	public Integer getCodigoContrato() {
		return codigoContrato;
	}
	public void setCodigoContrato(Integer codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
	public String getCodigoSicContrato() {
		return codigoSicContrato;
	}
	public void setCodigoSicContrato(String codigoSicContrato) {
		this.codigoSicContrato = codigoSicContrato;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
