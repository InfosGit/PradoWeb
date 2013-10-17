package com.infosgroup.planilla.modelo.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(FacturasPK.class)
public class FacturasPK_ { 

    public static volatile SingularAttribute<FacturasPK, String> codCliente;
    public static volatile SingularAttribute<FacturasPK, Integer> numDocto;
    public static volatile SingularAttribute<FacturasPK, Short> codCia;
    public static volatile SingularAttribute<FacturasPK, BigDecimal> saldo;
    public static volatile SingularAttribute<FacturasPK, Date> fechaDocto;

}