package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Posicion;
import com.infosgroup.planilla.modelo.entidades.SeccionesPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Secciones.class)
public class Secciones_ { 

    public static volatile ListAttribute<Secciones, Posicion> posicionList;
    public static volatile SingularAttribute<Secciones, Departamentos> departamentos;
    public static volatile SingularAttribute<Secciones, String> nomSeccion;
    public static volatile SingularAttribute<Secciones, SeccionesPK> seccionesPK;
    public static volatile SingularAttribute<Secciones, String> proyecto;

}