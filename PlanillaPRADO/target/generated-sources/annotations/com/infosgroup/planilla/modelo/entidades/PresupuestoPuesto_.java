package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.PresupuestoDepto;
import com.infosgroup.planilla.modelo.entidades.PresupuestoPuestoPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(PresupuestoPuesto.class)
public class PresupuestoPuesto_ { 

    public static volatile SingularAttribute<PresupuestoPuesto, PresupuestoPuestoPK> presupuestoPuestoPK;
    public static volatile SingularAttribute<PresupuestoPuesto, String> estado;
    public static volatile SingularAttribute<PresupuestoPuesto, BigDecimal> valorAprobado;
    public static volatile SingularAttribute<PresupuestoPuesto, Short> cantidad;
    public static volatile SingularAttribute<PresupuestoPuesto, String> descripcion;
    public static volatile SingularAttribute<PresupuestoPuesto, PresupuestoDepto> presupuestoDepto;
    public static volatile SingularAttribute<PresupuestoPuesto, BigDecimal> valorPresupuestado;

}