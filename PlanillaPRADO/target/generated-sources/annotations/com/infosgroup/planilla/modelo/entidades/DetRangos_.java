package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetRangosPK;
import com.infosgroup.planilla.modelo.entidades.PorRangos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(DetRangos.class)
public class DetRangos_ { 

    public static volatile SingularAttribute<DetRangos, BigDecimal> porcentaje;
    public static volatile SingularAttribute<DetRangos, BigDecimal> al;
    public static volatile SingularAttribute<DetRangos, PorRangos> porRangos;
    public static volatile SingularAttribute<DetRangos, BigDecimal> del;
    public static volatile SingularAttribute<DetRangos, BigDecimal> valorFijo;
    public static volatile SingularAttribute<DetRangos, BigDecimal> exceso;
    public static volatile SingularAttribute<DetRangos, DetRangosPK> detRangosPK;

}