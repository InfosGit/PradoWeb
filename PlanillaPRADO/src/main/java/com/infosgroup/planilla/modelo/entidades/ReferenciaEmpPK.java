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
public class ReferenciaEmpPK implements Serializable
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
@Column(name = "COD_REFERENCIA", nullable = false)
private int codReferencia;

public ReferenciaEmpPK()
{
}

public ReferenciaEmpPK(short codCia, int codEmp, int codReferencia)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codReferencia = codReferencia;
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

public int getCodReferencia()
{
    return codReferencia;
}

public void setCodReferencia(int codReferencia)
{
    this.codReferencia = codReferencia;
}

@Override
public int hashCode()
{
    int hash = 7;
    hash = 71 * hash + this.codCia;
    hash = 71 * hash + this.codEmp;
    hash = 71 * hash + this.codReferencia;
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += codEmp;
//    hash += codReferencia;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReferenciaEmpPK))
        {
        return false;
        }
    ReferenciaEmpPK other = (ReferenciaEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codReferencia != other.codReferencia)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ReferenciaEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codReferencia=" + codReferencia + " ]";
}
}
