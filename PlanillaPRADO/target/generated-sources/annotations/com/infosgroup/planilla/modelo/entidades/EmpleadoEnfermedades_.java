package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.EmpleadoEnfermedadesPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Enfermedades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EmpleadoEnfermedades.class)
public class EmpleadoEnfermedades_ { 

    public static volatile SingularAttribute<EmpleadoEnfermedades, Date> fecProxVisit;
    public static volatile SingularAttribute<EmpleadoEnfermedades, String> sintomas;
    public static volatile SingularAttribute<EmpleadoEnfermedades, String> desdeCuandoPadece;
    public static volatile SingularAttribute<EmpleadoEnfermedades, EmpleadoEnfermedadesPK> empleadoEnfermedadesPK;
    public static volatile SingularAttribute<EmpleadoEnfermedades, Date> fecha;
    public static volatile SingularAttribute<EmpleadoEnfermedades, Empleados> empleados;
    public static volatile SingularAttribute<EmpleadoEnfermedades, String> observaciones;
    public static volatile SingularAttribute<EmpleadoEnfermedades, String> incapacidad;
    public static volatile SingularAttribute<EmpleadoEnfermedades, String> tiempoIncapacidad;
    public static volatile SingularAttribute<EmpleadoEnfermedades, Enfermedades> codEnfermedad;

}