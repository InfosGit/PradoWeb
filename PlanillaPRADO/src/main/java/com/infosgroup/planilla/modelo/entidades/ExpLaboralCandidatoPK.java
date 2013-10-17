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
public class ExpLaboralCandidatoPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private long codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_CANDIDATO", nullable = false)
private long codCandidato;
@Basic(optional = false)
@NotNull
@Column(name = "COD_EXP_LABORAL", nullable = false)
private long codExpLaboral;

public ExpLaboralCandidatoPK()
{
}

public ExpLaboralCandidatoPK(long codCia, long codCandidato, long codExpLaboral)
{
    this.codCia = codCia;
    this.codCandidato = codCandidato;
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

public long getCodCandidato()
{
    return codCandidato;
}

public void setCodCandidato(long codCandidato)
{
    this.codCandidato = codCandidato;
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
    int hash = 7;
    hash = 37 * hash + (int) (this.codCia ^ (this.codCia >>> 32));
    hash = 37 * hash + (int) (this.codCandidato ^ (this.codCandidato >>> 32));
    hash = 37 * hash + (int) (this.codExpLaboral ^ (this.codExpLaboral >>> 32));
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codCandidato;
//    hash += (int) codExpLaboral;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExpLaboralCandidatoPK))
        {
        return false;
        }
    ExpLaboralCandidatoPK other = (ExpLaboralCandidatoPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codCandidato != other.codCandidato)
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
    return "com.infosgroup.planilla.modelo.entidades.ExpLaboralCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codExpLaboral=" + codExpLaboral + " ]";
}
}
