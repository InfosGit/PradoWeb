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
@Table(name = "DEPENDIENTE_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "DependienteXEmp.findAll", query = "SELECT d FROM DependienteXEmp d"),
    @NamedQuery(name = "DependienteXEmp.findByCodCia", query = "SELECT d FROM DependienteXEmp d WHERE d.dependienteXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "DependienteXEmp.findByCodEmp", query = "SELECT d FROM DependienteXEmp d WHERE d.dependienteXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "DependienteXEmp.findByCodDependiente", query = "SELECT d FROM DependienteXEmp d WHERE d.dependienteXEmpPK.codDependiente = :codDependiente"),
    @NamedQuery(name = "DependienteXEmp.findByCodParentesco", query = "SELECT d FROM DependienteXEmp d WHERE d.codParentesco = :codParentesco"),
    @NamedQuery(name = "DependienteXEmp.findByFechaNacimiento", query = "SELECT d FROM DependienteXEmp d WHERE d.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "DependienteXEmp.findByNombre", query = "SELECT d FROM DependienteXEmp d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DependienteXEmp.findBySexo", query = "SELECT d FROM DependienteXEmp d WHERE d.sexo = :sexo")
    })
public class DependienteXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected DependienteXEmpPK dependienteXEmpPK;
@Column(name = "COD_PARENTESCO")
private Short codParentesco;
@Column(name = "FECHA_NACIMIENTO")
@Temporal(TemporalType.TIMESTAMP)
private Date fechaNacimiento;
@Size(max = 100)
@Column(name = "NOMBRE", length = 100)
private String nombre;
@Size(max = 1)
@Column(name = "SEXO", length = 1)
private String sexo;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public DependienteXEmp()
{
}

public DependienteXEmp(DependienteXEmpPK dependienteXEmpPK)
{
    this.dependienteXEmpPK = dependienteXEmpPK;
}

public DependienteXEmp(short codCia, int codEmp, int codDependiente)
{
    this.dependienteXEmpPK = new DependienteXEmpPK(codCia, codEmp, codDependiente);
}

public DependienteXEmpPK getDependienteXEmpPK()
{
    return dependienteXEmpPK;
}

public void setDependienteXEmpPK(DependienteXEmpPK dependienteXEmpPK)
{
    this.dependienteXEmpPK = dependienteXEmpPK;
}

public Short getCodParentesco()
{
    return codParentesco;
}

public void setCodParentesco(Short codParentesco)
{
    this.codParentesco = codParentesco;
}

public Date getFechaNacimiento()
{
    return fechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento)
{
    this.fechaNacimiento = fechaNacimiento;
}

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public String getSexo()
{
    return sexo;
}

public void setSexo(String sexo)
{
    this.sexo = sexo;
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
    hash += (dependienteXEmpPK != null ? dependienteXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DependienteXEmp))
        {
        return false;
        }
    DependienteXEmp other = (DependienteXEmp) object;
    if ((this.dependienteXEmpPK == null && other.dependienteXEmpPK != null) || (this.dependienteXEmpPK != null && !this.dependienteXEmpPK.equals(other.dependienteXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.DependienteXEmp[ dependienteXEmpPK=" + dependienteXEmpPK + " ]";
}
}
