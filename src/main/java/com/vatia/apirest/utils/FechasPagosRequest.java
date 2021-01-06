package com.vatia.apirest.utils;

public class FechasPagosRequest {
	
	private String fechaPago;
	private String periodo;
	
	public FechasPagosRequest() {
		
	}

	public FechasPagosRequest(String fechaPago, String periodo) {
		super();
		this.fechaPago = fechaPago;
		this.periodo = periodo;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "FechasPagosRequest [fechaPago=" + fechaPago + ", periodo=" + periodo + "]";
	};
	
}
