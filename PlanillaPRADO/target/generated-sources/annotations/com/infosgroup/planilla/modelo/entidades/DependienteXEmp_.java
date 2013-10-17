package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DependienteXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DependienteXEmp.class)
public class DependienteXEmp_ { 

    public static volatile SingularAttribute<DependienteXEmp, String> nombre;
    public static volatile SingularAttribute<DependienteXEmp, Short> codParentesco;
    public static volatile SingularAttribute<DependienteXEmp, Empleados> empleados;
    public static volatile SingularAttribute<DependienteXEmp, String> sexo;
    public static volatile SingularAttribute<DependienteXEmp, DependienteXEmpPK> dependienteXEmpPK;
    public static volatile SingularAttribute<DependienteXEmp, Date> fechaNacimiento;

}