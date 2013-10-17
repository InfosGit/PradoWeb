package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.HoraExtraResumenPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(HoraExtraResumen.class)
public class HoraExtraResumen_ { 

    public static volatile SingularAttribute<HoraExtraResumen, Short> codDepto;
    public static volatile SingularAttribute<HoraExtraResumen, HoraExtraResumenPK> horaExtraResumenPK;
    public static volatile SingularAttribute<HoraExtraResumen, BigDecimal> hXsencillas;
    public static volatile SingularAttribute<HoraExtraResumen, String> estado;
    public static volatile SingularAttribute<HoraExtraResumen, BigDecimal> hXdobles;
    public static volatile SingularAttribute<HoraExtraResumen, BigDecimal> hXf150;
    public static volatile SingularAttribute<HoraExtraResumen, BigDecimal> hXf250;
    public static volatile SingularAttribute<HoraExtraResumen, String> codSucursal;

}