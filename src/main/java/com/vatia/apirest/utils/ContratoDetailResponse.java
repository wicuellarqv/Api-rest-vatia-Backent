package com.vatia.apirest.utils;

import java.util.List;

public class ContratoDetailResponse {

	private String id_contrato, num_contrato, codigo_sic,
	negocio_contrato, comprador, vendedor, estado, fecha_inicio,
	fecha_fin, condicion, formula, tel_contacto, nombre_contacto, fecha_firma,
	documento, email_contacto;
	private List<PreciosResponse> precios;
	private List<TipoCantidadResponse> cantidad;
	private List<GarantiasResponse> garantias;
	
	public ContratoDetailResponse(String[] args) {
		super();
		this.id_contrato = args[0].trim();
		this.num_contrato = args[1].trim();
		this.codigo_sic = args[2].trim();
		this.negocio_contrato = args[3].trim();
		this.comprador = args[4].trim();
		this.vendedor = args[5].trim();
		this.estado = args[6].trim();
		this.fecha_inicio = args[7].trim();
		this.fecha_fin = args[8].trim();
		this.condicion = args[9].trim();
		this.formula= args[10].trim();
	}
	
	public List<GarantiasResponse> getGarantias() {
		return garantias;
	}

	public void setGarantias(List<GarantiasResponse> garantias) {
		this.garantias = garantias;
	}
	
	public List<PreciosResponse> getPrecios() {
		return precios;
	}

	public void setPrecios(List<PreciosResponse> precios) {
		this.precios = precios;
	}

	public String getEstado() {
		return estado;
	}
	
	public List<TipoCantidadResponse> getCantidad() {
		return cantidad;
	}

	public void setCantidad(List<TipoCantidadResponse> cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "{id_contrato=" + id_contrato + ", codigo_sic=" + codigo_sic + ", negocio_contrato=" + negocio_contrato
				+ ", estado=" + estado + ", comprador=" + comprador + ", vendedor=" + vendedor + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", condicion=" + condicion + ", formula=" + formula
				+ ", num_contrato=" + num_contrato + ", precios= " +precios+"}";
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

	public String getTel_contacto() {
		return tel_contacto;
	}

	public void setTel_contacto(String tel_contacto) {
		this.tel_contacto = tel_contacto;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getFecha_firma() {
		return fecha_firma;
	}

	public void setFecha_firma(String fecha_firma) {
		this.fecha_firma = fecha_firma;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail_contacto() {
		return email_contacto;
	}

	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}

	
	
}
