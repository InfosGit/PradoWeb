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
public class DocumentosCandidatoPK implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private long codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CANDIDATO")
    private long codCandidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ARCHIVO")
    private long codArchivo;

    public DocumentosCandidatoPK()
    {
    }

    public DocumentosCandidatoPK(long codCia, long codCandidato, long codArchivo)
    {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codArchivo = codArchivo;
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

    public long getCodArchivo()
    {
        return codArchivo;
    }

    public void setCodArchivo(long codArchivo)
    {
        this.codArchivo = codArchivo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        hash += (int) codArchivo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentosCandidatoPK))
            {
            return false;
            }
        DocumentosCandidatoPK other = (DocumentosCandidatoPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codCandidato != other.codCandidato) return false;
        if (this.codArchivo != other.codArchivo) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DocumentosCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codArchivo=" + codArchivo + " ]";
    }
    
}
