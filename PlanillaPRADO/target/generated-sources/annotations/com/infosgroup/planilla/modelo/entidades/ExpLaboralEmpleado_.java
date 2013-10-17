package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralEmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ExpLaboralEmpleado.class)
public class ExpLaboralEmpleado_ { 

    public static volatile SingularAttribute<ExpLaboralEmpleado, ExpLaboralEmpleadoPK> expLaboralEmpleadoPK;
    public static volatile SingularAttribute<ExpLaboralEmpleado, String> lugarTrabajo;
    public static volatile SingularAttribute<ExpLaboralEmpleado, Empleados> empleados;
    public static volatile SingularAttribute<ExpLaboralEmpleado, Date> fechaFin;
    public static volatile SingularAttribute<ExpLaboralEmpleado, String> motivoRetiro;
    public static volatile SingularAttribute<ExpLaboralEmpleado, Puestos> puestos;
    public static volatile SingularAttribute<ExpLaboralEmpleado, Date> fechaInicio;

}