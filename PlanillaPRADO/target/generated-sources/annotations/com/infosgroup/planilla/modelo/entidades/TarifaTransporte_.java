package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.TarifaTransportePK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(TarifaTransporte.class)
public class TarifaTransporte_ { 

    public static volatile SingularAttribute<TarifaTransporte, String> destino;
    public static volatile SingularAttribute<TarifaTransporte, TarifaTransportePK> tarifaTransportePK;
    public static volatile SingularAttribute<TarifaTransporte, BigDecimal> valPasaje;
    public static volatile SingularAttribute<TarifaTransporte, BigDecimal> valTransporte;

}