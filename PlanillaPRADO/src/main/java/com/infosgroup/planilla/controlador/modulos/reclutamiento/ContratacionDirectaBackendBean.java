/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.facades.GerenciaFacade;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.modelo.procesos.usuarios.LDAPManager;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$contratacionDirecta")
@ViewScoped
public class ContratacionDirectaBackendBean extends AbstractJSFPage implements Serializable
{

private static final long serialVersionUID = 1L;
@EJB
private ReclutamientoSessionBean reclutamientoSessionBean;
@EJB
private PlanillaSessionBean planillaSessionBean;
@EJB
private transient GerenciaFacade gerenciaFacade;
@EJB
private ReportesStatelessBean reportesStatelessBean;
// ==
private List<Candidato> listaCandidatos;
private List<Puestos> listaPuestos;
private List<Empleados> listaJefes;
private List<TiposPlanilla> listaTiposPlanilla;
// ==
private Candidato candidatoSeleccionado;
// ==
private String actaAcuerdo;
private Date fechaAcuerdo;
private Double sueldoAprobado;
private Date fechaInicio;
private Date fechaFin;
private Short puesto;
private Integer representantePatronal;
private String tipoContrato;
private Integer estadoContrato;
// ==
private String usuario;
private Short tipoPlanilla;
// ==========

public List<Candidato> getListaCandidatos()
{
    return listaCandidatos;
}

public void setListaCandidatos(List<Candidato> listaCandidatos)
{
    this.listaCandidatos = listaCandidatos;
}

public List<Puestos> getListaPuestos()
{
    return listaPuestos;
}

public void setListaPuestos(List<Puestos> listaPuestos)
{
    this.listaPuestos = listaPuestos;
}

public List<Empleados> getListaJefes()
{
    return listaJefes;
}

public void setListaJefes(List<Empleados> listaJefes)
{
    this.listaJefes = listaJefes;
}

public List<TiposPlanilla> getListaTiposPlanilla()
{
    return listaTiposPlanilla;
}

public void setListaTiposPlanilla(List<TiposPlanilla> listaTiposPlanilla)
{
    this.listaTiposPlanilla = listaTiposPlanilla;
}

// ==========
public Candidato getCandidatoSeleccionado()
{
    return candidatoSeleccionado;
}

public void setCandidatoSeleccionado(Candidato candidatoSeleccionado)
{
    this.candidatoSeleccionado = candidatoSeleccionado;
}
// ==========

public String getActaAcuerdo()
{
    return actaAcuerdo;
}

public void setActaAcuerdo(String actaAcuerdo)
{
    this.actaAcuerdo = actaAcuerdo;
}

public Integer getEstadoContrato()
{
    return estadoContrato;
}

public void setEstadoContrato(Integer estadoContrato)
{
    this.estadoContrato = estadoContrato;
}

public Date getFechaAcuerdo()
{
    return fechaAcuerdo;
}

public void setFechaAcuerdo(Date fechaAcuerdo)
{
    this.fechaAcuerdo = fechaAcuerdo;
}

public Date getFechaFin()
{
    return fechaFin;
}

public void setFechaFin(Date fechaFin)
{
    this.fechaFin = fechaFin;
}

public Date getFechaInicio()
{
    return fechaInicio;
}

public void setFechaInicio(Date fechaInicio)
{
    this.fechaInicio = fechaInicio;
}

public Short getPuesto()
{
    return puesto;
}

public void setPuesto(Short puesto)
{
    this.puesto = puesto;
}

public ReclutamientoSessionBean getReclutamientoSessionBean()
{
    return reclutamientoSessionBean;
}

public void setReclutamientoSessionBean(ReclutamientoSessionBean reclutamientoSessionBean)
{
    this.reclutamientoSessionBean = reclutamientoSessionBean;
}

public Integer getRepresentantePatronal()
{
    return representantePatronal;
}

public void setRepresentantePatronal(Integer representantePatronal)
{
    this.representantePatronal = representantePatronal;
}

public Double getSueldoAprobado()
{
    return sueldoAprobado;
}

public void setSueldoAprobado(Double sueldoAprobado)
{
    this.sueldoAprobado = sueldoAprobado;
}

public String getTipoContrato()
{
    return tipoContrato;
}

public void setTipoContrato(String tipoContrato)
{
    this.tipoContrato = tipoContrato;
}
// ==========

public PlanillaSessionBean getPlanillaSessionBean()
{
    return planillaSessionBean;
}

public void setPlanillaSessionBean(PlanillaSessionBean planillaSessionBean)
{
    this.planillaSessionBean = planillaSessionBean;
}

public Short getTipoPlanilla()
{
    return tipoPlanilla;
}

public void setTipoPlanilla(Short tipoPlanilla)
{
    this.tipoPlanilla = tipoPlanilla;
}

public String getUsuario()
{
    return usuario;
}

public void setUsuario(String usuario)
{
    this.usuario = usuario;
}

// ==========
@PostConstruct
public void init()
{
    listaCandidatos = reclutamientoSessionBean.getCandidatosByEmpresa(getSessionBeanEMP().getCompania());
    listaPuestos = reclutamientoSessionBean.getPuestosByEmpresa(getSessionBeanEMP().getCompania());
    listaJefes = planillaSessionBean.listarJefes(getSessionBeanEMP().getCompania());
    listaTiposPlanilla = reclutamientoSessionBean.findTipoPlanillaByEmpresa(getSessionBeanEMP().getCompania());
}

// ==========
@Override
protected void limpiarCampos()
{
//        candidatoSeleccionado = null;

    actaAcuerdo = null;
    fechaAcuerdo = null;
    sueldoAprobado = null;
    fechaInicio = null;
    fechaFin = null;
    puesto = null;
    representantePatronal = null;
    tipoContrato = null;
    estadoContrato = null;
    // ==
    usuario = null;
    tipoPlanilla = null;
}

public String contratar$action()
{
    Boolean error = false;
    if (candidatoSeleccionado != null)
        {
//            if (getConcursoSeleccionado() == null)
//                {
//                addMessage("Contratar Candidato", "No ha seleccionado ningún concurso", TipoMensaje.INFORMACION);
//                return null;
//                }
        error = Boolean.FALSE;
        Contrato contrato = new Contrato();
        if (actaAcuerdo == null || actaAcuerdo.isEmpty())
            {
            addMessage("Contratar Candidato", "El campo Acta o Acuerdo es requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        if (fechaAcuerdo == null)
            {
            addMessage("Contratar Candidato", "El campo Fecha Acuerdo es requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        if (fechaInicio == null)
            {
            addMessage("Contratar Candidato", "El campo Fecha Inicio es requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        if ((fechaInicio != null) && (fechaFin != null))
            {
            if (!validaFechas(fechaInicio, fechaInicio))
                {
                addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            }
        if (sueldoAprobado == null)
            {
            addMessage("Contratar Candidato", "El campo Salario es requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        if ((usuario == null) || usuario.isEmpty())
            {
            addMessage("Contratar Candidato", "El campo Usuario es requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }
        if (usuario != null)
            {
            if (!reclutamientoSessionBean.findByUsuario(usuario).isEmpty())
                {
                addMessage("Contratar Candidato", "El usuario ingresado ya esta siendo usado por otra persona.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            }
//            if (agencia == null)
//                {
//                addMessage("Contratar Candidato", "Seleccione una Sucursal", TipoMensaje.ERROR);
//                error = Boolean.TRUE;
//                }
        if (tipoPlanilla == null)
            {
            addMessage("Contratar Candidato", "Seleccione el Tipo de Planilla", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }

        if (representantePatronal == null)
            {
            addMessage("Contratar Candidato", "No se ha configurado el representante patronal", TipoMensaje.ERROR);
            error = Boolean.TRUE;
            }

        if (error)
            {
            return null;
            }

        contrato.setNumActa(actaAcuerdo);
        contrato.setEstado("G");
        contrato.setTipo(tipoContrato);
        contrato.setFechaAcuerdo(fechaAcuerdo);
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFinal(fechaFin);
        PuestosPK puestoPK = new PuestosPK(getSessionBeanEMP().getCompania().getCodCia(), puesto);
        Puestos p = reclutamientoSessionBean.findPuestoById(puestoPK);
        contrato.setPuestos(p);
        contrato.setSalario(new BigDecimal(sueldoAprobado));
        //contrato.setCodAgencia(agencia);
        contrato.setTiposPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanilla)));

        Empleados rp = planillaSessionBean.findEmpleadosByID(new EmpleadosPK(getSessionBeanEMP().getCompania().getCodCia(), representantePatronal));
        //contrato.setObservacion(getObservaciones());
        
        Gerencia g = gerenciaFacade.find(new GerenciaPK(getSessionBeanEMP().getCompania().getCodCia(), p.getCodGerencia()));
        
        
        reclutamientoSessionBean.contratarCandidato2(candidatoSeleccionado, p, contrato, usuario, rp, candidatoSeleccionado.getNumDui(),g);
        //limpiarDatosContratacion();
        addMessage("Contratar Candidato", "Datos Guardados ", TipoMensaje.INFORMACION);
        //actualizaListas();

        //Crear usuario LDAP
        try
            {
            lDAPManager = getLDAPManager();
            lDAPManager.addUser(usuario, candidatoSeleccionado.getNombre(), candidatoSeleccionado.getApellido(), usuario);
            lDAPManager.assignUser(usuario, "empleados");
            }
        catch (Exception e)
            {
            addMessage("Contratar Candidato", "Usuario de Aplicación no creado.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Error al registrar empleado en servidor LDAP.", e);
            }
        }

    limpiarCampos();

    return null;
}
private LDAPManager lDAPManager;

public LDAPManager getLDAPManager() throws NamingException
{
    String servidor = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ConfiguracionLDAP");
    lDAPManager = LDAPManager.getInstance(servidor.split(":")[0], Integer.valueOf(servidor.split(":")[1]), servidor.split(":")[2], servidor.split(":")[3]);
    return lDAPManager;
}

public String imprimirContrato$action()
{
    if (candidatoSeleccionado == null)
        {
        addMessage("Reclutamiento y Selección", "No ha seleccionado ningun candidato", TipoMensaje.ERROR);
        return null;
        }
    HashMap<String, Object> parametros = new HashMap<String, Object>();
    parametros.put("COD_CIA", new Integer("" + candidatoSeleccionado.getEmpleados().getEmpleadosPK().getCodCia()));
    parametros.put("COD_EMP", candidatoSeleccionado.getEmpleados().getEmpleadosPK().getCodEmp());
    reportesStatelessBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "reporteContrato", FormatoReporte.PDF);
    return null;
}
}
