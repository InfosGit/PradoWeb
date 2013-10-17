/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.PreguntaPK;
import java.util.List;
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
public class PreguntaFacade extends AbstractFacade<Pregunta, PreguntaPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public PreguntaFacade()
{
    super(Pregunta.class);
}

public List<Pregunta> findPreguntasByFactor(Factor factor)
{
    TypedQuery<Pregunta> tq = getEntityManager().createQuery("SELECT p FROM Pregunta p WHERE p.preguntaPK.codCia = :codCia AND p.preguntaPK.codFactor = :codFactor order by TO_NUMBER(cod_pregunta)" , Pregunta.class);
    tq.setParameter("codCia", factor.getFactorPK().getCodCia());
    tq.setParameter("codFactor", factor.getFactorPK().getCodFactor());
    return tq.getResultList();
}

//METODO TRAE ORDENADAS LAS PREGUNTAS POR NUMERO DE PREGUNTA
public List<Pregunta> findPreguntasByFactor2(Factor factor){
    Query q = getEntityManager().createNativeQuery("SELECT * FROM Pregunta  WHERE cod_Cia = ?1 and cod_factor = ?2 order by TO_NUMBER(cod_pregunta)" , Pregunta.class);    
    q.setParameter(1 , factor.getFactorPK().getCodCia());
    q.setParameter(2, factor.getFactorPK().getCodFactor());
    return q.getResultList();
}
}
