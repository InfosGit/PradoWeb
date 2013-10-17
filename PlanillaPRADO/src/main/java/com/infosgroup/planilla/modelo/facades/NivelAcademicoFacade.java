/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.entidades.NivelAcademicoPK;
import com.infosgroup.planilla.modelo.entidades.Profesion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico, NivelAcademicoPK> {

    @PersistenceContext(unitName = "PlanillaWebPapeleraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }

    public List<NivelAcademico> findNivelesByEmpresa(Cias cias)
{
    List<NivelAcademico> nivelAcademico = new ArrayList<NivelAcademico>();
    nivelAcademico = getEntityManager().createQuery("SELECT n FROM NivelAcademico n WHERE n.nivelAcademicoPK.codCia = :codCia ORDER BY n.nomNivelAcademico ASC", NivelAcademico.class).setParameter("codCia", cias.getCodCia()).getResultList();
    return nivelAcademico != null ? nivelAcademico : new ArrayList<NivelAcademico>();
}
    
    public Short max(Cias cia) {
        Short max = (Short) getEntityManager().createQuery("SELECT max(n.nivelAcademicoPK.codNivelAcademico) FROM NivelAcademico n WHERE n.nivelAcademicoPK.codCia = :codCia").setParameter("codCia", cia.getCodCia()).getSingleResult();
        return (max == null) ? 1 : ++max;
    }
}
