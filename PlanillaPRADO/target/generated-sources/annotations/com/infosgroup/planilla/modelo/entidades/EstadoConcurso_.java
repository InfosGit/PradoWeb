package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EstadoConcurso.class)
public class EstadoConcurso_ { 

    public static volatile SingularAttribute<EstadoConcurso, String> nombre;
    public static volatile ListAttribute<EstadoConcurso, Concurso> concursoList;
    public static volatile SingularAttribute<EstadoConcurso, EstadoConcursoPK> estadoConcursoPK;

}