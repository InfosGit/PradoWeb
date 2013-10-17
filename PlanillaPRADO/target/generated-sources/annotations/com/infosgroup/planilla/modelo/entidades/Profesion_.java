package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ProfesionPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Profesion.class)
public class Profesion_ { 

    public static volatile SingularAttribute<Profesion, ProfesionPK> profesionPK;
    public static volatile SingularAttribute<Profesion, String> nomProfesion;
    public static volatile ListAttribute<Profesion, Candidato> candidatoList;

}