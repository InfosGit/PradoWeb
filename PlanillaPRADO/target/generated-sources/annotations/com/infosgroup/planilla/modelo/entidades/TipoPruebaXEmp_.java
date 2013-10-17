package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoPrueba;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXEmpPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoPruebaXEmp.class)
public class TipoPruebaXEmp_ { 

    public static volatile SingularAttribute<TipoPruebaXEmp, TipoPrueba> tipoPrueba;
    public static volatile SingularAttribute<TipoPruebaXEmp, BigDecimal> nota;
    public static volatile SingularAttribute<TipoPruebaXEmp, Date> fecha;
    public static volatile SingularAttribute<TipoPruebaXEmp, Empleados> empleados;
    public static volatile SingularAttribute<TipoPruebaXEmp, String> resultado;
    public static volatile SingularAttribute<TipoPruebaXEmp, TipoPruebaXEmpPK> tipoPruebaXEmpPK;
    public static volatile SingularAttribute<TipoPruebaXEmp, BigDecimal> costo;

}