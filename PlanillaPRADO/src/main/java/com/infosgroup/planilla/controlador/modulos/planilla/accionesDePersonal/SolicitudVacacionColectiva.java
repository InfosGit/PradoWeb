/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudVacacionColectiva")
@ViewScoped
public class SolicitudVacacionColectiva extends SolicitudDePersonal implements java.io.Serializable
{

private static final long serialVersionUID = 1L;
private String criterioSeleccionado;
private java.util.List<Departamentos> listaDepartamentos;
private Short departamento;
private Short tipoPlanilla;
private Short tipoPlanillaAplicar;
private Date fechaInicio;
private Date fechaFin;
private String planilla;
private Integer valorAfectados = 0;
private List<Empleados> listaEmpleadosAfectar;
private Empleados[] empleadosSeleccionados;
private List<ProgramacionPla> listaPlanillas;

public Short getTipoPlanillaAplicar()
{
    return tipoPlanillaAplicar;
}

public void setTipoPlanillaAplicar(Short tipoPlanillaAplicar)
{
    this.tipoPlanillaAplicar = tipoPlanillaAplicar;
}

@Override
public List<ProgramacionPla> getListaPlanillas()
{
    if (tipoPlanillaAplicar != null && tipoPlanillaAplicar != -1)
        {
        listaPlanillas = getPlanillaSessionBean().getProgramacionPlaByTipo(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanillaAplicar);
        }
    return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
}

@Override
public void setListaPlanillas(List<ProgramacionPla> listaPlanillas)
{
    this.listaPlanillas = listaPlanillas;
}

@Override
public String getPlanilla()
{
    return planilla;
}

@Override
public void setPlanilla(String planilla)
{
    this.planilla = planilla;
}

public Empleados[] getEmpleadosSeleccionados()
{
    return empleadosSeleccionados;
}

public void setEmpleadosSeleccionados(Empleados[] empleadosSeleccionados)
{
    this.empleadosSeleccionados = empleadosSeleccionados;
}

public List<Empleados> getListaEmpleadosAfectar()
{
    return listaEmpleadosAfectar;
}

public void setListaEmpleadosAfetar(List<Empleados> listaEmpleadosAfectar)
{
    this.listaEmpleadosAfectar = listaEmpleadosAfectar;
}

public Short getDepartamento()
{
    return departamento;
}

public void setDepartamento(Short departamento)
{
    this.departamento = departamento;
}

@Override
public Short getTipoPlanilla()
{
    return tipoPlanilla;
}

@Override
public void setTipoPlanilla(Short tipoPlanilla)
{
    this.tipoPlanilla = tipoPlanilla;
}

public String getCriterioSeleccionado()
{
    return criterioSeleccionado;
}

public void setCriterioSeleccionado(String criterioSeleccionado)
{
    this.criterioSeleccionado = criterioSeleccionado;
}

public List<Departamentos> getListaDepartamentos()
{
    listaDepartamentos = getPlanillaSessionBean().findDepartamentos(getSessionBeanEMP().getCompania());
    return listaDepartamentos;
}

public void setListaDepartamentos(List<Departamentos> listaDepartamentos)
{
    this.listaDepartamentos = listaDepartamentos;
}

public void limpiarFormaAplicar(AjaxBehaviorEvent event)
{
    limpiarCampos();
}

public Integer getValorAfectados()
{
    return valorAfectados;
}

public void setValorAfectados(Integer valorAfectados)
{
    this.valorAfectados = valorAfectados;
}

public String guardarSolicitud$action()
{
    if (validarSolicitud())
        {
        return null;
        }
    List<Empleados> e = Arrays.asList(empleadosSeleccionados);
    if (criterioSeleccionado.equals("departamentos"))
        {
        //Si ha seleccionado empleados guarda la seleccion, de lo contrario se guarda la solicitud para todos.
        if (e == null || e.size() <= 0)
            {
            e = getPlanillaSessionBean().listaAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanEMP().getCompania().getCodCia(), departamento)));
            }

        }
    else if (criterioSeleccionado.equals("tipoPlanilla"))
        {
        if (e == null || e.size() <= 0)
            {
            e = getPlanillaSessionBean().listaAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanilla)));
            }
        }
    try
        {
        getPlanillaSessionBean().registrarAccionPersonalColectiva(getAccionesPersonal(e));
        addMessage("Solicitud de Vacaciones Colectivas", "Datos guardados exitosamente.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        }
    catch (Exception exception)
        {
        addMessage("Solicitud de Vacaciones Colectivas", exception.getMessage(), TipoMensaje.ERROR);
        }

    return null;
}

public List<AccionPersonal> getAccionesPersonal(List<Empleados> empleados) throws Exception
{
    List<AccionPersonal> l = new ArrayList<AccionPersonal>();
    if (empleados == null || empleados.size() <= 0)
        {
        throw new Exception("No ha seleccionado ningun empleado para generar la solicitud.");
        }
    for (Empleados e : empleados)
        {
        l.add(getAccionPersonal(e));
        }
    return (l != null) ? l : new ArrayList<AccionPersonal>();
}

public AccionPersonal getAccionPersonal(Empleados e)
{
    AccionPersonal accionPersonal = new AccionPersonal();
    TipoAccion tipoAccion = new TipoAccion(new TipoAccionPK(getSessionBeanEMP().getCompania().getCodCia(), new Short("2")));
    accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanEMP().getCompania(), e));
    accionPersonal.setTipoAccion(tipoAccion); /*
     * Solicitud de Vacacion
     */
    accionPersonal.setEmpleados(e);
    accionPersonal.setEmpleados1(e.getEmpleados());
    accionPersonal.setFecha(new java.util.Date());
    accionPersonal.setObservacion(getObservacion());
    accionPersonal.setDepartamentos(e.getDepartamentos());
    accionPersonal = getEstadoSolicitudByRol(accionPersonal);//accionPersonal.setStatus("G");
    accionPersonal.setUsuarioCreacion(getSessionBeanEMP().getEmpleadoSesion().getUsuario());
    accionPersonal.setPuestos(e.getPuestos());
    accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
    accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
    accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
    accionPersonal.setCodTipopla(tipoPlanillaAplicar);
    accionPersonal.setFechaInicial(fechaInicio);
    accionPersonal.setFechaFinal(fechaFin);
    accionPersonal.setDias(dias);
    return accionPersonal;
}

