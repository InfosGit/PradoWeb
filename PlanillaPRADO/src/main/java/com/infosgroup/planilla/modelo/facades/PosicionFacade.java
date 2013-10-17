/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Posicion;
import com.infosgroup.planilla.modelo.entidades.PosicionPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.math.BigDecimal;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class PosicionFacade extends AbstractFacade<Posicion, PosicionPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public PosicionFacade()
{
    super(Posicion.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public Long contarVacantes(BigDecimal puesto)
{
    TypedQuery<Long> tq = getEntityManager().createQuery("SELECT COUNT(p) FROM Posicion p WHERE p.status  = 'V' and p.puestos.puestosPK.codPuesto = :puesto", Long.class);
    tq.setParameter("puesto", puesto);
    Long resultado = tq.getSingleResult();
    return (resultado == null) ? 0L : resultado;
}
}