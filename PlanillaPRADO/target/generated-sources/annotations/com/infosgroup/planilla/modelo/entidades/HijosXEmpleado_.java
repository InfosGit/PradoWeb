package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.HijosXEmpleadoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(HijosXEmpleado.class)
public class HijosXEmpleado_ { 

    public static volatile SingularAttribute<HijosXEmpleado, String> nombre;
    public static volatile SingularAttribute<HijosXEmpleado, Empleados> empleados;
    public static volatile SingularAttribute<HijosXEmpleado, String> sexo;
    public static volatile SingularAttribute<HijosXEmpleado, HijosXEmpleadoPK> hijosXEmpleadoPK;
    public static volatile SingularAttribute<HijosXEmpleado, Date> fechaNacimiento;

}