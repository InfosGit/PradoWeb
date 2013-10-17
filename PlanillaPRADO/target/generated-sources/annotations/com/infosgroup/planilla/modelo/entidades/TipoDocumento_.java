package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresentado;
import com.infosgroup.planilla.modelo.entidades.TipoDocumentoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, TipoDocumentoPK> tipoDocumentoPK;
    public static volatile SingularAttribute<TipoDocumento, String> nomTipoDocumento;
    public static volatile SingularAttribute<TipoDocumento, Cias> cias;
    public static volatile ListAttribute<TipoDocumento, DocumentoPresentado> documentoPresentadoList;

}