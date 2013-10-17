package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuestoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(PruebaXPuesto.class)
public class PruebaXPuesto_ { 

    public static volatile SingularAttribute<PruebaXPuesto, PruebaXPuestoPK> pruebaXPuestoPK;
    public static volatile SingularAttribute<PruebaXPuesto, String> nombre;
    public static volatile SingularAttribute<PruebaXPuesto, String> estado;
    public static volatile SingularAttribute<PruebaXPuesto, Cias> cias;
    public static volatile ListAttribute<PruebaXPuesto, EvaluacionCandidato> evaluacionCandidatoList;
    public static volatile SingularAttribute<PruebaXPuesto, Puestos> puestos;

}