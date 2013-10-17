package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoXCargoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(CandidatoXCargo.class)
public class CandidatoXCargo_ { 

    public static volatile SingularAttribute<CandidatoXCargo, CandidatoXCargoPK> candidatoXCargoPK;
    public static volatile SingularAttribute<CandidatoXCargo, Candidato> candidato;
    public static volatile SingularAttribute<CandidatoXCargo, Double> salarioAspirado;
    public static volatile SingularAttribute<CandidatoXCargo, Short> codTipoPuesto;
    public static volatile SingularAttribute<CandidatoXCargo, Puestos> puestos;

}