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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "CriteriosXEmp.findAll", query = "SELECT c FROM CriteriosXEmp c"),
    @NamedQuery(name = "CriteriosXEmp.findByCodCia", query = "SELECT c FROM CriteriosXEmp c WHERE c.criteriosXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXEmp.findByCodEmp", query = "SELECT c FROM CriteriosXEmp c WHERE c.criteriosXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "CriteriosXEmp.findByCriterio", query = "SELECT c FROM CriteriosXEmp c WHERE c.criteriosXEmpPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXEmp.findByTipoCriterio", query = "SELECT c FROM CriteriosXEmp c WHERE c.criteriosXEmpPK.tipoCriterio = :tipoCriterio"),
    @NamedQuery(name = "CriteriosXEmp.findByCorrelativo", query = "SELECT c FROM CriteriosXEmp c WHERE c.criteriosXEmpPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXEmp.findByValor", query = "SELECT c FROM CriteriosXEmp c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXEmp.findByCampo", query = "SELECT c FROM CriteriosXEmp c WHERE c.campo = :campo"),
    @NamedQuery(name = "CriteriosXEmp.findByEntidad", query = "SELECT c FROM CriteriosXEmp c WHERE c.entidad = :entidad"),
    @NamedQuery(name = "CriteriosXEmp.findByEntidadpk", query = "SELECT c FROM CriteriosXEmp c WHERE c.entidadpk = :entidadpk")
    })
public class CriteriosXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EmbeddedId
protected CriteriosXEmpPK criteriosXEmpPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 200)
@Column(name = "VALOR", nullable = false, length = 200)
private String valor;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 200)
@Column(name = "CAMPO", nullable = false, length = 200)
private String campo;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 200)
@Column(name = "ENTIDAD", nullable = false, length = 200)
private String entidad;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 200)
@Column(name = "ENTIDADPK", nullable = false, length = 200)
private String entidadpk;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public CriteriosXEmp()
{
}

public CriteriosXEmp(CriteriosXEmpPK criteriosXEmpPK)
{
    this.criteriosXEmpPK = criteriosXEmpPK;
}

public CriteriosXEmp(CriteriosXEmpPK criteriosXEmpPK, String valor, String campo, String entidad, String entidadpk)
{
    this.criteriosXEmpPK = criteriosXEmpPK;
    this.valor = valor;
    this.campo = campo;
    this.entidad = entidad;
    this.entidadpk = entidadpk;
}

public CriteriosXEmp(long codCia, int codEmp, long criterio, long tipoCriterio, long correlativo)
{
    this.criteriosXEmpPK = new CriteriosXEmpPK(codCia, codEmp, criterio, tipoCriterio, correlativo);
}

public CriteriosXEmpPK getCriteriosXEmpPK()
{
    return criteriosXEmpPK;
}

public void setCriteriosXEmpPK(CriteriosXEmpPK criteriosXEmpPK)
{
    this.criteriosXEmpPK = criteriosXEmpPK;
}

public String getValor()
{
    return valor;
}

public void setValor(String valor)
{
    this.valor = valor;
}

public String getCampo()
{
    return campo;
}

public void setCampo(String campo)
{
    this.campo = campo;
}

public String getEntidad()
{
    return entidad;
}

public void setEntidad(String entidad)
{
    this.entidad = entidad;
}

public String getEntidadpk()
{
    return entidadpk;
}

public void setEntidadpk(String entidadpk)
{
    this.entidadpk = entidadpk;
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
    hash += (criteriosXEmpPK != null ? criteriosXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CriteriosXEmp))
        {
        return false;
        }
    CriteriosXEmp other = (CriteriosXEmp) object;
    if ((this.criteriosXEmpPK == null && other.criteriosXEmpPK != null) || (this.criteriosXEmpPK != null && !this.criteriosXEmpPK.equals(other.criteriosXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.CriteriosXEmp[ criteriosXEmpPK=" + criteriosXEmpPK + " ]";
}
}
