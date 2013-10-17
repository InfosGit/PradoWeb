package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.TipoAusent;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(ResumenAsistencia.class)
public class ResumenAsistencia_ { 

    public static volatile SingularAttribute<ResumenAsistencia, Planilla> planilla;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> hXsencillas;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> viaticos;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> vacaciones;
    public static volatile SingularAttribute<ResumenAsistencia, Integer> hXf150;
    public static volatile SingularAttribute<ResumenAsistencia, String> status;
    public static volatile SingularAttribute<ResumenAsistencia, Short> dNocturnidad;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> hXf250;
    public static volatile ListAttribute<ResumenAsistencia, MovDp> movDpList;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> horasAusencia;
    public static volatile SingularAttribute<ResumenAsistencia, ResumenAsistenciaPK> resumenAsistenciaPK;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> hHora;
    public static volatile SingularAttribute<ResumenAsistencia, Short> dnLaborados;
    public static volatile SingularAttribute<ResumenAsistencia, TipoAusent> estado;
    public static volatile SingularAttribute<ResumenAsistencia, Integer> dAguinaldo;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> hXdobles;
    public static volatile SingularAttribute<ResumenAsistencia, Short> dLaborados;
    public static volatile SingularAttribute<ResumenAsistencia, BigDecimal> otros;
    public static volatile SingularAttribute<ResumenAsistencia, Agencias> agencias;
    public static volatile SingularAttribute<ResumenAsistencia, Departamentos> departamentos;
    public static volatile SingularAttribute<ResumenAsistencia, Empleados> empleados;
    public static volatile SingularAttribute<ResumenAsistencia, TiposPlanilla> tiposPlanilla;

}