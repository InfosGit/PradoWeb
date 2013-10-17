/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBeanADM")
@SessionScoped
public class SessionBeanADM implements Serializable
{
    private static final long serialVersionUID = 1L;
    // ==
    private Integer estadoAccion;
    // ==

////    /*
////     * Creates a new instance of SessionBeanADM
////     */
////    public SessionBeanADM()
////    {
////    }



    public Integer getEstadoAccion()
    {
        return estadoAccion;
    }

    /**
     * @param estadoAccion 0 - crear 1 - editar 2 - consultar
     */
    public void setEstadoAccion(Integer estadoAccion)
    {
        this.estadoAccion = estadoAccion;
    }
}