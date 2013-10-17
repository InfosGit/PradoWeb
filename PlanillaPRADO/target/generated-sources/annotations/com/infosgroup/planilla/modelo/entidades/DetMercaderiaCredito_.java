package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetMercaderiaCreditoPK;
import com.infosgroup.planilla.modelo.entidades.MercaderiaCredito;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetMercaderiaCredito.class)
public class DetMercaderiaCredito_ { 

    public static volatile SingularAttribute<DetMercaderiaCredito, DetMercaderiaCreditoPK> detMercaderiaCreditoPK;
    public static volatile SingularAttribute<DetMercaderiaCredito, Short> numPlanilla;
    public static volatile SingularAttribute<DetMercaderiaCredito, BigDecimal> cuotaSugerida;
    public static volatile SingularAttribute<DetMercaderiaCredito, Integer> codEmp;
    public static volatile SingularAttribute<DetMercaderiaCredito, Short> codTipopla;
    public static volatile SingularAttribute<DetMercaderiaCredito, BigDecimal> cuotaAprobada;
    public static volatile SingularAttribute<DetMercaderiaCredito, MercaderiaCredito> mercaderiaCredito;
    public static volatile SingularAttribute<DetMercaderiaCredito, BigDecimal> saldo;

}