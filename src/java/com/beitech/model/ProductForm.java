
package com.beitech.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author LeliaATC
 */
public class ProductForm extends org.apache.struts.action.ActionForm {
    
    private int id;
    private String name;
    private int priceEU;
    private int priceUSD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceEU() {
        return priceEU;
    }

    public void setPriceEU(int priceEU) {
        this.priceEU = priceEU;
    }

    public int getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(int priceUSD) {
        this.priceUSD = priceUSD;
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
}
