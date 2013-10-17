/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import com.infosgroup.planilla.modelo.entidades.TipoDocumentoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento, TipoDocumentoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public TipoDocumentoFacade()
{
    super(TipoDocumento.class);
}

public List<TipoDocumento> findAll(Cias c)
{
    TypedQuery<TipoDocumento> tq = getEntityManager().createQuery("SELECT doc FROM TipoDocumento doc WHERE doc.cias = :cia", entityClass);
    tq.setParameter("cia", c);
    return tq.getResultList();
}
}
