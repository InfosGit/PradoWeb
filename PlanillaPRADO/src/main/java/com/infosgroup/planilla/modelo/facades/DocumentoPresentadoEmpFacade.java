/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DocumentoPresEmp;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
@LocalBean
public class DocumentoPresentadoEmpFacade extends AbstractFacade<DocumentoPresEmp, DocumentoPresEmpPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

public DocumentoPresentadoEmpFacade()
{
    super(DocumentoPresEmp.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Empleados e)
{
    Query q = getEntityManager().createQuery("SELECT max(d.documentoPresEmpPK.codDocumentoPres) FROM DocumentoPresEmp d WHERE d.documentoPresEmpPK.codCia = :codCia AND d.documentoPresEmpPK.codEmp = :codEmpleado");
    q.setParameter("codCia", e.getEmpleadosPK().getCodCia());
    q.setParameter("codEmpleado", e.getEmpleadosPK().getCodEmp());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

@PermitAll
public List<DocumentoPresEmp> findByEmpleado(Empleados empleado)
{
    TypedQuery<DocumentoPresEmp> tq = getEntityManager().createQuery("SELECT d FROM DocumentoPresEmp d WHERE d.empleados = :empleado", DocumentoPresEmp.class);
    tq.setParameter("empleado", empleado);
    return tq.getResultList();
}
}
