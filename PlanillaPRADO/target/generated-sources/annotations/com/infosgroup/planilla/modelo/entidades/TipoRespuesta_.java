package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.TipoRespuestaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoRespuesta.class)
public class TipoRespuesta_ { 

    public static volatile SingularAttribute<TipoRespuesta, String> nomTipoRespuesta;
    public static volatile SingularAttribute<TipoRespuesta, TipoRespuestaPK> tipoRespuestaPK;
    public static volatile ListAttribute<TipoRespuesta, Respuesta> respuestaList;

}