package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ReferenciaPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Referencia.class)
public class Referencia_ { 

    public static volatile SingularAttribute<Referencia, String> tiempo;
    public static volatile SingularAttribute<Referencia, String> nomReferencia;
    public static volatile SingularAttribute<Referencia, Candidato> candidato;
    public static volatile SingularAttribute<Referencia, ReferenciaPK> referenciaPK;
    public static volatile SingularAttribute<Referencia, String> email;
    public static volatile SingularAttribute<Referencia, String> puesto;
    public static volatile SingularAttribute<Referencia, String> lugar;
    public static volatile SingularAttribute<Referencia, String> telefono;
    public static volatile SingularAttribute<Referencia, BigDecimal> sueldo;
    public static volatile SingularAttribute<Referencia, String> motivoRetiro;
    public static volatile SingularAttribute<Referencia, Character> tipoReferencia;

}