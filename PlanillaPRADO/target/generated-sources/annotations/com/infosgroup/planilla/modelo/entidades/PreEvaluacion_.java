package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluador;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PreEvaluacion.class)
public class PreEvaluacion_ { 

    public static volatile SingularAttribute<PreEvaluacion, Campania> campania;
    public static volatile SingularAttribute<PreEvaluacion, PreEvaluacionPK> preEvaluacionPK;
    public static volatile ListAttribute<PreEvaluacion, Evaluador> evaluadorList;
    public static volatile SingularAttribute<PreEvaluacion, TipoEvaluacion> tipoEvaluacion1;
    public static volatile SingularAttribute<PreEvaluacion, Plantilla> plantilla1;

}