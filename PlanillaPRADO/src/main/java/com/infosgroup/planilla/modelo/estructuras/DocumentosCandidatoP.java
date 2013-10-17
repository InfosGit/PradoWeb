/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.util.Date;

/**
 *
 * @author root
 */
public class DocumentosCandidatoP
{
    private static final long serialVersionUID = 1L;
    private Date fechaCargo;
    private String extension;
    private String descripcion;
    private String ruta;

    public Date getFechaCargo()
    {
        return fechaCargo;
    }

    public void setFechaCargo(Date fechaCargo)
    {
        this.fechaCargo = fechaCargo;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getRuta()
    {
        return ruta;
    }

    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }
            
    
}
