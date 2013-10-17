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
public class DepartamentosPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@Column(name = "COD_CIA", nullable = false)
private int codCia;
@Basic(optional = false)
@Column(name = "COD_DEPTO", nullable = false)
private int codDepto;

public DepartamentosPK()
{
}

public DepartamentosPK(int codCia, int codDepto)
{
    this.codCia = codCia;
    this.codDepto = codDepto;
}

public int getCodCia()
{
    return codCia;
}

public void setCodCia(int codCia)
{
    this.codCia = codCia;
}

public int getCodDepto()
{
    return codDepto;
}

public void setCodDepto(int codDepto)
{
    this.codDepto = codDepto;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += codCia;
    hash += codDepto;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DepartamentosPK))
        {
        return false;
        }
    DepartamentosPK other = (DepartamentosPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codDepto != other.codDepto)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.planilla.DepartamentosPK[ codCia=" + codCia + ", codDepto=" + codDepto + " ]";
}
}
