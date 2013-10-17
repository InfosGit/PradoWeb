package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ProgramacionPlaPK;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ProgramacionPla.class)
public class ProgramacionPla_ { 

    public static volatile SingularAttribute<ProgramacionPla, Date> fechaFinal;
    public static volatile SingularAttribute<ProgramacionPla, Short> anio;
    public static volatile SingularAttribute<ProgramacionPla, String> observacion;
    public static volatile SingularAttribute<ProgramacionPla, Date> fecha;
    public static volatile SingularAttribute<ProgramacionPla, Date> fechaInicial;
    public static volatile SingularAttribute<ProgramacionPla, String> status;
    public static volatile SingularAttribute<ProgramacionPla, Short> mes;
    public static volatile SingularAttribute<ProgramacionPla, ProgramacionPlaPK> programacionPlaPK;
    public static volatile SingularAttribute<ProgramacionPla, Short> numPlanilla;
    public static volatile SingularAttribute<ProgramacionPla, TiposPlanilla> tiposPlanilla;
    public static volatile SingularAttribute<ProgramacionPla, Date> fechaPago;
    public static volatile SingularAttribute<ProgramacionPla, Short> quincena;

}