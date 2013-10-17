package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.PlantillaPK;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Plantilla.class)
public class Plantilla_ { 

    public static volatile SingularAttribute<Plantilla, String> nombre;
    public static volatile ListAttribute<Plantilla, Evaluacion> evaluacionList;
    public static volatile SingularAttribute<Plantilla, PlantillaPK> plantillaPK;
    public static volatile SingularAttribute<Plantilla, String> incluyeObjetivos;
    public static volatile SingularAttribute<Plantilla, String> incluyeCompetencias;
    public static volatile ListAttribute<Plantilla, Pregunta> preguntaList;
    public static volatile ListAttribute<Plantilla, PreEvaluacion> preEvaluacionList;
    public static volatile SingularAttribute<Plantilla, TipoEvaluacion> tipoEvaluacion;

}