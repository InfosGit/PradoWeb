/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$organigrama")
@RequestScoped
public class Organigrama
{

@EJB
private transient PuestoFacade puestosFacade;
@EJB
private transient EmpleadoFacade empleadosFacade;
//
private String datosCias;
private String[] datos;
//
@PostConstruct
public void _init()
{
    List<Object[]> listaPuestos = puestosFacade.findPuestosArbolBinario();
    StringBuilder datosCiasJSONBuilder = new StringBuilder("[");

    for (Object[] puesto : listaPuestos)
        {
        datosCiasJSONBuilder.append("{codCia: ");
        datosCiasJSONBuilder.append(puesto[0]);
        datosCiasJSONBuilder.append(", codPuesto: ");
        datosCiasJSONBuilder.append(puesto[1]);
        datosCiasJSONBuilder.append(", nomPuesto: '");
        datosCiasJSONBuilder.append(puesto[2]);

        Object[] empleado = empleadosFacade.findPrimerEmpleadoByPuesto((BigDecimal) puesto[0], (BigDecimal) puesto[1]);

        datosCiasJSONBuilder.append("', nomEmpleado : '");
        datosCiasJSONBuilder.append(empleado == null ? '-' : empleado[2]);

        datosCiasJSONBuilder.append("', codCiaJefe: ");
        datosCiasJSONBuilder.append((puesto[3] == null) ? -1 : puesto[3]);
        datosCiasJSONBuilder.append(", codPuestoJefe: ");
        datosCiasJSONBuilder.append((puesto[4] == null) ? -1 : puesto[4]);
        datosCiasJSONBuilder.append("}, ");
        }
    datosCiasJSONBuilder.append("*]");
    datosCias = datosCiasJSONBuilder.toString().replace(", *]", "]");
    System.err.println(datosCias);
}

// =============================================================================
public String getDatosCias()
{
    return datosCias;
}

public void setDatosCias(String datosCias)
{
    this.datosCias = datosCias;
}

public String[] getDatos()
{
    return datos;
}

public void setDatos(String[] datos)
{
    this.datos = datos;
}
}