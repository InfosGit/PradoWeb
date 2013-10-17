package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DescuentoPrestamosPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DescuentoPrestamos.class)
public class DescuentoPrestamos_ { 

    public static volatile SingularAttribute<DescuentoPrestamos, Integer> codDeduc;
    public static volatile SingularAttribute<DescuentoPrestamos, String> nomEmpleado;
    public static volatile SingularAttribute<DescuentoPrestamos, Short> numPagos;
    public static volatile SingularAttribute<DescuentoPrestamos, Integer> codPresta;
    public static volatile SingularAttribute<DescuentoPrestamos, Long> cuota;
    public static volatile SingularAttribute<DescuentoPrestamos, BigDecimal> cuotaApagar;
    public static volatile SingularAttribute<DescuentoPrestamos, BigDecimal> valorPresta;
    public static volatile SingularAttribute<DescuentoPrestamos, Long> uPago;
    public static volatile SingularAttribute<DescuentoPrestamos, Short> codDepto;
    public static volatile SingularAttribute<DescuentoPrestamos, BigDecimal> saldoActual;
    public static volatile SingularAttribute<DescuentoPrestamos, String> paga;
    public static volatile SingularAttribute<DescuentoPrestamos, Integer> codEmp;
    public static volatile SingularAttribute<DescuentoPrestamos, DescuentoPrestamosPK> descuentoPrestamosPK;
    public static volatile SingularAttribute<DescuentoPrestamos, Long> pagosHechos;
    public static volatile SingularAttribute<DescuentoPrestamos, Long> pPago;

}