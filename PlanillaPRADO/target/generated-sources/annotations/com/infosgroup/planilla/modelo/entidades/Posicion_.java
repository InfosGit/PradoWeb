package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.entidades.HisPosicion;
import com.infosgroup.planilla.modelo.entidades.PosicionPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.Secciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Posicion.class)
public class Posicion_ { 

    public static volatile SingularAttribute<Posicion, Secciones> secciones;
    public static volatile SingularAttribute<Posicion, String> status;
    public static volatile SingularAttribute<Posicion, Integer> codEmp;
    public static volatile SingularAttribute<Posicion, Puestos> puestos;
    public static volatile SingularAttribute<Posicion, PosicionPK> posicionPK;
    public static volatile SingularAttribute<Posicion, Gerencia> gerencia;
    public static volatile ListAttribute<Posicion, HisPosicion> hisPosicionList;
    public static volatile ListAttribute<Posicion, AccionPersonal> accionPersonalList;

}