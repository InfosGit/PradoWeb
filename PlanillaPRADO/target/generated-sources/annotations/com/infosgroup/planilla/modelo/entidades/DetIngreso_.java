package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetIngresoPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetIngreso.class)
public class DetIngreso_ { 

    public static volatile SingularAttribute<DetIngreso, BigDecimal> porcentaje;
    public static volatile SingularAttribute<DetIngreso, BigDecimal> valor;
    public static volatile SingularAttribute<DetIngreso, Date> fechaAplicacion;
    public static volatile SingularAttribute<DetIngreso, Date> fechaIngreso;
    public static volatile SingularAttribute<DetIngreso, Long> correlativo;
    public static volatile SingularAttribute<DetIngreso, DetIngresoPK> detIngresoPK;

}