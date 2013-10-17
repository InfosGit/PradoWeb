package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DeptosPK;
import com.infosgroup.planilla.modelo.entidades.Municipios;
import com.infosgroup.planilla.modelo.entidades.Paises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Deptos.class)
public class Deptos_ { 

    public static volatile SingularAttribute<Deptos, DeptosPK> deptosPK;
    public static volatile SingularAttribute<Deptos, String> nomDepto;
    public static volatile ListAttribute<Deptos, Municipios> municipiosList;
    public static volatile SingularAttribute<Deptos, String> zona;
    public static volatile SingularAttribute<Deptos, Paises> paises;

}