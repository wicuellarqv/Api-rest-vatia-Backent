package com.vatia.apirest.utils;

public class GarantiasResponse {
	
	private String tipo_garantia, cantidad,
	tasa, iva, prima, costo, valor, fecha_inicio, fecha_fin, fecha_entrega;
	
	public GarantiasResponse(String [] args) {
		super();
		this.tipo_garantia = args[0].trim();
		this.cantidad = args[1].trim();
		this.tasa = args[2].trim();
		this.iva = args[3].trim();
		this.prima = args[4].trim();
		this.costo = args[5].trim();
		this.valor = args[6].trim();
		this.fecha_inicio = args[7].trim();
		this.fecha_fin = args[8].trim();
		this.fecha_entrega = args[9].trim();
	}

	public String getTipo_garantia() {
		return tipo_garantia;
	}

	public void setTipo_garantia(String tipo_garantia) {
		this.tipo_garantia = tipo_garantia;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getTasa() {
		return tasa;
	}

	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getPrima() {
		return prima;
	}

	public void setPrima(String prima) {
		this.prima = prima;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	
}
