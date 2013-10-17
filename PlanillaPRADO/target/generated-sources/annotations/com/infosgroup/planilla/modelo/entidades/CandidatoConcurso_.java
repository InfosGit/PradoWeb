package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(CandidatoConcurso.class)
public class CandidatoConcurso_ { 

    public static volatile SingularAttribute<CandidatoConcurso, String> observacion;
    public static volatile SingularAttribute<CandidatoConcurso, String> estado;
    public static volatile SingularAttribute<CandidatoConcurso, BigDecimal> notaEvaluacion;
    public static volatile SingularAttribute<CandidatoConcurso, CandidatoConcursoPK> candidatoConcursoPK;
    public static volatile SingularAttribute<CandidatoConcurso, Candidato> candidato1;
    public static volatile SingularAttribute<CandidatoConcurso, Date> fecha;
    public static volatile ListAttribute<CandidatoConcurso, EvaluacionCandidato> evaluacionCandidatoList;
    public static volatile SingularAttribute<CandidatoConcurso, Concurso> concurso1;

}