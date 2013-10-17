package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.InfoPlanillaPK;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(InfoPlanilla.class)
public class InfoPlanilla_ { 

    public static volatile SingularAttribute<InfoPlanilla, BigInteger> bonificacion;
    public static volatile SingularAttribute<InfoPlanilla, BigInteger> viatico;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> vextra;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> afp;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> sueldo;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> indemnizacion;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> isss;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> sueldoBase;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> renta;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> aguinaldo;
    public static volatile SingularAttribute<InfoPlanilla, BigInteger> comision;
    public static volatile SingularAttribute<InfoPlanilla, String> nombre;
    public static volatile SingularAttribute<InfoPlanilla, Short> codDepto;
    public static volatile SingularAttribute<InfoPlanilla, BigInteger> excindem;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> dLaborados;
    public static volatile SingularAttribute<InfoPlanilla, InfoPlanillaPK> infoPlanillaPK;
    public static volatile SingularAttribute<InfoPlanilla, BigDecimal> vacacion;

}