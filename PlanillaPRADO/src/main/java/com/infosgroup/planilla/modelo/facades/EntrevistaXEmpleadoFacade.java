/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXEmp;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class EntrevistaXEmpleadoFacade extends AbstractFacade<EntrevistaXEmp, EntrevistaXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public EntrevistaXEmpleadoFacade()
{
    super(EntrevistaXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Short max(Puestos p, Empleados e)
{
    TypedQuery<Short> q = getEntityManager().createQuery("SELECT max(e.entrevistaXEmpPK.codEntrevista) FROM EntrevistaXEmp e WHERE e.entrevistaXEmpPK.codCia = :codCia AND e.entrevistaXEmpPK.codEmp = :codEmp AND e.entrevistaXEmpPK.codPuesto = :codPuesto", Short.class);
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    q.setParameter("codPuesto", p.getPuestosPK().getCodPuesto());
    Short max = q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<EntrevistaXEmp> findByEmpleado(Empleados e)
{
    TypedQuery<EntrevistaXEmp> tq = getEntityManager().createQuery("SELECT e FROM EntrevistaXEmp e WHERE e.empleado = :empleado", EntrevistaXEmp.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
