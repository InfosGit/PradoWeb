/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.entidades.MenuPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu, MenuPK>
{

@PersistenceContext(unitName = "PlanillaWebPapeleraPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public MenuFacade()
{
    super(Menu.class);
}

@PermitAll
public List<Menu> findAllEnOrden(Cias c, String rol)
{
    //TypedQuery<Menu> tq = em.createQuery("SELECT m FROM Menu m WHERE m.nivel = 1 AND m.estado = 1 ORDER BY m.menuPK.codMenu", Menu.class);
    Query q = getEntityManager().createNativeQuery("select a.* from menu a, menu_rol b where a.cod_cia = ? and a.estado=1 and a.nivel=1 and b.cod_cia = a.cod_cia and b.cod_modulo=a.cod_modulo and b.cod_menu=a.cod_menu and b.cod_rol = ? order by a.cod_menu asc");
    q.setParameter(1, c.getCodCia());
    q.setParameter(2, rol);
    List<Object> listaObjetos = q.getResultList();
    List<Menu> listaMenu = new ArrayList<Menu>();
    if (listaObjetos != null)
        {
        for (Object o : listaObjetos)
            {
            Object [] objArray = (Object []) o;
            BigDecimal compania = (BigDecimal) objArray[0];
            BigDecimal modulo = (BigDecimal) objArray[1];
            BigDecimal menu = (BigDecimal) objArray[2];
            Menu mnu = find(new MenuPK(compania.shortValueExact(), modulo.longValueExact(), menu.longValueExact()));
            listaMenu.add(mnu);
//            System.out.println(objArray);
            }
        }
    return listaMenu;
}

@PermitAll
public List<Menu> findAllSubMenu(Cias c, String rol)
{
    Query q = getEntityManager().createNativeQuery("select a.* from menu a, menu_rol b where a.cod_cia = ? and a.estado=1 and a.nivel!=1 and b.cod_cia = a.cod_cia and b.cod_modulo=a.cod_modulo and b.cod_menu=a.cod_menu and b.cod_rol = ? order by a.cod_menu asc");
    q.setParameter(1, c.getCodCia());
    q.setParameter(2, rol);
    List<Object> listaObjetos = q.getResultList();
    List<Menu> listaMenu = new ArrayList<Menu>();
    if (listaObjetos != null)
        {
        for (Object o : listaObjetos)
            {
            Object [] objArray = (Object []) o;
            BigDecimal compania = (BigDecimal) objArray[0];
            BigDecimal modulo = (BigDecimal) objArray[1];
            BigDecimal menu = (BigDecimal) objArray[2];
            Menu mnu = find(new MenuPK(compania.shortValueExact(), modulo.longValueExact(), menu.longValueExact()));
            listaMenu.add(mnu);
            }
        }
    return listaMenu;
}
}