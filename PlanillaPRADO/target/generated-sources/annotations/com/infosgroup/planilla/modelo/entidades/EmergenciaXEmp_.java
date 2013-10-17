package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.EmergenciaXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EmergenciaXEmp.class)
public class EmergenciaXEmp_ { 

    public static volatile SingularAttribute<EmergenciaXEmp, String> nombre;
    public static volatile SingularAttribute<EmergenciaXEmp, Short> codParentesco;
    public static volatile SingularAttribute<EmergenciaXEmp, EmergenciaXEmpPK> emergenciaXEmpPK;
    public static volatile SingularAttribute<EmergenciaXEmp, String> telefono;
    public static volatile SingularAttribute<EmergenciaXEmp, Empleados> empleados;

}