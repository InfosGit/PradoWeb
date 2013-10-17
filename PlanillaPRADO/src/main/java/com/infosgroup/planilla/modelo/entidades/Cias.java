/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CIAS", schema = "CONTA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Cias.findAll", query = "SELECT c FROM Cias c"),
    @NamedQuery(name = "Cias.findByCodCia", query = "SELECT c FROM Cias c WHERE c.codCia = :codCia"),
    @NamedQuery(name = "Cias.findByRazonSocial", query = "SELECT c FROM Cias c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cias.findByNomComercial", query = "SELECT c FROM Cias c WHERE c.nomComercial = :nomComercial"),
    @NamedQuery(name = "Cias.findByDirecEmpresa", query = "SELECT c FROM Cias c WHERE c.direcEmpresa = :direcEmpresa"),
    @NamedQuery(name = "Cias.findByTelefEmpresa", query = "SELECT c FROM Cias c WHERE c.telefEmpresa = :telefEmpresa"),
    @NamedQuery(name = "Cias.findByNitEmpresa", query = "SELECT c FROM Cias c WHERE c.nitEmpresa = :nitEmpresa"),
    @NamedQuery(name = "Cias.findByNumeroPatronal", query = "SELECT c FROM Cias c WHERE c.numeroPatronal = :numeroPatronal"),
    @NamedQuery(name = "Cias.findByMesCierre", query = "SELECT c FROM Cias c WHERE c.mesCierre = :mesCierre"),
    @NamedQuery(name = "Cias.findByMesProceso", query = "SELECT c FROM Cias c WHERE c.mesProceso = :mesProceso"),
    @NamedQuery(name = "Cias.findByFechUlt", query = "SELECT c FROM Cias c WHERE c.fechUlt = :fechUlt"),
    @NamedQuery(name = "Cias.findByFecUltCie", query = "SELECT c FROM Cias c WHERE c.fecUltCie = :fecUltCie"),
    @NamedQuery(name = "Cias.findByTasaIva", query = "SELECT c FROM Cias c WHERE c.tasaIva = :tasaIva"),
    @NamedQuery(name = "Cias.findByTipoNumeracion", query = "SELECT c FROM Cias c WHERE c.tipoNumeracion = :tipoNumeracion"),
    @NamedQuery(name = "Cias.findBySiReferencia", query = "SELECT c FROM Cias c WHERE c.siReferencia = :siReferencia"),
    @NamedQuery(name = "Cias.findByRegistoIva", query = "SELECT c FROM Cias c WHERE c.registoIva = :registoIva"),
    @NamedQuery(name = "Cias.findByGiro", query = "SELECT c FROM Cias c WHERE c.giro = :giro"),
    @NamedQuery(name = "Cias.findByUtilizaProyecto", query = "SELECT c FROM Cias c WHERE c.utilizaProyecto = :utilizaProyecto"),
    @NamedQuery(name = "Cias.findByEnCierre", query = "SELECT c FROM Cias c WHERE c.enCierre = :enCierre"),
    @NamedQuery(name = "Cias.findByAnoProceso", query = "SELECT c FROM Cias c WHERE c.anoProceso = :anoProceso"),
    @NamedQuery(name = "Cias.findByCodPais", query = "SELECT c FROM Cias c WHERE c.codPais = :codPais"),
    //@NamedQuery(name = "Cias.findByMonedaBase", query = "SELECT c FROM Cias c WHERE c.monedaBase = :monedaBase"),
    @NamedQuery(name = "Cias.findByCodAuto", query = "SELECT c FROM Cias c WHERE c.codAuto = :codAuto"),
    @NamedQuery(name = "Cias.findByIvaDl", query = "SELECT c FROM Cias c WHERE c.ivaDl = :ivaDl"),
    @NamedQuery(name = "Cias.findByTasaPercep", query = "SELECT c FROM Cias c WHERE c.tasaPercep = :tasaPercep")
    })
