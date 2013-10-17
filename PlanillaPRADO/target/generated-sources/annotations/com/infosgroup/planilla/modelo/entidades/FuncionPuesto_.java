package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.FrecuenciaFuncion;
import com.infosgroup.planilla.modelo.entidades.FuncionPuestoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(FuncionPuesto.class)
public class FuncionPuesto_ { 

    public static volatile SingularAttribute<FuncionPuesto, FuncionPuestoPK> funcionPuestoPK;
    public static volatile SingularAttribute<FuncionPuesto, String> nomFuncion;
    public static volatile SingularAttribute<FuncionPuesto, FrecuenciaFuncion> frecuenciaFuncion;
    public static volatile ListAttribute<FuncionPuesto, Puestos> puestosList;
    public static volatile SingularAttribute<FuncionPuesto, Short> codTipoPuesto;
    public static volatile SingularAttribute<FuncionPuesto, String> descFuncion;

}