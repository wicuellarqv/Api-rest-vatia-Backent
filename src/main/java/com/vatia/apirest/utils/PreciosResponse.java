package com.vatia.apirest.utils;

import java.util.List;

public class PreciosResponse {

	private String periodo_negociacion, formula,
	periodo_precio, precio_referencia, mes_referencia;

	public PreciosResponse(String [] args) {
		super();
		this.periodo_negociacion = args[0].trim();
		this.formula = args[1].trim();
		this.periodo_precio = args[2].trim();
		this.precio_referencia = args[3].trim();
		this.mes_referencia = args[4].trim();
	}
	


	@Override
	public String toString() {
		return "PreciosResponse [periodo_negociacion=" + periodo_negociacion + ", formula=" + formula
				+ ", periodo_precio=" + periodo_precio + ", precio_referencia=" + precio_referencia
				+ ", mes_referencia=" + mes_referencia + "]";
	}



	public String getMes_referencia() {
		return mes_referencia;
	}

	public void setMes_referencia(String mes_referencia) {
		this.mes_referencia = mes_referencia;
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

	public String getPrecio_referencia() {
		return precio_referencia;
	}

	public void setPrecio_referencia(String precio_referencia) {
		this.precio_referencia = precio_referencia;
	}
	
	
}
