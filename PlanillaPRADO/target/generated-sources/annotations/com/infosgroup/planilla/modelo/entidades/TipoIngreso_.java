package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.TipoIngresoPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoIngreso.class)
public class TipoIngreso_ { 

    public static volatile SingularAttribute<TipoIngreso, TipoIngresoPK> tipoIngresoPK;
    public static volatile SingularAttribute<TipoIngreso, String> vpr;
    public static volatile SingularAttribute<TipoIngreso, BigDecimal> factor;
    public static volatile SingularAttribute<TipoIngreso, String> nomIngreso;

}