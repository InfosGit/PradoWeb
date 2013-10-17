package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.RelacionLaboralPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(RelacionLaboral.class)
public class RelacionLaboral_ { 

    public static volatile SingularAttribute<RelacionLaboral, Date> fechaVac;
    public static volatile SingularAttribute<RelacionLaboral, BigDecimal> salario;
    public static volatile SingularAttribute<RelacionLaboral, RelacionLaboralPK> relacionLaboralPK;
    public static volatile SingularAttribute<RelacionLaboral, Empleados> empleados;
    public static volatile SingularAttribute<RelacionLaboral, Date> fechaIni;
    public static volatile SingularAttribute<RelacionLaboral, Date> fechaFin;
    public static volatile SingularAttribute<RelacionLaboral, Date> fechaAgui;

}