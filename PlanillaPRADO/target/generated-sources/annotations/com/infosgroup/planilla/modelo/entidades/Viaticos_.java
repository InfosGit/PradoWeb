package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ViaticosPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Viaticos.class)
public class Viaticos_ { 

    public static volatile SingularAttribute<Viaticos, String> categoria;
    public static volatile SingularAttribute<Viaticos, BigDecimal> valViaticosL;
    public static volatile SingularAttribute<Viaticos, ViaticosPK> viaticosPK;
    public static volatile SingularAttribute<Viaticos, BigDecimal> valViaticosC;
    public static volatile SingularAttribute<Viaticos, BigDecimal> valHospedajeC;
    public static volatile SingularAttribute<Viaticos, BigDecimal> valHospedajeL;
    public static volatile SingularAttribute<Viaticos, Short> zona;

}