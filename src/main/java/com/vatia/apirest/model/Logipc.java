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
@Table(name = "LOGIPC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logipc.findAll", query = "SELECT l FROM Logipc l"),
    @NamedQuery(name = "Logipc.findById", query = "SELECT l FROM Logipc l WHERE l.id = :id"),
    @NamedQuery(name = "Logipc.findByFecha", query = "SELECT l FROM Logipc l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Logipc.findByHora", query = "SELECT l FROM Logipc l WHERE l.hora = :hora"),
    @NamedQuery(name = "Logipc.findByOperacion", query = "SELECT l FROM Logipc l WHERE l.operacion = :operacion"),
    @NamedQuery(name = "Logipc.findByMensaje", query = "SELECT l FROM Logipc l WHERE l.mensaje = :mensaje")})
public class Logipc implements Serializable {

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
    @JoinColumn(name = "ID_IPC", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ipc idIpc;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Logipc() {
    }

    public Logipc(Integer id) {
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

    public Ipc getIdIpc() {
        return idIpc;
    }

    public void setIdIpc(Ipc idIpc) {
        this.idIpc = idIpc;
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
        if (!(object instanceof Logipc)) {
            return false;
        }
        Logipc other = (Logipc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vatia.apirest.model.Logipc[ id=" + id + " ]";
    }
    
}
