package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CriterioPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Criterio.class)
public class Criterio_ { 

    public static volatile SingularAttribute<Criterio, String> nombre;
    public static volatile SingularAttribute<Criterio, String> valorInicial;
    public static volatile SingularAttribute<Criterio, String> valor;
    public static volatile SingularAttribute<Criterio, String> query;
    public static volatile SingularAttribute<Criterio, String> valorFinal;
    public static volatile SingularAttribute<Criterio, String> entidad;
    public static volatile SingularAttribute<Criterio, String> operador;
    public static volatile SingularAttribute<Criterio, CriterioPK> criterioPK;
    public static volatile ListAttribute<Criterio, CriteriosXPuesto> criteriosXPuestoList;

}