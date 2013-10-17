package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetPresupuestoHorasSucursal;
import com.infosgroup.planilla.modelo.entidades.PresupuestoHorasSucursalPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PresupuestoHorasSucursal.class)
public class PresupuestoHorasSucursal_ { 

    public static volatile SingularAttribute<PresupuestoHorasSucursal, Short> codDepto;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, Date> fechaFinal;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, String> observacion;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, String> estado;
    public static volatile ListAttribute<PresupuestoHorasSucursal, DetPresupuestoHorasSucursal> detPresupuestoHorasSucursalList;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, String> codSucursal;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, PresupuestoHorasSucursalPK> presupuestoHorasSucursalPK;
    public static volatile SingularAttribute<PresupuestoHorasSucursal, Date> fechaInicio;

}