package com.vatia.apirest.utils;

import java.util.List;

import com.vatia.apirest.model.PlantaCantContrato;

public class ContratoDetailResponse {

	private String id_contrato, num_contrato, codigo_sic,
	negocio_contrato, id_comprador, comprador,id_vendedor,  vendedor, estado, fecha_inicio,
	fecha_fin, condicion, formula, tel_contacto, nombre_contacto, fecha_firma,
	documento, email_contacto, tipo_contrato, tipo_mercado, tipo_precio, formula_precio,
	tipo_cantidad, tipo_garantia;
	private List<PreciosResponse> precios;
	private List<TipoCantidadResponse> cantidad;
	private List<GarantiasResponse> garantias;
	private List<fechaPagoResponse> fechaPago;
	private List<PlantaCantContrato> plantaCantContratos;
	
	public ContratoDetailResponse(String[] args) {
		super();
		if (args != null) {
		this.id_contrato = args[0].trim();
		this.num_contrato = args[1].trim();
		this.codigo_sic = args[2].trim();
		this.negocio_contrato = args[3].trim();
		this.id_comprador = args[4].trim();
		this.comprador = args[5].trim();
		this.id_vendedor = args[6].trim();
		this.vendedor = args[7].trim();
		this.estado = args[8].trim();
		this.fecha_inicio = args[9].trim();
		this.fecha_fin = args[10].trim();
		this.condicion = args[11].trim();		
		this.tel_contacto = args[12].trim();
		this.nombre_contacto= args[13].trim();		
		this.fecha_firma= args[14].trim();
		this.documento= args[15].trim();
		this.email_contacto= args[16].trim();
		this.tipo_contrato= args[17].trim();
		this.tipo_mercado= args[18].trim();
		this.tipo_precio= args[19].trim();
		this.formula_precio= args[20].trim();
		this.tipo_cantidad= args[21].trim();
		this.tipo_garantia= args[22].trim();
		}
	}
	
	
	@Override
	public String toString() {
		return "ContratoDetailResponse [id_contrato=" + id_contrato + ", num_contrato=" + num_contrato + ", codigo_sic="
				+ codigo_sic + ", negocio_contrato=" + negocio_contrato + ", id_comprador=" + id_comprador
				+ ", comprador=" + comprador + ", id_vendedor=" + id_vendedor + ", vendedor=" + vendedor + ", estado="
				+ estado + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", condicion=" + condicion
				+ ", formula=" + formula + ", tel_contacto=" + tel_contacto + ", nombre_contacto=" + nombre_contacto
				+ ", fecha_firma=" + fecha_firma + ", documento=" + documento + ", email_contacto=" + email_contacto
				+ ", tipo_contrato=" + tipo_contrato + ", tipo_mercado=" + tipo_mercado + ", tipo_precio=" + tipo_precio
				+ ", formula_precio=" + formula_precio + ", tipo_cantidad=" + tipo_cantidad + ", tipo_garantia="
				+ tipo_garantia + ", precios=" + precios + ", cantidad=" + cantidad + ", garantias=" + garantias
				+ ", fechaPago=" + fechaPago + "]";
	}


	public List<fechaPagoResponse> getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(List<fechaPagoResponse> fechaPago) {
		this.fechaPago = fechaPago;
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



	public String getId_comprador() {
		return id_comprador;
	}


	public void setId_comprador(String id_comprador) {
		this.id_comprador = id_comprador;
	}


	public String getId_vendedor() {
		return id_vendedor;
	}


	public void setId_vendedor(String id_vendedor) {
		this.id_vendedor = id_vendedor;
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

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public String getTipo_mercado() {
		return tipo_mercado;
	}

	public String getTipo_precio() {
		return tipo_precio;
	}

	public String getFormula_precio() {
		return formula_precio;
	}

	public String getTipo_cantidad() {
		return tipo_cantidad;
	}

	public String getTipo_garantia() {
		return tipo_garantia;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public void setTipo_mercado(String tipo_mercado) {
		this.tipo_mercado = tipo_mercado;
	}

	public void setTipo_precio(String tipo_precio) {
		this.tipo_precio = tipo_precio;
	}

	public void setFormula_precio(String formula_precio) {
		this.formula_precio = formula_precio;
	}

	public void setTipo_cantidad(String tipo_cantidad) {
		this.tipo_cantidad = tipo_cantidad;
	}

	public void setTipo_garantia(String tipo_garantia) {
		this.tipo_garantia = tipo_garantia;
	}


	public List<PlantaCantContrato> getPlantaCantContratos() {
		return plantaCantContratos;
	}


	public void setPlantaCantContratos(List<PlantaCantContrato> plantaCantContratos) {
		this.plantaCantContratos = plantaCantContratos;
	}

	
	
}
