package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetAsistencia;
import com.infosgroup.planilla.modelo.entidades.DetHoraExtraAsistenciaPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetHoraExtraAsistencia.class)
public class DetHoraExtraAsistencia_ { 

    public static volatile SingularAttribute<DetHoraExtraAsistencia, Short> codDepto;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, BigDecimal> horaNivel1;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, BigDecimal> horaNivel3;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, String> estado;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, BigDecimal> horaNivel2;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, String> status;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, DetHoraExtraAsistenciaPK> detHoraExtraAsistenciaPK;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, BigDecimal> horaAprobada;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, String> actividad;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, DetAsistencia> detAsistencia;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, BigDecimal> horaExtra;
    public static volatile SingularAttribute<DetHoraExtraAsistencia, String> codSucursal;

}