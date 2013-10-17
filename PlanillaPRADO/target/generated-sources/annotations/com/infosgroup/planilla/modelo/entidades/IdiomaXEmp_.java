package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Idioma;
import com.infosgroup.planilla.modelo.entidades.IdiomaXEmpPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(IdiomaXEmp.class)
public class IdiomaXEmp_ { 

    public static volatile SingularAttribute<IdiomaXEmp, IdiomaXEmpPK> idiomaXEmpPK;
    public static volatile SingularAttribute<IdiomaXEmp, String> escribe;
    public static volatile SingularAttribute<IdiomaXEmp, String> lee;
    public static volatile SingularAttribute<IdiomaXEmp, Idioma> idioma;
    public static volatile SingularAttribute<IdiomaXEmp, Empleados> empleados;
    public static volatile SingularAttribute<IdiomaXEmp, String> nivel;

}