package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.EscalaEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EscalaEvaluacion.class)
public class EscalaEvaluacion_ { 

    public static volatile SingularAttribute<EscalaEvaluacion, Short> rangoFinal;
    public static volatile SingularAttribute<EscalaEvaluacion, Short> rangoInicial;
    public static volatile SingularAttribute<EscalaEvaluacion, String> calificacion;
    public static volatile SingularAttribute<EscalaEvaluacion, EscalaEvaluacionPK> escalaEvaluacionPK;
    public static volatile SingularAttribute<EscalaEvaluacion, TipoEvaluacion> tipoEvaluacion;

}