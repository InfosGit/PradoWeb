package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetHojaAsistencia;
import com.infosgroup.planilla.modelo.entidades.HojaAsistenciaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(HojaAsistencia.class)
public class HojaAsistencia_ { 

    public static volatile SingularAttribute<HojaAsistencia, Short> anio;
    public static volatile SingularAttribute<HojaAsistencia, Short> codDepto;
    public static volatile SingularAttribute<HojaAsistencia, HojaAsistenciaPK> hojaAsistenciaPK;
    public static volatile SingularAttribute<HojaAsistencia, Integer> codSupervi;
    public static volatile SingularAttribute<HojaAsistencia, Date> periodoIni;
    public static volatile SingularAttribute<HojaAsistencia, String> tipoObra;
    public static volatile SingularAttribute<HojaAsistencia, Short> subProy;
    public static volatile SingularAttribute<HojaAsistencia, Date> periodoFin;
    public static volatile SingularAttribute<HojaAsistencia, String> codSucursal;
    public static volatile SingularAttribute<HojaAsistencia, Integer> codObra;
    public static volatile ListAttribute<HojaAsistencia, DetHojaAsistencia> detHojaAsistenciaList;

}