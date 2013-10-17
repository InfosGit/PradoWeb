package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.HorarioEmp;
import com.infosgroup.planilla.modelo.entidades.TipoHorarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(TipoHorario.class)
public class TipoHorario_ { 

    public static volatile SingularAttribute<TipoHorario, Short> horaFInicio;
    public static volatile SingularAttribute<TipoHorario, Short> minutosFInicio;
    public static volatile SingularAttribute<TipoHorario, Short> minutosFFin;
    public static volatile SingularAttribute<TipoHorario, Short> horaInicio;
    public static volatile SingularAttribute<TipoHorario, Short> horas;
    public static volatile SingularAttribute<TipoHorario, Short> horaFin;
    public static volatile SingularAttribute<TipoHorario, Short> minutosInicio;
    public static volatile SingularAttribute<TipoHorario, Short> horaFFin;
    public static volatile SingularAttribute<TipoHorario, TipoHorarioPK> tipoHorarioPK;
    public static volatile SingularAttribute<TipoHorario, String> desTipoHorario;
    public static volatile ListAttribute<TipoHorario, HorarioEmp> horarioEmpList;
    public static volatile SingularAttribute<TipoHorario, String> estatus;
    public static volatile SingularAttribute<TipoHorario, Short> minutosFin;

}