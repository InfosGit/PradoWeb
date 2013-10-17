package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.ContratoPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:22")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, Date> fechaFinal;
    public static volatile SingularAttribute<Contrato, Candidato> candidato;
    public static volatile SingularAttribute<Contrato, Short> codSucursal;
    public static volatile SingularAttribute<Contrato, Puestos> puestos;
    public static volatile SingularAttribute<Contrato, String> observacion;
    public static volatile SingularAttribute<Contrato, String> estado;
    public static volatile SingularAttribute<Contrato, BigDecimal> salario;
    public static volatile SingularAttribute<Contrato, Date> fechaAcuerdo;
    public static volatile SingularAttribute<Contrato, String> tipo;
    public static volatile SingularAttribute<Contrato, Short> codAgencia;
    public static volatile SingularAttribute<Contrato, Empleados> empleados;
    public static volatile SingularAttribute<Contrato, TiposPlanilla> tiposPlanilla;
    public static volatile SingularAttribute<Contrato, String> numActa;
    public static volatile SingularAttribute<Contrato, Date> fechaInicio;
    public static volatile SingularAttribute<Contrato, ContratoPK> contratoPK;

}