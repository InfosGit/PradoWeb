/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.BeneficiarioXEmp;
import com.infosgroup.planilla.modelo.entidades.BeneficiarioXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class BeneficiarioXEmpleadoFacade extends AbstractFacade<BeneficiarioXEmp, BeneficiarioXEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public BeneficiarioXEmpleadoFacade()
{
    super(BeneficiarioXEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public Integer max(Empleados e)
{
    Query q = em.createQuery("SELECT max(b.beneficiarioXEmpPK.codBeneficiario) FROM BeneficiarioXEmp b WHERE b.beneficiarioXEmpPK.codCia = :codCia AND b.beneficiarioXEmpPK.codEmp = :codEmp");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    Integer i = (Integer) q.getSingleResult();
    return i != null ? ++i : 1;
}

@PermitAll
public List<BeneficiarioXEmp> findByEmpleado(Empleados e)
{
    List<BeneficiarioXEmp> l = null;
    TypedQuery<BeneficiarioXEmp> tq = getEntityManager().createQuery("SELECT b FROM BeneficiarioXEmp b WHERE b.beneficiarioXEmpPK.codCia = :codCia AND b.beneficiarioXEmpPK.codEmp = :codEmp", entityClass);
    tq.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    tq.setParameter("codEmp", e.getEmpleadosPK().getCodEmp());
    l = tq.getResultList();
    return l != null ? l : new ArrayList<BeneficiarioXEmp>();
}
}
