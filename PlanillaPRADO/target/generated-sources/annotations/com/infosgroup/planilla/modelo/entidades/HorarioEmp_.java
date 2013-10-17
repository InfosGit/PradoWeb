package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.HorarioEmpPK;
import com.infosgroup.planilla.modelo.entidades.TipoHorario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(HorarioEmp.class)
public class HorarioEmp_ { 

    public static volatile SingularAttribute<HorarioEmp, HorarioEmpPK> horarioEmpPK;
    public static volatile SingularAttribute<HorarioEmp, Date> fecha;
    public static volatile SingularAttribute<HorarioEmp, Date> inicio;
    public static volatile SingularAttribute<HorarioEmp, BigDecimal> horas;
    public static volatile SingularAttribute<HorarioEmp, String> status;
    public static volatile SingularAttribute<HorarioEmp, Empleados> empleados;
    public static volatile SingularAttribute<HorarioEmp, Date> fin;
    public static volatile SingularAttribute<HorarioEmp, TipoHorario> tipoHorario;

}