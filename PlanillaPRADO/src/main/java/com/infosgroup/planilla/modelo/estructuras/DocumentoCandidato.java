/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author root
 */
public class DocumentoCandidato implements Serializable
{

private static final long serialVersionUID = 1L;
private TipoDocumento tipo;
private String numero;
private String ubicacion;
private Date fechaCargo;

public TipoDocumento getTipo()
{
    return tipo;
}

public void setTipo(TipoDocumento tipo)
{
    this.tipo = tipo;
}

public String getNumero()
{
    return numero;
}

public void setNumero(String numero)
{
    this.numero = numero;
}

public String getUbicacion()
{
    return ubicacion;
}

public void setUbicacion(String ubicacion)
{
    this.ubicacion = ubicacion;
}

public Date getFechaCargo()
{
    return fechaCargo;
}

public void setFechaCargo(Date fechaCargo)
{
    this.fechaCargo = fechaCargo;
}
}
