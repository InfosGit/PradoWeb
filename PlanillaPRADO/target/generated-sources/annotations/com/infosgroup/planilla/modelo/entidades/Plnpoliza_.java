package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetPlnpoliza;
import com.infosgroup.planilla.modelo.entidades.PlnpolizaPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Plnpoliza.class)
public class Plnpoliza_ { 

    public static volatile SingularAttribute<Plnpoliza, Short> anio;
    public static volatile SingularAttribute<Plnpoliza, String> concepto;
    public static volatile ListAttribute<Plnpoliza, DetPlnpoliza> detPlnpolizaList;
    public static volatile SingularAttribute<Plnpoliza, String> status;
    public static volatile SingularAttribute<Plnpoliza, BigDecimal> totalPoliza;
    public static volatile SingularAttribute<Plnpoliza, Short> mes;
    public static volatile SingularAttribute<Plnpoliza, Short> numPlanilla;
    public static volatile SingularAttribute<Plnpoliza, PlnpolizaPK> plnpolizaPK;
    public static volatile SingularAttribute<Plnpoliza, Short> codTipopla;
    public static volatile SingularAttribute<Plnpoliza, String> numReferencia;

}