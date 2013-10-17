package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ComisionMesPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(ComisionMes.class)
public class ComisionMes_ { 

    public static volatile SingularAttribute<ComisionMes, BigDecimal> totComision;
    public static volatile SingularAttribute<ComisionMes, ComisionMesPK> comisionMesPK;
    public static volatile SingularAttribute<ComisionMes, BigDecimal> comProducto;
    public static volatile SingularAttribute<ComisionMes, BigDecimal> comObra;

}