package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.NivelAcademicoPK;
import com.infosgroup.planilla.modelo.entidades.SubNivelAcademico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(NivelAcademico.class)
public class NivelAcademico_ { 

    public static volatile SingularAttribute<NivelAcademico, NivelAcademicoPK> nivelAcademicoPK;
    public static volatile SingularAttribute<NivelAcademico, String> nomNivelAcademico;
    public static volatile ListAttribute<NivelAcademico, SubNivelAcademico> subNivelAcademicoList;
    public static volatile ListAttribute<NivelAcademico, Candidato> candidatoList;

}