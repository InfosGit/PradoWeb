package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DeducPresta;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.MovDpPK;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(MovDp.class)
public class MovDp_ { 

    public static volatile SingularAttribute<MovDp, MovDpPK> movDpPK;
    public static volatile SingularAttribute<MovDp, BigDecimal> baseCalculo;
    public static volatile SingularAttribute<MovDp, Date> fechaMovto;
    public static volatile SingularAttribute<MovDp, String> status;
    public static volatile SingularAttribute<MovDp, Short> codPresta;
    public static volatile SingularAttribute<MovDp, BigDecimal> factor;
    public static volatile SingularAttribute<MovDp, ResumenAsistencia> resumenAsistencia;
    public static volatile SingularAttribute<MovDp, Integer> secuencia;
    public static volatile SingularAttribute<MovDp, DeducPresta> deducPresta;
    public static volatile SingularAttribute<MovDp, String> constancia;
    public static volatile SingularAttribute<MovDp, BigDecimal> valor;
    public static volatile SingularAttribute<MovDp, Integer> numCheque;
    public static volatile SingularAttribute<MovDp, Departamentos> departamentos;
    public static volatile SingularAttribute<MovDp, String> sumaResta;
    public static volatile SingularAttribute<MovDp, String> vpr;
    public static volatile SingularAttribute<MovDp, String> generado;

}