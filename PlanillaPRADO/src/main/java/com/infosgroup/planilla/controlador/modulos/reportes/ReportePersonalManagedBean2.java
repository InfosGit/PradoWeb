/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reportes;

import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "reportes$reportePersonal2")
@ViewScoped
public class ReportePersonalManagedBean2 extends AbstractJSFPage implements Serializable {

    //
    @EJB
    private transient ReportesStatelessBean reportesBean;
    //
    private Integer anio;
    //

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //==================================================================
    @PostConstruct
    public void _init() {
        anio = Calendar.getInstance().get(Calendar.YEAR);
    }

    //==================================================================
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    //==================================================================
    public String generarReporte$action() {
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("CIA", sessionBeanEMP.getCompania().getCodCia().intValue());
        parametros.put("ANIO", anio);
        reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA161", FormatoReporte.PDF);
        return null;
    }
}