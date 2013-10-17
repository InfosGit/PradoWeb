package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EntrevistaXCandidato.class)
public class EntrevistaXCandidato_ { 

    public static volatile SingularAttribute<EntrevistaXCandidato, EntrevistaXCandidatoPK> entrevistaXCandidatoPK;
    public static volatile SingularAttribute<EntrevistaXCandidato, Date> fecha;
    public static volatile SingularAttribute<EntrevistaXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<EntrevistaXCandidato, Puestos> puesto;
    public static volatile SingularAttribute<EntrevistaXCandidato, String> descripcion;
    public static volatile SingularAttribute<EntrevistaXCandidato, String> resultado;
    public static volatile SingularAttribute<EntrevistaXCandidato, String> nomEntrevistador;
    public static volatile SingularAttribute<EntrevistaXCandidato, Empleados> entrevistador;

}