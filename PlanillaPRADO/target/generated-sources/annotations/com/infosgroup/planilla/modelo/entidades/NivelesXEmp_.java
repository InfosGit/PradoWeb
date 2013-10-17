package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.NivelesXEmpPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(NivelesXEmp.class)
public class NivelesXEmp_ { 

    public static volatile SingularAttribute<NivelesXEmp, Short> codDepto;
    public static volatile SingularAttribute<NivelesXEmp, Short> anioIngreso;
    public static volatile SingularAttribute<NivelesXEmp, Short> anioEgreso;
    public static volatile SingularAttribute<NivelesXEmp, NivelesXEmpPK> nivelesXEmpPK;
    public static volatile SingularAttribute<NivelesXEmp, Short> codPais;
    public static volatile SingularAttribute<NivelesXEmp, Empleados> empleados;
    public static volatile SingularAttribute<NivelesXEmp, String> estadoNivel;
    public static volatile SingularAttribute<NivelesXEmp, Short> subNivel;
    public static volatile SingularAttribute<NivelesXEmp, Date> fecEstado;
    public static volatile SingularAttribute<NivelesXEmp, String> nomInstitucion;

}