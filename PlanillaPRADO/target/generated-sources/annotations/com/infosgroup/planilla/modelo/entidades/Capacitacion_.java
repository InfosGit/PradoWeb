package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CapacitacionAreas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.Capacitadores;
import com.infosgroup.planilla.modelo.entidades.GastoXCapacitacion;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Capacitacion.class)
public class Capacitacion_ { 

    public static volatile ListAttribute<Capacitacion, GastoXCapacitacion> gastoXCapacitacionList;
    public static volatile SingularAttribute<Capacitacion, Date> fechaDesde;
    public static volatile ListAttribute<Capacitacion, CapacitacionAsistencia> capacitacionAsistenciaList;
    public static volatile SingularAttribute<Capacitacion, Instituciones> instituciones;
    public static volatile SingularAttribute<Capacitacion, CapacitacionPK> capacitacionPK;
    public static volatile SingularAttribute<Capacitacion, String> status;
    public static volatile SingularAttribute<Capacitacion, Date> fechaHasta;
    public static volatile SingularAttribute<Capacitacion, String> nomCapacitacion;
    public static volatile SingularAttribute<Capacitacion, String> impartidaPor;
    public static volatile SingularAttribute<Capacitacion, String> razon;
    public static volatile SingularAttribute<Capacitacion, BigDecimal> duracion;
    public static volatile SingularAttribute<Capacitacion, BigDecimal> notaCapacitacion;
    public static volatile ListAttribute<Capacitacion, CapacitacionXEmpleado> capacitacionXEmpleadoList;
    public static volatile SingularAttribute<Capacitacion, CapacitacionAreas> capacitacionAreas;
    public static volatile SingularAttribute<Capacitacion, BigDecimal> costoRazon;
    public static volatile SingularAttribute<Capacitacion, CapacitacionTemas> capacitacionTemas;
    public static volatile SingularAttribute<Capacitacion, Capacitadores> capacitadores;

}