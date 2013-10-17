/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.*;  
import java.math.BigDecimal; 
import java.util.ArrayList;  
import java.util.List; 
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;   
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;      
import javax.persistence.Query;
import javax.persistence.TypedQuery;  
import javax.persistence.criteria.CriteriaBuilder;   
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
    
/**
 *
 * @author root
 */
@LocalBean
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleados, EmpleadosPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public EmpleadoFacade()
{
    super(Empleados.class);
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> findEmpleadosEvaluados(Campania c)
{
    Query q = em.createNativeQuery("select em.* from empleados em where (cod_cia, em.cod_emp) in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
    q.setParameter(1, c.getCampaniaPK().getCodCia());
    q.setParameter(2, c.getCampaniaPK().getPeriodo());
    q.setParameter(3, c.getCampaniaPK().getCodCampania());
    List<Empleados> le = (List<Empleados>) q.getResultList();
    return le;
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> findEmpleadosNoEvaluados(Campania c)
{
    Query q = em.createNativeQuery("select em.* from empleados em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
    q.setParameter(1, c.getCampaniaPK().getCodCia());
    q.setParameter(2, c.getCampaniaPK().getPeriodo());
    q.setParameter(3, c.getCampaniaPK().getCodCampania());
    List<Empleados> le = (List<Empleados>) q.getResultList();
    return le;
}

@PermitAll
public Empleados findByUsuario(String usuario) throws javax.persistence.NoResultException
{
    try
        {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleados> cq = cb.createQuery(Empleados.class);
        Root<Empleados> empleado = cq.from(Empleados.class);
        cq.select(empleado).where(cb.equal(empleado.get(Empleados_.usuario), usuario));
        TypedQuery<Empleados> tq = getEntityManager().createQuery(cq);
        Empleados e = tq.getSingleResult(); 
        return e; 
        }
    catch (Exception excpt)
        {
        excpt.printStackTrace(System.err);
        return null;
        }
}

@PermitAll
public List<Empleados> findByPuedeEntrevistar(Cias cia)
{
    TypedQuery<Empleados> tq = em.createQuery("SELECT e FROM Empleados e WHERE e.cias = :compania AND e.puedeEntrevistar = 'S'", entityClass);
    tq.setParameter("compania", cia);
    List<Empleados> listaJefes = tq.getResultList();
    return (listaJefes != null) ? listaJefes : new ArrayList<Empleados>();
}

/*@PermitAll
public Integer max(short empresa)
{
    Integer max = (Integer) em.createQuery("SELECT max(e.empleadosPK.codEmp) FROM Empleados e WHERE e.empleadosPK.codCia = :codCia").setParameter("codCia", empresa).getSingleResult();
    return max != null ? (++max) : 1;
}*/

@PermitAll
public Integer max(short empresa, Gerencia g)
{
    Query q = getEntityManager().createNativeQuery("select nvl(max(cod_emp),0) from empleados a, gerencia g where cod_emp - mod(cod_emp, ?1) = ?2");
    q.setParameter(1, g.getBase());
    q.setParameter(2, g.getCodigo());
    Integer max = ((BigDecimal) q.getSingleResult()).intValueExact();
    return max != null ? (++max) : 1;
}

@PermitAll
public Empleados toEmpleado(Candidato c, Gerencia g)
{
    Empleados e = new Empleados();
    EmpleadosPK pk = new EmpleadosPK(c.getCandidatoPK().getCodCia(), max(c.getCandidatoPK().getCodCia(), g).intValue());
    e.setEmpleadosPK(pk);
//    if (c != null)
//        {
    e.setNombres(c.getNombre());
    e.setApellidos(c.getApellido());
    e.setApCasada(c.getApCasada());
    e.setFechaNac(c.getFechaNac());
    e.setObservacion(c.getObservacion());
    e.setCodPais(c.getCodPaisNacimiento());
//        }
    return e;
}

@PermitAll
public String generaUsuario(Candidato c)
{
    String nombre = "", apellido = "", user = "";
    int n = 0;
    nombre = c.getNombre() != null ? c.getNombre().split(" ")[0] : "";
    apellido = c.getApellido() != null ? c.getApellido().split(" ")[0] : "";
    user = nombre + apellido;
    for (;;)
        {
        if (em.createNamedQuery("Empleados.findByUsuario", Empleados.class).setParameter("usuario", user).getResultList().isEmpty())
            {
            break;
            }
        user += n;
        n++;
        }
    return user;
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> findEmpleadosByUsuario(String usuario)
{
    Query q = em.createNamedQuery("Empleados.findByUsuario", Empleados.class);
    q.setParameter("usuario", usuario);
    List<Empleados> lista = q.getResultList();
    return lista != null ? lista : new ArrayList<Empleados>();
}

@PermitAll
public Integer totalAfectadosDepartamentos(Departamentos departamento)
{
    Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A' ").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getSingleResult();
    return t != null ? t.intValue() : 0;
}

@PermitAll
public Integer totalAfectadosTipoPlanilla(TiposPlanilla tipoPlanilla)
{
    Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.tiposPlanilla = :tiposPlanilla AND e.status = 'A' ").setParameter("codCia", tipoPlanilla.getTiposPlanillaPK().getCodCia()).setParameter("tiposPlanilla", tipoPlanilla).getSingleResult();
    return t != null ? t.intValue() : 0; 
}

@PermitAll
public Integer totalAfectadosRangosSalario(Cias cias, BigDecimal si, BigDecimal sf, Short puesto)
{
    Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.status = 'A' AND e.salario BETWEEN :si AND :sf AND e.puestos.puestosPK.codPuesto = :pto").setParameter("codCia", cias.getCodCia()).setParameter("si", si != null ? si : 0).setParameter("sf", sf != null ? sf : 0).setParameter("pto", puesto).getSingleResult();
    return t != null ? t.intValue() : 0;
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> afectadosRangosSalario(Cias cias, BigDecimal si, BigDecimal sf)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.status = 'A' AND e.salario BETWEEN :si AND :sf ").setParameter("codCia", cias.getCodCia()).setParameter("si", si != null ? si : 0).setParameter("sf", sf != null ? sf : 0).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

//CONSULTA EMPLEADOS POR RANGO DE SALARIO O PUESTO.
public List<Empleados> afectadosRangoSalarioPuesto(Short cias, BigDecimal si, BigDecimal sf, Short puesto){

         Query q = getEntityManager().createNativeQuery(
            "SELECT * FROM EMPLEADOS "+
            "WHERE COD_CIA = ?1 "+
            "AND SALARIO BETWEEN  ?2 AND ?3 "+
            "AND COD_PUESTO = NVL(?4,COD_PUESTO) ", Empleados.class);
    q.setParameter(1, cias);
    q.setParameter(2, si);
    q.setParameter(3, sf);
    q.setParameter(4, puesto);
   
    List<Empleados> listaRetorno = q.getResultList();
     return listaRetorno != null ? listaRetorno : new ArrayList<Empleados>();
} 

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> afectadosDepartamentos(Departamentos departamento)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A'").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> findByDepartamentos(Departamentos departamento)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A'").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> findByPuestos(Puestos puesto)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.puestos = :puestos AND e.status = 'A'").setParameter("codCia", puesto.getPuestosPK().getCodCia()).setParameter("puestos", puesto).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
@SuppressWarnings(value =
    {
    "cast", "unchecked"
    })
public List<Empleados> afectadosTipoPlanilla(TiposPlanilla tipoPlanilla)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.tiposPlanilla = :tiposPlanilla AND e.status = 'A'").setParameter("codCia", tipoPlanilla.getTiposPlanillaPK().getCodCia()).setParameter("tiposPlanilla", tipoPlanilla).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
public List<Empleados> findEmpleadosByCias(Cias cias)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia ORDER BY e.empleadosPK.codEmp", Empleados.class).setParameter("codCia", cias.getCodCia()).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
public List<Empleados> findEmpleadosByJefe(Empleados jefe)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e WHERE e.empleados = :jefe", Empleados.class).setParameter("jefe", jefe).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
public List<Empleados> findJefesByDepto(Departamentos depto)
{
    List<Empleados> l = em.createQuery("SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.puestos.jefatura = 'SI'", Empleados.class).setParameter("departamentos", depto).setParameter("codCia", depto.getDepartamentosPK().getCodCia()).getResultList();
    return l != null ? l : new ArrayList<Empleados>();
}

@PermitAll
public void eliminarEvaluadorEvaluaciones(PreEvaluacion preevaluacion, Empleados empleado, List<Evaluacion> evaluacion)
{
    Empleados e = em.find(Empleados.class, empleado.getEmpleadosPK());
    e.getEvaluacionList().clear();
    e.setEvaluacionList(evaluacion);
    em.merge(e);
}

@PermitAll
public List<Empleados> findEmpleadosCandidatosByCia(Cias cia)
{
    //String jpql = "SELECT e FROM Empleados e JOIN Candidato c WHERE e.empleadosPK.codCia = c.candidatoPK.codCia AND e.candidato IN NOT NULL AND e.empleadosPK.codCia = :codCia";
    String jpql = "SELECT e FROM Empleados e JOIN e.candidatoList c WHERE e.empleadosPK.codCia = :codCia AND c.candidatoPK.codCia = e.empleadosPK.codCia AND e.candidatoList IS NOT EMPTY";
    TypedQuery<Empleados> tq = getEntityManager().createQuery(jpql, entityClass);
    tq.setParameter("codCia", cia.getCodCia());
    return tq.getResultList();
}

@PermitAll
@SuppressWarnings("unchecked")
public Object[] findPrimerEmpleadoByPuesto(BigDecimal codCia, BigDecimal codPuesto)
{
    Object[] resultado = null;
    try
        {
        String sql = "select e.cod_cia, e.cod_emp, e.nombres || ' ' || e.apellidos as nombre_empleado from empleados e where e.cod_cia = ?1 and e.cod_puesto = ?2 and rownum = 1 order by cod_puesto";
        TypedQuery<Object[]> tq = (TypedQuery<Object[]>) getEntityManager().createNativeQuery(sql);
        tq.setParameter(1, codCia);
        tq.setParameter(2, codPuesto);
        resultado = tq.getSingleResult();
        }
    catch (Exception excpt)
        {
        resultado = null;
        }
    finally
        {
        return resultado;
        }
}

@PermitAll
public List<Empleados> findByJefes(Cias cia)
{
    TypedQuery<Empleados> tq = getEntityManager().createQuery("SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia AND e.puestos.jefatura = 'SI'", entityClass);
    tq.setParameter("codCia", cia.getCodCia());
    return tq.getResultList();
}
}