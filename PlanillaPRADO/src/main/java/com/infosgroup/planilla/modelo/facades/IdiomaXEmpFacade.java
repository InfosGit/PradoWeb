/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.IdiomaXEmp;
import com.infosgroup.planilla.modelo.entidades.IdiomaXEmpPK;
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
public class IdiomaXEmpFacade extends AbstractFacade<IdiomaXEmp, IdiomaXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public IdiomaXEmpFacade()
{
    super(IdiomaXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(i.idiomaXEmpPK.codIdioma) FROM IdiomaXEmp i WHERE i.idiomaXEmpPK.codCia = :codCia AND i.idiomaXEmpPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<IdiomaXEmp> findByEmpleado(Empleados e)
{
    TypedQuery<IdiomaXEmp> tq = getEntityManager().createQuery("SELECT i FROM IdiomaXEmp i WHERE i.empleados = :empleado", IdiomaXEmp.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
