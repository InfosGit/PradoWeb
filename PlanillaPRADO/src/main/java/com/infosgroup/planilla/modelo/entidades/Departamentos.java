/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DEPARTAMENTOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByCodCia", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.codCia = :codCia"),
    @NamedQuery(name = "Departamentos.findByCodDepto", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.codDepto = :codDepto"),
    @NamedQuery(name = "Departamentos.findByNomDepto", query = "SELECT d FROM Departamentos d WHERE d.nomDepto = :nomDepto"),
    @NamedQuery(name = "Departamentos.findByEmpleados", query = "SELECT d FROM Departamentos d WHERE d.empleados = :empleados"),
    @NamedQuery(name = "Departamentos.findByBcta1", query = "SELECT d FROM Departamentos d WHERE d.bcta1 = :bcta1"),
    @NamedQuery(name = "Departamentos.findByBcta2", query = "SELECT d FROM Departamentos d WHERE d.bcta2 = :bcta2"),
    @NamedQuery(name = "Departamentos.findByBcta3", query = "SELECT d FROM Departamentos d WHERE d.bcta3 = :bcta3"),
    @NamedQuery(name = "Departamentos.findByBcta4", query = "SELECT d FROM Departamentos d WHERE d.bcta4 = :bcta4"),
    @NamedQuery(name = "Departamentos.findByBcta5", query = "SELECT d FROM Departamentos d WHERE d.bcta5 = :bcta5"),
    @NamedQuery(name = "Departamentos.findByEcta1", query = "SELECT d FROM Departamentos d WHERE d.ecta1 = :ecta1"),
    @NamedQuery(name = "Departamentos.findByEcta2", query = "SELECT d FROM Departamentos d WHERE d.ecta2 = :ecta2"),
    @NamedQuery(name = "Departamentos.findByEcta3", query = "SELECT d FROM Departamentos d WHERE d.ecta3 = :ecta3"),
    @NamedQuery(name = "Departamentos.findByEcta4", query = "SELECT d FROM Departamentos d WHERE d.ecta4 = :ecta4"),
    @NamedQuery(name = "Departamentos.findByEcta5", query = "SELECT d FROM Departamentos d WHERE d.ecta5 = :ecta5"),
    @NamedQuery(name = "Departamentos.findByCta1", query = "SELECT d FROM Departamentos d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "Departamentos.findByCta2", query = "SELECT d FROM Departamentos d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "Departamentos.findByCta3", query = "SELECT d FROM Departamentos d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "Departamentos.findByCta4", query = "SELECT d FROM Departamentos d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "Departamentos.findByCta5", query = "SELECT d FROM Departamentos d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "Departamentos.findByContable", query = "SELECT d FROM Departamentos d WHERE d.contable = :contable"),
    @NamedQuery(name = "Departamentos.findByPlanilla", query = "SELECT d FROM Departamentos d WHERE d.planilla = :planilla"),
    @NamedQuery(name = "Departamentos.findByMontoCaja", query = "SELECT d FROM Departamentos d WHERE d.montoCaja = :montoCaja"),
    @NamedQuery(name = "Departamentos.findByActa1", query = "SELECT d FROM Departamentos d WHERE d.acta1 = :acta1"),
    @NamedQuery(name = "Departamentos.findByActa2", query = "SELECT d FROM Departamentos d WHERE d.acta2 = :acta2"),
    @NamedQuery(name = "Departamentos.findByActa3", query = "SELECT d FROM Departamentos d WHERE d.acta3 = :acta3"),
    @NamedQuery(name = "Departamentos.findByActa4", query = "SELECT d FROM Departamentos d WHERE d.acta4 = :acta4"),
    @NamedQuery(name = "Departamentos.findByActa5", query = "SELECT d FROM Departamentos d WHERE d.acta5 = :acta5"),
    @NamedQuery(name = "Departamentos.findByVcta1", query = "SELECT d FROM Departamentos d WHERE d.vcta1 = :vcta1"),
    @NamedQuery(name = "Departamentos.findByVcta2", query = "SELECT d FROM Departamentos d WHERE d.vcta2 = :vcta2"),
    @NamedQuery(name = "Departamentos.findByVcta3", query = "SELECT d FROM Departamentos d WHERE d.vcta3 = :vcta3"),
    @NamedQuery(name = "Departamentos.findByVcta4", query = "SELECT d FROM Departamentos d WHERE d.vcta4 = :vcta4"),
    @NamedQuery(name = "Departamentos.findByVcta5", query = "SELECT d FROM Departamentos d WHERE d.vcta5 = :vcta5"),
    @NamedQuery(name = "Departamentos.findByDep1", query = "SELECT d FROM Departamentos d WHERE d.dep1 = :dep1"),
    @NamedQuery(name = "Departamentos.findByDep2", query = "SELECT d FROM Departamentos d WHERE d.dep2 = :dep2"),
    @NamedQuery(name = "Departamentos.findByDep3", query = "SELECT d FROM Departamentos d WHERE d.dep3 = :dep3"),
    @NamedQuery(name = "Departamentos.findByDep4", query = "SELECT d FROM Departamentos d WHERE d.dep4 = :dep4"),
    @NamedQuery(name = "Departamentos.findByDep5", query = "SELECT d FROM Departamentos d WHERE d.dep5 = :dep5"),
    @NamedQuery(name = "Departamentos.findBySxpcta1", query = "SELECT d FROM Departamentos d WHERE d.sxpcta1 = :sxpcta1"),
    @NamedQuery(name = "Departamentos.findBySxpcta2", query = "SELECT d FROM Departamentos d WHERE d.sxpcta2 = :sxpcta2"),
    @NamedQuery(name = "Departamentos.findBySxpcta3", query = "SELECT d FROM Departamentos d WHERE d.sxpcta3 = :sxpcta3"),
    @NamedQuery(name = "Departamentos.findBySxpcta4", query = "SELECT d FROM Departamentos d WHERE d.sxpcta4 = :sxpcta4"),
    @NamedQuery(name = "Departamentos.findBySxpcta5", query = "SELECT d FROM Departamentos d WHERE d.sxpcta5 = :sxpcta5"),
    @NamedQuery(name = "Departamentos.findByDepacum1", query = "SELECT d FROM Departamentos d WHERE d.depacum1 = :depacum1"),
    @NamedQuery(name = "Departamentos.findByDepacum2", query = "SELECT d FROM Departamentos d WHERE d.depacum2 = :depacum2"),
    @NamedQuery(name = "Departamentos.findByDepacum3", query = "SELECT d FROM Departamentos d WHERE d.depacum3 = :depacum3"),
    @NamedQuery(name = "Departamentos.findByDepacum4", query = "SELECT d FROM Departamentos d WHERE d.depacum4 = :depacum4"),
    @NamedQuery(name = "Departamentos.findByDepacum5", query = "SELECT d FROM Departamentos d WHERE d.depacum5 = :depacum5"),
    @NamedQuery(name = "Departamentos.findByIcta1", query = "SELECT d FROM Departamentos d WHERE d.icta1 = :icta1"),
    @NamedQuery(name = "Departamentos.findByIcta2", query = "SELECT d FROM Departamentos d WHERE d.icta2 = :icta2"),
    @NamedQuery(name = "Departamentos.findByIcta3", query = "SELECT d FROM Departamentos d WHERE d.icta3 = :icta3"),
    @NamedQuery(name = "Departamentos.findByIcta4", query = "SELECT d FROM Departamentos d WHERE d.icta4 = :icta4"),
    @NamedQuery(name = "Departamentos.findByIcta5", query = "SELECT d FROM Departamentos d WHERE d.icta5 = :icta5"),
    @NamedQuery(name = "Departamentos.findByCopcta1", query = "SELECT d FROM Departamentos d WHERE d.copcta1 = :copcta1"),
    @NamedQuery(name = "Departamentos.findByCopcta2", query = "SELECT d FROM Departamentos d WHERE d.copcta2 = :copcta2"),
    @NamedQuery(name = "Departamentos.findByCopcta3", query = "SELECT d FROM Departamentos d WHERE d.copcta3 = :copcta3"),
    @NamedQuery(name = "Departamentos.findByCopcta4", query = "SELECT d FROM Departamentos d WHERE d.copcta4 = :copcta4"),
    @NamedQuery(name = "Departamentos.findByCopcta5", query = "SELECT d FROM Departamentos d WHERE d.copcta5 = :copcta5"),
    @NamedQuery(name = "Departamentos.findByCocta1", query = "SELECT d FROM Departamentos d WHERE d.cocta1 = :cocta1"),
    @NamedQuery(name = "Departamentos.findByCocta2", query = "SELECT d FROM Departamentos d WHERE d.cocta2 = :cocta2"),
    @NamedQuery(name = "Departamentos.findByCocta3", query = "SELECT d FROM Departamentos d WHERE d.cocta3 = :cocta3"),
    @NamedQuery(name = "Departamentos.findByCocta4", query = "SELECT d FROM Departamentos d WHERE d.cocta4 = :cocta4"),
    @NamedQuery(name = "Departamentos.findByCocta5", query = "SELECT d FROM Departamentos d WHERE d.cocta5 = :cocta5"),
    @NamedQuery(name = "Departamentos.findByVicta1", query = "SELECT d FROM Departamentos d WHERE d.victa1 = :victa1"),
    @NamedQuery(name = "Departamentos.findByVicta2", query = "SELECT d FROM Departamentos d WHERE d.victa2 = :victa2"),
    @NamedQuery(name = "Departamentos.findByVicta3", query = "SELECT d FROM Departamentos d WHERE d.victa3 = :victa3"),
    @NamedQuery(name = "Departamentos.findByVicta4", query = "SELECT d FROM Departamentos d WHERE d.victa4 = :victa4"),
    @NamedQuery(name = "Departamentos.findByVicta5", query = "SELECT d FROM Departamentos d WHERE d.victa5 = :victa5"),
    @NamedQuery(name = "Departamentos.findByCodGerencia", query = "SELECT d FROM Departamentos d WHERE d.codGerencia = :codGerencia"),
    @NamedQuery(name = "Departamentos.findByDescDepto", query = "SELECT d FROM Departamentos d WHERE d.descDepto = :descDepto"),
    @NamedQuery(name = "Departamentos.findByStaff", query = "SELECT d FROM Departamentos d WHERE d.staff = :staff"),
    @NamedQuery(name = "Departamentos.findByProyecto", query = "SELECT d FROM Departamentos d WHERE d.proyecto = :proyecto"),
    @NamedQuery(name = "Departamentos.findByCodCuenta", query = "SELECT d FROM Departamentos d WHERE d.codCuenta = :codCuenta"),
    @NamedQuery(name = "Departamentos.findByCodSucursal", query = "SELECT d FROM Departamentos d WHERE d.codSucursal = :codSucursal"),
    @NamedQuery(name = "Departamentos.findByEstructura", query = "SELECT d FROM Departamentos d WHERE d.estructura = :estructura"),
    @NamedQuery(name = "Departamentos.findByCodObjetoSalarios", query = "SELECT d FROM Departamentos d WHERE d.codObjetoSalarios = :codObjetoSalarios"),
    @NamedQuery(name = "Departamentos.findByCodObjetoTreceavo", query = "SELECT d FROM Departamentos d WHERE d.codObjetoTreceavo = :codObjetoTreceavo"),
    @NamedQuery(name = "Departamentos.findByCodObjetoCatorceavo", query = "SELECT d FROM Departamentos d WHERE d.codObjetoCatorceavo = :codObjetoCatorceavo"),
    @NamedQuery(name = "Departamentos.findByCodObjSalNopermanente", query = "SELECT d FROM Departamentos d WHERE d.codObjSalNopermanente = :codObjSalNopermanente"),
    @NamedQuery(name = "Departamentos.findByCodObjTrecNopermanente", query = "SELECT d FROM Departamentos d WHERE d.codObjTrecNopermanente = :codObjTrecNopermanente"),
    @NamedQuery(name = "Departamentos.findByCodObjCatNopermanente", query = "SELECT d FROM Departamentos d WHERE d.codObjCatNopermanente = :codObjCatNopermanente"),
    @NamedQuery(name = "Departamentos.findByCodObjVacaciones", query = "SELECT d FROM Departamentos d WHERE d.codObjVacaciones = :codObjVacaciones"),
    @NamedQuery(name = "Departamentos.findByCodObjVacNopermanente", query = "SELECT d FROM Departamentos d WHERE d.codObjVacNopermanente = :codObjVacNopermanente"),
    @NamedQuery(name = "Departamentos.findByPeriodoPre", query = "SELECT d FROM Departamentos d WHERE d.periodoPre = :periodoPre")
    })
