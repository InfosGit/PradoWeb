package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.PasatiempoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Pasatiempo.class)
public class Pasatiempo_ { 

    public static volatile SingularAttribute<Pasatiempo, PasatiempoPK> pasatiempoPK;
    public static volatile ListAttribute<Pasatiempo, Candidato> candidatoList;
    public static volatile SingularAttribute<Pasatiempo, String> nomPasatiempo;

}