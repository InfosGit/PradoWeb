package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Etnia;
import com.infosgroup.planilla.modelo.entidades.Monedas;
import com.infosgroup.planilla.modelo.entidades.TiposIncapacidad;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(Cias.class)
public class Cias_ { 

    public static volatile SingularAttribute<Cias, String> direcEmpresa;
    public static volatile ListAttribute<Cias, Cias> ciasList;
    public static volatile SingularAttribute<Cias, String> nomComercial;
    public static volatile SingularAttribute<Cias, String> numeroPatronal;
    public static volatile SingularAttribute<Cias, Cias> codCiaMatriz;
    public static volatile SingularAttribute<Cias, String> codAuto;
    public static volatile SingularAttribute<Cias, Date> fechUlt;
    public static volatile SingularAttribute<Cias, String> telefEmpresa;
    public static volatile SingularAttribute<Cias, Monedas> monedas;
    public static volatile SingularAttribute<Cias, Short> anoProceso;
    public static volatile SingularAttribute<Cias, String> giro;
    public static volatile SingularAttribute<Cias, Date> fecUltCie;
    public static volatile SingularAttribute<Cias, Short> mesProceso;
    public static volatile SingularAttribute<Cias, String> utilizaProyecto;
    public static volatile SingularAttribute<Cias, String> enCierre;
    public static volatile SingularAttribute<Cias, BigDecimal> tasaPercep;
    public static volatile ListAttribute<Cias, Empleados> empleadosList;
    public static volatile SingularAttribute<Cias, Short> tipoNumeracion;
    public static volatile SingularAttribute<Cias, String> siReferencia;
    public static volatile ListAttribute<Cias, Etnia> etniaList;
    public static volatile SingularAttribute<Cias, Short> mesCierre;
    public static volatile SingularAttribute<Cias, String> nitEmpresa;
    public static volatile SingularAttribute<Cias, String> razonSocial;
    public static volatile SingularAttribute<Cias, BigDecimal> tasaIva;
    public static volatile SingularAttribute<Cias, String> ivaDl;
    public static volatile SingularAttribute<Cias, Short> codPais;
    public static volatile SingularAttribute<Cias, Short> codCia;
    public static volatile ListAttribute<Cias, TiposIncapacidad> tiposIncapacidadList;
    public static volatile SingularAttribute<Cias, String> registoIva;

}