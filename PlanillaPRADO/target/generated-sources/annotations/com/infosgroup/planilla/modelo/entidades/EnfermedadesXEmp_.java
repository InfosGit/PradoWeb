package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Enfermedades;
import com.infosgroup.planilla.modelo.entidades.EnfermedadesXEmpPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EnfermedadesXEmp.class)
public class EnfermedadesXEmp_ { 

    public static volatile SingularAttribute<EnfermedadesXEmp, EnfermedadesXEmpPK> enfermedadesXEmpPK;
    public static volatile SingularAttribute<EnfermedadesXEmp, Empleados> empleados;
    public static volatile SingularAttribute<EnfermedadesXEmp, String> desEnfermedad;
    public static volatile SingularAttribute<EnfermedadesXEmp, Enfermedades> enfermedades;

}