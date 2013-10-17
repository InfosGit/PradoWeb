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
public class EmpXCargoPK implements Serializable
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
@Column(name = "COD_PUESTO", nullable = false)
private short codPuesto;

public EmpXCargoPK()
{
}

public EmpXCargoPK(short codCia, int codEmp, short codPuesto)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codPuesto = codPuesto;
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

public short getCodPuesto()
{
    return codPuesto;
}

public void setCodPuesto(short codPuesto)
{
    this.codPuesto = codPuesto;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += codEmp;
//    hash += (int) codPuesto;
//    return hash;
//}
@Override
public int hashCode()
{
    int hash = 7;
    hash = 79 * hash + this.codCia;
    hash = 79 * hash + this.codEmp;
    hash = 79 * hash + this.codPuesto;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EmpXCargoPK))
        {
        return false;
        }
    EmpXCargoPK other = (EmpXCargoPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codPuesto != other.codPuesto)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EmpXCargoPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codPuesto=" + codPuesto + " ]";
}
}