public class Cias implements Serializable
{

    private static final long serialVersionUID = 1L;
//
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private Short codCia;
    @Column(name = "RAZON_SOCIAL", length = 60)
    private String razonSocial;
    @Column(name = "NOM_COMERCIAL", length = 60)
    private String nomComercial;
    @Column(name = "DIREC_EMPRESA", length = 100)
    private String direcEmpresa;
    @Column(name = "TELEF_EMPRESA", length = 30)
    private String telefEmpresa;
    @Column(name = "NIT_EMPRESA", length = 17)
    private String nitEmpresa;
    @Column(name = "NUMERO_PATRONAL", length = 15)
    private String numeroPatronal;
    @Column(name = "MES_CIERRE")
    private Short mesCierre;
    @Column(name = "MES_PROCESO")
    private Short mesProceso;
    @Column(name = "FECH_ULT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechUlt;
    @Column(name = "FEC_ULT_CIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltCie;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TASA_IVA", precision = 5, scale = 3)
    private BigDecimal tasaIva;
    @Column(name = "TIPO_NUMERACION")
    private Short tipoNumeracion;
    @Column(name = "SI_REFERENCIA", length = 1)
    private String siReferencia;
    @Column(name = "REGISTO_IVA", length = 15)
    private String registoIva;
    @Column(name = "GIRO", length = 35)
    private String giro;
    @Column(name = "UTILIZA_PROYECTO", length = 1)
    private String utilizaProyecto;
    @Column(name = "EN_CIERRE", length = 1)
    private String enCierre;
    @Column(name = "ANO_PROCESO")
    private Short anoProceso;
    @Column(name = "COD_PAIS")
    private Short codPais;
//    @Column(name = "MONEDA_BASE")
//    private Short monedaBase;
    @Column(name = "COD_AUTO", length = 1)
    private String codAuto;
    @Column(name = "IVA_DL", length = 5)
    private String ivaDl;
    @Column(name = "TASA_PERCEP", precision = 5, scale = 3)
    private BigDecimal tasaPercep;
    @OneToMany(mappedBy = "codCiaMatriz")
    private List<Cias> ciasList;
    @JoinColumn(name = "COD_CIA_MATRIZ", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cias codCiaMatriz;
    @JoinColumns(
        {
        @JoinColumn(name = "MONEDA_BASE", referencedColumnName = "COD_MONEDA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Monedas monedas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TiposIncapacidad> tiposIncapacidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Etnia> etniaList;

    public Cias()
    {
    }

    public Monedas getMonedas()
    {
        return monedas;
    }

    public void setMonedas(Monedas monedas)
    {
        this.monedas = monedas;
    }

    public Cias(Short codCia)
    {
        this.codCia = codCia;
    }

    public Short getCodCia()
    {
        return codCia;
    }

    public void setCodCia(Short codCia)
    {
        this.codCia = codCia;
    }

    public String getRazonSocial()
    {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
    }

    public String getNomComercial()
    {
        return nomComercial;
    }

    public void setNomComercial(String nomComercial)
    {
        this.nomComercial = nomComercial;
    }

    public String getDirecEmpresa()
    {
        return direcEmpresa;
    }

    public void setDirecEmpresa(String direcEmpresa)
    {
        this.direcEmpresa = direcEmpresa;
    }

    public String getTelefEmpresa()
    {
        return telefEmpresa;
    }

    public void setTelefEmpresa(String telefEmpresa)
    {
        this.telefEmpresa = telefEmpresa;
    }

    public String getNitEmpresa()
    {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa)
    {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNumeroPatronal()
    {
        return numeroPatronal;
    }

    public void setNumeroPatronal(String numeroPatronal)
    {
        this.numeroPatronal = numeroPatronal;
    }

    public Short getMesCierre()
    {
        return mesCierre;
    }

    public void setMesCierre(Short mesCierre)
    {
        this.mesCierre = mesCierre;
    }

    public Short getMesProceso()
    {
        return mesProceso;
    }

    public void setMesProceso(Short mesProceso)
    {
        this.mesProceso = mesProceso;
    }

    public Date getFechUlt()
    {
        return fechUlt;
    }

    public void setFechUlt(Date fechUlt)
    {
        this.fechUlt = fechUlt;
    }

    public Date getFecUltCie()
    {
        return fecUltCie;
    }

    public void setFecUltCie(Date fecUltCie)
    {
        this.fecUltCie = fecUltCie;
    }

    public BigDecimal getTasaIva()
    {
        return tasaIva;
    }

    public void setTasaIva(BigDecimal tasaIva)
    {
        this.tasaIva = tasaIva;
    }

    public Short getTipoNumeracion()
    {
        return tipoNumeracion;
    }

    public void setTipoNumeracion(Short tipoNumeracion)
    {
        this.tipoNumeracion = tipoNumeracion;
    }

    public String getSiReferencia()
    {
        return siReferencia;
    }

    public void setSiReferencia(String siReferencia)
    {
        this.siReferencia = siReferencia;
    }

    public String getRegistoIva()
    {
        return registoIva;
    }

    public void setRegistoIva(String registoIva)
    {
        this.registoIva = registoIva;
    }

    public String getGiro()
    {
        return giro;
    }

    public void setGiro(String giro)
    {
        this.giro = giro;
    }

    public String getUtilizaProyecto()
    {
        return utilizaProyecto;
    }

    public void setUtilizaProyecto(String utilizaProyecto)
    {
        this.utilizaProyecto = utilizaProyecto;
    }

    public String getEnCierre()
    {
        return enCierre;
    }

    public void setEnCierre(String enCierre)
    {
        this.enCierre = enCierre;
    }

    public Short getAnoProceso()
    {
        return anoProceso;
    }

    public void setAnoProceso(Short anoProceso)
    {
        this.anoProceso = anoProceso;
    }

    public Short getCodPais()
    {
        return codPais;
    }

    public void setCodPais(Short codPais)
    {
        this.codPais = codPais;
    }
//
//    public Short getMonedaBase() {
//        return monedaBase;
//    }
//
//    public void setMonedaBase(Short monedaBase) {
//        this.monedaBase = monedaBase;
//    }

    public String getCodAuto()
    {
        return codAuto;
    }

    public void setCodAuto(String codAuto)
    {
        this.codAuto = codAuto;
    }

    public String getIvaDl()
    {
        return ivaDl;
    }

    public void setIvaDl(String ivaDl)
    {
        this.ivaDl = ivaDl;
    }

    public BigDecimal getTasaPercep()
    {
        return tasaPercep;
    }

    public void setTasaPercep(BigDecimal tasaPercep)
    {
        this.tasaPercep = tasaPercep;
    }

    @XmlTransient
    public List<Cias> getCiasList()
    {
        return ciasList;
    }

    public void setCiasList(List<Cias> ciasList)
    {
        this.ciasList = ciasList;
    }

    public Cias getCodCiaMatriz()
    {
        return codCiaMatriz;
    }

    public void setCodCiaMatriz(Cias codCiaMatriz)
    {
        this.codCiaMatriz = codCiaMatriz;
    }

    @XmlTransient
    public List<TiposIncapacidad> getTiposIncapacidadList()
    {
        return tiposIncapacidadList;
    }

    public void setTiposIncapacidadList(List<TiposIncapacidad> tiposIncapacidadList)
    {
        this.tiposIncapacidadList = tiposIncapacidadList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cias))
            {
            return false;
            }
        Cias other = (Cias) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.conta.Cias[ codCia=" + codCia + " ]";
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Empleados> empleadosList;

    public List<Empleados> getEmpleadosList()
    {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList)
    {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Etnia> getEtniaList()
    {
        return etniaList;
    }

    public void setEtniaList(List<Etnia> etniaList)
    {
        this.etniaList = etniaList;
    }
}
