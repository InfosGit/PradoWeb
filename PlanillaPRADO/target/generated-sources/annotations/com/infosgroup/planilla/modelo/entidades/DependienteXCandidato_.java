package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.DependienteXCandidatoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DependienteXCandidato.class)
public class DependienteXCandidato_ { 

    public static volatile SingularAttribute<DependienteXCandidato, String> nombre;
    public static volatile SingularAttribute<DependienteXCandidato, Short> codParentesco;
    public static volatile SingularAttribute<DependienteXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<DependienteXCandidato, DependienteXCandidatoPK> dependienteXCandidatoPK;
    public static volatile SingularAttribute<DependienteXCandidato, String> sexo;
    public static volatile SingularAttribute<DependienteXCandidato, Date> fechaNacimiento;

}