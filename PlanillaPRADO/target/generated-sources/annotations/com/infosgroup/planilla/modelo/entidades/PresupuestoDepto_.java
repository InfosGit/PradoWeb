package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.PresupuestoDeptoPK;
import com.infosgroup.planilla.modelo.entidades.PresupuestoPlanilla;
import com.infosgroup.planilla.modelo.entidades.PresupuestoPuesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(PresupuestoDepto.class)
public class PresupuestoDepto_ { 

    public static volatile SingularAttribute<PresupuestoDepto, String> observacion;
    public static volatile SingularAttribute<PresupuestoDepto, PresupuestoDeptoPK> presupuestoDeptoPK;
    public static volatile SingularAttribute<PresupuestoDepto, String> estado;
    public static volatile SingularAttribute<PresupuestoDepto, PresupuestoPlanilla> presupuestoPlanilla;
    public static volatile ListAttribute<PresupuestoDepto, PresupuestoPuesto> presupuestoPuestoList;

}