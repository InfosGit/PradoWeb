/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ReferenciaEmp;
import com.infosgroup.planilla.modelo.entidades.ReferenciaEmpPK;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class ReferenciaEmpFacade extends AbstractFacade<ReferenciaEmp, ReferenciaEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public ReferenciaEmpFacade()
{
    super(ReferenciaEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public Integer max(Candidato c)
{
    TypedQuery<Integer> q = getEntityManager().createQuery("SELECT max(r.referenciaEmpPK.codReferencia) FROM ReferenciaEmp r WHERE r.empleados = :empleado", Integer.class);
    q.setParameter("empleado", c);
    Integer max = q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

@PermitAll
public List<ReferenciaEmp> findByEmpleado(Empleados e)
{
    String jpql = "SELECT r FROM ReferenciaEmp r WHERE r.empleados = :empleado";
    TypedQuery<ReferenciaEmp> tq = getEntityManager().createQuery(jpql, entityClass);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
