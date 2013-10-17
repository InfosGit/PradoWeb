/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Etnia;
import com.infosgroup.planilla.modelo.entidades.EtniaPK;
import java.util.List;
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
public class EtniaFacade extends AbstractFacade<Etnia, EtniaPK>
{

    @PersistenceContext(unitName = "PlanillaWebPapeleraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public EtniaFacade()
    {
        super(Etnia.class);
    }

    public List<Etnia> findAll(Cias c)
    {
        TypedQuery<Etnia> tq = getEntityManager().createQuery("SELECT e FROM Etnia e WHERE e.cias = :cia", entityClass);
        tq.setParameter("cia", c);
        return tq.getResultList();
    }
}