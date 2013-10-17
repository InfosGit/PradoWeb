/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CAPACITACION_X_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "CapacitacionXEmp.findAll", query = "SELECT c FROM CapacitacionXEmp c"),
    @NamedQuery(name = "CapacitacionXEmp.findByCodCia", query = "SELECT c FROM CapacitacionXEmp c WHERE c.capacitacionXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionXEmp.findByCodCandidato", query = "SELECT c FROM CapacitacionXEmp c WHERE c.capacitacionXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "CapacitacionXEmp.findByCodCapacitacion", query = "SELECT c FROM CapacitacionXEmp c WHERE c.capacitacionXEmpPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "CapacitacionXEmp.findByDescripcion", query = "SELECT c FROM CapacitacionXEmp c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CapacitacionXEmp.findByFecha", query = "SELECT c FROM CapacitacionXEmp c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CapacitacionXEmp.findByCodInsti", query = "SELECT c FROM CapacitacionXEmp c WHERE c.codInsti = :codInsti"),
    @NamedQuery(name = "CapacitacionXEmp.findByTipo", query = "SELECT c FROM CapacitacionXEmp c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CapacitacionXEmp.findByNacional", query = "SELECT c FROM CapacitacionXEmp c WHERE c.nacional = :nacional"),
    @NamedQuery(name = "CapacitacionXEmp.findByHorasRecibidas", query = "SELECT c FROM CapacitacionXEmp c WHERE c.horasRecibidas = :horasRecibidas"),
    @NamedQuery(name = "CapacitacionXEmp.findByNomInstitucion", query = "SELECT c FROM CapacitacionXEmp c WHERE c.nomInstitucion = :nomInstitucion")
    })
public class CapacitacionXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected CapacitacionXEmpPK capacitacionXEmpPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "DESCRIPCION", nullable = false, length = 100)
private String descripcion;
@Size(max = 30)
@Column(name = "FECHA", length = 30)
private String fecha;
@Column(name = "COD_INSTI")
private Short codInsti;
@Size(max = 2)
@Column(name = "TIPO", length = 2)
private String tipo;
@Size(max = 1)
@Column(name = "NACIONAL", length = 1)
private String nacional;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Column(name = "HORAS_RECIBIDAS", precision = 5, scale = 2)
private BigDecimal horasRecibidas;
@Size(max = 100)
@Column(name = "NOM_INSTITUCION", length = 100)
private String nomInstitucion;
//@JoinColumns(
//    {
//    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
//    @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false, insertable = false, updatable = false)
//    })
//@ManyToOne(optional = false)
//private Capacitacion capacitacion;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public CapacitacionXEmp()
{
}

public CapacitacionXEmp(CapacitacionXEmpPK capacitacionXEmpPK)
{
    this.capacitacionXEmpPK = capacitacionXEmpPK;
}

public CapacitacionXEmp(CapacitacionXEmpPK capacitacionXEmpPK, String descripcion)
{
    this.capacitacionXEmpPK = capacitacionXEmpPK;
    this.descripcion = descripcion;
}

public CapacitacionXEmp(short codCia, int codEmp, int codCapacitacion)
{
    this.capacitacionXEmpPK = new CapacitacionXEmpPK(codCia, codEmp, codCapacitacion);
}

public CapacitacionXEmpPK getCapacitacionXEmpPK()
{
    return capacitacionXEmpPK;
}

public void setCapacitacionXEmpPK(CapacitacionXEmpPK capacitacionXEmpPK)
{
    this.capacitacionXEmpPK = capacitacionXEmpPK;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public String getFecha()
{
    return fecha;
}

public void setFecha(String fecha)
{
    this.fecha = fecha;
}

public Short getCodInsti()
{
    return codInsti;
}

public void setCodInsti(Short codInsti)
{
    this.codInsti = codInsti;
}

public String getTipo()
{
    return tipo;
}

public void setTipo(String tipo)
{
    this.tipo = tipo;
}

public String getNacional()
{
    return nacional;
}

public void setNacional(String nacional)
{
    this.nacional = nacional;
}

public BigDecimal getHorasRecibidas()
{
    return horasRecibidas;
}

public void setHorasRecibidas(BigDecimal horasRecibidas)
{
    this.horasRecibidas = horasRecibidas;
}

public String getNomInstitucion()
{
    return nomInstitucion;
}

public void setNomInstitucion(String nomInstitucion)
{
    this.nomInstitucion = nomInstitucion;
}

//public Capacitacion getCapacitacion()
//{
//    return capacitacion;
//}
//
//public void setCapacitacion(Capacitacion capacitacion)
//{
//    this.capacitacion = capacitacion;
//}
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
    hash += (capacitacionXEmpPK != null ? capacitacionXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CapacitacionXEmp))
        {
        return false;
        }
    CapacitacionXEmp other = (CapacitacionXEmp) object;
    if ((this.capacitacionXEmpPK == null && other.capacitacionXEmpPK != null) || (this.capacitacionXEmpPK != null && !this.capacitacionXEmpPK.equals(other.capacitacionXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.CapacitacionXEmp[ capacitacionXEmpPK=" + capacitacionXEmpPK + " ]";
}
}
