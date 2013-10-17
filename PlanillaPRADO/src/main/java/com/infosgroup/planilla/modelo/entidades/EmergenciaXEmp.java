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
@Table(name = "EMERGENCIA_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EmergenciaXEmp.findAll", query = "SELECT e FROM EmergenciaXEmp e"),
    @NamedQuery(name = "EmergenciaXEmp.findByCodCia", query = "SELECT e FROM EmergenciaXEmp e WHERE e.emergenciaXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "EmergenciaXEmp.findByCodEmp", query = "SELECT e FROM EmergenciaXEmp e WHERE e.emergenciaXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "EmergenciaXEmp.findByCodEmergencia", query = "SELECT e FROM EmergenciaXEmp e WHERE e.emergenciaXEmpPK.codEmergencia = :codEmergencia"),
    @NamedQuery(name = "EmergenciaXEmp.findByNombre", query = "SELECT e FROM EmergenciaXEmp e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmergenciaXEmp.findByTelefono", query = "SELECT e FROM EmergenciaXEmp e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EmergenciaXEmp.findByCodParentesco", query = "SELECT e FROM EmergenciaXEmp e WHERE e.codParentesco = :codParentesco")
    })
public class EmergenciaXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected EmergenciaXEmpPK emergenciaXEmpPK;
@Size(max = 200)
@Column(name = "NOMBRE", length = 200)
private String nombre;
@Size(max = 20)
@Column(name = "TELEFONO", length = 20)
private String telefono;
@Column(name = "COD_PARENTESCO")
private Short codParentesco;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public EmergenciaXEmp()
{
}

public EmergenciaXEmp(EmergenciaXEmpPK emergenciaXEmpPK)
{
    this.emergenciaXEmpPK = emergenciaXEmpPK;
}

public EmergenciaXEmp(short codCia, int codEmp, int codEmergencia)
{
    this.emergenciaXEmpPK = new EmergenciaXEmpPK(codCia, codEmp, codEmergencia);
}

public EmergenciaXEmpPK getEmergenciaXEmpPK()
{
    return emergenciaXEmpPK;
}

public void setEmergenciaXEmpPK(EmergenciaXEmpPK emergenciaXEmpPK)
{
    this.emergenciaXEmpPK = emergenciaXEmpPK;
}

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public String getTelefono()
{
    return telefono;
}

public void setTelefono(String telefono)
{
    this.telefono = telefono;
}

public Short getCodParentesco()
{
    return codParentesco;
}

public void setCodParentesco(Short codParentesco)
{
    this.codParentesco = codParentesco;
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
    hash += (emergenciaXEmpPK != null ? emergenciaXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EmergenciaXEmp))
        {
        return false;
        }
    EmergenciaXEmp other = (EmergenciaXEmp) object;
    if ((this.emergenciaXEmpPK == null && other.emergenciaXEmpPK != null) || (this.emergenciaXEmpPK != null && !this.emergenciaXEmpPK.equals(other.emergenciaXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EmergenciaXEmp[ emergenciaXEmpPK=" + emergenciaXEmpPK + " ]";
}
}
