package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.NivelSalarialPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(NivelSalarial.class)
public class NivelSalarial_ { 

    public static volatile SingularAttribute<NivelSalarial, NivelSalarialPK> nivelSalarialPK;
    public static volatile SingularAttribute<NivelSalarial, BigDecimal> limiteSuperior;
    public static volatile SingularAttribute<NivelSalarial, BigDecimal> limiteInferior;

}