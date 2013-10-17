package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.SupervisionObraPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(SupervisionObra.class)
public class SupervisionObra_ { 

    public static volatile SingularAttribute<SupervisionObra, Short> diasTrans;
    public static volatile SingularAttribute<SupervisionObra, SupervisionObraPK> supervisionObraPK;
    public static volatile SingularAttribute<SupervisionObra, Short> diasProgra;
    public static volatile SingularAttribute<SupervisionObra, Date> fechaInicio;

}