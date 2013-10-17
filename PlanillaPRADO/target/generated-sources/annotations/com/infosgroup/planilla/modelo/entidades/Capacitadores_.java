package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CapacitadoresPK;
import com.infosgroup.planilla.modelo.entidades.PrograCampania;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Capacitadores.class)
public class Capacitadores_ { 

    public static volatile SingularAttribute<Capacitadores, String> nombre;
    public static volatile SingularAttribute<Capacitadores, CapacitadoresPK> capacitadoresPK;
    public static volatile SingularAttribute<Capacitadores, String> tipo;
    public static volatile ListAttribute<Capacitadores, PrograCampania> prograCampaniaList;

}