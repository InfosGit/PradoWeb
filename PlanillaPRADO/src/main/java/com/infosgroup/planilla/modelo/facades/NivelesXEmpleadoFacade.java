/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.NivelesXEmp;
import com.infosgroup.planilla.modelo.entidades.NivelesXEmpPK;
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
public class NivelesXEmpleadoFacade extends AbstractFacade<NivelesXEmp, NivelesXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public NivelesXEmpleadoFacade()
{
    super(NivelesXEmp.class);
}

@PermitAll
public Short max(Empleados e)
{
    TypedQuery<Short> q = getEntityManager().createQuery("SELECT max(n.nivelesXEmpPK.codNivel) FROM NivelesXEmp n WHERE n.nivelesXEmpPK.codCia = :codCia AND n.nivelesXEmpPK.codCandidato = :codEmpleado", Short.class);
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmpleado", e.getEmpleadosPK().getCodEmp());
    Short max = (Short) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

@PermitAll
public List<NivelesXEmp> findByEmpleado(Empleados e)
{
    TypedQuery<NivelesXEmp> tq = getEntityManager().createQuery("SELECT n FROM NivelesXEmp n WHERE n.nivelesXEmpPK.codCia = :codCia AND n.nivelesXEmpPK.codEmp = :codEmpleado", NivelesXEmp.class);
    tq.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    tq.setParameter("codEmpleado", e.getEmpleadosPK().getCodEmp());
    return tq.getResultList();
}
}
