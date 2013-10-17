/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPOS_INCAPACIDAD")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "TiposIncapacidad.findAll", query = "SELECT t FROM TiposIncapacidad t"),
    @NamedQuery(name = "TiposIncapacidad.findByCodCia", query = "SELECT t FROM TiposIncapacidad t WHERE t.tiposIncapacidadPK.codCia = :codCia"),
    @NamedQuery(name = "TiposIncapacidad.findByCodTipoinca", query = "SELECT t FROM TiposIncapacidad t WHERE t.tiposIncapacidadPK.codTipoinca = :codTipoinca"),
    @NamedQuery(name = "TiposIncapacidad.findByNomTipoinca", query = "SELECT t FROM TiposIncapacidad t WHERE t.nomTipoinca = :nomTipoinca")
    })
public class TiposIncapacidad implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected TiposIncapacidadPK tiposIncapacidadPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 40)
@Column(name = "NOM_TIPOINCA", nullable = false, length = 40)
private String nomTipoinca;
@JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
@ManyToOne(optional = false)
private Cias cias;

public TiposIncapacidad()
{
}

public TiposIncapacidad(TiposIncapacidadPK tiposIncapacidadPK)
{
    this.tiposIncapacidadPK = tiposIncapacidadPK;
}

public TiposIncapacidad(TiposIncapacidadPK tiposIncapacidadPK, String nomTipoinca)
{
    this.tiposIncapacidadPK = tiposIncapacidadPK;
    this.nomTipoinca = nomTipoinca;
}

public TiposIncapacidad(Integer codCia, Integer codTipoinca)
{
    this.tiposIncapacidadPK = new TiposIncapacidadPK(codCia, codTipoinca);
}

public TiposIncapacidadPK getTiposIncapacidadPK()
{
    return tiposIncapacidadPK;
}

public void setTiposIncapacidadPK(TiposIncapacidadPK tiposIncapacidadPK)
{
    this.tiposIncapacidadPK = tiposIncapacidadPK;
}

public String getNomTipoinca()
{
    return nomTipoinca;
}

public void setNomTipoinca(String nomTipoinca)
{
    this.nomTipoinca = nomTipoinca;
}

public Cias getCias()
{
    return cias;
}

public void setCias(Cias cias)
{
    this.cias = cias;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (tiposIncapacidadPK != null ? tiposIncapacidadPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TiposIncapacidad))
        {
        return false;
        }
    TiposIncapacidad other = (TiposIncapacidad) object;
    if ((this.tiposIncapacidadPK == null && other.tiposIncapacidadPK != null) || (this.tiposIncapacidadPK != null && !this.tiposIncapacidadPK.equals(other.tiposIncapacidadPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TiposIncapacidad[ tiposIncapacidadPK=" + tiposIncapacidadPK + " ]";
}
}
