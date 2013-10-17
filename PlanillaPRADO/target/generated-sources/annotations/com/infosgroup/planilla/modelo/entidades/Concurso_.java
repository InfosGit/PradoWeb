package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.ConcursoPK;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Concurso.class)
public class Concurso_ { 

    public static volatile SingularAttribute<Concurso, String> nombre;
    public static volatile SingularAttribute<Concurso, Date> fechaFinal;
    public static volatile SingularAttribute<Concurso, ConcursoPK> concursoPK;
    public static volatile SingularAttribute<Concurso, Date> fechaInicial;
    public static volatile SingularAttribute<Concurso, Long> numeroPlazas;
    public static volatile ListAttribute<Concurso, CandidatoConcurso> candidatoConcursoList;
    public static volatile SingularAttribute<Concurso, EstadoConcurso> estadoConcurso;
    public static volatile SingularAttribute<Concurso, String> comentarioFinal;
    public static volatile SingularAttribute<Concurso, Puestos> puestos;

}