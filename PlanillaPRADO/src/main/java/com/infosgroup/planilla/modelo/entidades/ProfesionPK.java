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
public class ProfesionPK implements Serializable
{

private static final long serialVersionUID = 1L;
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_PROFESION", nullable = false)
private short codProfesion;

public ProfesionPK()
{
}

public ProfesionPK(short codCia, short codProfesion)
{
    this.codCia = codCia;
    this.codProfesion = codProfesion;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public short getCodProfesion()
{
    return codProfesion;
}

public void setCodProfesion(short codProfesion)
{
    this.codProfesion = codProfesion;
}

@Override
public int hashCode()
{
    int hash = 3;
    hash = 47 * hash + this.codCia;
    hash = 47 * hash + this.codProfesion;
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codProfesion;
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ProfesionPK))
        {
        return false;
        }
    ProfesionPK other = (ProfesionPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codProfesion != other.codProfesion)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ProfesionPK[ codCia=" + codCia + ", codProfesion=" + codProfesion + " ]";
}
}
