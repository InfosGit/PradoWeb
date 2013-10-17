/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class ClasificacionPK implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private BigInteger codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CLASIFICACION")
    private BigInteger codClasificacion;

    public ClasificacionPK()
    {
    }

    public ClasificacionPK(BigInteger codCia, BigInteger codClasificacion)
    {
        this.codCia = codCia;
        this.codClasificacion = codClasificacion;
    }

    public BigInteger getCodCia()
    {
        return codCia;
    }

    public void setCodCia(BigInteger codCia)
    {
        this.codCia = codCia;
    }

    public BigInteger getCodClasificacion()
    {
        return codClasificacion;
    }

    public void setCodClasificacion(BigInteger codClasificacion)
    {
        this.codClasificacion = codClasificacion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        hash += (codClasificacion != null ? codClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasificacionPK))
            {
            return false;
            }
        ClasificacionPK other = (ClasificacionPK) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) return false;
        if ((this.codClasificacion == null && other.codClasificacion != null) || (this.codClasificacion != null && !this.codClasificacion.equals(other.codClasificacion))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ClasificacionPK[ codCia=" + codCia + ", codClasificacion=" + codClasificacion + " ]";
    }
    
}
