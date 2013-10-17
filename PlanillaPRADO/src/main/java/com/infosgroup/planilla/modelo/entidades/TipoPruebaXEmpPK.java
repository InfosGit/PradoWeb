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
public class TipoPruebaXEmpPK implements Serializable
{

private static final long serialVersionUID = 1L;
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
@Column(name = "COD_TIPO_PRUEBA", nullable = false)
private short codTipoPrueba;

public TipoPruebaXEmpPK()
{
}

public TipoPruebaXEmpPK(short codCia, int codEmp, short codTipoPrueba)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codTipoPrueba = codTipoPrueba;
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

public short getCodTipoPrueba()
{
    return codTipoPrueba;
}

public void setCodTipoPrueba(short codTipoPrueba)
{
    this.codTipoPrueba = codTipoPrueba;
}

@Override
public int hashCode()
{
    int hash = 7;
    hash = 89 * hash + this.codCia;
    hash = 89 * hash + this.codEmp;
    hash = 89 * hash + this.codTipoPrueba;
    return hash;
}

//    @Override
//    public int hashCode()
//    {
//        int hash = 0;
//        hash += (int) codCia;
//        hash += (int) codEmp;
//        hash += (int) codTipoPrueba;
//        return hash;
//    }
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoPruebaXEmpPK))
        {
        return false;
        }
    TipoPruebaXEmpPK other = (TipoPruebaXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codTipoPrueba != other.codTipoPrueba)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TipoPruebaXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codTipoPrueba=" + codTipoPrueba + " ]";
}
}
