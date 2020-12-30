package com.vatia.apirest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.type.DateType;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "tbl_cantidad_contratos")
@XmlRootElement

public class CantidadesContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_id_cantidad_contrato")
    private Integer idCantidadContrato;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "num_id_contrato")
    private Integer idContrato;
    
    @Basic(optional = false)
    @Column(name = "num_id_tipo_cantidad")
    private Integer idTipoCantidad;
    
    @Basic(optional = false)
    @Column(name = "dtm_fecha_cantidad")
    private String fechaCantidad;
      
    @Basic(optional = false)
    @Column(name = "num_h1")
    private BigDecimal cantidadH1;
    
    @Basic(optional = false)
    @Column(name = "num_h2")
    private BigDecimal cantidadH2;
    
    @Basic(optional = false)
    @Column(name = "num_h3")
    private BigDecimal cantidadH3;
    
    @Basic(optional = false)
    @Column(name = "num_h4")
    private BigDecimal cantidadH4;
    
    @Basic(optional = false)
    @Column(name = "num_h5")
    private BigDecimal cantidadH5;
    
    @Basic(optional = false)
    @Column(name = "num_h6")
    private BigDecimal cantidadH6;
    
    @Basic(optional = false)
    @Column(name = "num_h7")
    private BigDecimal cantidadH7;
    
    @Basic(optional = false)
    @Column(name = "num_h8")
    private BigDecimal cantidadH8;
    
    @Basic(optional = false)
    @Column(name = "num_h9")
    private BigDecimal cantidadH9;
    
    @Basic(optional = false)
    @Column(name = "num_h10")
    private BigDecimal cantidadH10;
	    
    @Basic(optional = false)
    @Column(name = "num_h11")
    private BigDecimal cantidadH11;
    
    @Basic(optional = false)
    @Column(name = "num_h12")
    private BigDecimal cantidadH12;
    
    @Basic(optional = false)
    @Column(name = "num_h13")
    private BigDecimal cantidadH13;
    
    @Basic(optional = false)
    @Column(name = "num_h14")
    private BigDecimal cantidadH14;
    
    @Basic(optional = false)
    @Column(name = "num_h15")
    private BigDecimal cantidadH15;
    
    @Basic(optional = false)
    @Column(name = "num_h16")
    private BigDecimal cantidadH16;
    
    @Basic(optional = false)
    @Column(name = "num_h17")
    private BigDecimal cantidadH17;
    
    @Basic(optional = false)
    @Column(name = "num_h18")
    private BigDecimal cantidadH18;
    
    @Basic(optional = false)
    @Column(name = "num_h19")
    private BigDecimal cantidadH19;
    
    @Basic(optional = false)
    @Column(name = "num_h20")
    private BigDecimal cantidadH20;
    
    @Basic(optional = false)
    @Column(name = "num_h21")
    private BigDecimal cantidadH21;
    
    @Basic(optional = false)
    @Column(name = "num_h22")
    private BigDecimal cantidadH22;
    
    @Basic(optional = false)
    @Column(name = "num_h23")
    private BigDecimal cantidadH23;

    @Basic(optional = false)
    @Column(name = "num_h24")
    private BigDecimal cantidadH24;
  
	public CantidadesContratos() {
	}

	public CantidadesContratos(Integer idCantidadContrato, Integer idContrato, Integer idTipoCantidad,
			String fechaCantidad, BigDecimal cantidadH1, BigDecimal cantidadH2, BigDecimal cantidadH3,
			BigDecimal cantidadH4, BigDecimal cantidadH5, BigDecimal cantidadH6, BigDecimal cantidadH7,
			BigDecimal cantidadH8, BigDecimal cantidadH9, BigDecimal cantidadH10, BigDecimal cantidadH11,
			BigDecimal cantidadH12, BigDecimal cantidadH13, BigDecimal cantidadH14, BigDecimal cantidadH15,
			BigDecimal cantidadH16, BigDecimal cantidadH17, BigDecimal cantidadH18, BigDecimal cantidadH19,
			BigDecimal cantidadH20, BigDecimal cantidadH21, BigDecimal cantidadH22, BigDecimal cantidadH23,
			BigDecimal cantidadH24) {
		super();
		this.idCantidadContrato = idCantidadContrato;
		this.idContrato = idContrato;
		this.idTipoCantidad = idTipoCantidad;
		this.fechaCantidad = fechaCantidad;
		this.cantidadH1 = cantidadH1;
		this.cantidadH2 = cantidadH2;
		this.cantidadH3 = cantidadH3;
		this.cantidadH4 = cantidadH4;
		this.cantidadH5 = cantidadH5;
		this.cantidadH6 = cantidadH6;
		this.cantidadH7 = cantidadH7;
		this.cantidadH8 = cantidadH8;
		this.cantidadH9 = cantidadH9;
		this.cantidadH10 = cantidadH10;
		this.cantidadH11 = cantidadH11;
		this.cantidadH12 = cantidadH12;
		this.cantidadH13 = cantidadH13;
		this.cantidadH14 = cantidadH14;
		this.cantidadH15 = cantidadH15;
		this.cantidadH16 = cantidadH16;
		this.cantidadH17 = cantidadH17;
		this.cantidadH18 = cantidadH18;
		this.cantidadH19 = cantidadH19;
		this.cantidadH20 = cantidadH20;
		this.cantidadH21 = cantidadH21;
		this.cantidadH22 = cantidadH22;
		this.cantidadH23 = cantidadH23;
		this.cantidadH24 = cantidadH24;
	}


	public Contratos getContratosCantidades() {
		return contratosCantidades;
	}


	public void setContratosCantidades(Contratos contratosCantidades) {
		this.contratosCantidades = contratosCantidades;
	}


	public TiposCantidad getTiposCantidades() {
		return tiposCantidades;
	}


	public void setTiposCantidades(TiposCantidad tiposCantidades) {
		this.tiposCantidades = tiposCantidades;
	}


	public Integer getIdCantidadContrato() {
		return idCantidadContrato;
	}


	public void setIdCantidadContrato(Integer idCantidadContrato) {
		this.idCantidadContrato = idCantidadContrato;
	}


	public Integer getIdContrato() {
		return idContrato;
	}


	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}


	public String getFechaCantidad() {
		return fechaCantidad;
	}


	public void setFechaCantidad(String fechaCantidad) {
		this.fechaCantidad = fechaCantidad;
	}



	public BigDecimal getCantidadH1() {
		return cantidadH1;
	}


	public void setCantidadH1(BigDecimal cantidadH1) {
		this.cantidadH1 = cantidadH1;
	}


	public BigDecimal getCantidadH2() {
		return cantidadH2;
	}


	public void setCantidadH2(BigDecimal cantidadH2) {
		this.cantidadH2 = cantidadH2;
	}


	public BigDecimal getCantidadH3() {
		return cantidadH3;
	}


	public void setCantidadH3(BigDecimal cantidadH3) {
		this.cantidadH3 = cantidadH3;
	}


	public BigDecimal getCantidadH4() {
		return cantidadH4;
	}


	public void setCantidadH4(BigDecimal cantidadH4) {
		this.cantidadH4 = cantidadH4;
	}


	public BigDecimal getCantidadH5() {
		return cantidadH5;
	}


	public void setCantidadH5(BigDecimal cantidadH5) {
		this.cantidadH5 = cantidadH5;
	}


	public BigDecimal getCantidadH6() {
		return cantidadH6;
	}


	public void setCantidadH6(BigDecimal cantidadH6) {
		this.cantidadH6 = cantidadH6;
	}


	public BigDecimal getCantidadH7() {
		return cantidadH7;
	}


	public void setCantidadH7(BigDecimal cantidadH7) {
		this.cantidadH7 = cantidadH7;
	}


	public BigDecimal getCantidadH8() {
		return cantidadH8;
	}


	public void setCantidadH8(BigDecimal cantidadH8) {
		this.cantidadH8 = cantidadH8;
	}


	public BigDecimal getCantidadH9() {
		return cantidadH9;
	}


	public void setCantidadH9(BigDecimal cantidadH9) {
		this.cantidadH9 = cantidadH9;
	}


	public BigDecimal getCantidadH10() {
		return cantidadH10;
	}


	public void setCantidadH10(BigDecimal cantidadH10) {
		this.cantidadH10 = cantidadH10;
	}


	public BigDecimal getCantidadH11() {
		return cantidadH11;
	}


	public void setCantidadH11(BigDecimal cantidadH11) {
		this.cantidadH11 = cantidadH11;
	}


	public BigDecimal getCantidadH12() {
		return cantidadH12;
	}


	public void setCantidadH12(BigDecimal cantidadH12) {
		this.cantidadH12 = cantidadH12;
	}


	public BigDecimal getCantidadH13() {
		return cantidadH13;
	}


	public void setCantidadH13(BigDecimal cantidadH13) {
		this.cantidadH13 = cantidadH13;
	}


	public BigDecimal getCantidadH14() {
		return cantidadH14;
	}


	public void setCantidadH14(BigDecimal cantidadH14) {
		this.cantidadH14 = cantidadH14;
	}


	public BigDecimal getCantidadH15() {
		return cantidadH15;
	}


	public void setCantidadH15(BigDecimal cantidadH15) {
		this.cantidadH15 = cantidadH15;
	}


	public BigDecimal getCantidadH16() {
		return cantidadH16;
	}


	public void setCantidadH16(BigDecimal cantidadH16) {
		this.cantidadH16 = cantidadH16;
	}


	public BigDecimal getCantidadH17() {
		return cantidadH17;
	}


	public void setCantidadH17(BigDecimal cantidadH17) {
		this.cantidadH17 = cantidadH17;
	}


	public BigDecimal getCantidadH18() {
		return cantidadH18;
	}


	public void setCantidadH18(BigDecimal cantidadH18) {
		this.cantidadH18 = cantidadH18;
	}


	public BigDecimal getCantidadH19() {
		return cantidadH19;
	}


	public void setCantidadH19(BigDecimal cantidadH19) {
		this.cantidadH19 = cantidadH19;
	}


	public BigDecimal getCantidadH20() {
		return cantidadH20;
	}


	public void setCantidadH20(BigDecimal cantidadH20) {
		this.cantidadH20 = cantidadH20;
	}


	public BigDecimal getCantidadH21() {
		return cantidadH21;
	}


	public void setCantidadH21(BigDecimal cantidadH21) {
		this.cantidadH21 = cantidadH21;
	}


	public BigDecimal getCantidadH22() {
		return cantidadH22;
	}


	public void setCantidadH22(BigDecimal cantidadH22) {
		this.cantidadH22 = cantidadH22;
	}


	public BigDecimal getCantidadH23() {
		return cantidadH23;
	}


	public void setCantidadH23(BigDecimal cantidadH23) {
		this.cantidadH23 = cantidadH23;
	}
	
	

	public BigDecimal getCantidadH24() {
		return cantidadH24;
	}


	public void setCantidadH24(BigDecimal cantidadH24) {
		this.cantidadH24 = cantidadH24;
	}


	public Integer getIdTipoCantidad() {
		return idTipoCantidad;
	}


	public void setIdTipoCantidad(Integer idTipoCantidad) {
		this.idTipoCantidad = idTipoCantidad;
	}



	@ManyToOne
	@JoinColumn(name="num_id_contrato", referencedColumnName = "num_id_contrato", insertable=false,updatable=false)
	Contratos contratosCantidades;
    
	@ManyToOne
	@JoinColumn(name="num_id_tipo_cantidad", referencedColumnName = "num_id_tipo_cantidad", insertable=false,updatable=false)
	TiposCantidad tiposCantidades;

        
}

    