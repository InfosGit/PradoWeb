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
@Table(name = "NIVELES_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "NivelesXEmp.findAll", query = "SELECT n FROM NivelesXEmp n"),
    @NamedQuery(name = "NivelesXEmp.findByCodCia", query = "SELECT n FROM NivelesXEmp n WHERE n.nivelesXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "NivelesXEmp.findByCodEmp", query = "SELECT n FROM NivelesXEmp n WHERE n.nivelesXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "NivelesXEmp.findByCodNivel", query = "SELECT n FROM NivelesXEmp n WHERE n.nivelesXEmpPK.codNivel = :codNivel"),
    @NamedQuery(name = "NivelesXEmp.findByEstadoNivel", query = "SELECT n FROM NivelesXEmp n WHERE n.estadoNivel = :estadoNivel"),
    @NamedQuery(name = "NivelesXEmp.findByFecEstado", query = "SELECT n FROM NivelesXEmp n WHERE n.fecEstado = :fecEstado"),
    @NamedQuery(name = "NivelesXEmp.findBySubNivel", query = "SELECT n FROM NivelesXEmp n WHERE n.subNivel = :subNivel"),
    @NamedQuery(name = "NivelesXEmp.findByNomInstitucion", query = "SELECT n FROM NivelesXEmp n WHERE n.nomInstitucion = :nomInstitucion"),
    @NamedQuery(name = "NivelesXEmp.findByAnioIngreso", query = "SELECT n FROM NivelesXEmp n WHERE n.anioIngreso = :anioIngreso"),
    @NamedQuery(name = "NivelesXEmp.findByAnioEgreso", query = "SELECT n FROM NivelesXEmp n WHERE n.anioEgreso = :anioEgreso"),
    @NamedQuery(name = "NivelesXEmp.findByCodPais", query = "SELECT n FROM NivelesXEmp n WHERE n.codPais = :codPais"),
    @NamedQuery(name = "NivelesXEmp.findByCodDepto", query = "SELECT n FROM NivelesXEmp n WHERE n.codDepto = :codDepto")
    })
public class NivelesXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected NivelesXEmpPK nivelesXEmpPK;
@Size(max = 1)
@Column(name = "ESTADO_NIVEL", length = 1)
private String estadoNivel;
@Column(name = "FEC_ESTADO")
@Temporal(TemporalType.TIMESTAMP)
private Date fecEstado;
@Column(name = "SUB_NIVEL")
private Short subNivel;
@Size(max = 100)
@Column(name = "NOM_INSTITUCION", length = 100)
private String nomInstitucion;
@Column(name = "ANIO_INGRESO")
private Short anioIngreso;
@Column(name = "ANIO_EGRESO")
private Short anioEgreso;
@Column(name = "COD_PAIS")
private Short codPais;
@Column(name = "COD_DEPTO")
private Short codDepto;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public NivelesXEmp()
{
}

public NivelesXEmp(NivelesXEmpPK nivelesXEmpPK)
{
    this.nivelesXEmpPK = nivelesXEmpPK;
}

public NivelesXEmp(short codCia, int codEmp, short codNivel)
{
    this.nivelesXEmpPK = new NivelesXEmpPK(codCia, codEmp, codNivel);
}

public NivelesXEmpPK getNivelesXEmpPK()
{
    return nivelesXEmpPK;
}

public void setNivelesXEmpPK(NivelesXEmpPK nivelesXEmpPK)
{
    this.nivelesXEmpPK = nivelesXEmpPK;
}

public String getEstadoNivel()
{
    return estadoNivel;
}

public void setEstadoNivel(String estadoNivel)
{
    this.estadoNivel = estadoNivel;
}

public Date getFecEstado()
{
    return fecEstado;
}

public void setFecEstado(Date fecEstado)
{
    this.fecEstado = fecEstado;
}

public Short getSubNivel()
{
    return subNivel;
}

public void setSubNivel(Short subNivel)
{
    this.subNivel = subNivel;
}

public String getNomInstitucion()
{
    return nomInstitucion;
}

public void setNomInstitucion(String nomInstitucion)
{
    this.nomInstitucion = nomInstitucion;
}

public Short getAnioIngreso()
{
    return anioIngreso;
}

public void setAnioIngreso(Short anioIngreso)
{
    this.anioIngreso = anioIngreso;
}

public Short getAnioEgreso()
{
    return anioEgreso;
}

public void setAnioEgreso(Short anioEgreso)
{
    this.anioEgreso = anioEgreso;
}

public Short getCodPais()
{
    return codPais;
}

public void setCodPais(Short codPais)
{
    this.codPais = codPais;
}

public Short getCodDepto()
{
    return codDepto;
}

public void setCodDepto(Short codDepto)
{
    this.codDepto = codDepto;
}

public Empleados getEmpleados()
{
    return empleados;
}

public void setEmpleados(Empleados empleados)
{
    this.empleados = empleados;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (nivelesXEmpPK != null ? nivelesXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof NivelesXEmp))
        {
        return false;
        }
    NivelesXEmp other = (NivelesXEmp) object;
    if ((this.nivelesXEmpPK == null && other.nivelesXEmpPK != null) || (this.nivelesXEmpPK != null && !this.nivelesXEmpPK.equals(other.nivelesXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.NivelesXEmp[ nivelesXEmpPK=" + nivelesXEmpPK + " ]";
}
}
