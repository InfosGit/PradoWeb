/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TIPO_PRUEBA_X_EMP")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "TipoPruebaXEmp.findAll", query = "SELECT t FROM TipoPruebaXEmp t"),
    @NamedQuery(name = "TipoPruebaXEmp.findByCodCia", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.tipoPruebaXEmpPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPruebaXEmp.findByCodEmp", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.tipoPruebaXEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "TipoPruebaXEmp.findByCodTipoPrueba", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.tipoPruebaXEmpPK.codTipoPrueba = :codTipoPrueba"),
    @NamedQuery(name = "TipoPruebaXEmp.findByResultado", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.resultado = :resultado"),
    @NamedQuery(name = "TipoPruebaXEmp.findByNota", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.nota = :nota"),
    @NamedQuery(name = "TipoPruebaXEmp.findByFecha", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TipoPruebaXEmp.findByCosto", query = "SELECT t FROM TipoPruebaXEmp t WHERE t.costo = :costo")
    })
public class TipoPruebaXEmp implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected TipoPruebaXEmpPK tipoPruebaXEmpPK;
@Size(max = 200)
@Column(name = "RESULTADO", length = 200)
private String resultado;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Column(name = "NOTA", precision = 5, scale = 2)
private BigDecimal nota;
@Column(name = "FECHA")
@Temporal(TemporalType.TIMESTAMP)
private Date fecha;
@Column(name = "COSTO", precision = 12, scale = 2)
private BigDecimal costo;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_TIPO_PRUEBA", referencedColumnName = "COD_TIPO_PRUEBA", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private TipoPrueba tipoPrueba;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Empleados empleados;

public TipoPruebaXEmp()
{
}

public TipoPruebaXEmp(TipoPruebaXEmpPK tipoPruebaXEmpPK)
{
    this.tipoPruebaXEmpPK = tipoPruebaXEmpPK;
}

public TipoPruebaXEmp(short codCia, int codEmp, short codTipoPrueba)
{
    this.tipoPruebaXEmpPK = new TipoPruebaXEmpPK(codCia, codEmp, codTipoPrueba);
}

public TipoPruebaXEmpPK getTipoPruebaXEmpPK()
{
    return tipoPruebaXEmpPK;
}

public void setTipoPruebaXEmpPK(TipoPruebaXEmpPK tipoPruebaXEmpPK)
{
    this.tipoPruebaXEmpPK = tipoPruebaXEmpPK;
}

public String getResultado()
{
    return resultado;
}

public void setResultado(String resultado)
{
    this.resultado = resultado;
}

public BigDecimal getNota()
{
    return nota;
}

public void setNota(BigDecimal nota)
{
    this.nota = nota;
}

public Date getFecha()
{
    return fecha;
}

public void setFecha(Date fecha)
{
    this.fecha = fecha;
}

public BigDecimal getCosto()
{
    return costo;
}

public void setCosto(BigDecimal costo)
{
    this.costo = costo;
}

public TipoPrueba getTipoPrueba()
{
    return tipoPrueba;
}

public void setTipoPrueba(TipoPrueba tipoPrueba)
{
    this.tipoPrueba = tipoPrueba;
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
    hash += (tipoPruebaXEmpPK != null ? tipoPruebaXEmpPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoPruebaXEmp))
        {
        return false;
        }
    TipoPruebaXEmp other = (TipoPruebaXEmp) object;
    if ((this.tipoPruebaXEmpPK == null && other.tipoPruebaXEmpPK != null) || (this.tipoPruebaXEmpPK != null && !this.tipoPruebaXEmpPK.equals(other.tipoPruebaXEmpPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TipoPruebaXEmp[ tipoPruebaXEmpPK=" + tipoPruebaXEmpPK + " ]";
}
}
