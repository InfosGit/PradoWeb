/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias; 
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.ConcursoPK; 
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK; 
import java.util.ArrayList;  
import java.util.Date; 
import java.util.List; 
import javax.ejb.LocalBean;    
import javax.ejb.Stateless;     
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root; 
import com.infosgroup.planilla.modelo.entidades.Concurso_; 
 
/**
 *
 * @author root 
 */
@Stateless
@LocalBean
public class ConcursoFacade extends AbstractFacade<Concurso, ConcursoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public ConcursoFacade()
{
    super(Concurso.class);
}

public List<Concurso> getConcursosByDate(Cias cias, Date fechaInicial, Date fechaFinal) 
{
    List<Concurso> lstConcurso = new ArrayList<Concurso>();
    CriteriaQuery<Concurso> cq = getEntityManager().getCriteriaBuilder().createQuery(Concurso.class);
    Root<Concurso> rootConcurso = cq.from(Concurso.class);
    if (fechaInicial != null && fechaFinal != null)
        {
        cq.where(getEntityManager().getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), getEntityManager().find(EstadoConcurso.class, new EstadoConcursoPK(cias.getCodCia(), "A"))),
                getEntityManager().getCriteriaBuilder().and(getEntityManager().getCriteriaBuilder().between(rootConcurso.get(Concurso_.fechaInicial), fechaInicial, fechaFinal)));
        }
    else
        {
        cq.where(getEntityManager().getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), getEntityManager().find(EstadoConcurso.class, new EstadoConcursoPK(cias.getCodCia(), "A"))));
        }
    lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
    return lstConcurso;
}

public List<Concurso> getConcursosActivos(Cias empresa)
{
    List<Concurso> lstConcurso = new ArrayList<Concurso>();
    CriteriaQuery<Concurso> cq = getEntityManager().getCriteriaBuilder().createQuery(Concurso.class);
    Root<Concurso> rootConcurso = cq.from(Concurso.class);
    cq.where(getEntityManager().getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), getEntityManager().find(EstadoConcurso.class, new EstadoConcursoPK(empresa.getCodCia(), "A"))));
    lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
    return lstConcurso; 
}

public Long max(Cias empresa)
{
    Long max = (Long) getEntityManager().createQuery("SELECT max(c.concursoPK.codConcurso) FROM Concurso c WHERE c.concursoPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
    return max != null ? (++max) : 1L;
}

public List<Concurso> findConcursoByEmpresa(Cias empresa)
{
    List<Concurso> l = new ArrayList<Concurso>();
    l.addAll(getEntityManager().createQuery("SELECT c FROM Concurso c WHERE c.concursoPK.codCia = :codCia", Concurso.class).setParameter("codCia", empresa.getCodCia()).getResultList());
    return l;
}
} 