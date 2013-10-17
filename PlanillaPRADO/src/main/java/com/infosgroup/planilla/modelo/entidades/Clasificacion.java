/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CLASIFICACION")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c"),
    @NamedQuery(name = "Clasificacion.findByCodCia", query = "SELECT c FROM Clasificacion c WHERE c.clasificacionPK.codCia = :codCia"),
    @NamedQuery(name = "Clasificacion.findByCodClasificacion", query = "SELECT c FROM Clasificacion c WHERE c.clasificacionPK.codClasificacion = :codClasificacion"),
    @NamedQuery(name = "Clasificacion.findByDescripcion", query = "SELECT c FROM Clasificacion c WHERE c.descripcion = :descripcion")
    })
public class Clasificacion implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClasificacionPK clasificacionPK;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Clasificacion()
    {
    }

    public Clasificacion(ClasificacionPK clasificacionPK)
    {
        this.clasificacionPK = clasificacionPK;
    }

    public Clasificacion(BigInteger codCia, BigInteger codClasificacion)
    {
        this.clasificacionPK = new ClasificacionPK(codCia, codClasificacion);
    }

    public ClasificacionPK getClasificacionPK()
    {
        return clasificacionPK;
    }

    public void setClasificacionPK(ClasificacionPK clasificacionPK)
    {
        this.clasificacionPK = clasificacionPK;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (clasificacionPK != null ? clasificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion))
            {
            return false;
            }
        Clasificacion other = (Clasificacion) object;
        if ((this.clasificacionPK == null && other.clasificacionPK != null) || (this.clasificacionPK != null && !this.clasificacionPK.equals(other.clasificacionPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Clasificacion[ clasificacionPK=" + clasificacionPK + " ]";
    }
    
}
