package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.EmergenciaXCandidatoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(EmergenciaXCandidato.class)
public class EmergenciaXCandidato_ { 

    public static volatile SingularAttribute<EmergenciaXCandidato, String> nombre;
    public static volatile SingularAttribute<EmergenciaXCandidato, Short> codParentesco;
    public static volatile SingularAttribute<EmergenciaXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<EmergenciaXCandidato, String> telefono;
    public static volatile SingularAttribute<EmergenciaXCandidato, EmergenciaXCandidatoPK> emergenciaXCandidatoPK;

}