package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ItemXPerfilPK;
import com.infosgroup.planilla.modelo.entidades.Perfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(ItemXPerfil.class)
public class ItemXPerfil_ { 

    public static volatile SingularAttribute<ItemXPerfil, ItemXPerfilPK> itemXPerfilPK;
    public static volatile SingularAttribute<ItemXPerfil, Perfil> perfil;
    public static volatile ListAttribute<ItemXPerfil, Candidato> candidatoList;

}