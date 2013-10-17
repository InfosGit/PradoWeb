package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.HisEmpleoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(HisEmpleo.class)
public class HisEmpleo_ { 

    public static volatile SingularAttribute<HisEmpleo, Candidato> candidato;
    public static volatile SingularAttribute<HisEmpleo, String> nomEmpresa;
    public static volatile SingularAttribute<HisEmpleo, Date> fechRetiro;
    public static volatile SingularAttribute<HisEmpleo, HisEmpleoPK> hisEmpleoPK;
    public static volatile SingularAttribute<HisEmpleo, Date> fechIngreso;

}