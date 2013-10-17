package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.GastoXCapacitacionPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(GastoXCapacitacion.class)
public class GastoXCapacitacion_ { 

    public static volatile SingularAttribute<GastoXCapacitacion, Capacitacion> capacitacion;
    public static volatile SingularAttribute<GastoXCapacitacion, GastoXCapacitacionPK> gastoXCapacitacionPK;
    public static volatile SingularAttribute<GastoXCapacitacion, String> desGasto;
    public static volatile SingularAttribute<GastoXCapacitacion, BigDecimal> gasto;

}