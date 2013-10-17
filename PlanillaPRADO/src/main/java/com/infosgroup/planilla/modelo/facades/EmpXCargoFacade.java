/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.EmpXCargo;
import com.infosgroup.planilla.modelo.entidades.EmpXCargoPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
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
public class EmpXCargoFacade extends AbstractFacade<EmpXCargo, EmpXCargoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public EmpXCargoFacade()
{
    super(EmpXCargo.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}
//@PermitAll
//public Integer max(Candidato c)
//{
//    Query q = getEntityManager().createQuery("SELECT max(r.referenciaPK.codReferencia) FROM Referencia r WHERE r.candidato = :candidato");
//    q.setParameter("candidato", c);
//    Integer max = (Integer) q.getSingleResult();
//    return (max == null) ? 1 : ++max;
//}

@PermitAll
public List<EmpXCargo> findByEmpleado(Empleados e)
{
    TypedQuery<EmpXCargo> tq = getEntityManager().createQuery("SELECT c FROM EmpXCargo c WHERE c.empleados = :empleado", EmpXCargo.class);
    tq.setParameter("empleado", e);
    return tq.getResultList();
}
}
