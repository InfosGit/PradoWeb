/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralEmpleado;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralEmpleadoPK;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ExpLaboralEmpleadoFacade extends AbstractFacade<ExpLaboralEmpleado, ExpLaboralEmpleadoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public ExpLaboralEmpleadoFacade()
{
    super(ExpLaboralEmpleado.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(e.expLaboralEmpleadoPK.codExpLaboral) FROM ExpLaboralEmpleado e WHERE e.expLaboralEmpleadoPK.codCia = :codCia AND e.expLaboralEmpleadoPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<ExpLaboralEmpleado> findByEmpleado(Empleados e)
{
    TypedQuery<ExpLaboralEmpleado> tq = getEntityManager().createQuery("SELECT e FROM ExpLaboralEmpleado e WHERE e.empleados = :empleado", ExpLaboralEmpleado.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}