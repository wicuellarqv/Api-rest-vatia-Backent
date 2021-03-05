package com.vatia.apirest.utils;

import java.io.Serializable;
import java.util.List;

import com.vatia.apirest.model.PlantaCantContrato;

public class ContratosRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idContrato;
	private String tipoMercado;
	private String estadoContrato;
	private String negociacionContrato;
	private String fechaInicioContrato;
	private String fechaFinContrato;
	private String contratoSic;
	private String cod_SIC_comprador;
	private String cod_SIC_vendedor;	
	private String fechaFirma;
	private String nombreCliente;
	private String emailContacto;
	private String tipoContrato; 
	private String telefonoContacto;
	private String tipoGarantia;
	private String fechaEntregaGarantia;
	private String cantidadContrato;	
	private String tipoCantidad;
	private String tipoPrecio;
	private String mesBase;
	private String condicionTipoContrato;
	private String formulaPrecio;
	private String contratoDocumento;
	private String numContrato;	
	private List<GarantiasRequest>  garantiasContratos;
	private List<PreciosRequest>  preciosRequest;
	private List<CantidadRequest>  cantidadRequest;
	private List<PlantaCantContrato> plantaCantContratos;
	
	public ContratosRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContratosRequest(String idContrato, String tipoMercado, String estadoContrato, String negociacionContrato,
			String fechaInicioContrato, String fechaFinContrato, String contratoSic, String cod_SIC_comprador,
			String cod_SIC_vendedor, String fechaFirma, String nombreCliente, String emailContacto, String tipoContrato,
			String telefonoContacto, String tipoGarantia, String fechaEntregaGarantia, String cantidadContrato,
			String tipoCantidad, String tipoPrecio, String mesBase, String condicionTipoContrato, String formulaPrecio,
			String contratoDocumento, String numContrato, List<GarantiasRequest> garantiasContratos,
			List<PreciosRequest> preciosRequest, List<CantidadRequest> cantidadRequest,
			List<PlantaCantContrato> plantaCantContratos) {
		super();
		this.idContrato = idContrato;
		this.tipoMercado = tipoMercado;
		this.estadoContrato = estadoContrato;
		this.negociacionContrato = negociacionContrato;
		this.fechaInicioContrato = fechaInicioContrato;
		this.fechaFinContrato = fechaFinContrato;
		this.contratoSic = contratoSic;
		this.cod_SIC_comprador = cod_SIC_comprador;
		this.cod_SIC_vendedor = cod_SIC_vendedor;
		this.fechaFirma = fechaFirma;
		this.nombreCliente = nombreCliente;
		this.emailContacto = emailContacto;
		this.tipoContrato = tipoContrato;
		this.telefonoContacto = telefonoContacto;
		this.tipoGarantia = tipoGarantia;
		this.fechaEntregaGarantia = fechaEntregaGarantia;
		this.cantidadContrato = cantidadContrato;
		this.tipoCantidad = tipoCantidad;
		this.tipoPrecio = tipoPrecio;
		this.mesBase = mesBase;
		this.condicionTipoContrato = condicionTipoContrato;
		this.formulaPrecio = formulaPrecio;
		this.contratoDocumento = contratoDocumento;
		this.numContrato = numContrato;
		this.garantiasContratos = garantiasContratos;
		this.preciosRequest = preciosRequest;
		this.cantidadRequest = cantidadRequest;
		this.plantaCantContratos = plantaCantContratos;
	}


	
	@Override
	public String toString() {
		return "ContratosRequest [idContrato=" + idContrato + ", tipoMercado=" + tipoMercado + ", estadoContrato="
				+ estadoContrato + ", negociacionContrato=" + negociacionContrato + ", fechaInicioContrato="
				+ fechaInicioContrato + ", fechaFinContrato=" + fechaFinContrato + ", contratoSic=" + contratoSic
				+ ", cod_SIC_comprador=" + cod_SIC_comprador + ", cod_SIC_vendedor=" + cod_SIC_vendedor
				+ ", fechaFirma=" + fechaFirma + ", nombreCliente=" + nombreCliente + ", emailContacto=" + emailContacto
				+ ", tipoContrato=" + tipoContrato + ", telefonoContacto=" + telefonoContacto + ", tipoGarantia="
				+ tipoGarantia + ", fechaEntregaGarantia=" + fechaEntregaGarantia + ", cantidadContrato="
				+ cantidadContrato + ", tipoCantidad=" + tipoCantidad + ", tipoPrecio=" + tipoPrecio + ", mesBase="
				+ mesBase + ", condicionTipoContrato=" + condicionTipoContrato + ", formulaPrecio=" + formulaPrecio
				+ ", contratoDocumento=" + contratoDocumento + ", numContrato=" + numContrato + ", garantiasContratos="
				+ garantiasContratos.size() + ", preciosRequest=" + preciosRequest.size() + ", cantidadRequest=" + cantidadRequest.size()
				+ ", plantaCantContratos=" + plantaCantContratos.size() + "]";
	}

	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public String getCondicionTipoContrato() {
		return condicionTipoContrato;
	}
	public void setCondicionTipoContrato(String condicionTipoContrato) {
		this.condicionTipoContrato = condicionTipoContrato;
	}
	public String getTipoMercado() {
		return tipoMercado;
	}
	public void setTipoMercado(String tipoMercado) {
		this.tipoMercado = tipoMercado;
	}
	public String getFechaInicioContrato() {
		return fechaInicioContrato;
	}
	public void setFechaInicioContrato(String fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}
	public String getFechaFinContrato() {
		return fechaFinContrato;
	}
	public void setFechaFinContrato(String fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public String getEmailContacto() {
		return emailContacto;
	}
	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}
	public String getFechaFirma() {
		return fechaFirma;
	}
	public void setFechaFirma(String fechaFirma) {
		this.fechaFirma = fechaFirma;
	}
	public String getNegociacionContrato() {
		return negociacionContrato;
	}
	public void setNegociacionContrato(String negociacionContrato) {
		this.negociacionContrato = negociacionContrato;
	}
	public String getContratoDocumento() {
		return contratoDocumento;
	}
	public void setContratoDocumento(String contratoDocumento) {
		this.contratoDocumento = contratoDocumento;
	}
	public String getFormulaPrecio() {
		return formulaPrecio;
	}
	public void setFormulaPrecio(String formulaPrecio) {
		this.formulaPrecio = formulaPrecio;
	}
	public String getMesBase() {
		return mesBase;
	}
	public void setMesBase(String mesBase) {
		this.mesBase = mesBase;
	}
	public String getTipoPrecio() {
		return tipoPrecio;
	}
	public void setTipoPrecio(String tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}
	public String getTipoCantidad() {
		return tipoCantidad;
	}
	public void setTipoCantidad(String tipoCantidad) {
		this.tipoCantidad = tipoCantidad;
	}
	public String getCantidadContrato() {
		return cantidadContrato;
	}
	public void setCantidadContrato(String cantidadContrato) {
		this.cantidadContrato = cantidadContrato;
	}
	public List<CantidadRequest> getCantidadRequest() {
		return cantidadRequest;
	}
	public void setCantidadRequest(List<CantidadRequest> cantidadRequest) {
		this.cantidadRequest = cantidadRequest;
	}
	public List<PreciosRequest> getPreciosRequest() {
		return preciosRequest;
	}
	public void setPreciosRequest(List<PreciosRequest> preciosRequest) {
		this.preciosRequest = preciosRequest;
	}
	public String getFechaEntregaGarantia() {
		return fechaEntregaGarantia;
	}
	public void setFechaEntregaGarantia(String fechaEntregaGarantia) {
		this.fechaEntregaGarantia = fechaEntregaGarantia;
	}
	public List<GarantiasRequest> getGarantiasContratos() {
		return garantiasContratos;
	}
	public void setGarantiasContratos(List<GarantiasRequest> garantiasContratos) {
		this.garantiasContratos = garantiasContratos;
	}
	public String getEstadoContrato() {
		return estadoContrato;
	}
	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
	public String getContratoSic() {
		return contratoSic;
	}
	public void setContratoSic(String contratoSic) {
		this.contratoSic = contratoSic;
	}
	public String getCod_SIC_comprador() {
		return cod_SIC_comprador;
	}
	public void setCod_SIC_comprador(String cod_SIC_comprador) {
		this.cod_SIC_comprador = cod_SIC_comprador;
	}
	public String getCod_SIC_vendedor() {
		return cod_SIC_vendedor;
	}
	public void setCod_SIC_vendedor(String cod_SIC_vendedor) {
		this.cod_SIC_vendedor = cod_SIC_vendedor;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public List<PlantaCantContrato> getPlantaCantContratos() {
		return plantaCantContratos;
	}
	public void setPlantaCantContratos(List<PlantaCantContrato> plantaCantContratos) {
		this.plantaCantContratos = plantaCantContratos;
	}
}
