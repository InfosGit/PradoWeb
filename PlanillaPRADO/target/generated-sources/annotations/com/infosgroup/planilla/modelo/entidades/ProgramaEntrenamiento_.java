package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetProgramaEntrenamiento;
import com.infosgroup.planilla.modelo.entidades.ProgramaEntrenamientoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(ProgramaEntrenamiento.class)
public class ProgramaEntrenamiento_ { 

    public static volatile ListAttribute<ProgramaEntrenamiento, DetProgramaEntrenamiento> detProgramaEntrenamientoList;
    public static volatile SingularAttribute<ProgramaEntrenamiento, String> observacion;
    public static volatile SingularAttribute<ProgramaEntrenamiento, String> estado;
    public static volatile SingularAttribute<ProgramaEntrenamiento, Integer> codEmp;
    public static volatile SingularAttribute<ProgramaEntrenamiento, ProgramaEntrenamientoPK> programaEntrenamientoPK;

}