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
public class TiposIncapacidadPK implements Serializable
{

private static final long serialVersionUID = 1L;
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private Integer codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_TIPOINCA", nullable = false)
private Integer codTipoinca;

public TiposIncapacidadPK()
{
}

public TiposIncapacidadPK(Integer codCia, Integer codTipoinca)
{
    this.codCia = codCia;
    this.codTipoinca = codTipoinca;
}

public Integer getCodCia()
{
    return codCia;
}

public void setCodCia(Integer codCia)
{
    this.codCia = codCia;
}

public Integer getCodTipoinca()
{
    return codTipoinca;
}

public void setCodTipoinca(Integer codTipoinca)
{
    this.codTipoinca = codTipoinca;
}

@Override
public int hashCode()
{
    int hash = 5;
    hash = 59 * hash + (this.codCia != null ? this.codCia.hashCode() : 0);
    hash = 59 * hash + (this.codTipoinca != null ? this.codTipoinca.hashCode() : 0);
    return hash;
}

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (int) codCia;
//        hash += (int) codTipoinca;
//        return hash;
//    }
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TiposIncapacidadPK))
        {
        return false;
        }
    TiposIncapacidadPK other = (TiposIncapacidadPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codTipoinca != other.codTipoinca)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TiposIncapacidadPK[ codCia=" + codCia + ", codTipoinca=" + codTipoinca + " ]";
}
}
