/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.facades.ContratoFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.GerenciaFacade;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.modelo.procesos.usuarios.LDAPManager;
import com.infosgroup.planilla.view.AbstractPreseleccion;
import com.infosgroup.planilla.view.AutocompletePruebaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$preseleccionAspirante")
@ViewScoped
public class PreseleccionAspiranteBackendBean extends AbstractPreseleccion implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    @EJB
    private ReportesStatelessBean reportesStatelessBean;
    @EJB
    private transient EmpleadosSessionBean empleadosSessionBean;
    @EJB
    private transient EmpleadoFacade empleadosFacade;
    @EJB
    private transient GerenciaFacade gerenciaFacade;
    @EJB
    private transient ContratoFacade contratofacade;
// ==
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Concurso> listaConcurso;
    private transient DataTable tableCandidatos;
    private transient DataTable tableSeleccion;
    private transient DataTable tableContratacion;
    private CandidatoConcurso candidatoSeleccionado;
    private List<EvaluacionCandidato> evaluacionCandidatos;
    private List<CandidatoConcurso> candidatosGuardados;
    private List<CandidatoConcurso> candidatosContratar;
    private List<Criterio> criteriosDisponibles;
    private List<Empleados> listaJefes;
//  Criterios adicionales
    private Criterio criterio;
    private List<Criterio> criteriosPrincipales;
    private String actaOAcuerdo;
    private Date dia;
    private Date fechaInicio;
    private Date fechaFin;
    private String dui;
    private String tipoContratoSeleccionado;
    private String comentarioFinal;
    private Double salario;
    private Boolean error;
    private String observaciones;
    private String usuario;
    private List<Agencias> listaAgencias;
    private List<TiposPlanilla> listaTipoPlanilla;
    private Short agencia;
    private Short tipoPlanilla;
    private List<Candidato> listaCandidatos;
    private Concurso concursoSeleccionado;
    private Candidato[] candidatosSeleccionados;
    private Criterio[] criteriosAdicionales;
    private PruebaXPuesto pruebaXPuestoSeleccionada;
    private AutocompletePruebaConverter pruebaConverter;
    private EvaluacionCandidato pruebaEliminar;
    private List<BeneficiarioXCandidato> listaBeneficiarios;
    private List<Parentesco> listaParentesco;
    private String nombreBeneficiario;
    private Short parentesco;
    private BeneficiarioXCandidato beneficiarioSeleccionado;
    private Short parentescoEdit;
    private String accionSeleccion = "A";
    private Candidato preCandidatoSeleccionado;

    @PostConstruct
    public void init()
    {
        setDia(new Date());
        pruebaConverter = new AutocompletePruebaConverter(reclutamientoSessionBean.finPruebaXPuestosByCias(getSessionBeanEMP().getCompania()));
        listaParentesco = reclutamientoSessionBean.findParentescoByCias(getSessionBeanEMP().getCompania());
        listaJefes = empleadosFacade.findByJefes(getSessionBeanEMP().getCompania());
    }

    public Criterio getCriterio()
    {
        return criterio;
    }

    public void setCriterio(Criterio criterio)
    {
        this.criterio = criterio;
    }

    public String agregarCriterio()
    {
        if (criteriosPrincipales == null)
            {
            criteriosPrincipales = new ArrayList<Criterio>();
            }
        if (!criteriosPrincipales.contains(criterio))
            {
            criteriosPrincipales.add(criterio);
            }
        else
            {
            addMessage("Agregar criterio", "Este criterio ya ha sido seleccionado.", TipoMensaje.INFORMACION);
            }
        return null;
    }

    public String eliminarCriterio()
    {
        if (criteriosPrincipales != null && !criteriosPrincipales.isEmpty())
            {
            if (criteriosPrincipales.contains(criterio))
                {
                criteriosPrincipales.remove(criterio);
                }
            }
        return null;
    }

    public Candidato getPreCandidatoSeleccionado()
    {
        return preCandidatoSeleccionado;
    }

    public void setPreCandidatoSeleccionado(Candidato preCandidatoSeleccionado)
    {
        this.preCandidatoSeleccionado = preCandidatoSeleccionado;
    }

    public String getAccionSeleccion()
    {
        return accionSeleccion;
    }

    public void setAccionSeleccion(String accionSeleccion)
    {
        this.accionSeleccion = accionSeleccion;
    }

    public List<Parentesco> getListaParentesco()
    {
        return listaParentesco;
    }

    public void setListaParentesco(List<Parentesco> listaParentesco)
    {
        this.listaParentesco = listaParentesco;
    }

    public List<BeneficiarioXCandidato> getListaBeneficiarios()
    {
        return listaBeneficiarios;
    }

    public void setListaBeneficiarios(List<BeneficiarioXCandidato> listaBeneficiarios)
    {
        this.listaBeneficiarios = listaBeneficiarios;
    }

    public CandidatoConcurso getCandidatoSeleccionado()
    {
        return candidatoSeleccionado;
    }

    public void setCandidatoSeleccionado(CandidatoConcurso candidatoSeleccionado)
    {
        this.candidatoSeleccionado = candidatoSeleccionado;
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

    public List<Concurso> getListaConcurso()
    {
        return listaConcurso;
    }

    public void setListaConcurso(List<Concurso> listaConcurso)
    {
        this.listaConcurso = listaConcurso;
    }

    public List<Candidato> getListaCandidato()
    {
        return reclutamientoSessionBean.getCandidatosByEmpresa(getSessionBeanEMP().getCompania());
    }

    public DataTable getTableCandidatos()
    {
        return tableCandidatos;
    }

    public void setTableCandidatos(DataTable tableCandidatos)
    {
        this.tableCandidatos = tableCandidatos;
    }

    public DataTable getTableContratacion()
    {
        return tableContratacion;
    }

    public void setTableContratacion(DataTable tableContratacion)
    {
        this.tableContratacion = tableContratacion;
    }

    public List<CandidatoConcurso> getCandidatosGuardados()
    {
        return candidatosGuardados;
    }

    public void setCandidatosGuardados(List<CandidatoConcurso> candidatoConcurso)
    {
        this.candidatosGuardados = candidatoConcurso;
    }

    public DataTable getTableSeleccion()
    {
        return tableSeleccion;
    }

    public void setTableSeleccion(DataTable tableSeleccion)
    {
        this.tableSeleccion = tableSeleccion;
    }

    public List<EvaluacionCandidato> getEvaluacionCandidatos()
    {
        return evaluacionCandidatos;
    }

    public void setEvaluacionCandidatos(List<EvaluacionCandidato> evaluacionCandidatos)
    {
        this.evaluacionCandidatos = evaluacionCandidatos;
    }

    public List<CandidatoConcurso> getCandidatosContratar()
    {
        return candidatosContratar;
    }

    public void setCandidatosContratar(List<CandidatoConcurso> candidatosContratar)
    {
        this.candidatosContratar = candidatosContratar;
    }

    public List<Agencias> getListaAgencias()
    {
        listaAgencias = reclutamientoSessionBean.findAgenciasByEmpresa(getSessionBeanEMP().getCompania());
        return listaAgencias;
    }

    public void setListaSucursales(List<Agencias> listaAgencias)
    {
        this.listaAgencias = listaAgencias;
    }

    public List<TiposPlanilla> getListaTipoPlanilla()
    {
        listaTipoPlanilla = reclutamientoSessionBean.findTipoPlanillaByEmpresa(getSessionBeanEMP().getCompania());
        return listaTipoPlanilla;
    }

    public void setListaTipoPlanilla(List<TiposPlanilla> listaTipoPlanilla)
    {
        this.listaTipoPlanilla = listaTipoPlanilla;
    }

    public Short getAgencia()
    {
        return agencia;
    }

    public void setAgencia(Short agencia)
    {
        this.agencia = agencia;
    }

    public Short getTipoPlanilla()
    {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla)
    {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Date getDia()
    {
        return dia;
    }

    public void setDia(Date dia)
    {
        this.dia = dia;
    }

    public List<Criterio> getCriteriosDisponibles()
    {
        return criteriosDisponibles;
    }

    public void setCriteriosDisponibles(List<Criterio> criteriosDisponibles)
    {
        this.criteriosDisponibles = criteriosDisponibles;
    }

    public String getTipoContratoSeleccionado()
    {
        return tipoContratoSeleccionado;
    }

    public void setTipoContratoSeleccionado(String tipoContratoSeleccionado)
    {
        this.tipoContratoSeleccionado = tipoContratoSeleccionado;
    }

    public String getComentarioFinal()
    {
        return comentarioFinal;
    }

    public void setComentarioFinal(String comentarioFinal)
    {
        this.comentarioFinal = comentarioFinal;
    }

    public String getActaOAcuerdo()
    {
        return actaOAcuerdo;
    }

    public void setActaOAcuerdo(String actaOAcuerdo)
    {
        this.actaOAcuerdo = actaOAcuerdo;
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

    public String getDui()
    {
        return dui;
    }

    public void setDui(String dui)
    {
        this.dui = dui;
    }

    public Double getSalario()
    {
        return salario;
    }

    public void setSalario(Double salario)
    {
        this.salario = salario;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public List<Criterio> getCriteriosPrincipales()
    {
        return criteriosPrincipales;
    }

    public void setCriteriosPrincipales(List<Criterio> criteriosPrincipales)
    {
        this.criteriosPrincipales = criteriosPrincipales;
    }

    public String getUsuario()
    {
        if (candidatoSeleccionado != null)
            {
            if (candidatoSeleccionado.getCandidato1() != null)
                {
                usuario = reclutamientoSessionBean.generaUsuario(candidatoSeleccionado.getCandidato1());
                }
            }
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String buscarConcurso$action()
    {
        setConcursoSeleccionado(null);
        if (fechaInicial != null && fechaFinal != null)
            {
            if (validaFechas(fechaInicial, fechaFinal) == true)
                {
                setListaConcurso(reclutamientoSessionBean.getListaConcursos(getSessionBeanEMP().getCompania(), fechaInicial, fechaFinal));
                }
            else
                {
                addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
                }
            }
        setListaConcurso(reclutamientoSessionBean.getListaConcursos(getSessionBeanEMP().getCompania(), fechaInicial, fechaFinal));
        limpiarCampos();
        return null;
    }

    public String iniciar()
    {
        if (comentarioFinal == null || comentarioFinal.length() <= 0)
            {
            addMessage("Cerrar Concurso", "Debe ingresar un comentario final antes de cerrar el concurso.", TipoMensaje.ERROR);
            return null;
            }
        cerrarConcurso();
        setListaConcurso(new ArrayList<Concurso>());
        limpiarCampos();
        return "concursoSeleccionado";
    }

    public void cerrarConcurso()
    {
        EstadoConcurso ec = reclutamientoSessionBean.findEstadoConcursoById(new EstadoConcursoPK(getSessionBeanEMP().getCompania().getCodCia(), "C"));
        if (ec == null)
            {
            addMessage("Cerrar Concurso", "No esta registrado el estado de concurso para guardar los cambios.", TipoMensaje.INFORMACION);
            return;
            }
        if (getConcursoSeleccionado() != null)
            {
            getConcursoSeleccionado().setEstadoConcurso(ec);
            getConcursoSeleccionado().setComentarioFinal(comentarioFinal);
            reclutamientoSessionBean.editarConcurso(getConcursoSeleccionado());
            addMessage("Cerrar Concurso", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            }
    }

    public void onEditCandidato(RowEditEvent event)
    {
        reclutamientoSessionBean.editarCandidatoConcurso((CandidatoConcurso) event.getObject());
        actualizaListas();
    }

    public void onEditNotasCandidato(RowEditEvent event)
    {
        EvaluacionCandidato c = (EvaluacionCandidato) event.getObject();
        if (c.getNota() == null)
            {
            c.setNota(BigDecimal.ZERO);
            }
        reclutamientoSessionBean.editarEvaluacionCandidato(c);
        if (evaluacionCandidatos != null && evaluacionCandidatos.size() > 0)
            {
            reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos, candidatoSeleccionado);
            }
        actualizaListas();
        addMessage("Evaluacion de Candidato", "Datos Guardados", TipoMensaje.INFORMACION);
    }

    public void onEditUpdate(RowEditEvent event)
    {
        reclutamientoSessionBean.editarCandidatoConcurso((CandidatoConcurso) event.getObject());
        actualizaListas();
    }

    public String onFlowListener(FlowEvent event)
    {
        if (getConcursoSeleccionado() == null)
            {
            addMessage("Contratar Candidato", "No ha seleccionado ningún concurso", TipoMensaje.INFORMACION);
            return "concursoSeleccionado";
            }
        if (event.getOldStep().equals("concursoSeleccionado"))
            {
            if (getConcursoSeleccionado() != null)
                {
                setCriteriosPrincipales(reclutamientoSessionBean.getListaCriteriosPorPuesto(getConcursoSeleccionado().getPuestos().getPuestosPK()));
                setCriteriosDisponibles(reclutamientoSessionBean.getListaCriteriosByCias(concursoSeleccionado.getConcursoPK().getCodCia()));
                }
            }
        actualizaListas();
        if (event.getNewStep().equals("tabSeleccion"))
            {
            ordenarLista();
            }
        return event.getNewStep();
    }

    public void ordenarLista()
    {
        if (candidatosGuardados != null)
            {
            Collections.sort(candidatosGuardados);
            for (int i = 0; i <= candidatosGuardados.size() - 1; i++)
                {
                candidatosGuardados.get(i).setOrden(i);
                if (i == 5)
                    {
                    break;
                    }
                }
            }
    }

    public String aplicarCriterios()
    {
        if (getConcursoSeleccionado() != null)
            {
            if (getCandidatosSeleccionados() != null)
                {
                for (Candidato n : getCandidatosSeleccionados())
                    {
                    if (n.getConcursoList() == null)
                        {
                        n.setConcursoList(new ArrayList<Concurso>());
                        n.getConcursoList().add(getConcursoSeleccionado());
                        }
                    else if (!n.getConcursoList().contains(getConcursoSeleccionado()))
                        {
                        n.getConcursoList().add(getConcursoSeleccionado());
                        }
                    reclutamientoSessionBean.editarCandidato(n);
                    }
                addMessage("Preselección de Candidatos", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
                return "concursoSeleccionado";
                }
            }
        addMessage("Preselección de Candidatos", "No ha seleccionado ningún concurso, de clic en Atrás para reiniciar el asistente.", TipoMensaje.INFORMACION);
        return "concursoSeleccionado";
    }

    public String seleccionarCandidato()
    {
        cambioEstadoCandidato("S");
        return null;
    }

    public String deseleccionarCandidato()
    {
        cambioEstadoCandidato("P");
        return null;
    }

    public String contratarCandidato()
    {
        error = Boolean.FALSE;
        if (candidatoSeleccionado != null)
            {
            if (concursoSeleccionado == null)
                {
                addMessage("Contratar Candidato", "No ha seleccionado ning&uacute;n concurso", TipoMensaje.INFORMACION);
                return null;
                }
            if (actaOAcuerdo == null || actaOAcuerdo.length() <= 0)
                {
                addMessage("Contratar Candidato", "El campo Acta o Acuerdo es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            if (dia == null)
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
                if (validaFechas(fechaInicio, fechaInicio) == false)
                    {
                    addMessage("Buscar concurso", "Los rangos de fecha ingresados no son consistentes", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                    }
                }
            if (salario == null)
                {
                addMessage("Contratar Candidato", "El campo Salario es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            if ((dui == null) || dui.isEmpty())
                {
                addMessage("Contratar Candidato", "El campo DUI es requerido", TipoMensaje.ERROR);
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
                    addMessage("Contratar Candidato", "El usuario ingresado ya esta siendo usado por otra persona", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                    }
                }
            if (agencia == null)
                {
                addMessage("Contratar Candidato", "Seleccione una Sucursal", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }
            if (tipoPlanilla == null)
                {
                addMessage("Contratar Candidato", "Seleccione el Tipo de Planilla", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }

            if (reclutamientoSessionBean.getRepresentantePatronal(getSessionBeanEMP().getCompania()) == null)
                {
                addMessage("Contratar Candidato", "No se ha configurado el representante patronal", TipoMensaje.ERROR);
                error = Boolean.TRUE;
                }

            if (error)
                {
                return null;
                }

            Candidato candidato = candidatoSeleccionado.getCandidato1();
            Empleados empleado = crearEmpleado(candidato);

            if (empleado == null)
                {
                return null;
                }

            candidato.setEmpleados(empleado);
            candidato.setStatus("C");
            reclutamientoSessionBean.editarCandidato(candidato);

            ContratoPK contratoPK = new ContratoPK();
            contratoPK.setCodCia(sessionBeanEMP.getCompania().getCodCia());
            contratoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            contratoPK.setCodContrato(reclutamientoSessionBean.maxContrato(candidato));

            Contrato contrato = new Contrato();
            contrato.setContratoPK(contratoPK);

            contrato.setNumActa(getActaOAcuerdo());
            contrato.setEstado("G");
            contrato.setTipo(tipoContratoSeleccionado);
            contrato.setFechaAcuerdo(getDia());
            contrato.setFechaInicio(getFechaInicio());
            contrato.setFechaFinal(getFechaFin());
            contrato.setPuestos(concursoSeleccionado.getPuestos());
            contrato.setSalario(new BigDecimal(getSalario()));
            contrato.setCodAgencia(agencia);
            contrato.setTiposPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanEMP().getCompania().getCodCia(), tipoPlanilla)));
            contrato.setObservacion(getObservaciones());
            contrato.setCandidato(candidato);
            contrato.setEmpleados(empleado);
            reclutamientoSessionBean.guardarContrato(contrato);

            empleado.setFecIngreso(fechaInicio);
            empleado.setPuestos(concursoSeleccionado.getPuestos());
            empleado.setSalario(new BigDecimal(getSalario()));
            empleado.setSalarioBase(new BigDecimal(getSalario()));
            empleado.setTipoContra(tipoContratoSeleccionado);
            empleado.setTiposPlanilla(contrato.getTiposPlanilla());
            empleadosSessionBean.editarEmpleado(empleado);

            candidatoSeleccionado.setEstado("C");
            reclutamientoSessionBean.editarCandidatoConcurso(candidatoSeleccionado);

            limpiarDatosContratacion();
            addMessage("Contratar candidato", "Datos guardados", TipoMensaje.INFORMACION);
            actualizaListas();

            //Crear usuario LDAP
            try
                {
                LDAPManager lDAPManager = getLDAPManager();
                lDAPManager.addUser(usuario, candidatoSeleccionado.getCandidato1().getNombre(), candidatoSeleccionado.getCandidato1().getApellido(), usuario);
                lDAPManager.assignUser(usuario, "empleados");
                }
            catch (Exception e)
                {
                addMessage("Contratar candidato", "Usuario de Aplicación no creado", TipoMensaje.ERROR);
                logger.log(Level.SEVERE, "Error al registrar empleado en servidor LDAP", e);
                }
            }
        return null;
    }

    public void limpiarDatosContratacion()
    {
        setActaOAcuerdo(null);
        setFechaInicio(null);
        setFechaFin(null);
        setDui(null);
        setTipoContratoSeleccionado(null);
        setComentarioFinal(null);
        setSalario(null);
        setObservaciones(null);
        error = Boolean.FALSE;
    }

    public String noContratarCandidato()
    {
        if (tableContratacion.getRowIndex() != -1)
            {
            CandidatoConcurso c = candidatosContratar.get(tableContratacion.getRowIndex());
            c.setEstado("S");
            reclutamientoSessionBean.editarCandidatoConcurso(c);
            addMessage("Seleccionar Candidato", "Datos Guardados ", TipoMensaje.INFORMACION);
            actualizaListas();
            }
        return null;
    }

    public void cambioEstadoCandidato(String estado)
    {
        if (tableSeleccion.getRowIndex() != -1)
            {
            CandidatoConcurso c = candidatosGuardados.get(tableSeleccion.getRowIndex());
            c.setEstado(estado);
            c.setFecha(new Date());
            reclutamientoSessionBean.editarCandidatoConcurso(c);
            addMessage("Seleccionar Candidato", "Datos Guardados " + candidatosGuardados.get(tableSeleccion.getRowIndex()).getCandidato1().getNombreCompleto(), TipoMensaje.INFORMACION);
            actualizaListas();
            ordenarLista();
            }
    }

    public void handleCloseEvaluacionCandidato(CloseEvent event)
    {
        reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos, candidatoSeleccionado);
        setCandidatoSeleccionado(null);
    }

    public void handleCloseCriterioAdicional(CloseEvent event)
    {
        if (getCriteriosAdicionales() != null && getCriteriosAdicionales().length > 0)
            {
            for (Criterio c : getCriteriosAdicionales())
                {
                if (getCriteriosPrincipales() == null)
                    {
                    setCriteriosPrincipales(new ArrayList<Criterio>());
                    }
                if (!getCriteriosPrincipales().contains(c))
                    {
                    getCriteriosPrincipales().add(c);
                    }
                }
            }
    }

    public String listarEvaluaciones()
    {
        setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));//registrarPruebasPorCandidato();
        return null;
    }

    public void actualizaListas()
    {
        if (getConcursoSeleccionado() != null)
            {
            listaCandidatos = reclutamientoSessionBean.getCandidatosByConcurso(getConcursoSeleccionado());
            setCandidatosGuardados(reclutamientoSessionBean.getListaCandidatoConcurso(getConcursoSeleccionado(), "P"));
            setCandidatosContratar(reclutamientoSessionBean.getListaCandidatoSeleccionado(getConcursoSeleccionado(), Arrays.asList("S", "C")));
            }
    }

    @Override
    protected void limpiarCampos()
    {
        setFechaInicial(null);
        setFechaFinal(null);
        tableCandidatos.setSelection(null);
        setComentarioFinal(null);
        setConcursoSeleccionado(null);
        setCriteriosAdicionales(new Criterio[0]);
        setAccionSeleccion("A");
    }

    public String buscarCandidatosXCriterios()
    {
        if (concursoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
            }
        setAccionSeleccion("C");
        setCandidatosSeleccionados(null);
        setTableCandidatos(new DataTable());
        if (criteriosPrincipales != null && !criteriosPrincipales.isEmpty())
            {
            listaCandidatos = reclutamientoSessionBean.findCandidatosMatchCriteria( /*
                     * Arrays.asList(
                     */criteriosPrincipales, getSessionBeanEMP().getCompania().getCodCia()/*
                     * criteriosSeleccionados)
                     */);
            }
        else
            {
            listaCandidatos = new ArrayList<Candidato>();
            }

        return null;
    }

    public String buscarAllCandidatos()
    {
        if (concursoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
            }
        setAccionSeleccion("M");
        setCandidatosSeleccionados(null);
        setTableCandidatos(new DataTable());
        listaCandidatos = reclutamientoSessionBean.getCandidatosByEmpresa(getSessionBeanEMP().getCompania());
        return null;
    }

    public String buscarAllEmpleados()
    {
        if (concursoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
            }
        setAccionSeleccion("M");
        setCandidatosSeleccionados(null);
        setTableCandidatos(new DataTable());
        listaCandidatos = reclutamientoSessionBean.findCandidatosLikeEmpleados(getSessionBeanEMP().getCompania());
        return null;
    }

    public String mostrarCandidatos()
    {
        setAccionSeleccion("A");
        actualizaListas();
        setCandidatosSeleccionados(null);
        return null;
    }

    public EvaluacionCandidato getPruebaEliminar()
    {
        return pruebaEliminar;
    }

    public void setPruebaEliminar(EvaluacionCandidato pruebaEliminar)
    {
        this.pruebaEliminar = pruebaEliminar;
    }

    public List<Candidato> getListaCandidatos()
    {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos)
    {
        this.listaCandidatos = listaCandidatos;
    }

    public Concurso getConcursoSeleccionado()
    {
        return concursoSeleccionado;
    }

    public void setConcursoSeleccionado(Concurso concursoSeleccionado)
    {
        this.concursoSeleccionado = concursoSeleccionado;
    }

    public Candidato[] getCandidatosSeleccionados()
    {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(Candidato[] candidatosSeleccionados)
    {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }

    public Criterio[] getCriteriosAdicionales()
    {
        return criteriosAdicionales;
    }

    public void setCriteriosAdicionales(Criterio[] criteriosAdicionales)
    {
        this.criteriosAdicionales = criteriosAdicionales;
    }

    public AutocompletePruebaConverter getPruebaConverter()
    {
        return pruebaConverter;
    }

    public void setPruebaConverter(AutocompletePruebaConverter pruebaConverter)
    {
        this.pruebaConverter = pruebaConverter;
    }

    public PruebaXPuesto getPruebaXPuestoSeleccionada()
    {
        return pruebaXPuestoSeleccionada;
    }

    public void setPruebaXPuestoSeleccionada(PruebaXPuesto pruebaXPuestoSeleccionada)
    {
        this.pruebaXPuestoSeleccionada = pruebaXPuestoSeleccionada;
    }

    public List<PruebaXPuesto> completePrueba(String query)
    {
        List<PruebaXPuesto> suggestions = new ArrayList<PruebaXPuesto>();
        for (PruebaXPuesto p : pruebaConverter.listaPruebaXPuesto)
            {
            if (p.getNombre().toLowerCase().contains(query.toLowerCase()))
                {
                suggestions.add(p);
                }
            }
        return suggestions;
    }

    public String agregarPrueba()
    {
        if (pruebaXPuestoSeleccionada != null)
            {
            addMessage("Reclutamiento y Selección", "Ha Seleccionado " + pruebaXPuestoSeleccionada.getNombre(), TipoMensaje.INFORMACION);
            return null;
            }
        addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
        return null;
    }

    public String eliminarPruebaCandidato()
    {
        if (pruebaEliminar == null)
            {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
            return null;
            }
        reclutamientoSessionBean.eliminarEvaluacionCandidato(pruebaEliminar);
        addMessage("Reclutamiento y Selección", "Datos eliminados con éxito.", TipoMensaje.INFORMACION);
        setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));
        reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos, candidatoSeleccionado);
        return null;
    }

    public String agregarPruebaCandidato()
    {
        if (candidatoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ningun Candidato", TipoMensaje.ERROR);
            return null;
            }
        if (pruebaXPuestoSeleccionada == null)
            {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
            return null;
            }
        EvaluacionCandidato nuevaEvaluacion = new EvaluacionCandidato();
        EvaluacionCandidatoPK pk = new EvaluacionCandidatoPK();
        nuevaEvaluacion.setCandidatoConcurso(candidatoSeleccionado);         
        nuevaEvaluacion.setFecha(new Date());
        nuevaEvaluacion.setNota(BigDecimal.ZERO);
        nuevaEvaluacion.setObservacion("Ninguna");        
        nuevaEvaluacion.setPruebaXPuesto(pruebaXPuestoSeleccionada);     
        pk.setPuesto((short)pruebaXPuestoSeleccionada.getPruebaXPuestoPK().getPuesto());
        pk.setCodCia(pruebaXPuestoSeleccionada.getPruebaXPuestoPK().getCodCia());
        pk.setPrueba(pruebaXPuestoSeleccionada.getPruebaXPuestoPK().getCodigo());
        pk.setCandidato(candidatoSeleccionado.getCandidato1().getCandidatoPK().getCodCandidato());
        pk.setConcurso(getConcursoSeleccionado().getConcursoPK().getCodConcurso()); 
       
        
        nuevaEvaluacion.setEvaluacionCandidatoPK(pk);
        
        for (EvaluacionCandidato a : evaluacionCandidatos)
            {
            if (a.getEvaluacionCandidatoPK().equals(pk))
                {
                addMessage("Reclutamiento y Selección", "Ya se ha registrado una evaluación de este tipo.", TipoMensaje.ERROR);
                return null;
                }
            }
        try
            {
            reclutamientoSessionBean.guardarEvaluacionCandidato(nuevaEvaluacion);
            addMessage("Reclutamiento y Selección", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
            setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));
            setPruebaXPuestoSeleccionada(null);
            }
        catch (Exception e)
            {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar guardar.", TipoMensaje.ERROR);
            }
        return null;
    }

    public String imprimirContrato()
    {
        if (candidatoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun candidato.", TipoMensaje.ERROR);
            return null;
            }

        Contrato c = contratofacade.findUltimo(candidatoSeleccionado.getCandidato1());
        if (c == null)
            {
            addMessage("Reclutamiento y Selección", "No ha encontrado ningún contrato.", TipoMensaje.ERROR);
            return null;
            }
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("COD_CIA", Integer.valueOf("" + c.getContratoPK().getCodCia()));
        parametros.put("COD_CONTRATO", Integer.valueOf("" + c.getContratoPK().getCodContrato()));
        reportesStatelessBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "reporteContratoTOTO", FormatoReporte.PDF);
        return null;
    }

    public String listarBeneficiarios()
    {
        listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
        return null;
    }

    public String guardarBeneficiario()
    {
        Boolean _error = Boolean.FALSE;
        if (candidatoSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun candidato.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
            }
        if (nombreBeneficiario == null || nombreBeneficiario.length() <= 0)
            {
            addMessage("Reclutamiento y Selección", "Ingrese el nombre del beneficiario.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
            }
        if (parentesco == null || parentesco == -1)
            {
            addMessage("Reclutamiento y Selección", "Seleccione el parentesco.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
            }
        if (_error)
            {
            return null;
            }
        BeneficiarioXCandidato bc = new BeneficiarioXCandidato();
        BeneficiarioXCandidatoPK pk = reclutamientoSessionBean.getPkBeneficiarioCandiato(candidatoSeleccionado.getCandidato1());
        bc.setBeneficiarioXCandidatoPK(pk);
        bc.setCandidato(candidatoSeleccionado.getCandidato1());
        bc.setNombre(nombreBeneficiario);
        bc.setParentesco(new Parentesco(candidatoSeleccionado.getCandidatoConcursoPK().getCodCia(), parentesco));

        try
            {
            reclutamientoSessionBean.guardarBeneficiarioCandidato(bc);
            addMessage("Reclutamiento y Selección", "Datos Guardados con exito.", TipoMensaje.INFORMACION);
            listaBeneficiarios = (candidatoSeleccionado != null) ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
            }
        catch (Exception e)
            {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar guardar.", TipoMensaje.ERROR);
            }
        nombreBeneficiario = null;
        parentesco = null;
        return null;
    }

    public void onEditarBeneficiario(RowEditEvent event)
    {
        BeneficiarioXCandidato c = (BeneficiarioXCandidato) event.getObject();
        if (c.getNombre() == null || c.getNombre().length() <= 0)
            {
            addMessage("Reclutamiento y Selección", "Ingrese el nombre de beneficiario.", TipoMensaje.ERROR);
            return;
            }
        c.setParentesco(new Parentesco(getSessionBeanEMP().getCompania().getCodCia(), parentescoEdit));
        try
            {
            reclutamientoSessionBean.editarBeneficiarioCandidato(c);
            listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
            addMessage("Reclutamiento y Selección", "Datos Guardados con exito.", TipoMensaje.INFORMACION);
            }
        catch (Exception e)
            {
            logger.log(Level.OFF, "Ocurrio el siguiente error al intentar guardar: ", e);
            }
    }

    public String eliminarBeneficiario()
    {
        if (beneficiarioSeleccionado == null)
            {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun beneficiario.", TipoMensaje.ERROR);
            return null;
            }
        try
            {
            reclutamientoSessionBean.eliminarBeneficiarioCandidato(beneficiarioSeleccionado);
            addMessage("Reclutamiento y Selección", "Datos Eliminados con exito.", TipoMensaje.INFORMACION);
            listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
            }
        catch (Exception e)
            {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar eliminar.", TipoMensaje.ERROR);
            }

        return null;
    }

    public String getNombreBeneficiario()
    {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario)
    {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public Short getParentesco()
    {
        return parentesco;
    }

    public void setParentesco(Short parentesco)
    {
        this.parentesco = parentesco;
    }

    public BeneficiarioXCandidato getBeneficiarioSeleccionado()
    {
        return beneficiarioSeleccionado;
    }

    public void setBeneficiarioSeleccionado(BeneficiarioXCandidato beneficiarioSeleccionado)
    {
        this.beneficiarioSeleccionado = beneficiarioSeleccionado;
    }

    public Short getParentescoEdit()
    {
        return parentescoEdit;
    }

    public void setParentescoEdit(Short parentescoEdit)
    {
        this.parentescoEdit = parentescoEdit;
    }

    public String eliminarCandidato()
    {

        try
            {
            if (candidatoSeleccionado == null)
                {
                addMessage("Reclutamiento y Selección", "No ha seleccionado ningún candidato.", TipoMensaje.ERROR);
                return null;
                }
            for (EvaluacionCandidato e : candidatoSeleccionado.getEvaluacionCandidatoList())
                {
                reclutamientoSessionBean.eliminarEvaluacionCandidato(e);
                }
            candidatoSeleccionado.getCandidato1().getConcursoList().remove(concursoSeleccionado);
            reclutamientoSessionBean.editarCandidato(candidatoSeleccionado.getCandidato1());
            reclutamientoSessionBean.removerCandidatoConcurso(candidatoSeleccionado);
            addMessage("Reclutamiento y Selección", "Datos Eliminados con exito.", TipoMensaje.INFORMACION);
            actualizaListas();
            setCandidatoSeleccionado(null);
            }
        catch (Exception e)
            {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar eliminar.", TipoMensaje.ERROR);
            logger.log(Level.OFF, "Ocurrio el siguiente error al intentar eliminar: ", e);
            }

        return null;
    }

    public Empleados crearEmpleado(Candidato candidato)
    {
        Integer i = null;
        EmpleadosPK empleadoPK = null;
        Empleados empleado = null;
        try
            {
            Puestos p = concursoSeleccionado.getPuestos();
            Gerencia g = gerenciaFacade.find(new GerenciaPK(sessionBeanEMP.getCompania().getCodCia(), p.getCodGerencia()));

            empleadoPK = new EmpleadosPK();
            empleadoPK.setCodCia(sessionBeanEMP.getCompania().getCodCia());
            empleadoPK.setCodEmp(empleadosSessionBean.maxEmpleado(sessionBeanEMP.getCompania().getCodCia(), g));

            empleado = new Empleados();
            empleado.setEmpleadosPK(empleadoPK);

            empleado.setFecIngreso(candidato.getFecIngreso());
            empleado.setNombres(candidato.getNombre());
            empleado.setApellidos(candidato.getApellido());
            empleado.setApCasada(candidato.getApCasada());
            empleado.setEstadoCivil(candidato.getEstadoCivil());
            empleado.setSexo(candidato.getSexo());
            empleado.setCorreo(candidato.getEmail());

            empleado.setCodPais(candidato.getCodPaisNacimiento());
            empleado.setCodDepar(candidato.getCodDepartamentoNacim());
            empleado.setCodMuni(candidato.getCodMunicipioNacim());
            empleado.setTelefonos(candidato.getTelefono());
            empleado.setDireccion(candidato.getDireccion());

            empleado.setFechaNac(candidato.getFechaNac());

            empleado.setCodPaisNacimiento(candidato.getCodPaisNacimiento());
            empleado.setCodDepartamentoNacim(candidato.getCodDepartamentoNacim());
            empleado.setCodMunicipioNacim(candidato.getCodMunicipioNacim());

            empleado.setCodPaisNacionalidad(candidato.getCodPaisNacionalidad());

            empleado.setTipoSangre(candidato.getTipoSangre());

            empleado.setNumDui(candidato.getNumDui());
            empleado.setNumNit(candidato.getNomNit());
            empleado.setFechaDui(candidato.getFechaExpDui());

//        String[] deptoExpDUIPKStr = generales$departamentoExpDui.split(":");
//        String[] municipioExpDUIStr = generales$municipioExpDui.split(":");
//        DeptosPK deptoExpDUI = new DeptosPK(new Short(deptoExpDUIPKStr[0]), new Short(deptoExpDUIPKStr[1]));
//        MunicipiosPK municipioExpDUI = new MunicipiosPK(new Short(municipioExpDUIStr[0]), new Short(municipioExpDUIStr[1]), new Short(municipioExpDUIStr[2]));

            empleado.setExpedicionDui(candidato.getExpedicionDui());
            empleado.setMuniExpDui(candidato.getMuniExpDui());

            empleado.setLicencia(candidato.getNumLicencia());
            empleado.setNombreIsss(candidato.getNomIsss());
            empleado.setNumIrtra(candidato.getNumIrtra());
            empleado.setNumIgss(candidato.getNumIsss());
            empleado.setNombreRenta(candidato.getNomNit());

            empleado.setNombreConyuge(candidato.getNombreConyuge());
            empleado.setTrabajoConyuge(candidato.getTrabajoConyuge());
            empleado.setTelefonoConyuge(candidato.getTelefonoConyuge());

            empleado.setCondicionSalud(candidato.getCondicionSalud());
            empleado.setActividadLimitada(candidato.getActividadLimitada());
            empleado.setTieneAccidente(candidato.getTieneAccidente());
            empleado.setTipoAccidente(candidato.getTipoAccidente());
            empleado.setPeso(candidato.getPeso());
            empleado.setEstatura(candidato.getEstatura());

            empleado.setRepresentantePatronal(reclutamientoSessionBean.getRepresentantePatronal(getSessionBeanEMP().getCompania()));
            empleado.setObservacion(observaciones);
            empleado.setStatus("A");

            empleadosSessionBean.crearEmpleado(empleado);
            empleado = empleadosSessionBean.buscarEmpleadoPorPK(empleado.getEmpleadosPK()); //reclutamientoFacade.findCandidatoById(candidato.getCandidatoPK());

            // =======================================================================================================
            List<NivelesXCandidato> listaNiveles = reclutamientoSessionBean.findNivelCandidatoByCandidato(candidato);

            i = 0;
            for (NivelesXCandidato nivelCandidato : listaNiveles)
                {
                NivelesXEmpPK nivelEmpPK = new NivelesXEmpPK();
                nivelEmpPK.setCodCia(nivelCandidato.getNivelesXCandidatoPK().getCodCia());
                nivelEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                nivelEmpPK.setCodNivel(new Short("" + (++i)));

                NivelesXEmp nivelEmp = new NivelesXEmp();
                nivelEmp.setNivelesXEmpPK(nivelEmpPK);
                nivelEmp.setEmpleados(empleado);
                nivelEmp.setNomInstitucion(nivelCandidato.getNomInstitucion());
                nivelEmp.setCodPais(nivelCandidato.getCodPais());
                nivelEmp.setCodDepto(nivelCandidato.getCodDepto());
                nivelEmp.setAnioIngreso(nivelCandidato.getAnioIngreso());
                nivelEmp.setAnioEgreso(nivelCandidato.getAnioEgreso());
                nivelEmp.setEstadoNivel(nivelCandidato.getEstadoNivel());
                nivelEmp.setSubNivel(nivelCandidato.getSubNivel());
                empleadosSessionBean.crearNivelXEmpleado(nivelEmp);
                }

            List<EmergenciaXCandidato> listaEmergencias = reclutamientoSessionBean.findEmergenciasByCandidato(candidato);

            i = 0;
            for (EmergenciaXCandidato emergenciaCandidato : listaEmergencias)
                {
                EmergenciaXEmpPK emergenciaEmpPK = new EmergenciaXEmpPK();
                emergenciaEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                emergenciaEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                emergenciaEmpPK.setCodEmergencia(++i);

                EmergenciaXEmp emergenciaEmp = new EmergenciaXEmp();
                emergenciaEmp.setEmergenciaXEmpPK(emergenciaEmpPK);
                emergenciaEmp.setEmpleados(empleado);
                emergenciaEmp.setNombre(emergenciaCandidato.getNombre());
                emergenciaEmp.setTelefono(emergenciaCandidato.getTelefono());
                emergenciaEmp.setCodParentesco(emergenciaCandidato.getCodParentesco());

                empleadosSessionBean.crearEmergenciaEmpleado(emergenciaEmp);
                }

            List<ExpLaboralCandidato> listaExperiencias = reclutamientoSessionBean.findExperienciasLaboralesByCandidato(candidato);

            i = 0;
            for (ExpLaboralCandidato elc : listaExperiencias)
                {
                ExpLaboralEmpleadoPK expLaboralEmpleadoPK = new ExpLaboralEmpleadoPK();
                expLaboralEmpleadoPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                expLaboralEmpleadoPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                expLaboralEmpleadoPK.setCodExpLaboral(++i);

                ExpLaboralEmpleado expLaboralEmpleado = new ExpLaboralEmpleado(expLaboralEmpleadoPK);
                expLaboralEmpleado.setEmpleados(empleado);
                expLaboralEmpleado.setLugarTrabajo(elc.getLugarTrabajo());
                expLaboralEmpleado.setPuestos(elc.getPuestos());
                expLaboralEmpleado.setFechaInicio(elc.getFechaInicio());
                expLaboralEmpleado.setFechaFin(elc.getFechaFin());
                expLaboralEmpleado.setMotivoRetiro(elc.getMotivoRetiro());

                empleadosSessionBean.crearExpLaboralEmpleado(expLaboralEmpleado);
                }

            List<Referencia> listaReferencias = reclutamientoSessionBean.findReferenciasByCandidato(candidato);

            i = 0;
            for (Referencia referenciaLaboral : listaReferencias)
                {
                ReferenciaEmpPK referenciaEmpPK = new ReferenciaEmpPK();
                referenciaEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                referenciaEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                referenciaEmpPK.setCodReferencia(++i);

                ReferenciaEmp referenciaEmp = new ReferenciaEmp();
                referenciaEmp.setReferenciaEmpPK(referenciaEmpPK);
                referenciaEmp.setEmpleados(empleado);
                referenciaEmp.setTipoReferencia(referenciaLaboral.getTipoReferencia());
                referenciaEmp.setNomReferencia(referenciaLaboral.getNomReferencia());
                referenciaEmp.setLugar(referenciaLaboral.getLugar());
                referenciaEmp.setEmail(referenciaLaboral.getEmail());
                referenciaEmp.setTelefono(referenciaLaboral.getTelefono());
                referenciaEmp.setTiempo(referenciaLaboral.getTiempo());

                empleadosSessionBean.crearReferenciaEmpleado(referenciaEmp);
                }

            List<DocumentoPresentado> listaDocumentos = reclutamientoSessionBean.findDocumentosByCandidato(candidato);

            i = 0;
            for (DocumentoPresentado documentoCandidato : listaDocumentos)
                {
                DocumentoPresEmpPK dPK = new DocumentoPresEmpPK();
                dPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                dPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                dPK.setCodDocumentoPres(++i);

                DocumentoPresEmp d = new DocumentoPresEmp();
                d.setDocumentoPresEmpPK(dPK);
                d.setEmpleados(empleado);
                d.setTipoDocumento(documentoCandidato.getTipoDocumento());
                d.setObservacion(documentoCandidato.getObservacion());

                empleadosSessionBean.crearDocumentoEmpleado(d);
                }

            List<CapacitacionXCandidato> listaCapacitaciones = reclutamientoSessionBean.findCapacitacionesByCandidato(candidato);

            i = 0;
            for (CapacitacionXCandidato capacitacionCandidato : listaCapacitaciones)
                {
                CapacitacionXEmpPK capacitacionXEmpPK = new CapacitacionXEmpPK();
                capacitacionXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                capacitacionXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                capacitacionXEmpPK.setCodCapacitacion(++i);

                CapacitacionXEmp capacitacionXEmp = new CapacitacionXEmp();
                capacitacionXEmp.setCapacitacionXEmpPK(capacitacionXEmpPK);
                capacitacionXEmp.setEmpleados(empleado);
                capacitacionXEmp.setTipo(capacitacionCandidato.getTipo());
                capacitacionXEmp.setDescripcion(capacitacionCandidato.getDescripcion());
                capacitacionXEmp.setNomInstitucion(capacitacionCandidato.getNomInstitucion());
                capacitacionXEmp.setFecha(capacitacionCandidato.getFecha());

                empleadosSessionBean.crearCapacitacionEmpleado(capacitacionXEmp);
                }

            List<DependienteXCandidato> listaDependientes = reclutamientoSessionBean.findDependientesByCandidato(candidato);

            i = 0;
            for (DependienteXCandidato dependienteCandidato : listaDependientes)
                {
                DependienteXEmpPK dependienteXEmpPK = new DependienteXEmpPK();
                dependienteXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                dependienteXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                dependienteXEmpPK.setCodDependiente(++i);

                DependienteXEmp dependienteXEmp = new DependienteXEmp();
                dependienteXEmp.setDependienteXEmpPK(dependienteXEmpPK);
                dependienteXEmp.setEmpleados(empleado);
                dependienteXEmp.setCodParentesco(dependienteCandidato.getCodParentesco());
                dependienteXEmp.setFechaNacimiento(dependienteCandidato.getFechaNacimiento());
                dependienteXEmp.setNombre(dependienteCandidato.getNombre());

                empleadosSessionBean.crearDependienteEmpleado(dependienteXEmp);
                }

            List<IdiomaXCandidato> listaIdiomas = reclutamientoSessionBean.findIdiomasByCandidato(candidato);

            i = 0;
            for (IdiomaXCandidato idiomaCandidato : listaIdiomas)
                {
                IdiomaXEmpPK idiomaXEmpPK = new IdiomaXEmpPK();
                idiomaXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                idiomaXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                idiomaXEmpPK.setCodIdioma(++i);

                IdiomaXEmp idiomaXEmp = new IdiomaXEmp(idiomaXEmpPK);
                idiomaXEmp.setEmpleados(empleado);
                idiomaXEmp.setLee(idiomaCandidato.getLee());
                idiomaXEmp.setEscribe(idiomaCandidato.getEscribe());
                idiomaXEmp.setNivel(idiomaCandidato.getNivel());

                empleadosSessionBean.crearIdiomaEmpleado(idiomaXEmp);
                }

            List<BeneficiarioXCandidato> listaBeneficiariosCandidato = reclutamientoSessionBean.findBeneficiariosByCandidato(candidato);

            i = 0;
            for (BeneficiarioXCandidato beneficiarioCandidato : listaBeneficiariosCandidato)
                {
                BeneficiarioXEmpPK beneficiarioXEmpPK = new BeneficiarioXEmpPK();
                beneficiarioXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                beneficiarioXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                beneficiarioXEmpPK.setCodBeneficiario(++i);

                BeneficiarioXEmp beneficiarioXEmp = new BeneficiarioXEmp(beneficiarioXEmpPK);
                beneficiarioXEmp.setEmpleados(empleado);
                beneficiarioXEmp.setNombre(beneficiarioCandidato.getNombre());
                beneficiarioXEmp.setParentesco(beneficiarioCandidato.getParentesco());

                empleadosSessionBean.crearBeneficiarioEmpleado(beneficiarioXEmp);
                }

            if (candidato.getEquipoList() != null)
                {
                List<Equipo> equiposCandidato = candidato.getEquipoList();
                for (Equipo equipoCandidato : equiposCandidato)
                    {
                    empleado.getEquipoList().add(equipoCandidato);
                    }
                empleadosSessionBean.editarEmpleado(empleado);
                }

            List<TipoPruebaXCandidato> listaPruebas = reclutamientoSessionBean.findTiposPruebasByCandidato(candidato);

            i = 0;
            for (TipoPruebaXCandidato pruebaCandidato : listaPruebas)
                {
                TipoPruebaXEmpPK tipoPruebaXEmpPK = new TipoPruebaXEmpPK();
                tipoPruebaXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                tipoPruebaXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                tipoPruebaXEmpPK.setCodTipoPrueba(new Short("" + (++i)));

                TipoPruebaXEmp tipoPruebaXEmp = new TipoPruebaXEmp(tipoPruebaXEmpPK);
                tipoPruebaXEmp.setEmpleados(empleado);
                tipoPruebaXEmp.setTipoPrueba(pruebaCandidato.getTipoPrueba());
                tipoPruebaXEmp.setFecha(pruebaCandidato.getFecha());
                tipoPruebaXEmp.setCosto(pruebaCandidato.getCosto());
                tipoPruebaXEmp.setNota(pruebaCandidato.getNota());
                tipoPruebaXEmp.setResultado(pruebaCandidato.getResultado());

                empleadosSessionBean.crearPruebaEmpleado(tipoPruebaXEmp);
                }

            List<CandidatoXCargo> listaCargos = reclutamientoSessionBean.findCargosByCandidato(candidato);

            for (CandidatoXCargo puestoCandidato : listaCargos)
                {
                EmpXCargoPK empleadoCargoPK = new EmpXCargoPK();
                empleadoCargoPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                empleadoCargoPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                empleadoCargoPK.setCodPuesto(puestoCandidato.getCandidatoXCargoPK().getCodPuesto());

                EmpXCargo empleadoCargo = new EmpXCargo();
                empleadoCargo.setEmpXCargoPK(empleadoCargoPK);
                empleadoCargo.setEmpleados(empleado);
                empleadoCargo.setPuestos(puestoCandidato.getPuestos());
                empleadoCargo.setCodTipoPuesto(puestoCandidato.getCodTipoPuesto());
                empleadoCargo.setSalarioAspirado(puestoCandidato.getSalarioAspirado());

                empleadosSessionBean.crearPuestoEmpleado(empleadoCargo);
                }

            List<EntrevistaXCandidato> listaEntrevistas = reclutamientoSessionBean.findEntrevistasByCandidato(candidato);

            for (EntrevistaXCandidato entrevistaCandidato : listaEntrevistas)
                {
                EntrevistaXEmpPK entrevistaXEmpPK = new EntrevistaXEmpPK();
                entrevistaXEmpPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                entrevistaXEmpPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
                entrevistaXEmpPK.setCodPuesto(entrevistaCandidato.getPuesto().getPuestosPK().getCodPuesto());
                entrevistaXEmpPK.setCodEntrevista(empleadosSessionBean.maxEntrevistaEmpleado(entrevistaCandidato.getPuesto(), empleado));

                EntrevistaXEmp entrevistaXEmp = new EntrevistaXEmp(entrevistaXEmpPK);
                entrevistaXEmp.setEntrevistaXEmpPK(entrevistaXEmpPK);
                entrevistaXEmp.setEmpleado(empleado);
                entrevistaXEmp.setFecha(entrevistaCandidato.getFecha());
                entrevistaXEmp.setPuesto(entrevistaCandidato.getPuesto());
                entrevistaXEmp.setEntrevistador(entrevistaCandidato.getEntrevistador());
                entrevistaXEmp.setDescripcion(entrevistaCandidato.getDescripcion());
                entrevistaXEmp.setResultado(entrevistaCandidato.getResultado());

                empleadosSessionBean.crearEntrevistaEmpleado(entrevistaXEmp);
                }

            empleadosSessionBean.editarEmpleado(empleado);
            empleado = empleadosSessionBean.buscarEmpleadoPorPK(empleado.getEmpleadosPK());
            addMessage("Registro de empleados", "Datos guardados exitosamente", TipoMensaje.INFORMACION);
            return empleado;
            }
        catch (Exception e)
            {
            e.printStackTrace(System.err);
            addMessage("Registro de empleados", e.toString(), TipoMensaje.ERROR_FATAL);
            return null;
            }
    }

    public List<Empleados> getListaJefes()
    {
        return listaJefes;
    }

    public void setListaJefes(List<Empleados> listaJefes)
    {
        this.listaJefes = listaJefes;
    }
}