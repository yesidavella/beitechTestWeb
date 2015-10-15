
package com.beitech.model;

/**
 *
 * @author yesid
 */
public class CatalogForm extends org.apache.struts.action.ActionForm {

    private int idCustomer;
    private int idProduct;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    
    
    
}
