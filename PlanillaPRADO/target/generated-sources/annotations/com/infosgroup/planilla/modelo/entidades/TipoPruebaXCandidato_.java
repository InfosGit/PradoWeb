package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.TipoPrueba;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXCandidatoPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoPruebaXCandidato.class)
public class TipoPruebaXCandidato_ { 

    public static volatile SingularAttribute<TipoPruebaXCandidato, TipoPrueba> tipoPrueba;
    public static volatile SingularAttribute<TipoPruebaXCandidato, TipoPruebaXCandidatoPK> tipoPruebaXCandidatoPK;
    public static volatile SingularAttribute<TipoPruebaXCandidato, BigDecimal> nota;
    public static volatile SingularAttribute<TipoPruebaXCandidato, Date> fecha;
    public static volatile SingularAttribute<TipoPruebaXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<TipoPruebaXCandidato, String> resultado;
    public static volatile SingularAttribute<TipoPruebaXCandidato, BigDecimal> costo;

}