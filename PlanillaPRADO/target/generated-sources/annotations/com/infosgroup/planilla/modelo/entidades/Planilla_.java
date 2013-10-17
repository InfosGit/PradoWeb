package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Planilla.class)
public class Planilla_ { 

    public static volatile SingularAttribute<Planilla, BigDecimal> chX250;
    public static volatile SingularAttribute<Planilla, BigDecimal> chHora;
    public static volatile SingularAttribute<Planilla, BigDecimal> prestaciones;
    public static volatile SingularAttribute<Planilla, BigDecimal> comisiones;
    public static volatile SingularAttribute<Planilla, BigDecimal> sueldoBase;
    public static volatile SingularAttribute<Planilla, Short> codDepto;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhXdoble;
    public static volatile SingularAttribute<Planilla, BigDecimal> dLaborados;
    public static volatile SingularAttribute<Planilla, BigDecimal> chX150;
    public static volatile SingularAttribute<Planilla, BigDecimal> liqRecibir;
    public static volatile SingularAttribute<Planilla, BigDecimal> chXsencilla;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhXsencilla;
    public static volatile SingularAttribute<Planilla, BigDecimal> deducciones;
    public static volatile SingularAttribute<Planilla, BigDecimal> bonificacion;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhX250;
    public static volatile SingularAttribute<Planilla, Date> fecha;
    public static volatile SingularAttribute<Planilla, String> status;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhHora;
    public static volatile SingularAttribute<Planilla, String> codSucursal;
    public static volatile SingularAttribute<Planilla, BigDecimal> factorDp;
    public static volatile SingularAttribute<Planilla, ResumenAsistencia> resumenAsistencia;
    public static volatile SingularAttribute<Planilla, String> chequeDep;
    public static volatile SingularAttribute<Planilla, String> estado;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhrNoche;
    public static volatile SingularAttribute<Planilla, Short> codSeccion;
    public static volatile SingularAttribute<Planilla, BigDecimal> totDebenga;
    public static volatile SingularAttribute<Planilla, BigDecimal> antipag;
    public static volatile SingularAttribute<Planilla, Empleados> empleados;
    public static volatile SingularAttribute<Planilla, BigDecimal> chrNoche;
    public static volatile SingularAttribute<Planilla, PlanillaPK> planillaPK;
    public static volatile SingularAttribute<Planilla, Integer> codAfp;
    public static volatile SingularAttribute<Planilla, BigDecimal> vhX150;
    public static volatile SingularAttribute<Planilla, BigDecimal> chXdoble;

}