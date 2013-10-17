package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TiposPlanilla.class)
public class TiposPlanilla_ { 

    public static volatile ListAttribute<TiposPlanilla, Departamentos> departamentosList;
    public static volatile ListAttribute<TiposPlanilla, Empleados> empleadosList;
    public static volatile SingularAttribute<TiposPlanilla, String> nomTipopla;
    public static volatile SingularAttribute<TiposPlanilla, TiposPlanillaPK> tiposPlanillaPK;
    public static volatile SingularAttribute<TiposPlanilla, String> status;
    public static volatile ListAttribute<TiposPlanilla, ProgramacionPla> programacionPlaList;
    public static volatile SingularAttribute<TiposPlanilla, Long> diasLab;

}