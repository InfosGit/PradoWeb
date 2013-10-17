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
public class CriteriosXEmpPK implements Serializable
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
private int codEmp;
@Basic(optional = false)
@NotNull
@Column(name = "CRITERIO", nullable = false)
private long criterio;
@Basic(optional = false)
@NotNull
@Column(name = "TIPO_CRITERIO", nullable = false)
private long tipoCriterio;
@Basic(optional = false)
@NotNull
@Column(name = "CORRELATIVO", nullable = false)
private long correlativo;

public CriteriosXEmpPK()
{
}

public CriteriosXEmpPK(long codCia, int codEmp, long criterio, long tipoCriterio, long correlativo)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.criterio = criterio;
    this.tipoCriterio = tipoCriterio;
    this.correlativo = correlativo;
}

public long getCodCia()
{
    return codCia;
}

public void setCodCia(long codCia)
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

public long getCriterio()
{
    return criterio;
}

public void setCriterio(long criterio)
{
    this.criterio = criterio;
}

public long getTipoCriterio()
{
    return tipoCriterio;
}

public void setTipoCriterio(long tipoCriterio)
{
    this.tipoCriterio = tipoCriterio;
}

public long getCorrelativo()
{
    return correlativo;
}

public void setCorrelativo(long correlativo)
{
    this.correlativo = correlativo;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += (int) codEmp;
    hash += (int) criterio;
    hash += (int) tipoCriterio;
    hash += (int) correlativo;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CriteriosXEmpPK))
        {
        return false;
        }
    CriteriosXEmpPK other = (CriteriosXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.criterio != other.criterio)
        {
        return false;
        }
    if (this.tipoCriterio != other.tipoCriterio)
        {
        return false;
        }
    if (this.correlativo != other.correlativo)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.CriteriosXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", criterio=" + criterio + ", tipoCriterio=" + tipoCriterio + ", correlativo=" + correlativo + " ]";
}
}
