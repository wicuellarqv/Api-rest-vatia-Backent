package com.vatia.apirest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "VARIPC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VarIpc.findAll", query = "SELECT i FROM VarIpc i"),
    @NamedQuery(name = "VarIpc.findByAnio", query = "SELECT i FROM VarIpc i WHERE i.anio = :anio"),
    @NamedQuery(name = "VarIpc.findByMes1", query = "SELECT i FROM VarIpc i WHERE i.mes1 = :mes1"),
    @NamedQuery(name = "VarIpc.findByMes2", query = "SELECT i FROM VarIpc i WHERE i.mes2 = :mes2"),
    @NamedQuery(name = "VarIpc.findByMes3", query = "SELECT i FROM VarIpc i WHERE i.mes3 = :mes3"),
    @NamedQuery(name = "VarIpc.findByMes4", query = "SELECT i FROM VarIpc i WHERE i.mes4 = :mes4"),
    @NamedQuery(name = "VarIpc.findByMes5", query = "SELECT i FROM VarIpc i WHERE i.mes5 = :mes5"),
    @NamedQuery(name = "VarIpc.findByMes6", query = "SELECT i FROM VarIpc i WHERE i.mes6 = :mes6"),
    @NamedQuery(name = "VarIpc.findByMes7", query = "SELECT i FROM VarIpc i WHERE i.mes7 = :mes7"),
    @NamedQuery(name = "VarIpc.findByMes8", query = "SELECT i FROM VarIpc i WHERE i.mes8 = :mes8"),
    @NamedQuery(name = "VarIpc.findByMes9", query = "SELECT i FROM VarIpc i WHERE i.mes9 = :mes9"),
    @NamedQuery(name = "VarIpc.findByMes10", query = "SELECT i FROM VarIpc i WHERE i.mes10 = :mes10"),
    @NamedQuery(name = "VarIpc.findByMes11", query = "SELECT i FROM VarIpc i WHERE i.mes11 = :mes11"),
    @NamedQuery(name = "VarIpc.findByMes12", query = "SELECT i FROM VarIpc i WHERE i.mes12 = :mes12")})
public class VarIpc implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ANIO") 
    private int anio;
    @Column(name = "MES1")
    private BigDecimal mes1;
    @Column(name = "MES2")
    private BigDecimal mes2;
    @Column(name = "MES3")
    private BigDecimal mes3;
    @Column(name = "MES4")
    private BigDecimal mes4;
    @Column(name = "MES5")
    private BigDecimal mes5;
    @Column(name = "MES6")
    private BigDecimal mes6;
    @Column(name = "MES7")
    private BigDecimal mes7;
    @Column(name = "MES8")
    private BigDecimal mes8;
    @Column(name = "MES9")
    private BigDecimal mes9;
    @Column(name = "MES10")
    private BigDecimal mes10;
    @Column(name = "MES11")
    private BigDecimal mes11;
    @Column(name = "MES12")
    private BigDecimal mes12;

    public VarIpc() {
    	
    }
    
    
    public VarIpc(int anio, BigDecimal mes1, BigDecimal mes2, BigDecimal mes3, BigDecimal mes4, BigDecimal mes5,
			BigDecimal mes6, BigDecimal mes7, BigDecimal mes8, BigDecimal mes9, BigDecimal mes10, BigDecimal mes11,
			BigDecimal mes12) {
		super();
		this.anio = anio;
		this.mes1 = mes1;
		this.mes2 = mes2;
		this.mes3 = mes3;
		this.mes4 = mes4;
		this.mes5 = mes5;
		this.mes6 = mes6;
		this.mes7 = mes7;
		this.mes8 = mes8;
		this.mes9 = mes9;
		this.mes10 = mes10;
		this.mes11 = mes11;
		this.mes12 = mes12;
	}



	public VarIpc(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VarIpc(int anio) {
        this.anio = anio;
    }


	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public BigDecimal getMes1() {
		return mes1;
	}

	public void setMes1(BigDecimal mes1) {
		this.mes1 = mes1;
	}

	public BigDecimal getMes2() {
		return mes2;
	}

	public void setMes2(BigDecimal mes2) {
		this.mes2 = mes2;
	}

	public BigDecimal getMes3() {
		return mes3;
	}

	public void setMes3(BigDecimal mes3) {
		this.mes3 = mes3;
	}

	public BigDecimal getMes4() {
		return mes4;
	}

	public void setMes4(BigDecimal mes4) {
		this.mes4 = mes4;
	}

	public BigDecimal getMes5() {
		return mes5;
	}

	public void setMes5(BigDecimal mes5) {
		this.mes5 = mes5;
	}

	public BigDecimal getMes6() {
		return mes6;
	}

	public void setMes6(BigDecimal mes6) {
		this.mes6 = mes6;
	}

	public BigDecimal getMes7() {
		return mes7;
	}

	public void setMes7(BigDecimal mes7) {
		this.mes7 = mes7;
	}

	public BigDecimal getMes8() {
		return mes8;
	}

	public void setMes8(BigDecimal mes8) {
		this.mes8 = mes8;
	}

	public BigDecimal getMes9() {
		return mes9;
	}

	public void setMes9(BigDecimal mes9) {
		this.mes9 = mes9;
	}

	public BigDecimal getMes10() {
		return mes10;
	}

	public void setMes10(BigDecimal mes10) {
		this.mes10 = mes10;
	}

	public BigDecimal getMes11() {
		return mes11;
	}

	public void setMes11(BigDecimal mes11) {
		this.mes11 = mes11;
	}

	public BigDecimal getMes12() {
		return mes12;
	}

	public void setMes12(BigDecimal mes12) {
		this.mes12 = mes12;
	}

	@Override
	public String toString() {
		return "VarIpc [id=" + id + ", anio=" + anio + ", mes1=" + mes1 + ", mes2=" + mes2 + ", mes3=" + mes3
				+ ", mes4=" + mes4 + ", mes5=" + mes5 + ", mes6=" + mes6 + ", mes7=" + mes7 + ", mes8=" + mes8
				+ ", mes9=" + mes9 + ", mes10=" + mes10 + ", mes11=" + mes11 + ", mes12=" + mes12 + "]";
	}

}

