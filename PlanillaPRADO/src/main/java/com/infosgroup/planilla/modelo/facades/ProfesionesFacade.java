/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Profesion;
import com.infosgroup.planilla.modelo.entidades.ProfesionPK;
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
public class ProfesionesFacade extends AbstractFacade<Profesion, ProfesionPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public ProfesionesFacade()
{
    super(Profesion.class);
}

public List<Profesion> findProfesionByEmpresa(Cias cias)
{
    List<Profesion> profesion = new ArrayList<Profesion>();
    profesion = getEntityManager().createQuery("SELECT p FROM Profesion p WHERE p.profesionPK.codCia = :codCia ORDER BY p.nomProfesion ASC", Profesion.class).setParameter("codCia", cias.getCodCia()).getResultList();
    return profesion != null ? profesion : new ArrayList<Profesion>();
}


@Override
protected EntityManager getEntityManager()
{
    return em;
}
}
