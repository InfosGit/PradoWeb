package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ReferenciaEmpPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ReferenciaEmp.class)
public class ReferenciaEmp_ { 

    public static volatile SingularAttribute<ReferenciaEmp, String> tiempo;
    public static volatile SingularAttribute<ReferenciaEmp, ReferenciaEmpPK> referenciaEmpPK;
    public static volatile SingularAttribute<ReferenciaEmp, String> nomReferencia;
    public static volatile SingularAttribute<ReferenciaEmp, String> email;
    public static volatile SingularAttribute<ReferenciaEmp, String> lugar;
    public static volatile SingularAttribute<ReferenciaEmp, String> telefono;
    public static volatile SingularAttribute<ReferenciaEmp, Empleados> empleados;
    public static volatile SingularAttribute<ReferenciaEmp, BigDecimal> sueldo;
    public static volatile SingularAttribute<ReferenciaEmp, String> motivoRetiro;
    public static volatile SingularAttribute<ReferenciaEmp, Character> tipoReferencia;

}