/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DependienteXEmp;
import com.infosgroup.planilla.modelo.entidades.DependienteXEmpPK;
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
public class DependienteXEmpleadoFacade extends AbstractFacade<DependienteXEmp, DependienteXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public DependienteXEmpleadoFacade()
{
    super(DependienteXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(d.dependienteXEmpPK.codDocumentoPres) FROM DependienteXEmp d WHERE d.dependienteXEmpPK.codCia = :codCia AND d.dependienteXEmpPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<DependienteXEmp> findByCandidato(Empleados e)
{
    TypedQuery<DependienteXEmp> tq = getEntityManager().createQuery("SELECT d FROM DependienteXEmp d WHERE d.empleados = :empleado", DependienteXEmp.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
