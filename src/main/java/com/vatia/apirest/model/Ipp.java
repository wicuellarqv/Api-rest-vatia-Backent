/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vatia.apirest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "IPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ipp.findAll", query = "SELECT i FROM Ipp i"),
    @NamedQuery(name = "Ipp.findById", query = "SELECT i FROM Ipp i WHERE i.id = :id"),
    @NamedQuery(name = "Ipp.findByIndice", query = "SELECT i FROM Ipp i WHERE i.indice = :indice"),
    @NamedQuery(name = "Ipp.findByAnio", query = "SELECT i FROM Ipp i WHERE i.anio = :anio"),
    @NamedQuery(name = "Ipp.findByMes1", query = "SELECT i FROM Ipp i WHERE i.mes1 = :mes1"),
    @NamedQuery(name = "Ipp.findByMes2", query = "SELECT i FROM Ipp i WHERE i.mes2 = :mes2"),
    @NamedQuery(name = "Ipp.findByMes3", query = "SELECT i FROM Ipp i WHERE i.mes3 = :mes3"),
    @NamedQuery(name = "Ipp.findByMes4", query = "SELECT i FROM Ipp i WHERE i.mes4 = :mes4"),
    @NamedQuery(name = "Ipp.findByMes5", query = "SELECT i FROM Ipp i WHERE i.mes5 = :mes5"),
    @NamedQuery(name = "Ipp.findByMes6", query = "SELECT i FROM Ipp i WHERE i.mes6 = :mes6"),
    @NamedQuery(name = "Ipp.findByMes7", query = "SELECT i FROM Ipp i WHERE i.mes7 = :mes7"),
    @NamedQuery(name = "Ipp.findByMes8", query = "SELECT i FROM Ipp i WHERE i.mes8 = :mes8"),
    @NamedQuery(name = "Ipp.findByMes9", query = "SELECT i FROM Ipp i WHERE i.mes9 = :mes9"),
    @NamedQuery(name = "Ipp.findByMes10", query = "SELECT i FROM Ipp i WHERE i.mes10 = :mes10"),
    @NamedQuery(name = "Ipp.findByMes11", query = "SELECT i FROM Ipp i WHERE i.mes11 = :mes11"),
    @NamedQuery(name = "Ipp.findByMes12", query = "SELECT i FROM Ipp i WHERE i.mes12 = :mes12"),
    @NamedQuery(name = "Ipp.findByFuente", query = "SELECT i FROM Ipp i WHERE i.fuente = :fuente")})
public class Ipp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "INDICE")
    private BigDecimal indice;
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
    @Column(name = "FUENTE")
    private Integer fuente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIpp")
    private List<Hisipp> hisippList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIpp")
    private List<Logipp> logippList;

    public Ipp() {
    }

    public Ipp(Integer id) {
        this.id = id;
    }

    public Ipp(Integer id, BigDecimal indice, int anio) {
        this.id = id;
        this.indice = indice;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getIndice() {
        return indice;
    }

    public void setIndice(BigDecimal indice) {
        this.indice = indice;
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

    public Integer getFuente() {
        return fuente;
    }

    public void setFuente(Integer fuente) {
        this.fuente = fuente;
    }

    @XmlTransient
    public List<Hisipp> getHisippList() {
        return hisippList;
    }

    public void setHisippList(List<Hisipp> hisippList) {
        this.hisippList = hisippList;
    }

    @XmlTransient
    public List<Logipp> getLogippList() {
        return logippList;
    }

    public void setLogippList(List<Logipp> logippList) {
        this.logippList = logippList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ipp)) {
            return false;
        }
        Ipp other = (Ipp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Ipp [id=" + id + ", indice=" + indice + ", anio=" + anio + ", mes1=" + mes1 + ", mes2=" + mes2
				+ ", mes3=" + mes3 + ", mes4=" + mes4 + ", mes5=" + mes5 + ", mes6=" + mes6 + ", mes7=" + mes7
				+ ", mes8=" + mes8 + ", mes9=" + mes9 + ", mes10=" + mes10 + ", mes11=" + mes11 + ", mes12=" + mes12
				+ ", fuente=" + fuente + ", hisippList=" + hisippList + ", logippList=" + logippList + "]";
	}
}
