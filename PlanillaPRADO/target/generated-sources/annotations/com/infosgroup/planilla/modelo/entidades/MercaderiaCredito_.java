package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetMercaderiaCredito;
import com.infosgroup.planilla.modelo.entidades.MercaderiaCreditoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(MercaderiaCredito.class)
public class MercaderiaCredito_ { 

    public static volatile SingularAttribute<MercaderiaCredito, Date> fechaFinal;
    public static volatile SingularAttribute<MercaderiaCredito, MercaderiaCreditoPK> mercaderiaCreditoPK;
    public static volatile SingularAttribute<MercaderiaCredito, String> estado;
    public static volatile SingularAttribute<MercaderiaCredito, Date> fechaInicial;
    public static volatile SingularAttribute<MercaderiaCredito, Short> numPlanilla;
    public static volatile SingularAttribute<MercaderiaCredito, Short> codTipopla;
    public static volatile ListAttribute<MercaderiaCredito, DetMercaderiaCredito> detMercaderiaCreditoList;

}