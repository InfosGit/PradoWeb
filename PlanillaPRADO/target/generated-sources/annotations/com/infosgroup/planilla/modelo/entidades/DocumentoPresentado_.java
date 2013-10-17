package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresentadoPK;
import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DocumentoPresentado.class)
public class DocumentoPresentado_ { 

    public static volatile SingularAttribute<DocumentoPresentado, String> observacion;
    public static volatile SingularAttribute<DocumentoPresentado, Candidato> candidato;
    public static volatile SingularAttribute<DocumentoPresentado, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<DocumentoPresentado, DocumentoPresentadoPK> documentoPresentadoPK;
    public static volatile SingularAttribute<DocumentoPresentado, String> ubicacion;

}