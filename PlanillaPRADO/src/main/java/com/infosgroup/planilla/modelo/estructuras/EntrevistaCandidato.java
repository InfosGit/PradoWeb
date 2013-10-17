/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author root
 */
public class EntrevistaCandidato implements Serializable
{

private static final long serialVersionUID = 1L;
private Puestos puesto;
private Double salarioAspirado;
private Date fecha;
private Empleados entrevistador;
private String descripcion;
private String resultado;
private Integer tipoEntrevistador;
private String nombreEntrevistador;

public Puestos getPuesto()
{
    return puesto;
}

public void setPuesto(Puestos puesto)
{
    this.puesto = puesto;
}

public Double getSalarioAspirado()
{
    return salarioAspirado;
}

public void setSalarioAspirado(Double salarioAspirado)
{
    this.salarioAspirado = salarioAspirado;
}

public Date getFecha()
{
    return fecha;
}

public void setFecha(Date fecha)
{
    this.fecha = fecha;
}

public Empleados getEntrevistador()
{
    return entrevistador;
}

public void setEntrevistador(Empleados entrevistador)
{
    this.entrevistador = entrevistador;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public String getResultado()
{
    return resultado;
}

public void setResultado(String resultado)
{
    this.resultado = resultado;
}

public Integer getTipoEntrevistador()
{
    return tipoEntrevistador;
}

public void setTipoEntrevistador(Integer tipoEntrevistador)
{
    this.tipoEntrevistador = tipoEntrevistador;
}

public String getNombreEntrevistador()
{
    return nombreEntrevistador;
}

public void setNombreEntrevistador(String nombreEntrevistador)
{
    this.nombreEntrevistador = nombreEntrevistador;
}
}
