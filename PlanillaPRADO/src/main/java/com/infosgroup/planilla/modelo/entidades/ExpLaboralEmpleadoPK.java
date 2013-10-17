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
public class ExpLaboralEmpleadoPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private long codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_EMP", nullable = false)
private long codEmp;
@Basic(optional = false)
@NotNull
@Column(name = "COD_EXP_LABORAL", nullable = false)
private long codExpLaboral;

public ExpLaboralEmpleadoPK()
{
}

public ExpLaboralEmpleadoPK(long codCia, long codEmp, long codExpLaboral)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codExpLaboral = codExpLaboral;
}

public long getCodCia()
{
    return codCia;
}

public void setCodCia(long codCia)
{
    this.codCia = codCia;
}

public long getCodEmp()
{
    return codEmp;
}

public void setCodEmp(long codEmp)
{
    this.codEmp = codEmp;
}

public long getCodExpLaboral()
{
    return codExpLaboral;
}

public void setCodExpLaboral(long codExpLaboral)
{
    this.codExpLaboral = codExpLaboral;
}

@Override
public int hashCode()
{
    int hash = 3;
    hash = 59 * hash + (int) (this.codCia ^ (this.codCia >>> 32));
    hash = 59 * hash + (int) (this.codEmp ^ (this.codEmp >>> 32));
    hash = 59 * hash + (int) (this.codExpLaboral ^ (this.codExpLaboral >>> 32));
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codEmp;
//    hash += (int) codExpLaboral;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExpLaboralEmpleadoPK))
        {
        return false;
        }
    ExpLaboralEmpleadoPK other = (ExpLaboralEmpleadoPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codExpLaboral != other.codExpLaboral)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ExpLaboralEmpleadoPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codExpLaboral=" + codExpLaboral + " ]";
}
}
