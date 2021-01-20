package com.vatia.apirest.utils;

public class ConsultaContratosResponse {
	private String idContrato,
					numContrato,
					codSic,
					negociacionContrato,
					condicion,
					tipoMercado,
					tipoContrato,
					periodoInicio,
					periodoFinalizacion,
					nombreComprador,
					nombreVendedor,
					estado;

	public String getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getCodSic() {
		return codSic;
	}

	public void setCodSic(String codSic) {
		this.codSic = codSic;
	}

	public String getNegociacionContrato() {
		return negociacionContrato;
	}

	public void setNegociacionContrato(String negociacionContrato) {
		this.negociacionContrato = negociacionContrato;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getTipoMercado() {
		return tipoMercado;
	}

	public void setTipoMercado(String tipoMercado) {
		this.tipoMercado = tipoMercado;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(String periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public String getPeriodoFinalizacion() {
		return periodoFinalizacion;
	}

	public void setPeriodoFinalizacion(String periodoFinalizacion) {
		this.periodoFinalizacion = periodoFinalizacion;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	@Override
	public String toString() {
		return "ConsultaContratosResponse {idContrato=" + idContrato + ", numContrato=" + numContrato + ", codSic="
				+ codSic + ", negociacionContrato=" + negociacionContrato + ", condicion=" + condicion
				+ ", tipoMercado=" + tipoMercado + ", tipoContrato=" + tipoContrato + ", periodoInicio=" + periodoInicio
				+ ", periodoFinalizacion=" + periodoFinalizacion + ", nombreComprador=" + nombreComprador
				+ ", nombreVendedor=" + nombreVendedor + ", estado=" + estado + "}";
	}
	
}
