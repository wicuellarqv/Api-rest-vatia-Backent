package com.vatia.apirest.utils;

public class PreciosResponse {

	private String periodo_negociacion, formula,
	periodo_precio, precioReferencia, mes;

	public PreciosResponse(String [] args) {
		super();
		this.periodo_negociacion = args[0].trim();
		this.formula = args[1].trim();
		this.periodo_precio = args[2].trim();
		this.precioReferencia = args[3].trim();
		this.mes = args[4].trim();
	}
	


	@Override
	public String toString() {
		return "PreciosResponse [periodo_negociacion=" + periodo_negociacion + ", formula=" + formula
				+ ", periodo_precio=" + periodo_precio + ", precio_referencia=" + precioReferencia
				+ ", mes_referencia=" + mes + "]";
	}



	public String getPrecioReferencia() {
		return precioReferencia;
	}

	public void setPrecioReferencia(String precioReferencia) {
		this.precioReferencia = precioReferencia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getPeriodo_negociacion() {
		return periodo_negociacion;
	}

	public void setPeriodo_negociacion(String periodo_negociacion) {
		this.periodo_negociacion = periodo_negociacion;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getPeriodo_precio() {
		return periodo_precio;
	}

	public void setPeriodo_precio(String periodo_precio) {
		this.periodo_precio = periodo_precio;
	}
	
}
