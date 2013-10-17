package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(CapacitacionXEmp.class)
public class CapacitacionXEmp_ { 

    public static volatile SingularAttribute<CapacitacionXEmp, String> fecha;
    public static volatile SingularAttribute<CapacitacionXEmp, Short> codInsti;
    public static volatile SingularAttribute<CapacitacionXEmp, CapacitacionXEmpPK> capacitacionXEmpPK;
    public static volatile SingularAttribute<CapacitacionXEmp, String> tipo;
    public static volatile SingularAttribute<CapacitacionXEmp, String> descripcion;
    public static volatile SingularAttribute<CapacitacionXEmp, Empleados> empleados;
    public static volatile SingularAttribute<CapacitacionXEmp, BigDecimal> horasRecibidas;
    public static volatile SingularAttribute<CapacitacionXEmp, String> nacional;
    public static volatile SingularAttribute<CapacitacionXEmp, String> nomInstitucion;

}