package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.MovPatronoPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(MovPatrono.class)
public class MovPatrono_ { 

    public static volatile SingularAttribute<MovPatrono, BigDecimal> baseCalculo;
    public static volatile SingularAttribute<MovPatrono, Short> codDp;
    public static volatile SingularAttribute<MovPatrono, Date> fechaMovto;
    public static volatile SingularAttribute<MovPatrono, String> status;
    public static volatile SingularAttribute<MovPatrono, Integer> codPresta;
    public static volatile SingularAttribute<MovPatrono, BigDecimal> factor;
    public static volatile SingularAttribute<MovPatrono, MovPatronoPK> movPatronoPK;
    public static volatile SingularAttribute<MovPatrono, Integer> secuencia;
    public static volatile SingularAttribute<MovPatrono, BigDecimal> valor;
    public static volatile SingularAttribute<MovPatrono, Integer> numCheque;
    public static volatile SingularAttribute<MovPatrono, Integer> codEmp;
    public static volatile SingularAttribute<MovPatrono, String> sumaResta;
    public static volatile SingularAttribute<MovPatrono, Short> codTipopla;
    public static volatile SingularAttribute<MovPatrono, String> vpr;
    public static volatile SingularAttribute<MovPatrono, String> generado;

}