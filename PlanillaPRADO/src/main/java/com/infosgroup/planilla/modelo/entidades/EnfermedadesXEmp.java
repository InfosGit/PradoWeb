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
@Table(name = "ENFERMEDADES_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EnfermedadesXEmp.findAll", query = "SELECT e FROM EnfermedadesXEmp e"),
    @NamedQuery(name = "EnfermedadesXEmp.findByCodCia", query = "SELECT e FROM EnfermedadesXEmp e WHERE e.enfermedadesXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "EnfermedadesXEmp.findByCodEmp", query = "SELECT e FROM EnfermedadesXEmp e WHERE e.enfermedadesXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "EnfermedadesXEmp.findByCodEnfermedad", query = "SELECT e FROM EnfermedadesXEmp e WHERE e.enfermedadesXEmpPK.codEnfermedad = :codEnfermedad"),
    @NamedQuery(name = "EnfermedadesXEmp.findByDesEnfermedad", query = "SELECT e FROM EnfermedadesXEmp e WHERE e.desEnfermedad = :desEnfermedad")
    })
public class EnfermedadesXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected EnfermedadesXEmpPK enfermedadesXEmpPK;
@Size(max = 25)
@Column(name = "DES_ENFERMEDAD", length = 25)
private String desEnfermedad;
@JoinColumn(name = "COD_ENFERMEDAD", referencedColumnName = "COD_ENFERMEDAD", nullable = false, insertable = false, updatable = false)
@ManyToOne(optional = false)
private Enfermedades enfermedades;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public EnfermedadesXEmp()
{
}

public EnfermedadesXEmp(EnfermedadesXEmpPK enfermedadesXEmpPK)
{
    this.enfermedadesXEmpPK = enfermedadesXEmpPK;
}

public EnfermedadesXEmp(short codCia, int codEmp, short codEnfermedad)
{
    this.enfermedadesXEmpPK = new EnfermedadesXEmpPK(codCia, codEmp, codEnfermedad);
}

public EnfermedadesXEmpPK getEnfermedadesXEmpPK()
{
    return enfermedadesXEmpPK;
}

public void setEnfermedadesXEmpPK(EnfermedadesXEmpPK enfermedadesXEmpPK)
{
    this.enfermedadesXEmpPK = enfermedadesXEmpPK;
}

public String getDesEnfermedad()
{
    return desEnfermedad;
}

public void setDesEnfermedad(String desEnfermedad)
{
    this.desEnfermedad = desEnfermedad;
}

public Enfermedades getEnfermedades()
{
    return enfermedades;
}

public void setEnfermedades(Enfermedades enfermedades)
{
    this.enfermedades = enfermedades;
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
    hash += (enfermedadesXEmpPK != null ? enfermedadesXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EnfermedadesXEmp))
        {
        return false;
        }
    EnfermedadesXEmp other = (EnfermedadesXEmp) object;
    if ((this.enfermedadesXEmpPK == null && other.enfermedadesXEmpPK != null) || (this.enfermedadesXEmpPK != null && !this.enfermedadesXEmpPK.equals(other.enfermedadesXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EnfermedadesXEmp[ enfermedadesXEmpPK=" + enfermedadesXEmpPK + " ]";
}
}
