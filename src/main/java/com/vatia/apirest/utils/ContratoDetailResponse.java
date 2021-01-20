package com.vatia.apirest.utils;

public class ContratoDetailResponse {

	private String id_contrato;
	private String codigo_sic;
	private String negocio_contrato;
	private String estado;
	private String comprador;
	private String vendedor;
	private String fecha_inicio;
	private String fecha_fin;
	private String condicion;
	private String formula;
	private String num_contrato;

	public ContratoDetailResponse(String[] args) {
		super();
		this.id_contrato = args[0].trim();
		this.codigo_sic = args[1].trim();
		this.negocio_contrato = args[2].trim();
		this.estado = args[3].trim();
		this.comprador = args[4].trim();
		this.vendedor = args[5].trim();
		this.fecha_inicio = args[6].trim();
		this.fecha_fin = args[7].trim();
		this.condicion = args[7].trim();
		this.formula = args[8].trim();
		this.num_contrato = args[9].trim();
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "{'id_contrato'='" + id_contrato + "', 'codigo_sic'='" + codigo_sic + "', 'negocio_contrato'='" + negocio_contrato
				+ "', 'estado'='" + estado + "', 'comprador'='" + comprador + "', 'vendedor'='" + vendedor + "', 'fecha_inicio'='"
				+ fecha_inicio + "', 'fecha_fin'='" + fecha_fin + "', 'condicion'='" + condicion + "', 'formula'='" + formula
				+ "', 'num_contrato'='" + num_contrato + "'}";
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(String id_contrato) {
		this.id_contrato = id_contrato;
	}

	public String getCodigo_sic() {
		return codigo_sic;
	}

	public void setCodigo_sic(String codigo_sic) {
		this.codigo_sic = codigo_sic;
	}

	public String getNegocio_contrato() {
		return negocio_contrato;
	}

	public void setNegocio_contrato(String negocio_contrato) {
		this.negocio_contrato = negocio_contrato;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
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

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getNum_contrato() {
		return num_contrato;
	}

	public void setNum_contrato(String num_contrato) {
		this.num_contrato = num_contrato;
	}

}
