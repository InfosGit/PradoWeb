package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.DetHoraExtraAsistencia;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetAsistencia.class)
public class DetAsistencia_ { 

    public static volatile SingularAttribute<DetAsistencia, BigDecimal> hXsencillas;
    public static volatile SingularAttribute<DetAsistencia, BigDecimal> viaticos;
    public static volatile SingularAttribute<DetAsistencia, BigDecimal> hXf150;
    public static volatile SingularAttribute<DetAsistencia, String> status;
    public static volatile SingularAttribute<DetAsistencia, Short> dNocturnidad;
    public static volatile SingularAttribute<DetAsistencia, BigDecimal> hXf250;
    public static volatile ListAttribute<DetAsistencia, DetHoraExtraAsistencia> detHoraExtraAsistenciaList;
    public static volatile SingularAttribute<DetAsistencia, String> codSucursal;
    public static volatile SingularAttribute<DetAsistencia, DetAsistenciaPK> detAsistenciaPK;
    public static volatile SingularAttribute<DetAsistencia, Short> dnLaborados;
    public static volatile SingularAttribute<DetAsistencia, Short> codDepto;
    public static volatile SingularAttribute<DetAsistencia, String> estado;
    public static volatile SingularAttribute<DetAsistencia, BigDecimal> hXdobles;
    public static volatile SingularAttribute<DetAsistencia, Short> dLaborados;
    public static volatile SingularAttribute<DetAsistencia, Empleados> empleados;

}