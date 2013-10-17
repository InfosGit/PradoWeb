/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class PuestoFacade extends AbstractFacade<Puestos, PuestosPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public PuestoFacade()
{
    super(Puestos.class);
}

public List<Puestos> findPuestoByEmpresa(Cias cias)
{
    List<Puestos> puestos = new ArrayList<Puestos>();
    puestos = getEntityManager().createQuery("SELECT p FROM Puestos p WHERE p.puestosPK.codCia = :codCia AND p.status = 'A' ORDER BY p.nomPuesto ASC", Puestos.class).setParameter("codCia", cias.getCodCia()).getResultList();
    return puestos != null ? puestos : new ArrayList<Puestos>();
}

@PermitAll
public Short max(Cias cias)
{
    Short max = (Short) getEntityManager().createQuery("SELECT max(p.puestosPK.codPuesto) FROM Puestos p WHERE p.puestosPK.codCia = :codCia").setParameter("codCia", cias.getCodCia()).getSingleResult();
    return (max == null) ? new Short("1") : ++max;
}

@PermitAll
@SuppressWarnings("unchecked")
public List<Object[]> findPuestosByGerencia(BigDecimal codGerencia)
{
    String sql = "select distinct cod_puesto, nom_puesto from puestos p where p.cod_gerencia = ?1 order by cod_puesto";
    TypedQuery<Object[]> tq = (TypedQuery<Object[]>) em.createNativeQuery(sql);
    tq.setParameter(1, codGerencia);
    return tq.getResultList();
}

@PermitAll
@SuppressWarnings("unchecked")
public List<Object[]> findPuestosArbolBinario()
{
    String sql = "select cod_cia, cod_puesto, nom_puesto, cod_cia_jefe, puesto_jefe, level from puestos start with cod_puesto = 1 and cod_cia = 1 connect by prior cod_puesto = puesto_jefe order by level, cod_cia, cod_puesto";
    TypedQuery<Object[]> tq = (TypedQuery<Object[]>) em.createNativeQuery(sql);
    //tq.setParameter(1, codGerencia);
    return tq.getResultList();
}
}
