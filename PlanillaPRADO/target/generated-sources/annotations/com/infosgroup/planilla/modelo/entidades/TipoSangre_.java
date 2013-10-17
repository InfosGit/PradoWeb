package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoSangre.class)
public class TipoSangre_ { 

    public static volatile SingularAttribute<TipoSangre, String> nomTipoSangre;
    public static volatile SingularAttribute<TipoSangre, String> tipoSangre;
    public static volatile ListAttribute<TipoSangre, Candidato> candidatoList;

}