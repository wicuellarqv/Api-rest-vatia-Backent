/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vatia.apirest.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author q-vision
 */
@Entity
@Table(name = "LOGIPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logipp.findAll", query = "SELECT l FROM Logipp l"),
    @NamedQuery(name = "Logipp.findById", query = "SELECT l FROM Logipp l WHERE l.id = :id"),
    @NamedQuery(name = "Logipp.findByFecha", query = "SELECT l FROM Logipp l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Logipp.findByHora", query = "SELECT l FROM Logipp l WHERE l.hora = :hora"),
    @NamedQuery(name = "Logipp.findByOperacion", query = "SELECT l FROM Logipp l WHERE l.operacion = :operacion"),
    @NamedQuery(name = "Logipp.findByMensaje", query = "SELECT l FROM Logipp l WHERE l.mensaje = :mensaje")})
public class Logipp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "OPERACION")
    private String operacion;
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumn(name = "ID_IPP", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ipp idIpp;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Logipp() {
    }

    public Logipp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Ipp getIdIpp() {
        return idIpp;
    }

    public void setIdIpp(Ipp idIpp) {
        this.idIpp = idIpp;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Logipp)) {
            return false;
        }
        Logipp other = (Logipp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vatia.apirest.model.Logipp[ id=" + id + " ]";
    }
    
}
