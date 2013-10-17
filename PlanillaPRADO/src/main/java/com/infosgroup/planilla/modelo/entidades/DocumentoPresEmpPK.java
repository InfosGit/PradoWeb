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
public class DocumentoPresEmpPK implements Serializable
{

private static final long serialVersionUID = 1L;
//
@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_DOCUMENTO_PRES", nullable = false)
private int codDocumentoPres;
@Basic(optional = false)
@NotNull
@Column(name = "COD_EMP", nullable = false)
private int codEmp;

public DocumentoPresEmpPK()
{
}

public DocumentoPresEmpPK(short codCia, int codDocumentoPres, int codEmp)
{
    this.codCia = codCia;
    this.codDocumentoPres = codDocumentoPres;
    this.codEmp = codEmp;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public int getCodDocumentoPres()
{
    return codDocumentoPres;
}

public void setCodDocumentoPres(int codDocumentoPres)
{
    this.codDocumentoPres = codDocumentoPres;
}

public int getCodEmp()
{
    return codEmp;
}

public void setCodEmp(int codEmp)
{
    this.codEmp = codEmp;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (int) codCia;
//    hash += (int) codDocumentoPres;
//    hash += (int) codEmp;
//    return hash;
//}
@Override
public int hashCode()
{
    int hash = 3;
    hash = 71 * hash + this.codCia;
    hash = 71 * hash + this.codDocumentoPres;
    hash = 71 * hash + this.codEmp;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DocumentoPresEmpPK))
        {
        return false;
        }
    DocumentoPresEmpPK other = (DocumentoPresEmpPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codDocumentoPres != other.codDocumentoPres)
        {
        return false;
        }
    if (this.codEmp != other.codEmp)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.DocumentoPresEmpPK[ codCia=" + codCia + ", codDocumentoPres=" + codDocumentoPres + ", codEmp=" + codEmp + " ]";
}
}
