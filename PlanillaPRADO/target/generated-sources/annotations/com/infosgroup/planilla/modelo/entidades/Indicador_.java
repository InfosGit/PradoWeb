package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.IndicadorPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Indicador.class)
public class Indicador_ { 

    public static volatile SingularAttribute<Indicador, Long> orden;
    public static volatile SingularAttribute<Indicador, IndicadorPK> indicadorPK;
    public static volatile SingularAttribute<Indicador, String> nombreModulo;
    public static volatile SingularAttribute<Indicador, String> nombreIndicador;
    public static volatile SingularAttribute<Indicador, String> valorIndicador;

}