/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "desctoHorasNoLaboradasEdit")
@ViewScoped
public class DesctoHorasNoLaboradas extends AbstractEditAccionPersonal implements java.io.Serializable
{

    private static final long serialVersionUID = 1L;
    //
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    //
    private Date fechaInicial;
    private Date fechaFinal;
    private Double dias = 0.0;
    private Short horas = 0;
    private Integer diurnasSencillas;
    private Integer diurnasExtras;
    private Integer nocturnasSencillas;
    private Integer nocturnasExtras;

    @PostConstruct
    public void _init()
    {
        if (getSessionBeanPLA().getAccionSeleccionada() == null)
            return;
        setPlanilla(getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString());
        setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
        setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
        setFechaFinal(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
        setDias(getSessionBeanPLA().getAccionSeleccionada().getDias());
        setHoras(getSessionBeanPLA().getAccionSeleccionada().getHoras());
        setDiurnasSencillas(getSessionBeanPLA().getAccionSeleccionada().getHrsNormalDiurna());
        setDiurnasExtras(getSessionBeanPLA().getAccionSeleccionada().getHrsExtraDiurna());
        setNocturnasSencillas(getSessionBeanPLA().getAccionSeleccionada().getHrsNormalNocturna());
        setNocturnasExtras(getSessionBeanPLA().getAccionSeleccionada().getHrsExtraNocturna());
        setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
    }

    public Double getDias()
    {
        return dias;
    }

    public void setDias(Double dias)
    {
        this.dias = dias;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    public Short getHoras()
    {
        return horas;
    }

    public void setHoras(Short horas)
    {
        this.horas = horas;
    }

    public Integer getDiurnasSencillas()
    {
        return diurnasSencillas;
    }

    public void setDiurnasSencillas(Integer diurnasSencillas)
    {
        this.diurnasSencillas = diurnasSencillas;
    }

    public Integer getDiurnasExtras()
    {
        return diurnasExtras;
    }

    public void setDiurnasExtras(Integer diurnasExtras)
    {
        this.diurnasExtras = diurnasExtras;
    }

    public Integer getNocturnasSencillas()
    {
        return nocturnasSencillas;
    }

    public void setNocturnasSencillas(Integer nocturnasSencillas)
    {
        this.nocturnasSencillas = nocturnasSencillas;
    }

    public Integer getNocturnasExtras()
    {
        return nocturnasExtras;
    }

    public void setNocturnasExtras(Integer nocturnasExtras)
    {
        this.nocturnasExtras = nocturnasExtras;
    }

    @Override
    public void limpiarCampos()
    {
        /*fechaInicial = null;
         fechaFinal = null;
         dias = new Double("0.0");
         horas = 0;
         diurnasSencillas = 0;
         diurnasExtras = 0;
         nocturnasSencillas = 0;
         nocturnasExtras = 0;
         setObservacion("");*/
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    @Override
    public boolean validarSolicitud()
    {
        Boolean error = Boolean.TRUE;

        if (fechaInicial == null)
            {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
            }

        if (fechaFinal == null)
            {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
            }

        if (fechaInicial != null && fechaFinal != null)
            {
            if (!validaFechas(fechaInicial, fechaFinal))
                {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
                }
            }

        if (dias != null && dias > calculaDias(getFechaInicial(), getFechaFinal()).doubleValue())
            {
            addMessage("Acciones de Personal", "Cantidad de Días fuera del rango seleccionado.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
            }

        if (horas != null)
            {
            if (horas < 0)
                {
                addMessage("Acciones de Personal", "La cantidad de horas no es valida.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
                }
            }

        if (getSessionBeanEMP().getEmpleadoSesion().getPuestos() == null)
            {
            addMessage("Acciones de Personal", "Usted no tiene ningún puesto asignado.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
            }
        return error;
    }

    public void handleFechaInicial(DateSelectEvent event)
    {
        setFechaInicial(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).doubleValue());
    }

    public void handleFechaFinal(DateSelectEvent event)
    {
        setFechaFinal(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).doubleValue());
    }

//    public boolean validaAccionPersonal(java.util.Date f1, java.util.Date f2)
//    {
//        Boolean error = Boolean.TRUE;
//        if (f1 == null)
//            {
//            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
//            error = Boolean.FALSE;
//            }
//
//        if (f2 == null)
//            {
//            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
//            error = Boolean.FALSE;
//            }
//
//        if (f1 != null && f2 != null)
//            {
//            if (!validaFechas(f1, f2))
//                {
//                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
//                error = Boolean.FALSE;
//                }
//            }
//        return error;
//    }
    @Override
    protected PlanillaSessionBean getPlanillaSessionBean()
    {
        return planillaSessionBean;
    }

    @Override
    public Cias getEmpresa()
    {
        return getSessionBeanEMP().getCompania();
    }

    @Override
    public String guardarCambios()
    {
        if (!validarSolicitud())
            {
            addMessage("Descuento por horas no laboradas", "No se puede actualizar la solicitud", TipoMensaje.INFORMACION);
            return null;
            }

        try
            {
            AccionPersonal accionPersonal = getSessionBeanPLA().getAccionSeleccionada();
            accionPersonal.setObservacion(getObservacion());
            accionPersonal.setFechaFinal(getFechaFinal());
            accionPersonal.setFechaInicial(getFechaInicial());
            accionPersonal.setDias(getDias());
            accionPersonal.setHrsNormalDiurna(getDiurnasSencillas());
            accionPersonal.setHrsExtraDiurna(getDiurnasExtras());
            accionPersonal.setHrsNormalNocturna(getNocturnasSencillas());
            accionPersonal.setHrsExtraNocturna(getNocturnasExtras());

            if (getPlanilla() != null)
                {
                accionPersonal.setAnio(new Short(getPlanilla().split(":")[1].toString()));
                accionPersonal.setMes(new Short(getPlanilla().split(":")[2].toString()));
                accionPersonal.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
                }
            accionPersonal.setCodTipopla(getTipoPlanilla());

            actualizarSolicitud(accionPersonal);
            addMessage("Acciones de Personal", "Datos guardados con éxito", TipoMensaje.INFORMACION);
            }
        catch (Exception excpt)
            {
            addMessage("Acciones de Personal", "Error al actualizar la acción de personal", TipoMensaje.ERROR);
            excpt.printStackTrace(System.err);
            }
        return null;
    }
}