package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.entidades.MenuPK;
import com.infosgroup.planilla.modelo.entidades.Modulo;
import com.infosgroup.planilla.modelo.entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> titulo;
    public static volatile SingularAttribute<Menu, Long> estado;
    public static volatile SingularAttribute<Menu, Menu> menu;
    public static volatile ListAttribute<Menu, Rol> rolList;
    public static volatile SingularAttribute<Menu, String> ruta;
    public static volatile SingularAttribute<Menu, Modulo> modulo;
    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, Long> nivel;
    public static volatile SingularAttribute<Menu, MenuPK> menuPK;

}