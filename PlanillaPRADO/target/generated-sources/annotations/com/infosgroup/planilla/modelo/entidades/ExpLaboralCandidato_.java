package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ExpLaboralCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ExpLaboralCandidato.class)
public class ExpLaboralCandidato_ { 

    public static volatile SingularAttribute<ExpLaboralCandidato, Candidato> candidato;
    public static volatile SingularAttribute<ExpLaboralCandidato, String> lugarTrabajo;
    public static volatile SingularAttribute<ExpLaboralCandidato, Date> fechaFin;
    public static volatile SingularAttribute<ExpLaboralCandidato, ExpLaboralCandidatoPK> expLaboralCandidatoPK;
    public static volatile SingularAttribute<ExpLaboralCandidato, String> motivoRetiro;
    public static volatile SingularAttribute<ExpLaboralCandidato, Puestos> puestos;
    public static volatile SingularAttribute<ExpLaboralCandidato, Date> fechaInicio;

}