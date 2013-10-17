/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ENTREVISTA_X_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EntrevistaXEmp.findAll", query = "SELECT e FROM EntrevistaXEmp e"),
    @NamedQuery(name = "EntrevistaXEmp.findByCodCia", query = "SELECT e FROM EntrevistaXEmp e WHERE e.entrevistaXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "EntrevistaXEmp.findByCodEmp", query = "SELECT e FROM EntrevistaXEmp e WHERE e.entrevistaXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "EntrevistaXEmp.findByCodPuesto", query = "SELECT e FROM EntrevistaXEmp e WHERE e.entrevistaXEmpPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "EntrevistaXEmp.findByCodEntrevista", query = "SELECT e FROM EntrevistaXEmp e WHERE e.entrevistaXEmpPK.codEntrevista = :codEntrevista"),
    @NamedQuery(name = "EntrevistaXEmp.findByDescripcion", query = "SELECT e FROM EntrevistaXEmp e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EntrevistaXEmp.findByFecha", query = "SELECT e FROM EntrevistaXEmp e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EntrevistaXEmp.findByResultado", query = "SELECT e FROM EntrevistaXEmp e WHERE e.resultado = :resultado")
    })
public class EntrevistaXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected EntrevistaXEmpPK entrevistaXEmpPK;
@Size(max = 200)
@Column(name = "DESCRIPCION", length = 200)
private String descripcion;
@Column(name = "FECHA")
@Temporal(TemporalType.TIMESTAMP)
private Date fecha;
@Size(max = 200)
@Column(name = "RESULTADO", length = 200)
private String resultado;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleado;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Puestos puesto;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_ENTREVISTADOR", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados entrevistador;
@Column(name = "NOM_ENTREVISTADOR", length = 200)
private String nomEntrevistador;

public EntrevistaXEmp()
{
}

public EntrevistaXEmp(EntrevistaXEmpPK entrevistaXEmpPK)
{
    this.entrevistaXEmpPK = entrevistaXEmpPK;
}

public EntrevistaXEmp(short codCia, int codEmp, short codPuesto, short codEntrevista)
{
    this.entrevistaXEmpPK = new EntrevistaXEmpPK(codCia, codEmp, codPuesto, codEntrevista);
}

public EntrevistaXEmpPK getEntrevistaXEmpPK()
{
    return entrevistaXEmpPK;
}

public void setEntrevistaXEmpPK(EntrevistaXEmpPK entrevistaXEmpPK)
{
    this.entrevistaXEmpPK = entrevistaXEmpPK;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public Date getFecha()
{
    return fecha;
}

public void setFecha(Date fecha)
{
    this.fecha = fecha;
}

public String getResultado()
{
    return resultado;
}

public void setResultado(String resultado)
{
    this.resultado = resultado;
}

public Empleados getEmpleado()
{
    return empleado;
}

public void setEmpleado(Empleados empleado)
{
    this.empleado = empleado;
}

public Puestos getPuesto()
{
    return puesto;
}

public void setPuesto(Puestos puesto)
{
    this.puesto = puesto;
}

public Empleados getEntrevistador()
{
    return entrevistador;
}

public void setEntrevistador(Empleados entrevistador)
{
    this.entrevistador = entrevistador;
}

public String getNomEntrevistador()
{
    return nomEntrevistador;
}

public void setNomEntrevistador(String nomEntrevistador)
{
    this.nomEntrevistador = nomEntrevistador;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (entrevistaXEmpPK != null ? entrevistaXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EntrevistaXEmpPK))
        {
        return false;
        }
    EntrevistaXEmp other = (EntrevistaXEmp) object;
    if ((this.entrevistaXEmpPK == null && other.entrevistaXEmpPK != null) || (this.entrevistaXEmpPK != null && !this.entrevistaXEmpPK.equals(other.entrevistaXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EntrevistaXEmp[ entrevistaXEmpPK=" + entrevistaXEmpPK + " ]";
}
}
