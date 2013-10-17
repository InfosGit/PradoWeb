package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(CapacitacionXEmpleado.class)
public class CapacitacionXEmpleado_ { 

    public static volatile SingularAttribute<CapacitacionXEmpleado, Capacitacion> capacitacion;
    public static volatile SingularAttribute<CapacitacionXEmpleado, BigDecimal> nota;
    public static volatile SingularAttribute<CapacitacionXEmpleado, Empleados> empleados;
    public static volatile SingularAttribute<CapacitacionXEmpleado, CapacitacionXEmpleadoPK> capacitacionXEmpleadoPK;

}