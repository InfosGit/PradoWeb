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
public class EnfermedadesXEmpPK implements Serializable
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
@Column(name = "COD_ENFERMEDAD", nullable = false)
private short codEnfermedad;

public EnfermedadesXEmpPK()
{
}

public EnfermedadesXEmpPK(short codCia, int codEmp, short codEnfermedad)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codEnfermedad = codEnfermedad;
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

public short getCodEnfermedad()
{
    return codEnfermedad;
}

public void setCodEnfermedad(short codEnfermedad)
{
    this.codEnfermedad = codEnfermedad;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codEmp;
//    hash += (int) codEnfermedad;
//    return hash;
//}
@Override
public int hashCode()
{
    int hash = 5;
    hash = 47 * hash + this.codCia;
    hash = 47 * hash + this.codEmp;
    hash = 47 * hash + this.codEnfermedad;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EnfermedadesXEmpPK))
        {
        return false;
        }
    EnfermedadesXEmpPK other = (EnfermedadesXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codEnfermedad != other.codEnfermedad)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EnfermedadesXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codEnfermedad=" + codEnfermedad + " ]";
}
}
