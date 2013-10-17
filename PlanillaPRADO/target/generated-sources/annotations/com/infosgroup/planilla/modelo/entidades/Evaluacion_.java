package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Evaluacion.class)
public class Evaluacion_ { 

    public static volatile SingularAttribute<Evaluacion, Campania> campania;
    public static volatile ListAttribute<Evaluacion, DetEvaluacion> detEvaluacionList;
    public static volatile SingularAttribute<Evaluacion, Long> finalizada;
    public static volatile SingularAttribute<Evaluacion, Date> fecha;
    public static volatile SingularAttribute<Evaluacion, TipoEvaluacion> tipoEvaluacion1;
    public static volatile SingularAttribute<Evaluacion, Empleados> empleados;
    public static volatile SingularAttribute<Evaluacion, Plantilla> plantilla1;
    public static volatile SingularAttribute<Evaluacion, EvaluacionPK> evaluacionPK;

}