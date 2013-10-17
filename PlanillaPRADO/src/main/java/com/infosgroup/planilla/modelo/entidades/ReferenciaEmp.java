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
@Table(name = "REFERENCIA_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ReferenciaEmp.findAll", query = "SELECT r FROM ReferenciaEmp r"),
    @NamedQuery(name = "ReferenciaEmp.findByCodCia", query = "SELECT r FROM ReferenciaEmp r WHERE r.referenciaEmpPK.codCia = :codCia"),
    @NamedQuery(name = "ReferenciaEmp.findByCodEmp", query = "SELECT r FROM ReferenciaEmp r WHERE r.referenciaEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "ReferenciaEmp.findByCodReferencia", query = "SELECT r FROM ReferenciaEmp r WHERE r.referenciaEmpPK.codReferencia = :codReferencia"),
    @NamedQuery(name = "ReferenciaEmp.findByNomReferencia", query = "SELECT r FROM ReferenciaEmp r WHERE r.nomReferencia = :nomReferencia"),
    @NamedQuery(name = "ReferenciaEmp.findByTiempo", query = "SELECT r FROM ReferenciaEmp r WHERE r.tiempo = :tiempo"),
    @NamedQuery(name = "ReferenciaEmp.findByTelefono", query = "SELECT r FROM ReferenciaEmp r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "ReferenciaEmp.findBySueldo", query = "SELECT r FROM ReferenciaEmp r WHERE r.sueldo = :sueldo"),
    @NamedQuery(name = "ReferenciaEmp.findByMotivoRetiro", query = "SELECT r FROM ReferenciaEmp r WHERE r.motivoRetiro = :motivoRetiro"),
    @NamedQuery(name = "ReferenciaEmp.findByTipoReferencia", query = "SELECT r FROM ReferenciaEmp r WHERE r.tipoReferencia = :tipoReferencia"),
    @NamedQuery(name = "ReferenciaEmp.findByLugar", query = "SELECT r FROM ReferenciaEmp r WHERE r.lugar = :lugar")
    })
public class ReferenciaEmp implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected ReferenciaEmpPK referenciaEmpPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "NOM_REFERENCIA", nullable = false, length = 100)
private String nomReferencia;
@Size(max = 50)
@Column(name = "TIEMPO", length = 50)
private String tiempo;
@Size(max = 10)
@Column(name = "TELEFONO", length = 10)
private String telefono;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Column(name = "SUELDO", precision = 6, scale = 2)
private BigDecimal sueldo;
@Size(max = 100)
@Column(name = "MOTIVO_RETIRO", length = 100)
private String motivoRetiro;
@Basic(optional = false)
@NotNull
@Column(name = "TIPO_REFERENCIA", nullable = false)
private char tipoReferencia;
@Size(max = 100)
@Column(name = "LUGAR", length = 100)
private String lugar;
@Size(max = 50)
@Column(name = "EMAIL", length = 50)
private String email;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public ReferenciaEmp()
{
}

public ReferenciaEmp(ReferenciaEmpPK referenciaEmpPK)
{
    this.referenciaEmpPK = referenciaEmpPK;
}

public ReferenciaEmp(ReferenciaEmpPK referenciaEmpPK, String nomReferencia, char tipoReferencia)
{
    this.referenciaEmpPK = referenciaEmpPK;
    this.nomReferencia = nomReferencia;
    this.tipoReferencia = tipoReferencia;
}

public ReferenciaEmp(short codCia, int codEmp, int codReferencia)
{
    this.referenciaEmpPK = new ReferenciaEmpPK(codCia, codEmp, codReferencia);
}

public ReferenciaEmpPK getReferenciaEmpPK()
{
    return referenciaEmpPK;
}

public void setReferenciaEmpPK(ReferenciaEmpPK referenciaEmpPK)
{
    this.referenciaEmpPK = referenciaEmpPK;
}

public String getNomReferencia()
{
    return nomReferencia;
}

public void setNomReferencia(String nomReferencia)
{
    this.nomReferencia = nomReferencia;
}

public String getTiempo()
{
    return tiempo;
}

public void setTiempo(String tiempo)
{
    this.tiempo = tiempo;
}

public String getTelefono()
{
    return telefono;
}

public void setTelefono(String telefono)
{
    this.telefono = telefono;
}

public BigDecimal getSueldo()
{
    return sueldo;
}

public void setSueldo(BigDecimal sueldo)
{
    this.sueldo = sueldo;
}

public String getMotivoRetiro()
{
    return motivoRetiro;
}

public void setMotivoRetiro(String motivoRetiro)
{
    this.motivoRetiro = motivoRetiro;
}

public char getTipoReferencia()
{
    return tipoReferencia;
}

public void setTipoReferencia(char tipoReferencia)
{
    this.tipoReferencia = tipoReferencia;
}

public String getLugar()
{
    return lugar;
}

public void setLugar(String lugar)
{
    this.lugar = lugar;
}

public String getEmail()
{
    return email;
}

public void setEmail(String email)
{
    this.email = email;
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
    hash += (referenciaEmpPK != null ? referenciaEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReferenciaEmp))
        {
        return false;
        }
    ReferenciaEmp other = (ReferenciaEmp) object;
    if ((this.referenciaEmpPK == null && other.referenciaEmpPK != null) || (this.referenciaEmpPK != null && !this.referenciaEmpPK.equals(other.referenciaEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.ReferenciaEmp[ referenciaEmpPK=" + referenciaEmpPK + " ]";
}
}
