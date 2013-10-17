package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.entidades.TipoRespuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, RespuestaPK> respuestaPK;
    public static volatile SingularAttribute<Respuesta, TipoRespuesta> tipoRespuesta;
    public static volatile SingularAttribute<Respuesta, String> texto;
    public static volatile SingularAttribute<Respuesta, Long> valor;
    public static volatile ListAttribute<Respuesta, Pregunta> preguntaList;
    public static volatile SingularAttribute<Respuesta, String> nivel;

}