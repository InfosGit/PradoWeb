package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CampaniaPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Campania.class)
public class Campania_ { 

    public static volatile SingularAttribute<Campania, Date> fechaFinal;
    public static volatile SingularAttribute<Campania, String> estado;
    public static volatile SingularAttribute<Campania, BigDecimal> nota;
    public static volatile SingularAttribute<Campania, Date> fechaInicial;
    public static volatile ListAttribute<Campania, Evaluacion> evaluacionList;
    public static volatile SingularAttribute<Campania, Long> codArea;
    public static volatile SingularAttribute<Campania, String> nomCampania;
    public static volatile ListAttribute<Campania, PreEvaluacion> preEvaluacionList;
    public static volatile SingularAttribute<Campania, CampaniaPK> campaniaPK;

}