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
public class CapacitacionXEmpPK implements Serializable
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
@Column(name = "COD_CAPACITACION", nullable = false)
private int codCapacitacion;

public CapacitacionXEmpPK()
{
}

public CapacitacionXEmpPK(short codCia, int codEmp, int codCapacitacion)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codCapacitacion = codCapacitacion;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public void setCodEmp(int codEmp)
{
    this.codEmp = codEmp;
}

public int getCodCapacitacion()
{
    return codCapacitacion;
}

public void setCodCapacitacion(int codCapacitacion)
{
    this.codCapacitacion = codCapacitacion;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += (int) codEmp;
    hash += (int) codCapacitacion;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CapacitacionXEmpPK))
        {
        return false;
        }
    CapacitacionXEmpPK other = (CapacitacionXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codCapacitacion != other.codCapacitacion)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codCapacitacion=" + codCapacitacion + " ]";
}
}