@Override
public boolean validarSolicitud()
{
    Boolean error = Boolean.FALSE;
    if (criterioSeleccionado == null || criterioSeleccionado.equals("-1"))
        {
        addMessage("Acciones de Personal", "Seleccione el Criterio.", TipoMensaje.ERROR);
        error = Boolean.TRUE;
        }
    if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1"))
        {
        if (criterioSeleccionado.equals("departamentos"))
            {
            if (departamento == null || departamento == -1)
                {
                addMessage("Acciones de Personal", "Departamento es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            }
        else if (criterioSeleccionado.equals("tipoPlanilla"))
            {
            if (tipoPlanilla == null || tipoPlanilla == -1)
                {
                addMessage("Acciones de Personal", "Tipo Planilla es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            }

        if (tipoPlanillaAplicar == null || tipoPlanillaAplicar == -1)
            {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }

        if ((tipoPlanillaAplicar != null && tipoPlanillaAplicar != -1) && (planilla == null || planilla.equals("-1")))
            {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }

        if (fechaInicio == null)
            {
            addMessage("Acciones de Personal", "Ingrese la fecha de inicio de vacaciones colectivas", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }

        if (fechaFin == null)
            {
            addMessage("Acciones de Personal", "Ingrese la fecha de finalización de vacaciones colectivas", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        }
    return error;
}

public void calcularAfectados(AjaxBehaviorEvent event)
{
    calcularEmpleados();
    empleadosSeleccionados = null;
}

public void calcularEmpleados()
{
    valorAfectados = 0;
    if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1"))
        {
        if (criterioSeleccionado.equals("departamentos"))
            {
            if (departamento != null && departamento != -1)
                {
                valorAfectados = getPlanillaSessionBean().totalAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanEMP().getCompania().getCodCia(), departamento)));
                }
            }
        else if (criterioSeleccionado.equals("tipoPlanilla"))
            {
            if (tipoPlanilla != null && tipoPlanilla != -1)
                {
                valorAfectados = getPlanillaSessionBean().totalAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanilla)));
                }
            }
        }
}

public String listarEmpleados()
{
    listaEmpleadosAfectar = new ArrayList<Empleados>();
    if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1"))
        {
        if (criterioSeleccionado.equals("departamentos"))
            {
            if (departamento != null && departamento != -1)
                {
                listaEmpleadosAfectar = getPlanillaSessionBean().listaAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanEMP().getCompania().getCodCia(), departamento)));
                }
            }
        else if (criterioSeleccionado.equals("tipoPlanilla"))
            {
            if (tipoPlanilla != null && tipoPlanilla != -1)
                {
                listaEmpleadosAfectar = getPlanillaSessionBean().listaAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanilla)));
                }
            }
        }
    return null;
}

public String actualizarAfectados()
{
    calcularEmpleados();
    valorAfectados = (empleadosSeleccionados != null && empleadosSeleccionados.length != 0) ? empleadosSeleccionados.length : valorAfectados;
    return null;
}

@Override
protected void limpiarCampos()
{
    departamento = -1;
    tipoPlanilla = -1;
    planilla = null;
    valorAfectados = 0;
    empleadosSeleccionados = null;
    tipoPlanillaAplicar = -1;
    listaEmpleadosAfectar = new ArrayList<Empleados>();
    listaPlanillas = new ArrayList<ProgramacionPla>();
    setObservacion("");
}

public Date getFechaInicio()
{
    return fechaInicio;
}

public void setFechaInicio(Date fechaInicio)
{
    this.fechaInicio = fechaInicio;
}

public Date getFechaFin()
{
    return fechaFin;
}

public void setFechaFin(Date fechaFin)
{
    this.fechaFin = fechaFin;
}

// *****************************************************************************
public void handleFechaInicial(DateSelectEvent event)
{
    setFechaInicio(event.getDate());
    setDias(calculaDias(getFechaInicio(), getFechaFin()).doubleValue());
}

public void handleFechaFinal(DateSelectEvent event)
{
    setFechaFin(event.getDate());
    setDias(calculaDias(getFechaInicio(), getFechaFin()).doubleValue());
}
//
private Double dias;

public Double getDias()
{
    return dias;
}

public void setDias(Double dias)
{
    this.dias = dias;
}
}
