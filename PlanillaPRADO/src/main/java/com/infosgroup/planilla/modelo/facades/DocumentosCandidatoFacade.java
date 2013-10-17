/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresentado;
import com.infosgroup.planilla.modelo.entidades.DocumentosCandidato;
import com.infosgroup.planilla.modelo.entidades.DocumentosCandidatoPK;
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
public class DocumentosCandidatoFacade extends AbstractFacade<DocumentosCandidato, DocumentosCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public DocumentosCandidatoFacade()
{
    super(DocumentosCandidato.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}



   @PermitAll
    public Long max(Candidato c)
    {
        Long m = null;
        try
            {
            TypedQuery<Long> tq = getEntityManager().createQuery("SELECT max(d.documentosCandidatoPK.codArchivo) FROM DocumentosCandidato d WHERE d.documentosCandidatoPK.codCia = :codCia AND d.documentosCandidatoPK.codCandidato = :codCandidato", Long.class);
            tq.setParameter("codCia", c.getCandidatoPK().getCodCia());
            tq.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
            m = tq.getSingleResult();
            }
        catch (Exception excpt)
            {
            m = 0L;
            }
        return (m == null) ? 0L : m;
    }




@PermitAll
public List<DocumentosCandidato> findByCandidato(Candidato candidato)
{
    TypedQuery<DocumentosCandidato> tq = getEntityManager().createQuery("SELECT d FROM DocumentoPresentado d WHERE d.candidato = :candidato", DocumentosCandidato.class);
    tq.setParameter("candidato", candidato);
    return tq.getResultList();
}


}
