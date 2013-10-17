package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.GerenciaPK;
import com.infosgroup.planilla.modelo.entidades.Posicion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Gerencia.class)
public class Gerencia_ { 

    public static volatile SingularAttribute<Gerencia, Long> codigo;
    public static volatile ListAttribute<Gerencia, Posicion> posicionList;
    public static volatile SingularAttribute<Gerencia, Long> base;
    public static volatile SingularAttribute<Gerencia, GerenciaPK> gerenciaPK;
    public static volatile SingularAttribute<Gerencia, String> nomGerencia;

}