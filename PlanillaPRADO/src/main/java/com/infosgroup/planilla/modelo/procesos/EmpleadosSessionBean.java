/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.*;
import com.infosgroup.planilla.modelo.facades.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author root 
 */
@Stateless
@LocalBean
public class EmpleadosSessionBean
{

@EJB
private transient CampaniaFacade campaniasFacade;
@EJB
private transient EmpleadoFacade empleadosFacade;
@EJB
private transient FactorFacade factorFacade;
@EJB
private transient RespuestaFacade respuestaFacade;
@EJB
private transient DetEvaluacionFacade detalleEvaluacionFacade;
@EJB
private transient EvaluacionFacade evaluacionFacade;
@EJB
private transient PuestoFacade puestoFacade;
@EJB
private transient TipoEvaluacionFacade tipoEvaluacionFacade;
@EJB
private transient GerenciaFacade gerenciaFacade;
@EJB
private transient PreguntaFacade preguntaFacade;
@EJB
private transient PlantillaFacade plantillaFacade;
@EJB
private transient PreEvaluacionFacade preEvaluacionFacade;
@EJB
private transient EvaluadorFacade evaluadorFacade;
@EJB
private transient EvaluadoFacade evaluadoFacade;
@EJB
private transient EmergenciaXEmpleadoFacade emergenciaXEmpFacade;
@EJB
private transient DocumentoPresentadoEmpFacade documentoEmpleadoFacade;
@EJB
private transient NivelesXEmpleadoFacade nivelesEmpleadoFacade;
@EJB
private transient CapacitacionXEmpFacade capacitacionEmpleadoFacade;
@EJB
private transient DependienteXEmpleadoFacade dependienteEmpleadoFacade;
@EJB
private transient IdiomaXEmpFacade idiomaEmpleadoFacade;
@EJB
private transient BeneficiarioXEmpleadoFacade beneficiarioEmpleadoFacade;
@EJB
private transient TipoPruebaXEmpleadoFacade tipoPruebaEmpleadoFacade;
@EJB
private transient EntrevistaXEmpleadoFacade entrevistasEmpFacade;
@EJB
private transient EmpXCargoFacade empCargoFacade;
@EJB
private transient ReferenciaEmpFacade referenciasEmpleadoFacade;
@EJB
private transient ExpLaboralEmpleadoFacade expLaboralEmpleadoFacade;

@PermitAll
public void EliminarEvaluacion(Evaluacion evaluacion)
{
    evaluacionFacade.remove(evaluacion);
}

@PermitAll
public void guardarEvaluacion(Evaluacion evaluacion)
{
    evaluacionFacade.create(evaluacion);
}

@PermitAll
public void editarEvaluacion(Evaluacion evaluacion)
{
    evaluacionFacade.refresh(evaluacion);
}

@PermitAll
public List<Evaluador> findEvaluadoresByPreEvaluacion(PreEvaluacion preEvaluacion)
{
    return evaluadorFacade.findByPreEvaluacion(preEvaluacion);
}

@PermitAll
public void guardarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.create(evaluador);
}

@PermitAll
public void eliminarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.remove(evaluador);
}

@PermitAll
public void eliminarEvaluado(Evaluado evaluado)
{
    evaluadoFacade.remove(evaluado);
}

@PermitAll
public void guardarEvaluado(Evaluado evaluado)
{
    evaluadoFacade.create(evaluado);
}

@PermitAll
public void eliminarEvaluados(Evaluador evaluador)
{
    evaluadoFacade.eliminarEvaluados(evaluador);
}

@PermitAll
public void editarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.edit(evaluador);
}

@PermitAll
public List<Campania> listarCampanias(Cias cia)
{
    return campaniasFacade.findAllByCia(cia.getCodCia());
}

@PermitAll
public List<PreEvaluacion> findPreevaluacionByCias(Cias cias)
{
    return preEvaluacionFacade.findPreevaluacionByCias(cias);
}

@PermitAll
public List<Campania> listarCampaniasPorEmpleado(Empleados empleado)
{
    return campaniasFacade.findByEmpleadoEvaluador(empleado);
}

@PermitAll
public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
    return plantillaFacade.findPlantillasByTipoEvaluacion(tipoEvaluacion);
    //return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
}

@PermitAll
public List<Factor> listarFactoresPorPlantilla(Plantilla plantilla)
{
    return factorFacade.findByPlantilla(plantilla);
}

@PermitAll
public List<com.infosgroup.planilla.modelo.entidades.Pregunta> listarPreguntasPorFactor(Factor factor)
{
    return preguntaFacade.findPreguntasByFactor2(factor);
    //return (factor != null) ? factor.getPreguntaList() : null;
}

