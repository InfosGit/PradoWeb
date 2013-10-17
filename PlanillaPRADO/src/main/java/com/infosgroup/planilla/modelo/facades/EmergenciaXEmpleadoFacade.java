/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.EmergenciaXEmp;
import com.infosgroup.planilla.modelo.entidades.EmergenciaXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author Soporte
 */
@Stateless
public class EmergenciaXEmpleadoFacade extends AbstractFacade<EmergenciaXEmp, EmergenciaXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public EmergenciaXEmpleadoFacade()
{
    super(EmergenciaXEmp.class);
}

public Integer max(Empleados e)
{
    TypedQuery<Integer> tq = em.createQuery("SELECT max(e.emergenciaXEmpPK.codEmergencia) FROM EmergenciaXEmp e WHERE e.emergenciaXEmpPK.codCia = :codCia AND e.emergenciaXEmpPK.codEmp = :codEmpleado", Integer.class);
    tq.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    tq.setParameter("codEmpleado", e.getEmpleadosPK().getCodEmp());
    Integer max = tq.getSingleResult();
    return (max != null) ? (++max) : 1;
}

@PermitAll
public List<EmergenciaXEmp> findByEmpleado(Empleados empleado)
{
    String jpql = "SELECT e FROM EmergenciaXEmp e WHERE e.empleados = :empleado";
    TypedQuery<EmergenciaXEmp> tq = getEntityManager().createQuery(jpql, entityClass);
    tq.setParameter("empleado", empleado);
    return tq.getResultList();
}
}
