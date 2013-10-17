package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.RhControlVacacionesPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(RhControlVacaciones.class)
public class RhControlVacaciones_ { 

    public static volatile SingularAttribute<RhControlVacaciones, BigDecimal> diasXPagar;
    public static volatile SingularAttribute<RhControlVacaciones, BigDecimal> diasDevengados;
    public static volatile SingularAttribute<RhControlVacaciones, RhControlVacacionesPK> rhControlVacacionesPK;
    public static volatile SingularAttribute<RhControlVacaciones, Date> fecInicio;
    public static volatile SingularAttribute<RhControlVacaciones, String> estado;
    public static volatile SingularAttribute<RhControlVacaciones, BigDecimal> diasPagados;
    public static volatile SingularAttribute<RhControlVacaciones, Empleados> empleados;
    public static volatile SingularAttribute<RhControlVacaciones, Date> fecFin;
    public static volatile SingularAttribute<RhControlVacaciones, BigDecimal> diasXDevengar;
    public static volatile SingularAttribute<RhControlVacaciones, BigDecimal> saldo;

}