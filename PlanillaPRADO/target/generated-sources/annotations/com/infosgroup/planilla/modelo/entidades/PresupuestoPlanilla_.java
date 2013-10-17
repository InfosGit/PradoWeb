package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.PresupuestoDepto;
import com.infosgroup.planilla.modelo.entidades.PresupuestoPlanillaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PresupuestoPlanilla.class)
public class PresupuestoPlanilla_ { 

    public static volatile SingularAttribute<PresupuestoPlanilla, String> observacion;
    public static volatile SingularAttribute<PresupuestoPlanilla, String> estado;
    public static volatile ListAttribute<PresupuestoPlanilla, PresupuestoDepto> presupuestoDeptoList;
    public static volatile SingularAttribute<PresupuestoPlanilla, PresupuestoPlanillaPK> presupuestoPlanillaPK;

}