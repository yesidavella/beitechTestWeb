
package com.beitech.model.dao;

import com.beitech.model.ProductForm;
import java.util.List;

/**
 *
 * @author Yeisd
 */
public interface ProductDao {
    
    public ProductForm findtProductById(int id);
    public List findProductsByPage(int amount, int page);
    public List findProductsByCustomerByPage(int idCustomer, int amount, int page);
    
}
