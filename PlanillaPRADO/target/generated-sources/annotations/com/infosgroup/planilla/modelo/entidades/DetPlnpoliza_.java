package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetPlnpolizaPK;
import com.infosgroup.planilla.modelo.entidades.Plnpoliza;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetPlnpoliza.class)
public class DetPlnpoliza_ { 

    public static volatile SingularAttribute<DetPlnpoliza, Plnpoliza> plnpoliza;
    public static volatile SingularAttribute<DetPlnpoliza, String> concepto;
    public static volatile SingularAttribute<DetPlnpoliza, Integer> cta5;
    public static volatile SingularAttribute<DetPlnpoliza, Short> cta4;
    public static volatile SingularAttribute<DetPlnpoliza, Short> cta3;
    public static volatile SingularAttribute<DetPlnpoliza, Short> cta2;
    public static volatile SingularAttribute<DetPlnpoliza, Short> cta1;
    public static volatile SingularAttribute<DetPlnpoliza, DetPlnpolizaPK> detPlnpolizaPK;
    public static volatile SingularAttribute<DetPlnpoliza, Integer> subActiv;
    public static volatile SingularAttribute<DetPlnpoliza, String> tipoActiv;
    public static volatile SingularAttribute<DetPlnpoliza, String> proyecto;
    public static volatile SingularAttribute<DetPlnpoliza, BigDecimal> cargo;
    public static volatile SingularAttribute<DetPlnpoliza, Short> codDepto;
    public static volatile SingularAttribute<DetPlnpoliza, Short> codTipopla;
    public static volatile SingularAttribute<DetPlnpoliza, BigDecimal> abono;

}