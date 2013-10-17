/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXEmp;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXEmpPK;
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
public class TipoPruebaXEmpleadoFacade extends AbstractFacade<TipoPruebaXEmp, TipoPruebaXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public TipoPruebaXEmpleadoFacade()
{
    super(TipoPruebaXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Short max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(t.tipoPruebaXEmpPK.codTipoPrueba) FROM TipoPruebaXEmp t WHERE t.tipoPruebaXEmpPK.codCia = :codCia AND t.tipoPruebaXEmpPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Short max = (Short) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<TipoPruebaXEmp> findByEmpleado(Empleados e)
{
    TypedQuery<TipoPruebaXEmp> tq = getEntityManager().createQuery("SELECT t FROM TipoPruebaXEmp t WHERE t.empleados = :empleado", entityClass);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
