package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.PlanillaIsssPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PlanillaIsss.class)
public class PlanillaIsss_ { 

    public static volatile SingularAttribute<PlanillaIsss, Short> codMuni;
    public static volatile SingularAttribute<PlanillaIsss, String> codObserva;
    public static volatile SingularAttribute<PlanillaIsss, Short> codDepto;
    public static volatile SingularAttribute<PlanillaIsss, String> id;
    public static volatile SingularAttribute<PlanillaIsss, String> nombre;
    public static volatile SingularAttribute<PlanillaIsss, String> noAfilacion;
    public static volatile SingularAttribute<PlanillaIsss, Short> diasRemunerados;
    public static volatile SingularAttribute<PlanillaIsss, Short> codPais;
    public static volatile SingularAttribute<PlanillaIsss, String> tipoDocto;
    public static volatile SingularAttribute<PlanillaIsss, BigDecimal> salDebengado;
    public static volatile SingularAttribute<PlanillaIsss, Short> codTipopla;
    public static volatile SingularAttribute<PlanillaIsss, PlanillaIsssPK> planillaIsssPK;
    public static volatile SingularAttribute<PlanillaIsss, String> noPatronal;
    public static volatile SingularAttribute<PlanillaIsss, Short> diasVacacion;
    public static volatile SingularAttribute<PlanillaIsss, String> horasJornada;

}