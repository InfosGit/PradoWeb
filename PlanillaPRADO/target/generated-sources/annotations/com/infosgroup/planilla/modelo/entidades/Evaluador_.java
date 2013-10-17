package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Evaluado;
import com.infosgroup.planilla.modelo.entidades.EvaluadorPK;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Evaluador.class)
public class Evaluador_ { 

    public static volatile SingularAttribute<Evaluador, EvaluadorPK> evaluadorPK;
    public static volatile SingularAttribute<Evaluador, String> estado;
    public static volatile SingularAttribute<Evaluador, PreEvaluacion> preEvaluacion;
    public static volatile SingularAttribute<Evaluador, Short> departamento;
    public static volatile SingularAttribute<Evaluador, Empleados> empleados;
    public static volatile SingularAttribute<Evaluador, String> criterioEvaluacion;
    public static volatile ListAttribute<Evaluador, Evaluado> evaluadoList;

}