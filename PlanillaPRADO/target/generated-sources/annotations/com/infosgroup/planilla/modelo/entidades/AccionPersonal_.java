package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.AccionPersonalPK;
import com.infosgroup.planilla.modelo.entidades.CausasRenuncia;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Posicion;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(AccionPersonal.class)
public class AccionPersonal_ { 

    public static volatile SingularAttribute<AccionPersonal, Short> anio;
    public static volatile SingularAttribute<AccionPersonal, Date> fechaFinal;
    public static volatile SingularAttribute<AccionPersonal, AccionPersonalPK> accionPersonalPK;
    public static volatile SingularAttribute<AccionPersonal, Short> horas;
    public static volatile SingularAttribute<AccionPersonal, TipoAccion> tipoAccion;
    public static volatile SingularAttribute<AccionPersonal, Integer> hrsExtraNocturna;
    public static volatile SingularAttribute<AccionPersonal, String> aprobadoRh;
    public static volatile SingularAttribute<AccionPersonal, Puestos> puestos;
    public static volatile SingularAttribute<AccionPersonal, String> aprobadoJefe;
    public static volatile SingularAttribute<AccionPersonal, Double> dias;
    public static volatile SingularAttribute<AccionPersonal, Date> fApruebaRh;
    public static volatile SingularAttribute<AccionPersonal, Puestos> nuevoPuesto;
    public static volatile SingularAttribute<AccionPersonal, BigDecimal> porcentaje;
    public static volatile SingularAttribute<AccionPersonal, String> observacion;
    public static volatile SingularAttribute<AccionPersonal, Date> fechaInicial;
    public static volatile SingularAttribute<AccionPersonal, Short> mes;
    public static volatile SingularAttribute<AccionPersonal, BigDecimal> cantidad;
    public static volatile SingularAttribute<AccionPersonal, Date> periodoFinal;
    public static volatile SingularAttribute<AccionPersonal, Short> codTipopla;
    public static volatile SingularAttribute<AccionPersonal, String> formaAumento;
    public static volatile SingularAttribute<AccionPersonal, Date> periodo;
    public static volatile SingularAttribute<AccionPersonal, Departamentos> nuevoDepartamento;
    public static volatile SingularAttribute<AccionPersonal, Posicion> posicion;
    public static volatile SingularAttribute<AccionPersonal, Integer> hrsNormalNocturna;
    public static volatile SingularAttribute<AccionPersonal, String> devengadas;
    public static volatile SingularAttribute<AccionPersonal, Date> fecha;
    public static volatile SingularAttribute<AccionPersonal, Short> tipoIngreso;
    public static volatile SingularAttribute<AccionPersonal, String> status;
    public static volatile SingularAttribute<AccionPersonal, Empleados> empleados1;
    public static volatile SingularAttribute<AccionPersonal, String> usuarioCreacion;
    public static volatile SingularAttribute<AccionPersonal, Date> fechaCanje;
    public static volatile SingularAttribute<AccionPersonal, Integer> hrsExtraDiurna;
    public static volatile SingularAttribute<AccionPersonal, Integer> codTipoIncapacidad;
    public static volatile SingularAttribute<AccionPersonal, BigDecimal> sueldoAnterior;
    public static volatile SingularAttribute<AccionPersonal, Short> numPlanilla;
    public static volatile SingularAttribute<AccionPersonal, Empleados> empleados;
    public static volatile SingularAttribute<AccionPersonal, Departamentos> departamentos;
    public static volatile SingularAttribute<AccionPersonal, Integer> hrsNormalDiurna;
    public static volatile SingularAttribute<AccionPersonal, CausasRenuncia> causasRenuncia;
    public static volatile SingularAttribute<AccionPersonal, Date> fApruebaJefe;
    public static volatile SingularAttribute<AccionPersonal, BigDecimal> monto;

}