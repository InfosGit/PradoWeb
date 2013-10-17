package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.AgenciasPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Agencias.class)
public class Agencias_ { 

    public static volatile SingularAttribute<Agencias, String> nomAgencia;
    public static volatile SingularAttribute<Agencias, String> dirAgencia;
    public static volatile SingularAttribute<Agencias, AgenciasPK> agenciasPK;
    public static volatile SingularAttribute<Agencias, String> faxAgencia;
    public static volatile SingularAttribute<Agencias, String> mailAgencia;
    public static volatile SingularAttribute<Agencias, String> status;
    public static volatile SingularAttribute<Agencias, String> telAgencia;
    public static volatile SingularAttribute<Agencias, Date> fecCreacion;
    public static volatile SingularAttribute<Agencias, String> encargado;
    public static volatile SingularAttribute<Agencias, Date> fecStatus;
    public static volatile SingularAttribute<Agencias, String> abrev;

}