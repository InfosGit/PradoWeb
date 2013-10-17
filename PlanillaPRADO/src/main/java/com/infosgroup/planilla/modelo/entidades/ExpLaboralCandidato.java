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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "EXP_LABORAL_CANDIDATO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ExpLaboralCandidato.findAll", query = "SELECT e FROM ExpLaboralCandidato e"),
    @NamedQuery(name = "ExpLaboralCandidato.findByCodCia", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.expLaboralCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "ExpLaboralCandidato.findByCodCandidato", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.expLaboralCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "ExpLaboralCandidato.findByCodExpLaboral", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.expLaboralCandidatoPK.codExpLaboral = :codExpLaboral"),
    @NamedQuery(name = "ExpLaboralCandidato.findByLugarTrabajo", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.lugarTrabajo = :lugarTrabajo"),
    @NamedQuery(name = "ExpLaboralCandidato.findByFechaInicio", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ExpLaboralCandidato.findByFechaFin", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "ExpLaboralCandidato.findByMotivoRetiro", query = "SELECT e FROM ExpLaboralCandidato e WHERE e.motivoRetiro = :motivoRetiro")
    })
public class ExpLaboralCandidato implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected ExpLaboralCandidatoPK expLaboralCandidatoPK;
@Size(max = 100)
@Column(name = "LUGAR_TRABAJO", length = 100)
private String lugarTrabajo;
@Column(name = "FECHA_INICIO")
@Temporal(TemporalType.TIMESTAMP)
private Date fechaInicio;
@Column(name = "FECHA_FIN")
@Temporal(TemporalType.TIMESTAMP)
private Date fechaFin;
@Size(max = 500)
@Column(name = "MOTIVO_RETIRO", length = 500)
private String motivoRetiro;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")
    })
@ManyToOne(optional = false)
private Puestos puestos;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Candidato candidato;

public ExpLaboralCandidato()
{
}

public ExpLaboralCandidato(ExpLaboralCandidatoPK expLaboralCandidatoPK)
{
    this.expLaboralCandidatoPK = expLaboralCandidatoPK;
}

public ExpLaboralCandidato(long codCia, long codCandidato, long codExpLaboral)
{
    this.expLaboralCandidatoPK = new ExpLaboralCandidatoPK(codCia, codCandidato, codExpLaboral);
}

public ExpLaboralCandidatoPK getExpLaboralCandidatoPK()
{
    return expLaboralCandidatoPK;
}

public void setExpLaboralCandidatoPK(ExpLaboralCandidatoPK expLaboralCandidatoPK)
{
    this.expLaboralCandidatoPK = expLaboralCandidatoPK;
}

public String getLugarTrabajo()
{
    return lugarTrabajo;
}

public void setLugarTrabajo(String lugarTrabajo)
{
    this.lugarTrabajo = lugarTrabajo;
}

public Date getFechaInicio()
{
    return fechaInicio;
}

public void setFechaInicio(Date fechaInicio)
{
    this.fechaInicio = fechaInicio;
}

public Date getFechaFin()
{
    return fechaFin;
}

public void setFechaFin(Date fechaFin)
{
    this.fechaFin = fechaFin;
}

public String getMotivoRetiro()
{
    return motivoRetiro;
}

public void setMotivoRetiro(String motivoRetiro)
{
    this.motivoRetiro = motivoRetiro;
}

public Puestos getPuestos()
{
    return puestos;
}

public void setPuestos(Puestos puestos)
{
    this.puestos = puestos;
}

public Candidato getCandidato()
{
    return candidato;
}

public void setCandidato(Candidato candidato)
{
    this.candidato = candidato;
}

@Override
public int hashCode()
{
    int hash = 7;
    hash = 41 * hash + (this.expLaboralCandidatoPK != null ? this.expLaboralCandidatoPK.hashCode() : 0);
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (expLaboralCandidatoPK != null ? expLaboralCandidatoPK.hashCode() : 0);
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExpLaboralCandidato))
        {
        return false;
        }
    ExpLaboralCandidato other = (ExpLaboralCandidato) object;
    if ((this.expLaboralCandidatoPK == null && other.expLaboralCandidatoPK != null) || (this.expLaboralCandidatoPK != null && !this.expLaboralCandidatoPK.equals(other.expLaboralCandidatoPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ExpLaboralCandidato[ expLaboralCandidatoPK=" + expLaboralCandidatoPK + " ]";
}
}
