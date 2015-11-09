/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitech.controller.ws;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeliaATC
 */
@Entity
@Table(name = "\"ORDER\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderClass.findAll", query = "SELECT o FROM OrderClass o"),
    @NamedQuery(name = "OrderClass.findByIdOrder", query = "SELECT o FROM OrderClass o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderClass.findByDeliveryAddress", query = "SELECT o FROM OrderClass o WHERE o.deliveryAddress = :deliveryAddress"),
    @NamedQuery(name = "OrderClass.findByCurrencyRate", query = "SELECT o FROM OrderClass o WHERE o.currencyRate = :currencyRate"),
    @NamedQuery(name = "OrderClass.findByTotalPriceEu", query = "SELECT o FROM OrderClass o WHERE o.totalPriceEu = :totalPriceEu"),
    @NamedQuery(name = "OrderClass.findByTotalPriceUsd", query = "SELECT o FROM OrderClass o WHERE o.totalPriceUsd = :totalPriceUsd"),
    @NamedQuery(name = "OrderClass.findByDate", query = "SELECT o FROM OrderClass o WHERE o.date = :date")})
public class OrderClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Size(max = 30)
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currency_rate")
    private double currencyRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price_eu")
    private double totalPriceEu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price_usd")
    private double totalPriceUsd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public OrderClass() {
    }

    public OrderClass(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public OrderClass(Integer idOrder, double currencyRate, double totalPriceEu, double totalPriceUsd, Date date) {
        this.idOrder = idOrder;
        this.currencyRate = currencyRate;
        this.totalPriceEu = totalPriceEu;
        this.totalPriceUsd = totalPriceUsd;
        this.date = date;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public double getTotalPriceEu() {
        return totalPriceEu;
    }

    public void setTotalPriceEu(double totalPriceEu) {
        this.totalPriceEu = totalPriceEu;
    }

    public double getTotalPriceUsd() {
        return totalPriceUsd;
    }

    public void setTotalPriceUsd(double totalPriceUsd) {
        this.totalPriceUsd = totalPriceUsd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderClass)) {
            return false;
        }
        OrderClass other = (OrderClass) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beitech.controller.OrderClass[ idOrder=" + idOrder + " ]";
    }
    
}
