package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXEmpPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(EntrevistaXEmp.class)
public class EntrevistaXEmp_ { 

    public static volatile SingularAttribute<EntrevistaXEmp, EntrevistaXEmpPK> entrevistaXEmpPK;
    public static volatile SingularAttribute<EntrevistaXEmp, Date> fecha;
    public static volatile SingularAttribute<EntrevistaXEmp, Empleados> empleado;
    public static volatile SingularAttribute<EntrevistaXEmp, Puestos> puesto;
    public static volatile SingularAttribute<EntrevistaXEmp, String> descripcion;
    public static volatile SingularAttribute<EntrevistaXEmp, String> resultado;
    public static volatile SingularAttribute<EntrevistaXEmp, String> nomEntrevistador;
    public static volatile SingularAttribute<EntrevistaXEmp, Empleados> entrevistador;

}