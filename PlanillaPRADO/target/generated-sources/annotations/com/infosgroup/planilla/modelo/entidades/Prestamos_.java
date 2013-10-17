package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.PrestamosPK;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Prestamos.class)
public class Prestamos_ { 

    public static volatile SingularAttribute<Prestamos, Integer> codDeduc;
    public static volatile SingularAttribute<Prestamos, String> usuario;
    public static volatile SingularAttribute<Prestamos, Short> codPres;
    public static volatile SingularAttribute<Prestamos, BigDecimal> cuota;
    public static volatile SingularAttribute<Prestamos, String> numPrestamoref;
    public static volatile SingularAttribute<Prestamos, BigDecimal> valorPresta;
    public static volatile SingularAttribute<Prestamos, BigDecimal> uPago;
    public static volatile SingularAttribute<Prestamos, Integer> noCuenta;
    public static volatile SingularAttribute<Prestamos, BigDecimal> saldoActual;
    public static volatile SingularAttribute<Prestamos, Integer> secuencia;
    public static volatile SingularAttribute<Prestamos, String> observacion;
    public static volatile SingularAttribute<Prestamos, Long> codCliente;
    public static volatile SingularAttribute<Prestamos, BigDecimal> oPago;
    public static volatile SingularAttribute<Prestamos, Short> pagosHechos;
    public static volatile SingularAttribute<Prestamos, TiposPlanilla> tiposPlanilla;
    public static volatile SingularAttribute<Prestamos, Date> fechaCancela;
    public static volatile SingularAttribute<Prestamos, BigDecimal> pPago;
    public static volatile SingularAttribute<Prestamos, String> refOPago;
    public static volatile SingularAttribute<Prestamos, Short> ultimoAnio;
    public static volatile SingularAttribute<Prestamos, Date> fecha;
    public static volatile SingularAttribute<Prestamos, Short> numPagos;
    public static volatile SingularAttribute<Prestamos, String> descripcion;
    public static volatile SingularAttribute<Prestamos, Short> descQuinc;
    public static volatile SingularAttribute<Prestamos, PrestamosPK> prestamosPK;
    public static volatile SingularAttribute<Prestamos, String> modificadoPor;
    public static volatile SingularAttribute<Prestamos, Integer> numCheque;
    public static volatile SingularAttribute<Prestamos, Empleados> empleados;
    public static volatile SingularAttribute<Prestamos, Short> ultimoMes;
    public static volatile SingularAttribute<Prestamos, BigDecimal> cuotaReal;

}