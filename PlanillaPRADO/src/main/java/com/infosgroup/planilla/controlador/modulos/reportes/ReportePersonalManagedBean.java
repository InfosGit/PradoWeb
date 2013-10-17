/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reportes;

import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.facades.DepartamentoFacade;
import com.infosgroup.planilla.modelo.facades.GerenciaFacade;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reportes$reportePersonal")
@ViewScoped
public class ReportePersonalManagedBean extends AbstractJSFPage implements Serializable {

    @EJB
    private transient GerenciaFacade gerenciasFacade;
    @EJB
    private transient DepartamentoFacade departamentosFacade;
    //
    @EJB
    private transient ReportesStatelessBean reportesBean;
    //
    private List<Gerencia> listaGerencias;
    private List<Departamentos> listaDepartamentos;
    //
    private Integer gerencia;
    private Integer departamento;
    private Integer anio;
    //

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //==================================================================
    @PostConstruct
    public void _init() {
        listaGerencias = gerenciasFacade.findGerenciasByCias(sessionBeanEMP.getCompania());
        listaDepartamentos = Collections.emptyList();
        anio = Calendar.getInstance().get(Calendar.YEAR);
    }

    //==================================================================
    public void gerencias$valueChangeListener(ValueChangeEvent evt) {
        Short gerencia = Short.valueOf(evt.getNewValue().toString());
        listaDepartamentos = departamentosFacade.findDepartamentosByGerencia(sessionBeanEMP.getCompania(), gerencia);
    }

    //==================================================================
    public List<Gerencia> getListaGerencias() {
        return listaGerencias;
    }

    public void setListaGerencias(List<Gerencia> listaGerencias) {
        this.listaGerencias = listaGerencias;
    }

    public List<Departamentos> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    //==================================================================
    public Integer getGerencia() {
        return gerencia;
    }

    public void setGerencia(Integer gerencia) {
        this.gerencia = gerencia;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

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
        parametros.put("GIA", gerencia);
        parametros.put("DEPTO", departamento);
        parametros.put("ANIO", anio);
        reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA160", FormatoReporte.PDF);
        return null;
    }
}
