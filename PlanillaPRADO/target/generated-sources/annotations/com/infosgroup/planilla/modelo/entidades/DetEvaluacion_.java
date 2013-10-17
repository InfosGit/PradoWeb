package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetEvaluacion.class)
public class DetEvaluacion_ { 

    public static volatile SingularAttribute<DetEvaluacion, Pregunta> pregunta;
    public static volatile SingularAttribute<DetEvaluacion, String> valor;
    public static volatile SingularAttribute<DetEvaluacion, DetEvaluacionPK> detEvaluacionPK;
    public static volatile SingularAttribute<DetEvaluacion, Evaluacion> evaluacion;
    public static volatile SingularAttribute<DetEvaluacion, Respuesta> respuesta;

}