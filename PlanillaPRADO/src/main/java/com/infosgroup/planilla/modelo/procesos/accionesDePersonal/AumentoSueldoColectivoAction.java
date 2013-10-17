/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;

/**
 *
 * @author root
 */
public class AumentoSueldoColectivoAction extends AccionSolicitud implements java.io.Serializable
{

private static final long serialVersionUID = 1L;

public AumentoSueldoColectivoAction(AccionPersonal accionPersonal)
{
    super(accionPersonal);
}

@Override
public void efectuar()
{
    throw new UnsupportedOperationException("Not supported yet.");
}
}
