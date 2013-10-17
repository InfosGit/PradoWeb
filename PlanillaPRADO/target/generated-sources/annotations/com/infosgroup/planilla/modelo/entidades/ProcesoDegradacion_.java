package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetProcesoDegradacion;
import com.infosgroup.planilla.modelo.entidades.ProcesoDegradacionPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(ProcesoDegradacion.class)
public class ProcesoDegradacion_ { 

    public static volatile SingularAttribute<ProcesoDegradacion, String> observacion;
    public static volatile SingularAttribute<ProcesoDegradacion, String> estado;
    public static volatile SingularAttribute<ProcesoDegradacion, Short> cantidad;
    public static volatile SingularAttribute<ProcesoDegradacion, ProcesoDegradacionPK> procesoDegradacionPK;
    public static volatile ListAttribute<ProcesoDegradacion, DetProcesoDegradacion> detProcesoDegradacionList;

}