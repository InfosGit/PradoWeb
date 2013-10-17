package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.NivelesXCandidatoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(NivelesXCandidato.class)
public class NivelesXCandidato_ { 

    public static volatile SingularAttribute<NivelesXCandidato, Short> codDepto;
    public static volatile SingularAttribute<NivelesXCandidato, NivelesXCandidatoPK> nivelesXCandidatoPK;
    public static volatile SingularAttribute<NivelesXCandidato, Short> anioIngreso;
    public static volatile SingularAttribute<NivelesXCandidato, Short> anioEgreso;
    public static volatile SingularAttribute<NivelesXCandidato, Candidato> candidato;
    public static volatile SingularAttribute<NivelesXCandidato, Short> codPais;
    public static volatile SingularAttribute<NivelesXCandidato, String> estadoNivel;
    public static volatile SingularAttribute<NivelesXCandidato, Short> subNivel;
    public static volatile SingularAttribute<NivelesXCandidato, Date> fecEstado;
    public static volatile SingularAttribute<NivelesXCandidato, String> nomInstitucion;

}