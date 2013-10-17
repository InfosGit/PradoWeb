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
public class EmergenciaXEmpPK implements Serializable
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
@Column(name = "COD_EMERGENCIA", nullable = false)
private int codEmergencia;

public EmergenciaXEmpPK()
{
}

public EmergenciaXEmpPK(short codCia, int codEmp, int codEmergencia)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codEmergencia = codEmergencia;
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

public int getCodEmergencia()
{
    return codEmergencia;
}

public void setCodEmergencia(int codEmergencia)
{
    this.codEmergencia = codEmergencia;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codEmp;
//    hash += (int) codEmergencia;
//    return hash;
//}
@Override
public int hashCode()
{
    int hash = 3;
    hash = 13 * hash + this.codCia;
    hash = 13 * hash + this.codEmp;
    hash = 13 * hash + this.codEmergencia;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EmergenciaXEmpPK))
        {
        return false;
        }
    EmergenciaXEmpPK other = (EmergenciaXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codEmergencia != other.codEmergencia)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EmergenciaXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codEmergencia=" + codEmergencia + " ]";
}
}
