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
@Table(name = "IDIOMA_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "IdiomaXEmp.findAll", query = "SELECT i FROM IdiomaXEmp i"),
    @NamedQuery(name = "IdiomaXEmp.findByCodCia", query = "SELECT i FROM IdiomaXEmp i WHERE i.idiomaXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "IdiomaXEmp.findByCodEmp", query = "SELECT i FROM IdiomaXEmp i WHERE i.idiomaXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "IdiomaXEmp.findByCodIdioma", query = "SELECT i FROM IdiomaXEmp i WHERE i.idiomaXEmpPK.codIdioma = :codIdioma"),
    @NamedQuery(name = "IdiomaXEmp.findByLee", query = "SELECT i FROM IdiomaXEmp i WHERE i.lee = :lee"),
    @NamedQuery(name = "IdiomaXEmp.findByEscribe", query = "SELECT i FROM IdiomaXEmp i WHERE i.escribe = :escribe"),
    @NamedQuery(name = "IdiomaXEmp.findByNivel", query = "SELECT i FROM IdiomaXEmp i WHERE i.nivel = :nivel")
    })
public class IdiomaXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected IdiomaXEmpPK idiomaXEmpPK;
@Size(max = 1)
@Column(name = "LEE", length = 1)
private String lee;
@Size(max = 1)
@Column(name = "ESCRIBE", length = 1)
private String escribe;
@Size(max = 1)
@Column(name = "NIVEL", length = 1)
private String nivel;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_IDIOMA", referencedColumnName = "COD_IDIOMA", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Idioma idioma;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public IdiomaXEmp()
{
}

public IdiomaXEmp(IdiomaXEmpPK idiomaXEmpPK)
{
    this.idiomaXEmpPK = idiomaXEmpPK;
}

public IdiomaXEmp(short codCia, int codEmp, int codIdioma)
{
    this.idiomaXEmpPK = new IdiomaXEmpPK(codCia, codEmp, codIdioma);
}

public IdiomaXEmpPK getIdiomaXEmpPK()
{
    return idiomaXEmpPK;
}

public void setIdiomaXEmpPK(IdiomaXEmpPK idiomaXEmpPK)
{
    this.idiomaXEmpPK = idiomaXEmpPK;
}

public String getLee()
{
    return lee;
}

public void setLee(String lee)
{
    this.lee = lee;
}

public String getEscribe()
{
    return escribe;
}

public void setEscribe(String escribe)
{
    this.escribe = escribe;
}

public String getNivel()
{
    return nivel;
}

public void setNivel(String nivel)
{
    this.nivel = nivel;
}

public Idioma getIdioma()
{
    return idioma;
}

public void setIdioma(Idioma idioma)
{
    this.idioma = idioma;
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
    hash += (idiomaXEmpPK != null ? idiomaXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IdiomaXEmp))
        {
        return false;
        }
    IdiomaXEmp other = (IdiomaXEmp) object;
    if ((this.idiomaXEmpPK == null && other.idiomaXEmpPK != null) || (this.idiomaXEmpPK != null && !this.idiomaXEmpPK.equals(other.idiomaXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.IdiomaXEmp[ idiomaXEmpPK=" + idiomaXEmpPK + " ]";
}
}
