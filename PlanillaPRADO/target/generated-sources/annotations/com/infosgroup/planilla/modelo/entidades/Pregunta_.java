package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.PreguntaPK;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Pregunta.class)
public class Pregunta_ { 

    public static volatile SingularAttribute<Pregunta, PreguntaPK> preguntaPK;
    public static volatile SingularAttribute<Pregunta, String> descripcion;
    public static volatile ListAttribute<Pregunta, Respuesta> respuestaList;
    public static volatile SingularAttribute<Pregunta, Factor> factor;

}