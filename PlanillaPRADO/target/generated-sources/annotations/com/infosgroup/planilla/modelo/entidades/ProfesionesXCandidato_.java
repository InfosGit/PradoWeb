package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ProfesionesXCandidatoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(ProfesionesXCandidato.class)
public class ProfesionesXCandidato_ { 

    public static volatile SingularAttribute<ProfesionesXCandidato, ProfesionesXCandidatoPK> profesionesXCandidatoPK;
    public static volatile SingularAttribute<ProfesionesXCandidato, Date> fecha;
    public static volatile SingularAttribute<ProfesionesXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<ProfesionesXCandidato, String> incorporado;
    public static volatile SingularAttribute<ProfesionesXCandidato, Short> codUniversidad;

}