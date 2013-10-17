package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.PrograCampania;
import com.infosgroup.planilla.modelo.entidades.TipoActividadPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoActividad.class)
public class TipoActividad_ { 

    public static volatile SingularAttribute<TipoActividad, TipoActividadPK> tipoActividadPK;
    public static volatile SingularAttribute<TipoActividad, String> descripcion;
    public static volatile ListAttribute<TipoActividad, PrograCampania> prograCampaniaList;

}