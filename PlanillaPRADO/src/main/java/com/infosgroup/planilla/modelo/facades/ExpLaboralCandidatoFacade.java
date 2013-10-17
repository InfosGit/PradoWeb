/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralCandidato;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralCandidatoPK;
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
public class ExpLaboralCandidatoFacade extends AbstractFacade<ExpLaboralCandidato, ExpLaboralCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public ExpLaboralCandidatoFacade()
{
    super(ExpLaboralCandidato.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(e.expLaboralCandidatoPK.codExpLaboral) FROM ExpLaboralCandidato e WHERE e.expLaboralCandidatoPK.codCia = :codCia AND e.expLaboralCandidatoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<ExpLaboralCandidato> findByCandidato(Candidato c)
{
    TypedQuery<ExpLaboralCandidato> tq = getEntityManager().createQuery("SELECT e FROM ExpLaboralCandidato e WHERE e.candidato = :candidato", ExpLaboralCandidato.class);
    tq.setParameter("candidato", c);
    return tq.getResultList();
}
}