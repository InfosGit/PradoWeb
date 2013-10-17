package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EvaluacionCandidato.class)
public class EvaluacionCandidato_ { 

    public static volatile SingularAttribute<EvaluacionCandidato, EvaluacionCandidatoPK> evaluacionCandidatoPK;
    public static volatile SingularAttribute<EvaluacionCandidato, String> observacion;
    public static volatile SingularAttribute<EvaluacionCandidato, CandidatoConcurso> candidatoConcurso;
    public static volatile SingularAttribute<EvaluacionCandidato, BigDecimal> nota;
    public static volatile SingularAttribute<EvaluacionCandidato, Date> fecha;
    public static volatile SingularAttribute<EvaluacionCandidato, PruebaXPuesto> pruebaXPuesto;

}