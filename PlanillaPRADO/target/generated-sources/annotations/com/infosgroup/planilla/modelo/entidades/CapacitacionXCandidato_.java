package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXCandidatoPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(CapacitacionXCandidato.class)
public class CapacitacionXCandidato_ { 

    public static volatile SingularAttribute<CapacitacionXCandidato, String> fecha;
    public static volatile SingularAttribute<CapacitacionXCandidato, Short> codInsti;
    public static volatile SingularAttribute<CapacitacionXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<CapacitacionXCandidato, String> tipo;
    public static volatile SingularAttribute<CapacitacionXCandidato, String> descripcion;
    public static volatile SingularAttribute<CapacitacionXCandidato, BigDecimal> horasRecibidas;
    public static volatile SingularAttribute<CapacitacionXCandidato, CapacitacionXCandidatoPK> capacitacionXCandidatoPK;
    public static volatile SingularAttribute<CapacitacionXCandidato, String> nacional;
    public static volatile SingularAttribute<CapacitacionXCandidato, String> nomInstitucion;

}