package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.RolPK;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, TipoAccion> tipoAccionList;
    public static volatile SingularAttribute<Rol, String> nomRol;
    public static volatile SingularAttribute<Rol, RolPK> rolPK;

}