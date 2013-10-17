/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TiposIncapacidad;
import com.infosgroup.planilla.modelo.entidades.TiposIncapacidadPK;
import java.util.List;
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
public class TiposIncapacidadFacade extends AbstractFacade<TiposIncapacidad, TiposIncapacidadPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public TiposIncapacidadFacade()
{
    super(TiposIncapacidad.class);
}

@PermitAll
public List<TiposIncapacidad> findByCompania(Cias compania)
{
    TypedQuery<TiposIncapacidad> tq = getEntityManager().createQuery("SELECT t FROM TiposIncapacidad t WHERE t.tiposIncapacidadPK.codCia = :codCia", TiposIncapacidad.class);
    tq.setParameter("codCia", compania.getCodCia()).getResultList();
    return tq.getResultList();
}
}
