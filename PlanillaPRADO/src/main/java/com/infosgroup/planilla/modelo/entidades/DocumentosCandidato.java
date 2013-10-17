/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DOCUMENTOS_CANDIDATO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "DocumentosCandidato.findAll", query = "SELECT d FROM DocumentosCandidato d"),
    @NamedQuery(name = "DocumentosCandidato.findByCodCia", query = "SELECT d FROM DocumentosCandidato d WHERE d.documentosCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "DocumentosCandidato.findByCodCandidato", query = "SELECT d FROM DocumentosCandidato d WHERE d.documentosCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "DocumentosCandidato.findByCodArchivo", query = "SELECT d FROM DocumentosCandidato d WHERE d.documentosCandidatoPK.codArchivo = :codArchivo"),
    @NamedQuery(name = "DocumentosCandidato.findByDescripcion", query = "SELECT d FROM DocumentosCandidato d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DocumentosCandidato.findByExtension", query = "SELECT d FROM DocumentosCandidato d WHERE d.extension = :extension"),
    @NamedQuery(name = "DocumentosCandidato.findByFechaCargo", query = "SELECT d FROM DocumentosCandidato d WHERE d.fechaCargo = :fechaCargo"),
    @NamedQuery(name = "DocumentosCandidato.findByRuta", query = "SELECT d FROM DocumentosCandidato d WHERE d.ruta = :ruta"),
    @NamedQuery(name = "DocumentosCandidato.findByTipo", query = "SELECT d FROM DocumentosCandidato d WHERE d.tipo = :tipo")
    })
public class DocumentosCandidato implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentosCandidatoPK documentosCandidatoPK;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 5)
    @Column(name = "EXTENSION")
    private String extension;
    @Column(name = "FECHA_CARGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCargo;
    @Size(max = 2000)
    @Column(name = "RUTA")
    private String ruta;
    @Size(max = 50)
    @Column(name = "TIPO")
    private String tipo;

    public DocumentosCandidato()
    {
    }

    public DocumentosCandidato(DocumentosCandidatoPK documentosCandidatoPK)
    {
        this.documentosCandidatoPK = documentosCandidatoPK;
    }

    public DocumentosCandidato(long codCia, long codCandidato, long codArchivo)
    {
        this.documentosCandidatoPK = new DocumentosCandidatoPK(codCia, codCandidato, codArchivo);
    }

    public DocumentosCandidatoPK getDocumentosCandidatoPK()
    {
        return documentosCandidatoPK;
    }

    public void setDocumentosCandidatoPK(DocumentosCandidatoPK documentosCandidatoPK)
    {
        this.documentosCandidatoPK = documentosCandidatoPK;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public Date getFechaCargo()
    {
        return fechaCargo;
    }

    public void setFechaCargo(Date fechaCargo)
    {
        this.fechaCargo = fechaCargo;
    }

    public String getRuta()
    {
        return ruta;
    }

    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (documentosCandidatoPK != null ? documentosCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentosCandidato))
            {
            return false;
            }
        DocumentosCandidato other = (DocumentosCandidato) object;
        if ((this.documentosCandidatoPK == null && other.documentosCandidatoPK != null) || (this.documentosCandidatoPK != null && !this.documentosCandidatoPK.equals(other.documentosCandidatoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DocumentosCandidato[ documentosCandidatoPK=" + documentosCandidatoPK + " ]";
    }
    
}
