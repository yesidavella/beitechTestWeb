package com.beitech.model;

import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionMapping;

/**
 *
 * @author yesid
 */
public class OrderForm extends ActionForm  {

    private int idCustomer;
    private Timestamp date;
    private String deliveryAddress;
    private double currencyRate;
    private double euTotalPrice;
    private double usdTotalPrice;

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public double getEuTotalPrice() {
        return euTotalPrice;
    }

    public void setEuTotalPrice(double euTotalPrice) {
        this.euTotalPrice = euTotalPrice;
    }

    public double getUsdTotalPrice() {
        return usdTotalPrice;
    }

    public void setUsdTotalPrice(double usdTotalPrice) {
        this.usdTotalPrice = usdTotalPrice;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }



    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }

    public void reset(ActionMapping mapping,HttpServletRequest request) {
        
        date = null;
        deliveryAddress = null;
        currencyRate = 0;
        euTotalPrice = 0;
        usdTotalPrice = 0;
        
        System.err.println("resetttttttt"+Calendar.getInstance().getTime());
        
    }
}
