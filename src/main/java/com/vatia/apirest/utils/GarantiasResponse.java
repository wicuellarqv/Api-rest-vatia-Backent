package com.vatia.apirest.utils;

public class GarantiasResponse {
	
	private String tipo_garantia,tasa, iva, prima, costo, valor, inicio, fin, fecha_entrega, ipp, cantidad;
	
	public GarantiasResponse(String [] args) {
		super();
		this.tipo_garantia = args[0].trim();
		this.tasa = args[1].trim();
		this.iva = args[2].trim();
		this.prima = args[3].trim();
		this.costo = args[4].trim();
		this.valor = args[5].trim();
		this.inicio = args[6].trim();
		this.fin = args[7].trim();
		this.fecha_entrega = args[8].trim();
		this.ipp = args[9].trim();
		this.cantidad = args[10].trim();
	}
	
			

	
	@Override
	public String toString() {
		return "GarantiasResponse [tipo_garantia=" + tipo_garantia + ", tasa=" + tasa + ", iva=" + iva + ", prima="
				+ prima + ", costo=" + costo + ", valor=" + valor + ", fecha_inicio=" + inicio + ", fecha_fin="
				+ fin + ", fecha_entrega=" + fecha_entrega + ", ipp_garantia=" + ipp + ", cantidad="
				+ cantidad + "]";
	}



	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}


	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getIpp() {
		return ipp;
	}

	public void setIpp(String ipp) {
		this.ipp = ipp;
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

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	
}
