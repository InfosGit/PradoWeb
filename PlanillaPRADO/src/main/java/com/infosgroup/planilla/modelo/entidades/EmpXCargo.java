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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EMP_X_CARGO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EmpXCargo.findAll", query = "SELECT e FROM EmpXCargo e"),
    @NamedQuery(name = "EmpXCargo.findByCodCia", query = "SELECT e FROM EmpXCargo e WHERE e.empXCargoPK.codCia = :codCia"),
    @NamedQuery(name = "EmpXCargo.findByCodEmp", query = "SELECT e FROM EmpXCargo e WHERE e.empXCargoPK.codEmp = :codEmp"),
    @NamedQuery(name = "EmpXCargo.findByCodPuesto", query = "SELECT e FROM EmpXCargo e WHERE e.empXCargoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "EmpXCargo.findBySalarioAspirado", query = "SELECT e FROM EmpXCargo e WHERE e.salarioAspirado = :salarioAspirado"),
    @NamedQuery(name = "EmpXCargo.findByCodTipoPuesto", query = "SELECT e FROM EmpXCargo e WHERE e.codTipoPuesto = :codTipoPuesto")
    })
public class EmpXCargo implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected EmpXCargoPK empXCargoPK;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Basic(optional = false)
@NotNull
@Column(name = "SALARIO_ASPIRADO", nullable = false)//, precision = 16, scale = 2)
private Double salarioAspirado;
@Column(name = "COD_TIPO_PUESTO")
private Short codTipoPuesto;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)
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

public EmpXCargo()
{
}

public EmpXCargo(EmpXCargoPK empXCargoPK)
{
    this.empXCargoPK = empXCargoPK;
}

public EmpXCargo(EmpXCargoPK empXCargoPK, Double salarioAspirado)
{
    this.empXCargoPK = empXCargoPK;
    this.salarioAspirado = salarioAspirado;
}

public EmpXCargo(short codCia, int codEmp, short codPuesto)
{
    this.empXCargoPK = new EmpXCargoPK(codCia, codEmp, codPuesto);
}

public EmpXCargoPK getEmpXCargoPK()
{
    return empXCargoPK;
}

public void setEmpXCargoPK(EmpXCargoPK empXCargoPK)
{
    this.empXCargoPK = empXCargoPK;
}

public Double getSalarioAspirado()
{
    return salarioAspirado;
}

public void setSalarioAspirado(Double salarioAspirado)
{
    this.salarioAspirado = salarioAspirado;
}

public Short getCodTipoPuesto()
{
    return codTipoPuesto;
}

public void setCodTipoPuesto(Short codTipoPuesto)
{
    this.codTipoPuesto = codTipoPuesto;
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
    int hash = 0;
    hash += (empXCargoPK != null ? empXCargoPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EmpXCargo))
        {
        return false;
        }
    EmpXCargo other = (EmpXCargo) object;
    if ((this.empXCargoPK == null && other.empXCargoPK != null) || (this.empXCargoPK != null && !this.empXCargoPK.equals(other.empXCargoPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.EmpXCargo[ empXCargoPK=" + empXCargoPK + " ]";
}
}
