package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ItemXPerfil;
import com.infosgroup.planilla.modelo.entidades.PerfilPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Long> valor;
    public static volatile SingularAttribute<Perfil, String> tipo;
    public static volatile SingularAttribute<Perfil, String> descripcionPerfil;
    public static volatile SingularAttribute<Perfil, Short> codTipoPuesto;
    public static volatile SingularAttribute<Perfil, PerfilPK> perfilPK;
    public static volatile SingularAttribute<Perfil, String> nomPerfil;
    public static volatile ListAttribute<Perfil, ItemXPerfil> itemXPerfilList;

}