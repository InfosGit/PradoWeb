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
@Table(name = "EXP_LABORAL_EMPLEADO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ExpLaboralEmpleado.findAll", query = "SELECT e FROM ExpLaboralEmpleado e"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByCodCia", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.expLaboralEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByCodEmp", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.expLaboralEmpleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByCodExpLaboral", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.expLaboralEmpleadoPK.codExpLaboral = :codExpLaboral"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByLugarTrabajo", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.lugarTrabajo = :lugarTrabajo"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByFechaInicio", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByFechaFin", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "ExpLaboralEmpleado.findByMotivoRetiro", query = "SELECT e FROM ExpLaboralEmpleado e WHERE e.motivoRetiro = :motivoRetiro")
    })
public class ExpLaboralEmpleado implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected ExpLaboralEmpleadoPK expLaboralEmpleadoPK;
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
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public ExpLaboralEmpleado()
{
}

public ExpLaboralEmpleado(ExpLaboralEmpleadoPK expLaboralEmpleadoPK)
{
    this.expLaboralEmpleadoPK = expLaboralEmpleadoPK;
}

public ExpLaboralEmpleado(long codCia, long codEmp, long codExpLaboral)
{
    this.expLaboralEmpleadoPK = new ExpLaboralEmpleadoPK(codCia, codEmp, codExpLaboral);
}

public ExpLaboralEmpleadoPK getExpLaboralEmpleadoPK()
{
    return expLaboralEmpleadoPK;
}

public void setExpLaboralEmpleadoPK(ExpLaboralEmpleadoPK expLaboralEmpleadoPK)
{
    this.expLaboralEmpleadoPK = expLaboralEmpleadoPK;
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
    int hash = 7;
    hash = 47 * hash + (this.expLaboralEmpleadoPK != null ? this.expLaboralEmpleadoPK.hashCode() : 0);
    return hash;
}

//@Override
//public int hashCode()
//{
//    int hash = 0;
//    hash += (expLaboralEmpleadoPK != null ? expLaboralEmpleadoPK.hashCode() : 0);
//    return hash;
//}
@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExpLaboralEmpleado))
        {
        return false;
        }
    ExpLaboralEmpleado other = (ExpLaboralEmpleado) object;
    if ((this.expLaboralEmpleadoPK == null && other.expLaboralEmpleadoPK != null) || (this.expLaboralEmpleadoPK != null && !this.expLaboralEmpleadoPK.equals(other.expLaboralEmpleadoPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ExpLaboralEmpleado[ expLaboralEmpleadoPK=" + expLaboralEmpleadoPK + " ]";
}
}
