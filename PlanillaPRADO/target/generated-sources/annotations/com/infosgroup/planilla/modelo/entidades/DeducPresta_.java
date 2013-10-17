package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.BasesCalculo;
import com.infosgroup.planilla.modelo.entidades.CtasXDepto;
import com.infosgroup.planilla.modelo.entidades.DeducPresta;
import com.infosgroup.planilla.modelo.entidades.DeducPrestaPK;
import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.PorRangos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(DeducPresta.class)
public class DeducPresta_ { 

    public static volatile SingularAttribute<DeducPresta, String> afp;
    public static volatile SingularAttribute<DeducPresta, String> desDp;
    public static volatile ListAttribute<DeducPresta, MovDp> movDpList;
    public static volatile ListAttribute<DeducPresta, DeducPresta> deducPrestaList1;
    public static volatile SingularAttribute<DeducPresta, BigDecimal> valRef;
    public static volatile SingularAttribute<DeducPresta, String> frecuencia;
    public static volatile SingularAttribute<DeducPresta, String> dIsss;
    public static volatile ListAttribute<DeducPresta, DeducPresta> deducPrestaList;
    public static volatile ListAttribute<DeducPresta, CtasXDepto> ctasXDeptoList;
    public static volatile SingularAttribute<DeducPresta, DeducPrestaPK> deducPrestaPK;
    public static volatile SingularAttribute<DeducPresta, String> sumaResta;
    public static volatile SingularAttribute<DeducPresta, String> dAfp;
    public static volatile SingularAttribute<DeducPresta, Short> posicion;
    public static volatile SingularAttribute<DeducPresta, Short> seContabiliza;
    public static volatile SingularAttribute<DeducPresta, String> cta5;
    public static volatile SingularAttribute<DeducPresta, String> cta4;
    public static volatile SingularAttribute<DeducPresta, String> cta3;
    public static volatile SingularAttribute<DeducPresta, String> cta2;
    public static volatile SingularAttribute<DeducPresta, String> cta1;
    public static volatile SingularAttribute<DeducPresta, String> desCorta;
    public static volatile ListAttribute<DeducPresta, PorRangos> porRangosList;
    public static volatile SingularAttribute<DeducPresta, String> aplicar;
    public static volatile SingularAttribute<DeducPresta, BigDecimal> factor;
    public static volatile SingularAttribute<DeducPresta, String> programado;
    public static volatile SingularAttribute<DeducPresta, String> constancia;
    public static volatile SingularAttribute<DeducPresta, String> dIsr;
    public static volatile SingularAttribute<DeducPresta, String> tipo;
    public static volatile SingularAttribute<DeducPresta, BasesCalculo> codBase;
    public static volatile SingularAttribute<DeducPresta, String> vpr;

}