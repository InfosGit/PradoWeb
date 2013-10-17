package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacionPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoEvaluacion.class)
public class TipoEvaluacion_ { 

    public static volatile ListAttribute<TipoEvaluacion, Plantilla> plantillaList;
    public static volatile SingularAttribute<TipoEvaluacion, TipoEvaluacionPK> tipoEvaluacionPK;
    public static volatile SingularAttribute<TipoEvaluacion, String> nomTipoEvaluacion;
    public static volatile ListAttribute<TipoEvaluacion, Evaluacion> evaluacionList;
    public static volatile ListAttribute<TipoEvaluacion, PreEvaluacion> preEvaluacionList;

}