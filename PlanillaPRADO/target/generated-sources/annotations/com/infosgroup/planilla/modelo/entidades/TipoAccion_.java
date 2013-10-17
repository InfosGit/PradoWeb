package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Rol;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoAccion.class)
public class TipoAccion_ { 

    public static volatile SingularAttribute<TipoAccion, Long> codRol;
    public static volatile SingularAttribute<TipoAccion, String> afectaSal;
    public static volatile SingularAttribute<TipoAccion, String> firmaRh;
    public static volatile SingularAttribute<TipoAccion, String> estado;
    public static volatile SingularAttribute<TipoAccion, String> urlPlantilla;
    public static volatile SingularAttribute<TipoAccion, String> retiro;
    public static volatile ListAttribute<TipoAccion, Rol> rolList;
    public static volatile SingularAttribute<TipoAccion, TipoAccionPK> tipoAccionPK;
    public static volatile SingularAttribute<TipoAccion, String> firmaJefe;
    public static volatile SingularAttribute<TipoAccion, String> nomTipoaccion;
    public static volatile ListAttribute<TipoAccion, AccionPersonal> accionPersonalList;

}