package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ParentescoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Parentesco.class)
public class Parentesco_ { 

    public static volatile SingularAttribute<Parentesco, String> nomParentesco;
    public static volatile SingularAttribute<Parentesco, ParentescoPK> parentescoPK;
    public static volatile ListAttribute<Parentesco, Candidato> candidatoList;

}