package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.CompetenciasPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Competencias.class)
public class Competencias_ { 

    public static volatile SingularAttribute<Competencias, String> estado;
    public static volatile SingularAttribute<Competencias, CompetenciasPK> competenciasPK;
    public static volatile SingularAttribute<Competencias, String> nomCompetencia;
    public static volatile ListAttribute<Competencias, Puestos> puestosList;

}