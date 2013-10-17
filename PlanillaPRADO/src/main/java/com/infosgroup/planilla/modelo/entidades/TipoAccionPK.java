/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class TipoAccionPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_TIPOACCION", nullable = false)
private Short codTipoaccion;

public TipoAccionPK()
{
}

public TipoAccionPK(short codCia, short codTipoaccion)
{
    this.codCia = codCia;
    this.codTipoaccion = codTipoaccion;
}

public Short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public Short getCodTipoaccion()
{
    return codTipoaccion;
}

public void setCodTipoaccion(short codTipoaccion)
{
    this.codTipoaccion = codTipoaccion;
}

@Override
public int hashCode()
{
    int hash = 7;
    hash = 79 * hash + this.codCia;
    hash = 79 * hash + (this.codTipoaccion != null ? this.codTipoaccion.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoAccionPK))
        {
        return false;
        }
    TipoAccionPK other = (TipoAccionPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codTipoaccion != other.codTipoaccion)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TipoAccionPK[ codCia=" + codCia + ", codTipoaccion=" + codTipoaccion + " ]";
}
}
