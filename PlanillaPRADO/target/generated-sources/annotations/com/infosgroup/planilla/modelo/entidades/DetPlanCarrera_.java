package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetPlanCarreraPK;
import com.infosgroup.planilla.modelo.entidades.PlanCarrera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetPlanCarrera.class)
public class DetPlanCarrera_ { 

    public static volatile SingularAttribute<DetPlanCarrera, PlanCarrera> planCarrera;
    public static volatile SingularAttribute<DetPlanCarrera, Short> tiempo;
    public static volatile SingularAttribute<DetPlanCarrera, String> observacion;
    public static volatile SingularAttribute<DetPlanCarrera, Date> fecha;
    public static volatile SingularAttribute<DetPlanCarrera, String> actividad;
    public static volatile SingularAttribute<DetPlanCarrera, String> resultado;
    public static volatile SingularAttribute<DetPlanCarrera, DetPlanCarreraPK> detPlanCarreraPK;

}