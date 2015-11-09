/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitech.controller.ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeliaATC
 */
@Entity
@Table(name = "REFERENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r"),
    @NamedQuery(name = "Reference.findByReference", query = "SELECT r FROM Reference r WHERE r.reference = :reference"),
    @NamedQuery(name = "Reference.findByRate", query = "SELECT r FROM Reference r WHERE r.rate = :rate")})
public class Reference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private double rate;

    public Reference() {
    }

    public Reference(String reference) {
        this.reference = reference;
    }

    public Reference(String reference, double rate) {
        this.reference = reference;
        this.rate = rate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beitech.controller.ws.Reference[ reference=" + reference + " ]";
    }
    
}
