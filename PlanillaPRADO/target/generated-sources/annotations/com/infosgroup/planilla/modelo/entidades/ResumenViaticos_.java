package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ResumenViaticosPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ResumenViaticos.class)
public class ResumenViaticos_ { 

    public static volatile SingularAttribute<ResumenViaticos, Short> codDepto;
    public static volatile SingularAttribute<ResumenViaticos, Short> codViatico;
    public static volatile SingularAttribute<ResumenViaticos, BigDecimal> dHospedaje;
    public static volatile SingularAttribute<ResumenViaticos, String> estado;
    public static volatile SingularAttribute<ResumenViaticos, Date> fFinal;
    public static volatile SingularAttribute<ResumenViaticos, String> status;
    public static volatile SingularAttribute<ResumenViaticos, Date> fInicial;
    public static volatile SingularAttribute<ResumenViaticos, BigDecimal> dViaticos;
    public static volatile SingularAttribute<ResumenViaticos, String> codSucursal;
    public static volatile SingularAttribute<ResumenViaticos, String> periodo;
    public static volatile SingularAttribute<ResumenViaticos, ResumenViaticosPK> resumenViaticosPK;
    public static volatile SingularAttribute<ResumenViaticos, Short> codTarifa;

}