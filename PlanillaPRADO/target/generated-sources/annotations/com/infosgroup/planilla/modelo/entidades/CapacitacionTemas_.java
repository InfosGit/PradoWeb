package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemasPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(CapacitacionTemas.class)
public class CapacitacionTemas_ { 

    public static volatile SingularAttribute<CapacitacionTemas, String> nomTema;
    public static volatile SingularAttribute<CapacitacionTemas, CapacitacionAreas> capacitacionAreas;
    public static volatile ListAttribute<CapacitacionTemas, Capacitacion> capacitacionList;
    public static volatile SingularAttribute<CapacitacionTemas, CapacitacionTemasPK> capacitacionTemasPK;

}