@PermitAll
public Respuesta findRespuestaById(RespuestaPK pk)
{
    return respuestaFacade.find(pk);
}

@PermitAll
public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania, Empleados empleado)
{
    return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania, empleado);
}

@PermitAll
public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania)
{
    return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania);
}

@PermitAll
public boolean cerrarEvaluacion(Evaluacion ev, List<DetalleEvaluacion> det)
{
    boolean result = true;
    Integer i = 1;
    try
        {
        for (DetalleEvaluacion d : det)
            {
            List<PreguntaRespuesta> preguntasRespuestasList = d.getRespuestas();
            for (PreguntaRespuesta pr : preguntasRespuestasList)
                {
                DetEvaluacionPK detEvaluacionPK = new DetEvaluacionPK();
                detEvaluacionPK.setCodCia(ev.getEvaluacionPK().getCodCia());
                detEvaluacionPK.setCodCampania(ev.getEvaluacionPK().getCodCampania());
                detEvaluacionPK.setTipoEvaluacion(new Short("" + ev.getEvaluacionPK().getTipoEvaluacion()));
                detEvaluacionPK.setCodEmp(ev.getEmpleados().getEmpleadosPK().getCodEmp());
                detEvaluacionPK.setPeriodo(new Short("" + ev.getCampania().getCampaniaPK().getPeriodo()));                
                detEvaluacionPK.setCodDetEvaluacion(i++);
                

                DetEvaluacion detEvaluacion = new DetEvaluacion();                
                detEvaluacion.setEvaluacion(ev);
                
                
                detEvaluacion.setDetEvaluacionPK(detEvaluacionPK);
                detEvaluacion.setValor(pr.getValor());
                detEvaluacion.setPregunta(preguntaFacade.find(pr.getPregunta().getPreguntaPK()));
                detEvaluacion.setRespuesta(pr.getRespuesta());

                detalleEvaluacionFacade.create(detEvaluacion);
                }
            }
        ev.setFinalizada(1L);
        evaluacionFacade.edit(ev);
        }
    catch (Exception excpt)
        {
        result = false;
        }
    return result;
}

@PermitAll
public List<Empleados> listarPuestosEmpleados(Cias cia)
{
    return empleadosFacade.findEmpleadosByCias(cia);
}

@PermitAll
public List<Empleados> listarEmpleadosEvaluados(Campania c)
{
    return empleadosFacade.findEmpleadosEvaluados(c);
}

@PermitAll
public List<Empleados> listarEmpleadosNoEvaluados(Campania c)
{
    return empleadosFacade.findEmpleadosNoEvaluados(c);
}

@PermitAll
public Empleados buscarEmpleadoPorUsuario(String usuario) throws javax.persistence.NoResultException
{
    return empleadosFacade.findByUsuario(usuario);
}

@PermitAll
public Empleados buscarEmpleadoPorPK(EmpleadosPK empleadoPK)
{
    return empleadosFacade.find(empleadoPK);
}

@PermitAll
public List<Puestos> listarPuestos()
{
    return puestoFacade.findAll();
}

@PermitAll
public List<TipoEvaluacion> listarTiposEvaluacion(Cias c)
{
    return tipoEvaluacionFacade.findByCompania(c);
}

@PermitAll
public Integer crearEvaluaciones(List<Evaluacion> listaEvaluaciones)
{
    Integer excepciones = 0;
    for (Evaluacion evaluacion : listaEvaluaciones)
        {
        try
            {
            evaluacionFacade.create(evaluacion);
            }
        catch (Exception excpt)
            {
            excepciones++;
            }
        }
    return excepciones;
}

public Boolean tieneEvaluaciones(Campania c)
{
    return (evaluacionFacade.findEvaluacionesByCampania(c) != 0);
}

@PermitAll
public Integer asignarEvaluaciones(List<Evaluacion> listaEvaluaciones, Empleados evaluador)
{
    Integer excepciones = 0;
    List<Evaluacion> evaluacionesActuales = evaluador.getEvaluacionList();
    for (Evaluacion evaluacion : listaEvaluaciones)
        {
        if (!evaluacionesActuales.contains(evaluacion))
            {
            evaluacionesActuales.add(evaluacion);
            }
        }
    try
        {
        evaluador.setEvaluacionList(evaluacionesActuales);
        empleadosFacade.edit(evaluador);
        }
    catch (Exception excpt)
        {
        excepciones += listaEvaluaciones.size();
        }
    return excepciones;
}

@PermitAll
public List<Gerencia> listarGerencias(Cias cias)
{
    return gerenciaFacade.findGerenciasByCias(cias);
}

