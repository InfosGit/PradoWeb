/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BENEFICIARIO_X_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "BeneficiarioXCandidato.findAll", query = "SELECT b FROM BeneficiarioXCandidato b"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodCia", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodCandidato", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodBeneficiario", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codBeneficiario = :codBeneficiario"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByNombre", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.nombre = :nombre")
    })
public class BeneficiarioXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected BeneficiarioXEmpPK beneficiarioXEmpPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "NOMBRE", nullable = false, length = 100)
private String nombre;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_PARENTESCO", referencedColumnName = "COD_PARENTESCO")
    })
@ManyToOne(optional = false)
private Parentesco parentesco;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public BeneficiarioXEmp()
{
}

public BeneficiarioXEmp(BeneficiarioXEmpPK beneficiarioXEmpPK)
{
    this.beneficiarioXEmpPK = beneficiarioXEmpPK;
}

public BeneficiarioXEmp(BeneficiarioXEmpPK beneficiarioXEmpPK, String nombre)
{
    this.beneficiarioXEmpPK = beneficiarioXEmpPK;
    this.nombre = nombre;
}

public BeneficiarioXEmp(short codCia, int codEmp, int codBeneficiario)
{
    this.beneficiarioXEmpPK = new BeneficiarioXEmpPK(codCia, codEmp, codBeneficiario);
}

public BeneficiarioXEmpPK getBeneficiarioXEmpPK()
{
    return beneficiarioXEmpPK;
}

public void setBeneficiarioXEmpPK(BeneficiarioXEmpPK beneficiarioXEmpPK)
{
    this.beneficiarioXEmpPK = beneficiarioXEmpPK;
}

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public Parentesco getParentesco()
{
    return parentesco;
}

public void setParentesco(Parentesco parentesco)
{
    this.parentesco = parentesco;
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
    hash += (beneficiarioXEmpPK != null ? beneficiarioXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BeneficiarioXEmp))
        {
        return false;
        }
    BeneficiarioXEmp other = (BeneficiarioXEmp) object;
    if ((this.beneficiarioXEmpPK == null && other.beneficiarioXEmpPK != null) || (this.beneficiarioXEmpPK != null && !this.beneficiarioXEmpPK.equals(other.beneficiarioXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.BeneficiarioXEmp[ beneficiarioXEmp=" + beneficiarioXEmpPK + " ]";
}
}
