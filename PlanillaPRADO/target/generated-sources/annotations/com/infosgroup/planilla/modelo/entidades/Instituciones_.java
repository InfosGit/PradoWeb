package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.DetInstitucion;
import com.infosgroup.planilla.modelo.entidades.InstitucionesPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Instituciones.class)
public class Instituciones_ { 

    public static volatile SingularAttribute<Instituciones, Integer> codDp;
    public static volatile SingularAttribute<Instituciones, InstitucionesPK> institucionesPK;
    public static volatile SingularAttribute<Instituciones, String> nomCortoInsti;
    public static volatile ListAttribute<Instituciones, DetInstitucion> detInstitucionList;
    public static volatile SingularAttribute<Instituciones, String> desInsti;
    public static volatile SingularAttribute<Instituciones, String> dirInsti;
    public static volatile SingularAttribute<Instituciones, BigDecimal> porInnsti;
    public static volatile ListAttribute<Instituciones, Capacitacion> capacitacionList;
    public static volatile SingularAttribute<Instituciones, String> telInsti1;
    public static volatile SingularAttribute<Instituciones, String> telInsti2;

}