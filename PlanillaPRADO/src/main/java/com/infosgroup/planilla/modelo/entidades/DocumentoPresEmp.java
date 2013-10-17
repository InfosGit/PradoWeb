/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DOCUMENTO_PRES_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "DocumentoPresEmp.findAll", query = "SELECT d FROM DocumentoPresEmp d"),
    @NamedQuery(name = "DocumentoPresEmp.findByCodCia", query = "SELECT d FROM DocumentoPresEmp d WHERE d.documentoPresEmpPK.codCia = :codCia"),
    @NamedQuery(name = "DocumentoPresEmp.findByCodDocumentoPres", query = "SELECT d FROM DocumentoPresEmp d WHERE d.documentoPresEmpPK.codDocumentoPres = :codDocumentoPres"),
    @NamedQuery(name = "DocumentoPresEmp.findByCodEmp", query = "SELECT d FROM DocumentoPresEmp d WHERE d.documentoPresEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "DocumentoPresEmp.findByObservacion", query = "SELECT d FROM DocumentoPresEmp d WHERE d.observacion = :observacion")
    })
public class DocumentoPresEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected DocumentoPresEmpPK documentoPresEmpPK;
@Size(max = 500)
@Column(name = "OBSERVACION", length = 500)
private String observacion;
@Column(name = "UBICACION", length = 500)
private String ubicacion;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_TIPO_DOCUMENTO", referencedColumnName = "COD_TIPO_DOCUMENTO")
    })
@ManyToOne(optional = false)
private TipoDocumento tipoDocumento;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public DocumentoPresEmp()
{
}

public DocumentoPresEmp(DocumentoPresEmpPK documentoPresEmpPK)
{
    this.documentoPresEmpPK = documentoPresEmpPK;
}

public DocumentoPresEmp(short codCia, int codDocumentoPres, int codEmp)
{
    this.documentoPresEmpPK = new DocumentoPresEmpPK(codCia, codDocumentoPres, codEmp);
}

public DocumentoPresEmpPK getDocumentoPresEmpPK()
{
    return documentoPresEmpPK;
}

public void setDocumentoPresEmpPK(DocumentoPresEmpPK documentoPresEmpPK)
{
    this.documentoPresEmpPK = documentoPresEmpPK;
}

public String getObservacion()
{
    return observacion;
}

public void setObservacion(String observacion)
{
    this.observacion = observacion;
}

public TipoDocumento getTipoDocumento()
{
    return tipoDocumento;
}

public void setTipoDocumento(TipoDocumento tipoDocumento)
{
    this.tipoDocumento = tipoDocumento;
}

public Empleados getEmpleados()
{
    return empleados;
}

public void setEmpleados(Empleados empleados)
{
    this.empleados = empleados;
}

public String getUbicacion()
{
    return ubicacion;
}

public void setUbicacion(String ubicacion)
{
    this.ubicacion = ubicacion;
}


@Override
public int hashCode()
{
    int hash = 0;
    hash += (documentoPresEmpPK != null ? documentoPresEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DocumentoPresEmp))
        {
        return false;
        }
    DocumentoPresEmp other = (DocumentoPresEmp) object;
    if ((this.documentoPresEmpPK == null && other.documentoPresEmpPK != null) || (this.documentoPresEmpPK != null && !this.documentoPresEmpPK.equals(other.documentoPresEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.DocumentoPresEmp[ documentoPresEmpPK=" + documentoPresEmpPK + " ]";
}
}
