package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.EmpXCargoPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(EmpXCargo.class)
public class EmpXCargo_ { 

    public static volatile SingularAttribute<EmpXCargo, EmpXCargoPK> empXCargoPK;
    public static volatile SingularAttribute<EmpXCargo, Double> salarioAspirado;
    public static volatile SingularAttribute<EmpXCargo, Empleados> empleados;
    public static volatile SingularAttribute<EmpXCargo, Short> codTipoPuesto;
    public static volatile SingularAttribute<EmpXCargo, Puestos> puestos;

}