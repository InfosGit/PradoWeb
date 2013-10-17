package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.HistPosicionPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(HistPosicion.class)
public class HistPosicion_ { 

    public static volatile SingularAttribute<HistPosicion, HistPosicionPK> histPosicionPK;
    public static volatile SingularAttribute<HistPosicion, Date> fechaActa;
    public static volatile SingularAttribute<HistPosicion, Date> fecha;
    public static volatile SingularAttribute<HistPosicion, Date> vigenciaHasta;
    public static volatile SingularAttribute<HistPosicion, Character> status;
    public static volatile SingularAttribute<HistPosicion, Integer> codEmp;
    public static volatile SingularAttribute<HistPosicion, String> numActa;
    public static volatile SingularAttribute<HistPosicion, Date> vigenciaDesde;
    public static volatile SingularAttribute<HistPosicion, String> razon;

}