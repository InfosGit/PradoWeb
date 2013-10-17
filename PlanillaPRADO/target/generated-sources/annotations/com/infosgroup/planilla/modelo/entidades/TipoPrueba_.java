package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.TipoPruebaPK;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXCandidato;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoPrueba.class)
public class TipoPrueba_ { 

    public static volatile SingularAttribute<TipoPrueba, TipoPruebaPK> tipoPruebaPK;
    public static volatile SingularAttribute<TipoPrueba, String> nomTipoPrueba;
    public static volatile ListAttribute<TipoPrueba, TipoPruebaXCandidato> tipoPruebaXCandidatoList;

}