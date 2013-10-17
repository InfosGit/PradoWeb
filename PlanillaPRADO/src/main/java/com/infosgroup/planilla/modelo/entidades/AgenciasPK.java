/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class AgenciasPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@Column(name = "COD_CIA", nullable = false)
private Short codCia;
@Basic(optional = false)
@Column(name = "COD_AGENCIA", nullable = false)
private String codAgencia;

public AgenciasPK()
{
}

public AgenciasPK(Short codCia, String codAgencia)
{
    this.codCia = codCia;
    this.codAgencia = codAgencia;
}

public Short getCodCia()
{
    return codCia;
}

public void setCodCia(Short codCia)
{
    this.codCia = codCia;
}

public String getCodAgencia()
{
    return codAgencia;
}

public void setCodAgencia(String codAgencia)
{
    this.codAgencia = codAgencia;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    //hash += (int) codAgencia;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AgenciasPK))
        {
        return false;
        }
    AgenciasPK other = (AgenciasPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codAgencia != other.codAgencia)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.factur.AgenciasPK[ codCia=" + codCia + ", codAgencia=" + codAgencia + " ]";
}
}
