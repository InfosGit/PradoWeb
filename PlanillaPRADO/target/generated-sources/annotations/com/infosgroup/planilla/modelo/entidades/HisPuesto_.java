package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.HisPuestoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(HisPuesto.class)
public class HisPuesto_ { 

    public static volatile SingularAttribute<HisPuesto, Date> fecha;
    public static volatile SingularAttribute<HisPuesto, Character> status;
    public static volatile SingularAttribute<HisPuesto, Integer> codEmp;
    public static volatile SingularAttribute<HisPuesto, Puestos> puestos;
    public static volatile SingularAttribute<HisPuesto, String> razon;
    public static volatile SingularAttribute<HisPuesto, HisPuestoPK> hisPuestoPK;

}