package com.vatia.apirest.utils;

public class fechaPagoResponse {
	
private String id_fecha_pago ,fecha_pago_periodo, contrato, fecha_periodo;
	
	public fechaPagoResponse(String [] args) {
		super();
		this.id_fecha_pago = args[0].trim();
		this.fecha_pago_periodo = args[1].trim();
		this.contrato = args[2].trim();
		this.fecha_periodo = args[3].trim();

	}

	@Override
	public String toString() {
		return "fechaPagoResponseRequest [id_fecha_pago=" + id_fecha_pago + ", fecha_pago_periodo=" + fecha_pago_periodo
				+ ", contrato=" + contrato + ", fecha_periodo=" + fecha_periodo + "]";
	}

	public String getId_fecha_pago() {
		return id_fecha_pago;
	}

	public void setId_fecha_pago(String id_fecha_pago) {
		this.id_fecha_pago = id_fecha_pago;
	}

	public String getFecha_pago_periodo() {
		return fecha_pago_periodo;
	}

	public void setFecha_pago_periodo(String fecha_pago_periodo) {
		this.fecha_pago_periodo = fecha_pago_periodo;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getFecha_periodo() {
		return fecha_periodo;
	}

	public void setFecha_periodo(String fecha_periodo) {
		this.fecha_periodo = fecha_periodo;
	}
	
	


}
