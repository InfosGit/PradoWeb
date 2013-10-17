/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmp;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
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
public class CapacitacionXEmpFacade extends AbstractFacade<CapacitacionXEmp, CapacitacionXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public CapacitacionXEmpFacade()
{
    super(CapacitacionXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(c.capacitacionXEmpPK.codCapacitacion) FROM CapacitacionXEmp c WHERE c.capacitacionXEmpPK.codCia = :codCia AND c.capacitacionXEmpPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<CapacitacionXEmp> findByEmpleado(Empleados e)
{
    TypedQuery<CapacitacionXEmp> tq = getEntityManager().createQuery("SELECT c FROM CapacitacionXEmp c WHERE c.empleados = :empleado", CapacitacionXEmp.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
