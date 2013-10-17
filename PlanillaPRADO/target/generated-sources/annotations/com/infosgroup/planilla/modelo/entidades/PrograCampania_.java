package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Capacitadores;
import com.infosgroup.planilla.modelo.entidades.PrograCampaniaPK;
import com.infosgroup.planilla.modelo.entidades.TipoActividad;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-10-17T11:26:23")
@StaticMetamodel(PrograCampania.class)
public class PrograCampania_ { 

    public static volatile SingularAttribute<PrograCampania, Campania> campania;
    public static volatile SingularAttribute<PrograCampania, TipoActividad> tipoActividad;
    public static volatile SingularAttribute<PrograCampania, String> observacion;
    public static volatile SingularAttribute<PrograCampania, String> estado;
    public static volatile SingularAttribute<PrograCampania, BigDecimal> costo;
    public static volatile SingularAttribute<PrograCampania, Capacitadores> capacitadores;
    public static volatile SingularAttribute<PrograCampania, PrograCampaniaPK> prograCampaniaPK;
    public static volatile SingularAttribute<PrograCampania, Long> capacitados;

}