package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ColateralesEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ColateralesEmp.class)
public class ColateralesEmp_ { 

    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> valorCarrera;
    public static volatile SingularAttribute<ColateralesEmp, Empleados> empleados;
    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> nivelAcademico;
    public static volatile SingularAttribute<ColateralesEmp, ColateralesEmpPK> colateralesEmpPK;
    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> meritosProf;
    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> aniosServicio;
    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> derechosAdquiridos;
    public static volatile SingularAttribute<ColateralesEmp, BigDecimal> colectivo;

}