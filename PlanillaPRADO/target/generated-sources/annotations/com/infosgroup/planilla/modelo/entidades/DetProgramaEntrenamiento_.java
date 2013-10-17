package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.DetProgramaEntrenamientoPK;
import com.infosgroup.planilla.modelo.entidades.ProgramaEntrenamiento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(DetProgramaEntrenamiento.class)
public class DetProgramaEntrenamiento_ { 

    public static volatile SingularAttribute<DetProgramaEntrenamiento, ProgramaEntrenamiento> programaEntrenamiento;
    public static volatile SingularAttribute<DetProgramaEntrenamiento, String> areaNecesidad;
    public static volatile SingularAttribute<DetProgramaEntrenamiento, String> estado;
    public static volatile SingularAttribute<DetProgramaEntrenamiento, Date> fecha;
    public static volatile SingularAttribute<DetProgramaEntrenamiento, DetProgramaEntrenamientoPK> detProgramaEntrenamientoPK;

}