/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ETNIA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Etnia.findAll", query = "SELECT e FROM Etnia e"),
    @NamedQuery(name = "Etnia.findByCodCia", query = "SELECT e FROM Etnia e WHERE e.etniaPK.codCia = :codCia"),
    @NamedQuery(name = "Etnia.findByCodigo", query = "SELECT e FROM Etnia e WHERE e.etniaPK.codigo = :codigo"),
    @NamedQuery(name = "Etnia.findByNombre", query = "SELECT e FROM Etnia e WHERE e.nombre = :nombre")
    })
public class Etnia implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EtniaPK etniaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public Etnia()
    {
    }

    public Etnia(EtniaPK etniaPK)
    {
        this.etniaPK = etniaPK;
    }

    public Etnia(EtniaPK etniaPK, String nombre)
    {
        this.etniaPK = etniaPK;
        this.nombre = nombre;
    }

    public Etnia(short codCia, int codigo)
    {
        this.etniaPK = new EtniaPK(codCia, codigo);
    }

    public EtniaPK getEtniaPK()
    {
        return etniaPK;
    }

    public void setEtniaPK(EtniaPK etniaPK)
    {
        this.etniaPK = etniaPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Cias getCias()
    {
        return cias;
    }

    public void setCias(Cias cias)
    {
        this.cias = cias;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (etniaPK != null ? etniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etnia))
            {
            return false;
            }
        Etnia other = (Etnia) object;
        if ((this.etniaPK == null && other.etniaPK != null) || (this.etniaPK != null && !this.etniaPK.equals(other.etniaPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Etnia[ etniaPK=" + etniaPK + " ]";
    }
}
