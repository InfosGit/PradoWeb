package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.BeneficiarioXCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Parentesco;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(BeneficiarioXCandidato.class)
public class BeneficiarioXCandidato_ { 

    public static volatile SingularAttribute<BeneficiarioXCandidato, String> nombre;
    public static volatile SingularAttribute<BeneficiarioXCandidato, Parentesco> parentesco;
    public static volatile SingularAttribute<BeneficiarioXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<BeneficiarioXCandidato, BeneficiarioXCandidatoPK> beneficiarioXCandidatoPK;

}