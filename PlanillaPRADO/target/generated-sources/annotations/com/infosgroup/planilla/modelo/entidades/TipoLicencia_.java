package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.TipoLicenciaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoLicencia.class)
public class TipoLicencia_ { 

    public static volatile ListAttribute<TipoLicencia, Candidato> candidatoList1;
    public static volatile SingularAttribute<TipoLicencia, String> descTipo;
    public static volatile ListAttribute<TipoLicencia, Candidato> candidatoList;
    public static volatile SingularAttribute<TipoLicencia, TipoLicenciaPK> tipoLicenciaPK;

}