public class Departamentos implements Serializable
{

    private static final long serialVersionUID = 1L;
//
    @EmbeddedId
    protected DepartamentosPK departamentosPK;
    @Column(name = "NOM_DEPTO", length = 100)
    private String nomDepto;
    @Column(name = "EMPLEADOS")
    private Integer empleados;
    @Column(name = "BCTA_1")
    private String bcta1;
    @Column(name = "BCTA_2")
    private String bcta2;
    @Column(name = "BCTA_3")
    private String bcta3;
    @Column(name = "BCTA_4")
    private String bcta4;
    @Column(name = "BCTA_5")
    private String bcta5;
    @Column(name = "ECTA_1")
    private String ecta1;
    @Column(name = "ECTA_2")
    private String ecta2;
    @Column(name = "ECTA_3")
    private String ecta3;
    @Column(name = "ECTA_4")
    private String ecta4;
    @Column(name = "ECTA_5")
    private String ecta5;
    @Column(name = "CTA_1")
    private String cta1;
    @Column(name = "CTA_2")
    private String cta2;
    @Column(name = "CTA_3")
    private String cta3;
    @Column(name = "CTA_4")
    private String cta4;
    @Column(name = "CTA_5")
    private String cta5;
    @Column(name = "CONTABLE", length = 1)
    private String contable;
    @Column(name = "PLANILLA", length = 5)
    private String planilla;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_CAJA", precision = 16, scale = 2)
    private BigDecimal montoCaja;
    @Column(name = "ACTA_1")
    private String acta1;
    @Column(name = "ACTA_2")
    private String acta2;
    @Column(name = "ACTA_3")
    private String acta3;
    @Column(name = "ACTA_4")
    private String acta4;
    @Column(name = "ACTA_5")
    private String acta5;
    @Column(name = "VCTA_1")
    private String vcta1;
    @Column(name = "VCTA_2")
    private String vcta2;
    @Column(name = "VCTA_3")
    private String vcta3;
    @Column(name = "VCTA_4")
    private String vcta4;
    @Column(name = "VCTA_5")
    private String vcta5;
    @Column(name = "DEP_1")
    private String dep1;
    @Column(name = "DEP_2")
    private String dep2;
    @Column(name = "DEP_3")
    private String dep3;
    @Column(name = "DEP_4")
    private String dep4;
    @Column(name = "DEP_5")
    private String dep5;
    @Column(name = "SXPCTA_1")
    private String sxpcta1;
    @Column(name = "SXPCTA_2")
    private String sxpcta2;
    @Column(name = "SXPCTA_3")
    private String sxpcta3;
    @Column(name = "SXPCTA_4")
    private String sxpcta4;
    @Column(name = "SXPCTA_5")
    private String sxpcta5;
    @Column(name = "DEPACUM_1")
    private String depacum1;
    @Column(name = "DEPACUM_2")
    private String depacum2;
    @Column(name = "DEPACUM_3")
    private String depacum3;
    @Column(name = "DEPACUM_4")
    private String depacum4;
    @Column(name = "DEPACUM_5")
    private String depacum5;
    @Column(name = "ICTA_1")
    private String icta1;
    @Column(name = "ICTA_2")
    private String icta2;
    @Column(name = "ICTA_3")
    private String icta3;
    @Column(name = "ICTA_4")
    private String icta4;
    @Column(name = "ICTA_5")
    private String icta5;
    @Column(name = "COPCTA_1")
    private String copcta1;
    @Column(name = "COPCTA_2")
    private String copcta2;
    @Column(name = "COPCTA_3")
    private String copcta3;
    @Column(name = "COPCTA_4")
    private String copcta4;
    @Column(name = "COPCTA_5")
    private String copcta5;
    @Column(name = "COCTA_1")
    private String cocta1;
    @Column(name = "COCTA_2")
    private String cocta2;
    @Column(name = "COCTA_3")
    private String cocta3;
    @Column(name = "COCTA_4")
    private String cocta4;
    @Column(name = "COCTA_5")
    private String cocta5;
    @Column(name = "VICTA_1")
    private String victa1;
    @Column(name = "VICTA_2")
    private String victa2;
    @Column(name = "VICTA_3")
    private String victa3;
    @Column(name = "VICTA_4")
    private String victa4;
    @Column(name = "VICTA_5")
    private String victa5;
    @Column(name = "COD_GERENCIA")
    private Short codGerencia;
    @Column(name = "DESC_DEPTO", length = 200)
    private String descDepto;
    @Column(name = "STAFF", length = 1)
    private String staff;
    @Column(name = "PROYECTO", length = 20)
    private String proyecto;
    @Column(name = "COD_CUENTA", length = 30)
    private String codCuenta;
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Column(name = "ESTRUCTURA", length = 20)
    private String estructura;
    @Column(name = "COD_OBJETO_SALARIOS", length = 20)
    private String codObjetoSalarios;
    @Column(name = "COD_OBJETO_TRECEAVO", length = 20)
    private String codObjetoTreceavo;
    @Column(name = "COD_OBJETO_CATORCEAVO", length = 20)
    private String codObjetoCatorceavo;
    @Column(name = "COD_OBJ_SAL_NOPERMANENTE", length = 20)
    private String codObjSalNopermanente;
    @Column(name = "COD_OBJ_TREC_NOPERMANENTE", length = 20)
    private String codObjTrecNopermanente;
    @Column(name = "COD_OBJ_CAT_NOPERMANENTE", length = 20)
    private String codObjCatNopermanente;
    @Column(name = "COD_OBJ_VACACIONES", length = 20)
    private String codObjVacaciones;
    @Column(name = "COD_OBJ_VAC_NOPERMANENTE", length = 20)
    private String codObjVacNopermanente;
    @Column(name = "PERIODO_PRE")
    private Short periodoPre;
    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA")
        })
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA")
        })
    @ManyToOne(optional = false)
    private AreasStaff areasStaff;

    public Departamentos()
    {
    }

    public Departamentos(DepartamentosPK departamentosPK)
    {
        this.departamentosPK = departamentosPK;
    }

    public Departamentos(int codCia, int codDepto)
    {
        this.departamentosPK = new DepartamentosPK(codCia, codDepto);
    }

    public DepartamentosPK getDepartamentosPK()
    {
        return departamentosPK;
    }

    public void setDepartamentosPK(DepartamentosPK departamentosPK)
    {
        this.departamentosPK = departamentosPK;
    }

    public String getNomDepto()
    {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto)
    {
        this.nomDepto = nomDepto;
    }

    public Integer getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(Integer empleados)
    {
        this.empleados = empleados;
    }

    public String getBcta1()
    {
        return bcta1;
    }

    public void setBcta1(String bcta1)
    {
        this.bcta1 = bcta1;
    }

    public String getBcta2()
    {
        return bcta2;
    }

    public void setBcta2(String bcta2)
    {
        this.bcta2 = bcta2;
    }

    public String getBcta3()
    {
        return bcta3;
    }

    public void setBcta3(String bcta3)
    {
        this.bcta3 = bcta3;
    }

    public String getBcta4()
    {
        return bcta4;
    }

    public void setBcta4(String bcta4)
    {
        this.bcta4 = bcta4;
    }

    public String getBcta5()
    {
        return bcta5;
    }

    public void setBcta5(String bcta5)
    {
        this.bcta5 = bcta5;
    }

    public String getEcta1()
    {
        return ecta1;
    }

    public void setEcta1(String ecta1)
    {
        this.ecta1 = ecta1;
    }

    public String getEcta2()
    {
        return ecta2;
    }

    public void setEcta2(String ecta2)
    {
        this.ecta2 = ecta2;
    }

    public String getEcta3()
    {
        return ecta3;
    }

    public void setEcta3(String ecta3)
    {
        this.ecta3 = ecta3;
    }

    public String getEcta4()
    {
        return ecta4;
    }

    public void setEcta4(String ecta4)
    {
        this.ecta4 = ecta4;
    }

    public String getEcta5()
    {
        return ecta5;
    }

    public void setEcta5(String ecta5)
    {
        this.ecta5 = ecta5;
    }

    public String getCta1()
    {
        return cta1;
    }

    public void setCta1(String cta1)
    {
        this.cta1 = cta1;
    }

    public String getCta2()
    {
        return cta2;
    }

    public void setCta2(String cta2)
    {
        this.cta2 = cta2;
    }

    public String getCta3()
    {
        return cta3;
    }

    public void setCta3(String cta3)
    {
        this.cta3 = cta3;
    }

    public String getCta4()
    {
        return cta4;
    }

    public void setCta4(String cta4)
    {
        this.cta4 = cta4;
    }

    public String getCta5()
    {
        return cta5;
    }

    public void setCta5(String cta5)
    {
        this.cta5 = cta5;
    }

    public String getActa1()
    {
        return acta1;
    }

    public void setActa1(String acta1)
    {
        this.acta1 = acta1;
    }

    public String getActa2()
    {
        return acta2;
    }

    public void setActa2(String acta2)
    {
        this.acta2 = acta2;
    }

    public String getActa3()
    {
        return acta3;
    }

    public void setActa3(String acta3)
    {
        this.acta3 = acta3;
    }

    public String getActa4()
    {
        return acta4;
    }

    public void setActa4(String acta4)
    {
        this.acta4 = acta4;
    }

    public String getActa5()
    {
        return acta5;
    }

    public void setActa5(String acta5)
    {
        this.acta5 = acta5;
    }

    public String getVcta1()
    {
        return vcta1;
    }

    public void setVcta1(String vcta1)
    {
        this.vcta1 = vcta1;
    }

    public String getVcta2()
    {
        return vcta2;
    }

    public void setVcta2(String vcta2)
    {
        this.vcta2 = vcta2;
    }

    public String getVcta3()
    {
        return vcta3;
    }

    public void setVcta3(String vcta3)
    {
        this.vcta3 = vcta3;
    }

    public String getVcta4()
    {
        return vcta4;
    }

    public void setVcta4(String vcta4)
    {
        this.vcta4 = vcta4;
    }

    public String getVcta5()
    {
        return vcta5;
    }

    public void setVcta5(String vcta5)
    {
        this.vcta5 = vcta5;
    }

    public String getDep1()
    {
        return dep1;
    }

    public void setDep1(String dep1)
    {
        this.dep1 = dep1;
    }

    public String getDep2()
    {
        return dep2;
    }

    public void setDep2(String dep2)
    {
        this.dep2 = dep2;
    }

    public String getDep3()
    {
        return dep3;
    }

    public void setDep3(String dep3)
    {
        this.dep3 = dep3;
    }

    public String getDep4()
    {
        return dep4;
    }

    public void setDep4(String dep4)
    {
        this.dep4 = dep4;
    }

    public String getDep5()
    {
        return dep5;
    }

    public void setDep5(String dep5)
    {
        this.dep5 = dep5;
    }

    public String getSxpcta1()
    {
        return sxpcta1;
    }

    public void setSxpcta1(String sxpcta1)
    {
        this.sxpcta1 = sxpcta1;
    }

    public String getSxpcta2()
    {
        return sxpcta2;
    }

    public void setSxpcta2(String sxpcta2)
    {
        this.sxpcta2 = sxpcta2;
    }

    public String getSxpcta3()
    {
        return sxpcta3;
    }

    public void setSxpcta3(String sxpcta3)
    {
        this.sxpcta3 = sxpcta3;
    }

    public String getSxpcta4()
    {
        return sxpcta4;
    }

    public void setSxpcta4(String sxpcta4)
    {
        this.sxpcta4 = sxpcta4;
    }

    public String getSxpcta5()
    {
        return sxpcta5;
    }

    public void setSxpcta5(String sxpcta5)
    {
        this.sxpcta5 = sxpcta5;
    }

    public String getDepacum1()
    {
        return depacum1;
    }

    public void setDepacum1(String depacum1)
    {
        this.depacum1 = depacum1;
    }

    public String getDepacum2()
    {
        return depacum2;
    }

    public void setDepacum2(String depacum2)
    {
        this.depacum2 = depacum2;
    }

    public String getDepacum3()
    {
        return depacum3;
    }

    public void setDepacum3(String depacum3)
    {
        this.depacum3 = depacum3;
    }

    public String getDepacum4()
    {
        return depacum4;
    }

    public void setDepacum4(String depacum4)
    {
        this.depacum4 = depacum4;
    }

    public String getDepacum5()
    {
        return depacum5;
    }

    public void setDepacum5(String depacum5)
    {
        this.depacum5 = depacum5;
    }

    public String getIcta1()
    {
        return icta1;
    }

    public void setIcta1(String icta1)
    {
        this.icta1 = icta1;
    }

    public String getIcta2()
    {
        return icta2;
    }

    public void setIcta2(String icta2)
    {
        this.icta2 = icta2;
    }

    public String getIcta3()
    {
        return icta3;
    }

    public void setIcta3(String icta3)
    {
        this.icta3 = icta3;
    }

    public String getIcta4()
    {
        return icta4;
    }

    public void setIcta4(String icta4)
    {
        this.icta4 = icta4;
    }

    public String getIcta5()
    {
        return icta5;
    }

    public void setIcta5(String icta5)
    {
        this.icta5 = icta5;
    }

    public String getCopcta1()
    {
        return copcta1;
    }

    public void setCopcta1(String copcta1)
    {
        this.copcta1 = copcta1;
    }

    public String getCopcta2()
    {
        return copcta2;
    }

    public void setCopcta2(String copcta2)
    {
        this.copcta2 = copcta2;
    }

    public String getCopcta3()
    {
        return copcta3;
    }

    public void setCopcta3(String copcta3)
    {
        this.copcta3 = copcta3;
    }

    public String getCopcta4()
    {
        return copcta4;
    }

    public void setCopcta4(String copcta4)
    {
        this.copcta4 = copcta4;
    }

    public String getCopcta5()
    {
        return copcta5;
    }

    public void setCopcta5(String copcta5)
    {
        this.copcta5 = copcta5;
    }

    public String getCocta1()
    {
        return cocta1;
    }

    public void setCocta1(String cocta1)
    {
        this.cocta1 = cocta1;
    }

    public String getCocta2()
    {
        return cocta2;
    }

    public void setCocta2(String cocta2)
    {
        this.cocta2 = cocta2;
    }

    public String getCocta3()
    {
        return cocta3;
    }

    public void setCocta3(String cocta3)
    {
        this.cocta3 = cocta3;
    }

    public String getCocta4()
    {
        return cocta4;
    }

    public void setCocta4(String cocta4)
    {
        this.cocta4 = cocta4;
    }

    public String getCocta5()
    {
        return cocta5;
    }

    public void setCocta5(String cocta5)
    {
        this.cocta5 = cocta5;
    }

    public String getVicta1()
    {
        return victa1;
    }

    public void setVicta1(String victa1)
    {
        this.victa1 = victa1;
    }

    public String getVicta2()
    {
        return victa2;
    }

    public void setVicta2(String victa2)
    {
        this.victa2 = victa2;
    }

    public String getVicta3()
    {
        return victa3;
    }

    public void setVicta3(String victa3)
    {
        this.victa3 = victa3;
    }

    public String getVicta4()
    {
        return victa4;
    }

    public void setVicta4(String victa4)
    {
        this.victa4 = victa4;
    }

    public String getVicta5()
    {
        return victa5;
    }

    public void setVicta5(String victa5)
    {
        this.victa5 = victa5;
    }

    public String getContable()
    {
        return contable;
    }

    public void setContable(String contable)
    {
        this.contable = contable;
    }

    public String getPlanilla()
    {
        return planilla;
    }

    public void setPlanilla(String planilla)
    {
        this.planilla = planilla;
    }

    public BigDecimal getMontoCaja()
    {
        return montoCaja;
    }

    public void setMontoCaja(BigDecimal montoCaja)
    {
        this.montoCaja = montoCaja;
    }

    public Short getCodGerencia()
    {
        return codGerencia;
    }

    public void setCodGerencia(Short codGerencia)
    {
        this.codGerencia = codGerencia;
    }

    public String getDescDepto()
    {
        return descDepto;
    }

    public void setDescDepto(String descDepto)
    {
        this.descDepto = descDepto;
    }

    public String getStaff()
    {
        return staff;
    }

    public void setStaff(String staff)
    {
        this.staff = staff;
    }

    public String getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(String proyecto)
    {
        this.proyecto = proyecto;
    }

    public String getCodCuenta()
    {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta)
    {
        this.codCuenta = codCuenta;
    }

    public String getCodSucursal()
    {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal)
    {
        this.codSucursal = codSucursal;
    }

    public String getEstructura()
    {
        return estructura;
    }

    public void setEstructura(String estructura)
    {
        this.estructura = estructura;
    }

    public String getCodObjetoSalarios()
    {
        return codObjetoSalarios;
    }

    public void setCodObjetoSalarios(String codObjetoSalarios)
    {
        this.codObjetoSalarios = codObjetoSalarios;
    }

    public String getCodObjetoTreceavo()
    {
        return codObjetoTreceavo;
    }

    public void setCodObjetoTreceavo(String codObjetoTreceavo)
    {
        this.codObjetoTreceavo = codObjetoTreceavo;
    }

    public String getCodObjetoCatorceavo()
    {
        return codObjetoCatorceavo;
    }

    public void setCodObjetoCatorceavo(String codObjetoCatorceavo)
    {
        this.codObjetoCatorceavo = codObjetoCatorceavo;
    }

    public String getCodObjSalNopermanente()
    {
        return codObjSalNopermanente;
    }

    public void setCodObjSalNopermanente(String codObjSalNopermanente)
    {
        this.codObjSalNopermanente = codObjSalNopermanente;
    }

    public String getCodObjTrecNopermanente()
    {
        return codObjTrecNopermanente;
    }

    public void setCodObjTrecNopermanente(String codObjTrecNopermanente)
    {
        this.codObjTrecNopermanente = codObjTrecNopermanente;
    }

    public String getCodObjCatNopermanente()
    {
        return codObjCatNopermanente;
    }

    public void setCodObjCatNopermanente(String codObjCatNopermanente)
    {
        this.codObjCatNopermanente = codObjCatNopermanente;
    }

    public String getCodObjVacaciones()
    {
        return codObjVacaciones;
    }

    public void setCodObjVacaciones(String codObjVacaciones)
    {
        this.codObjVacaciones = codObjVacaciones;
    }

    public String getCodObjVacNopermanente()
    {
        return codObjVacNopermanente;
    }

    public void setCodObjVacNopermanente(String codObjVacNopermanente)
    {
        this.codObjVacNopermanente = codObjVacNopermanente;
    }

    public Short getPeriodoPre()
    {
        return periodoPre;
    }

    public void setPeriodoPre(Short periodoPre)
    {
        this.periodoPre = periodoPre;
    }

    public TiposPlanilla getTiposPlanilla()
    {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla)
    {
        this.tiposPlanilla = tiposPlanilla;
    }

    public AreasStaff getAreasStaff()
    {
        return areasStaff;
    }

    public void setAreasStaff(AreasStaff areasStaff)
    {
        this.areasStaff = areasStaff;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (departamentosPK != null ? departamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos))
            {
            return false;
            }
        Departamentos other = (Departamentos) object;
        if ((this.departamentosPK == null && other.departamentosPK != null) || (this.departamentosPK != null && !this.departamentosPK.equals(other.departamentosPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Departamentos[ departamentosPK=" + departamentosPK + " ]";
    }
}
