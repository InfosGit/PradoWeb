package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DeducPresta;
import com.infosgroup.planilla.modelo.entidades.DetRangos;
import com.infosgroup.planilla.modelo.entidades.PorRangosPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PorRangos.class)
public class PorRangos_ { 

    public static volatile SingularAttribute<PorRangos, String> descipcion;
    public static volatile ListAttribute<PorRangos, DetRangos> detRangosList;
    public static volatile SingularAttribute<PorRangos, DeducPresta> deducPresta;
    public static volatile SingularAttribute<PorRangos, PorRangosPK> porRangosPK;
    public static volatile SingularAttribute<PorRangos, String> sindicato;
    public static volatile SingularAttribute<PorRangos, Short> periodo;
    public static volatile SingularAttribute<PorRangos, String> docente;

}