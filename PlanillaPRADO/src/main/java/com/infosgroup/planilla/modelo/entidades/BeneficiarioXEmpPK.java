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
public class BeneficiarioXEmpPK implements Serializable
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
@Column(name = "COD_BENEFICIARIO", nullable = false)
private int codBeneficiario;

public BeneficiarioXEmpPK()
{
}

public BeneficiarioXEmpPK(short codCia, int codEmp, int codBeneficiario)
{
    this.codCia = codCia;
    this.codEmp = codEmp;
    this.codBeneficiario = codBeneficiario;
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

public int getCodBeneficiario()
{
    return codBeneficiario;
}

public void setCodBeneficiario(int codBeneficiario)
{
    this.codBeneficiario = codBeneficiario;
}

@Override
public int hashCode()
{
    int hash = 3;
    hash = 97 * hash + this.codCia;
    hash = 97 * hash + this.codEmp;
    hash = 97 * hash + this.codBeneficiario;
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += codEmp;
//    hash += codBeneficiario;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BeneficiarioXEmpPK))
        {
        return false;
        }
    BeneficiarioXEmpPK other = (BeneficiarioXEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    if (this.codBeneficiario != other.codBeneficiario)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.BeneficiarioXEmpPK[ codCia=" + codCia + ", codCandidato=" + codEmp + ", codBeneficiario=" + codBeneficiario + " ]";
}
}
