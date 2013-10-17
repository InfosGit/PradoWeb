package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DocumentoPresEmpPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DocumentoPresEmp.class)
public class DocumentoPresEmp_ { 

    public static volatile SingularAttribute<DocumentoPresEmp, DocumentoPresEmpPK> documentoPresEmpPK;
    public static volatile SingularAttribute<DocumentoPresEmp, String> observacion;
    public static volatile SingularAttribute<DocumentoPresEmp, Empleados> empleados;
    public static volatile SingularAttribute<DocumentoPresEmp, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<DocumentoPresEmp, String> ubicacion;

}