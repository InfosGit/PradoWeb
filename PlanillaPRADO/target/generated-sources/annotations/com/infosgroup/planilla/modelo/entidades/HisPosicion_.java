package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.HisPosicionPK;
import com.infosgroup.planilla.modelo.entidades.Posicion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(HisPosicion.class)
public class HisPosicion_ { 

    public static volatile SingularAttribute<HisPosicion, Date> fechaActa;
    public static volatile SingularAttribute<HisPosicion, Date> fecha;
    public static volatile SingularAttribute<HisPosicion, String> status;
    public static volatile SingularAttribute<HisPosicion, HisPosicionPK> hisPosicionPK;
    public static volatile SingularAttribute<HisPosicion, Integer> codEmp;
    public static volatile SingularAttribute<HisPosicion, String> numActa;
    public static volatile SingularAttribute<HisPosicion, String> razon;
    public static volatile SingularAttribute<HisPosicion, Posicion> posicion;
    public static volatile SingularAttribute<HisPosicion, Integer> codAutoriza;

}