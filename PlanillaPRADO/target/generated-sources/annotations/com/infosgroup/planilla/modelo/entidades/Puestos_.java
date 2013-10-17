package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.AreasStaff;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.FuncionPuesto;
import com.infosgroup.planilla.modelo.entidades.PerfilXPuesto;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Puestos.class)
public class Puestos_ { 

    public static volatile SingularAttribute<Puestos, Long> codRangoEdad;
    public static volatile SingularAttribute<Puestos, PuestosPK> puestosPK;
    public static volatile SingularAttribute<Puestos, TipoPuesto> tipoPuesto;
    public static volatile SingularAttribute<Puestos, String> horasDob;
    public static volatile SingularAttribute<Puestos, String> viaticos;
    public static volatile SingularAttribute<Puestos, String> objetivo;
    public static volatile SingularAttribute<Puestos, Short> codLocacion;
    public static volatile SingularAttribute<Puestos, BigDecimal> salMinimo;
    public static volatile SingularAttribute<Puestos, String> comision;
    public static volatile ListAttribute<Puestos, PerfilXPuesto> perfilXPuestoList;
    public static volatile ListAttribute<Puestos, FuncionPuesto> funcionPuestoList;
    public static volatile SingularAttribute<Puestos, BigDecimal> salMaximo;
    public static volatile SingularAttribute<Puestos, String> infConf;
    public static volatile SingularAttribute<Puestos, String> codAlterno;
    public static volatile SingularAttribute<Puestos, AreasStaff> areasStaff;
    public static volatile SingularAttribute<Puestos, String> nomPuesto;
    public static volatile SingularAttribute<Puestos, String> status;
    public static volatile SingularAttribute<Puestos, Short> codGerencia;
    public static volatile SingularAttribute<Puestos, String> jefatura;
    public static volatile SingularAttribute<Puestos, String> descPuesto;
    public static volatile SingularAttribute<Puestos, Short> codCondicion;
    public static volatile SingularAttribute<Puestos, String> genero;
    public static volatile SingularAttribute<Puestos, Long> codRangoAnios;
    public static volatile SingularAttribute<Puestos, String> horasExt;
    public static volatile SingularAttribute<Puestos, Departamentos> departamentos;
    public static volatile SingularAttribute<Puestos, Short> codNivelAcademico;
    public static volatile SingularAttribute<Puestos, BigDecimal> impactoFinan;
    public static volatile SingularAttribute<Puestos, Short> puestoJefe;

}