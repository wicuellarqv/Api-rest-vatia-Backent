package com.vatia.apirest.utils;

public class TipoCantidadResponse {
	

	private String tipoCantidad, fecha, hora1, hora2, hora3, hora4, hora5, hora6;

	public TipoCantidadResponse(String [] args) {
		super();
		this.tipoCantidad = args[0].trim();
		this.fecha = args[1].trim();
		this.hora1 = args[2].trim();
		this.hora2 = args[3].trim();
		this.hora3 = args[4].trim();
		this.hora4 = args[5].trim();
		this.hora5 = args[6].trim();
		this.hora6 = args[7].trim();
	}
	
	@Override
	public String toString() {
		return "TipoCantidadResponse [tipoCantidad=" + tipoCantidad + ", fecha=" + fecha + ", hora1=" + hora1
				+ ", hora2=" + hora2 + ", hora3=" + hora3 + ", hora4=" + hora4 + ", hora5=" + hora5 + ", hora6=" + hora6
				+ "]";
	}

	public String getTipoCantidad() {
		return tipoCantidad;
	}

	public void setTipoCantidad(String tipoCantidad) {
		this.tipoCantidad = tipoCantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora1() {
		return hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getHora2() {
		return hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public String getHora3() {
		return hora3;
	}

	public void setHora3(String hora3) {
		this.hora3 = hora3;
	}

	public String getHora4() {
		return hora4;
	}

	public void setHora4(String hora4) {
		this.hora4 = hora4;
	}

	public String getHora5() {
		return hora5;
	}

	public void setHora5(String hora5) {
		this.hora5 = hora5;
	}

	public String getHora6() {
		return hora6;
	}

	public void setHora6(String hora6) {
		this.hora6 = hora6;
	}
	
}
