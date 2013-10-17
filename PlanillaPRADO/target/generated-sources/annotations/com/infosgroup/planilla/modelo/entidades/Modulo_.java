package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.entidades.ModuloPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, String> nomModulo;
    public static volatile ListAttribute<Modulo, Menu> menuList;
    public static volatile SingularAttribute<Modulo, ModuloPK> moduloPK;

}