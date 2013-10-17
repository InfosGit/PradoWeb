package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetPlanCarrera;
import com.infosgroup.planilla.modelo.entidades.PlanCarreraPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(PlanCarrera.class)
public class PlanCarrera_ { 

    public static volatile SingularAttribute<PlanCarrera, Short> codPuestoMeta;
    public static volatile SingularAttribute<PlanCarrera, String> observacion;
    public static volatile SingularAttribute<PlanCarrera, String> estado;
    public static volatile ListAttribute<PlanCarrera, DetPlanCarrera> detPlanCarreraList;
    public static volatile SingularAttribute<PlanCarrera, Short> codPuestoBase;
    public static volatile SingularAttribute<PlanCarrera, PlanCarreraPK> planCarreraPK;
    public static volatile SingularAttribute<PlanCarrera, Integer> codEmp;
    public static volatile SingularAttribute<PlanCarrera, Date> fechaRevision;
    public static volatile SingularAttribute<PlanCarrera, Date> fechaInicio;

}