@PermitAll
public List<HeadCountModel> generarHeadCount(Gerencia gerencia)
{
    List<HeadCountModel> lista = new ArrayList<HeadCountModel>(0);
    List<Object> listaResultado = gerenciaFacade.generarHeadCount(gerencia);
    for (Object o : listaResultado)
        {
        Object[] fila = (Object[]) o;
        HeadCountModel hcm = new HeadCountModel((BigDecimal) fila[0], (BigDecimal) fila[1], (String) fila[2], (BigDecimal) fila[3], (String) fila[4], (BigDecimal) fila[5], (String) fila[6], (BigDecimal) fila[7], (BigDecimal) fila[8]);
        lista.add(hcm);
        }
    return lista;
}

@PermitAll
public Gerencia findGerenciaByPK(GerenciaPK gerenciaPK)
{
    return gerenciaFacade.find(gerenciaPK);
}

@PermitAll
public List<Empleados> listarEmpleados()
{
    return empleadosFacade.findAll();
}

@PermitAll
public Integer calcularEmpleadosEvaluados(Campania c)
{
    Integer r;
    r = campaniasFacade.calcularEmpleadosEvaluados(c);
    return r;
}

@PermitAll
public void editarCampania(Campania c)
{
    campaniasFacade.edit(c);
}

@PermitAll
public Campania findCampaniaByPK(CampaniaPK campaniaPK)
{
    return campaniasFacade.find(campaniaPK);
}

@PermitAll
public List<Campania> findAllByCia(Short empresa)
{
    return campaniasFacade.findAllByCia(empresa);
}

@PermitAll
public List<Empleados> findEmpleadosByCias(Cias empresa)
{
    return empleadosFacade.findEmpleadosByCias(empresa);
}

@PermitAll
public Integer maxCampania(Cias cia)
{
    return campaniasFacade.max(cia);
}

@PermitAll
public void crearCampania(Campania c)
{
    campaniasFacade.create(c);
}

@PermitAll
public void crearPreEvaluacion(PreEvaluacion p)
{
    preEvaluacionFacade.create(p);
}

@PermitAll
public List<Empleados> findEmpleadosByJefe(Empleados jefe)
{
    return empleadosFacade.findEmpleadosByJefe(jefe);
}

@PermitAll
public List<Evaluado> findEvaluadosByJefe(Evaluador evaluador)
{
    List<Empleados> l = findEmpleadosByJefe(evaluador.getEmpleados());
    List<Evaluado> evls = new ArrayList<Evaluado>();
    for (Empleados e : l)
        {
        evls.add(new Evaluado(evaluador, e));
        }
    return evls;
}

@PermitAll
public void editarPreEvaluacion(PreEvaluacion p)
{
    preEvaluacionFacade.edit(p);
}

/*@PermitAll
public Integer maxEmpleado(Short codCia)
{
    return empleadosFacade.max(codCia);
}*/

@PermitAll
public Integer maxEmpleado(Short codCia, Gerencia g)
{
    return empleadosFacade.max(codCia, g);
}

@PermitAll
public void crearEmpleado(Empleados e)
{
    empleadosFacade.create(e);
}

@PermitAll
public void editarEmpleado(Empleados e)
{
    empleadosFacade.edit(e);
}

