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
public class NivelesXEmpPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_EMP", nullable = false)
private int codEmp;
@Basic(optional = false)
@NotNull
@Column(name = "COD_NIVEL", nullable = false)
private short codNivel;

public NivelesXEmpPK()
{
}

public NivelesXEmpPK(short codCia, int codEmp, short codNivel)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codNivel = codNivel;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public int getCodEmp()
{
    return codEmp;
}

public void setCodEmp(int codEmp)
{
    this.codEmp = codEmp;
}

public short getCodNivel()
{
    return codNivel;
}

public void setCodNivel(short codNivel)
{
    this.codNivel = codNivel;
}

@Override
public int hashCode()
{
    int hash = 5;
    hash = 71 * hash + this.codCia;
    hash = 71 * hash + this.codEmp;
    hash = 71 * hash + this.codNivel;
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += codEmp;
//    hash += (int) codNivel;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof NivelesXEmpPK))
        {
        return false;
        }
    NivelesXEmpPK other = (NivelesXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    //if ((this.codNivel == null && other.codNivel != null) || (this.codNivel != null && !this.codNivel.equals(other.codNivel)))
    if (this.codNivel != other.codNivel)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.NivelesXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codNivel=" + codNivel + " ]";
}
}
