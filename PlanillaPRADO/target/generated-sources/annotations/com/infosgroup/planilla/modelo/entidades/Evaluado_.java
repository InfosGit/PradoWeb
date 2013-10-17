package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EvaluadoPK;
import com.infosgroup.planilla.modelo.entidades.Evaluador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Evaluado.class)
public class Evaluado_ { 

    public static volatile SingularAttribute<Evaluado, Evaluador> evaluador1;
    public static volatile SingularAttribute<Evaluado, Empleados> empleados;
    public static volatile SingularAttribute<Evaluado, EvaluadoPK> evaluadoPK;

}