package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CausasRenunciaPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(CausasRenuncia.class)
public class CausasRenuncia_ { 

    public static volatile ListAttribute<CausasRenuncia, Empleados> empleadosList;
    public static volatile SingularAttribute<CausasRenuncia, String> status;
    public static volatile SingularAttribute<CausasRenuncia, String> otras;
    public static volatile SingularAttribute<CausasRenuncia, CausasRenunciaPK> causasRenunciaPK;
    public static volatile SingularAttribute<CausasRenuncia, String> descripcion;

}