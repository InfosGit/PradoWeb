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
public class DependienteXEmpPK implements Serializable
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
@Column(name = "COD_DEPENDIENTE", nullable = false)
private int codDependiente;

public DependienteXEmpPK()
{
}

public DependienteXEmpPK(short codCia, int codEmp, int codDependiente)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codDependiente = codDependiente;
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

public int getCodDependiente()
{
    return codDependiente;
}

public void setCodDependiente(int codDependiente)
{
    this.codDependiente = codDependiente;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += codEmp;
    hash += codDependiente;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DependienteXEmpPK))
        {
        return false;
        }
    DependienteXEmpPK other = (DependienteXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codDependiente != other.codDependiente)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.DependienteXEmpPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codDependiente=" + codDependiente + " ]";
}
}
