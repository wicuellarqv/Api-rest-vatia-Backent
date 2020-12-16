package com.vatia.apirest.utils;

import com.vatia.apirest.model.GarantiasContratos;
import java.util.List;

public class ContratosRequest {
	
	private String tipodeMercado;
	private String estadoContrato;
	private String modalidaddelcontrato;
	private String fechadeinicioContrato;
	private String fechadefinContrato;
	private String contratoSic;
	private String cod_SIC_comprador;
	private String cod_SIC_vendedor;
	private String fechaCorte;
	private String fechadefirma;
	private String nombreCliente;
	private String emailcontacto;
	private String tipodeContrato;
	private String telefonocontacto;
	private String tipogarantia;
	private String fechaEntregaGarantia;	
	private List<GarantiasRequest>  garantiasContratos;
	
	

	public String getFechaEntregaGarantia() {
		return fechaEntregaGarantia;
	}
	public void setFechaEntregaGarantia(String fechaEntregaGarantia) {
		this.fechaEntregaGarantia = fechaEntregaGarantia;
	}
	public String getTipogarantia() {
		return tipogarantia;
	}
	public void setTipogarantia(String tipogarantia) {
		this.tipogarantia = tipogarantia;
	}
	public List<GarantiasRequest> getGarantiasContratos() {
		return garantiasContratos;
	}
	public void setGarantiasContratos(List<GarantiasRequest> garantiasContratos) {
		this.garantiasContratos = garantiasContratos;
	}
	public String getTipodeMercado() {
		return tipodeMercado;
	}
	public void setTipodeMercado(String tipodeMercado) {
		this.tipodeMercado = tipodeMercado;
	}
	public String getEstadoContrato() {
		return estadoContrato;
	}
	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
	public String getModalidaddelcontrato() {
		return modalidaddelcontrato;
	}
	public void setModalidaddelcontrato(String modalidaddelcontrato) {
		this.modalidaddelcontrato = modalidaddelcontrato;
	}
	public String getFechadeinicioContrato() {
		return fechadeinicioContrato;
	}
	public void setFechadeinicioContrato(String fechadeinicioContrato) {
		this.fechadeinicioContrato = fechadeinicioContrato;
	}
	public String getFechadefinContrato() {
		return fechadefinContrato;
	}
	public void setFechadefinContrato(String fechadefinContrato) {
		this.fechadefinContrato = fechadefinContrato;
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
	public String getFechaCorte() {
		return fechaCorte;
	}
	public void setFechaCorte(String fechaCorte) {
		this.fechaCorte = fechaCorte;
	}
	public String getFechadefirma() {
		return fechadefirma;
	}
	public void setFechadefirma(String fechadefirma) {
		this.fechadefirma = fechadefirma;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getEmailcontacto() {
		return emailcontacto;
	}
	public void setEmailcontacto(String emailcontacto) {
		this.emailcontacto = emailcontacto;
	}
	public String getTipodeContrato() {
		return tipodeContrato;
	}
	public void setTipodeContrato(String tipodeContrato) {
		this.tipodeContrato = tipodeContrato;
	}
	public String getTelefonocontacto() {
		return telefonocontacto;
	}
	public void setTelefonocontacto(String telefonocontacto) {
		this.telefonocontacto = telefonocontacto;
	}
	
}
