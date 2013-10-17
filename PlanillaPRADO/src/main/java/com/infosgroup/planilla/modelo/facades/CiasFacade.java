/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class CiasFacade extends AbstractFacade<Cias, Short>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public CiasFacade()
{
    super(Cias.class);
}

public short max()
{
    TypedQuery<Short> tq = getEntityManager().createQuery("SELECT max(c.codCia) FROM Cias c", Short.class);
    Short max = tq.getSingleResult();
    return (max == null) ? 1 : ++max;
}
}