@PermitAll
public List<NivelesXEmp> findNivelesByEmpleado(Empleados e)
{
    return nivelesEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void crearNivelXEmpleado(NivelesXEmp nxe)
{
    nivelesEmpleadoFacade.create(nxe);
}

@PermitAll
public void eliminarNivelEmpleado(NivelesXEmp nxe)
{
    nivelesEmpleadoFacade.remove(nxe);
}

@PermitAll
public List<EmergenciaXEmp> findEmergenciasByEmpleado(Empleados e)
{
    return emergenciaXEmpFacade.findByEmpleado(e);
}

@PermitAll
public void crearEmergenciaEmpleado(EmergenciaXEmp exe)
{
    emergenciaXEmpFacade.create(exe);
}

@PermitAll
public void eliminarEmergenciaEmpleado(EmergenciaXEmp exe)
{
    emergenciaXEmpFacade.remove(exe);
}

@PermitAll
public List<DocumentoPresEmp> findDocumentosByEmpleado(Empleados empleado)
{
    return documentoEmpleadoFacade.findByEmpleado(empleado);
}

@PermitAll
public void crearDocumentoEmpleado(DocumentoPresEmp dpe)
{
    documentoEmpleadoFacade.create(dpe);
}

@PermitAll
public void eliminarDocumentoEmpleado(DocumentoPresEmp dpe)
{
    documentoEmpleadoFacade.remove(dpe);
}

@PermitAll
public List<CapacitacionXEmp> findCapacitacionesByEmpleado(Empleados e)
{
    return capacitacionEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void crearCapacitacionEmpleado(CapacitacionXEmp cxe)
{
    capacitacionEmpleadoFacade.create(cxe);
}

@PermitAll
public void eliminarCapacitacionEmpleado(CapacitacionXEmp cxe)
{
    capacitacionEmpleadoFacade.remove(cxe);
}

@PermitAll
public List<DependienteXEmp> findDependientesByEmpleado(Empleados e)
{
    return dependienteEmpleadoFacade.findByCandidato(e);
}

@PermitAll
public void crearDependienteEmpleado(DependienteXEmp dxe)
{
    dependienteEmpleadoFacade.create(dxe);
}

@PermitAll
public void eliminarDependienteEmpleado(DependienteXEmp dxe)
{
    dependienteEmpleadoFacade.remove(dxe);
}

@PermitAll
public List<IdiomaXEmp> findIdiomasByEmpleado(Empleados e)
{
    return idiomaEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void crearIdiomaEmpleado(IdiomaXEmp ixe)
{
    idiomaEmpleadoFacade.create(ixe);
}

@PermitAll
public void eliminarIdiomaEmpleado(IdiomaXEmp ixe)
{
    idiomaEmpleadoFacade.remove(ixe);
}

@PermitAll
public List<BeneficiarioXEmp> findBeneficiariosByEmpleado(Empleados e)
{
    return beneficiarioEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void crearBeneficiarioEmpleado(BeneficiarioXEmp bxe)
{
    beneficiarioEmpleadoFacade.create(bxe);
}

@PermitAll
public void eliminarBeneficiarioEmpleado(BeneficiarioXEmp bxe)
{
    beneficiarioEmpleadoFacade.remove(bxe);
}

@PermitAll
public List<TipoPruebaXEmp> findTiposPruebasByEmpleado(Empleados e)
{
    return tipoPruebaEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void crearPruebaEmpleado(TipoPruebaXEmp tpxe)
{
    tipoPruebaEmpleadoFacade.create(tpxe);
}

@PermitAll
public void eliminarPruebaEmpleado(TipoPruebaXEmp tpxe)
{
    tipoPruebaEmpleadoFacade.remove(tpxe);
}

@PermitAll
public List<EntrevistaXEmp> findEntrevistasByEmpleado(Empleados e)
{
    return entrevistasEmpFacade.findByEmpleado(e);
}

@PermitAll
public Short maxEntrevistaEmpleado(Puestos p, Empleados e)
{
    return entrevistasEmpFacade.max(p, e);
}

@PermitAll
public void crearEntrevistaEmpleado(EntrevistaXEmp exe)
{
    entrevistasEmpFacade.create(exe);
}

@PermitAll
public void eliminarEntrevistaEmpleado(EntrevistaXEmp exe)
{
    entrevistasEmpFacade.remove(exe);
}

@PermitAll
public List<EmpXCargo> findCargosByEmpleado(Empleados e)
{
    return empCargoFacade.findByEmpleado(e);
}

@PermitAll
public void crearPuestoEmpleado(EmpXCargo exc)
{
    empCargoFacade.create(exc);
}

@PermitAll
public void eliminarPuestoEmpleado(EmpXCargo exc)
{
    empCargoFacade.remove(exc);
}

@PermitAll
public List<ReferenciaEmp> findReferenciasByEmpleado(Empleados e)
{
    return referenciasEmpleadoFacade.findByEmpleado(e);
}

@PermitAll
public void eliminarReferenciaEmpleado(ReferenciaEmp re)
{
    referenciasEmpleadoFacade.remove(re);
}

@PermitAll
public void crearReferenciaEmpleado(ReferenciaEmp re)
{
    referenciasEmpleadoFacade.create(re);
}

@PermitAll
public Integer maxExpLaboralEmpleado(Empleados e)
{
    return expLaboralEmpleadoFacade.max(e);
}

@PermitAll
public void crearExpLaboralEmpleado(ExpLaboralEmpleado ele)
{
    expLaboralEmpleadoFacade.create(ele);
}

@PermitAll
public void eliminarExpLaboralEmpleado(ExpLaboralEmpleado ele)
{
    expLaboralEmpleadoFacade.remove(ele);
}

@PermitAll
public List<ExpLaboralEmpleado> findExperienciasLaboralesByEmpleado(Empleados e)
{
return expLaboralEmpleadoFacade.findByEmpleado(e);
}
}