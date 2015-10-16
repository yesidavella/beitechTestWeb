
package com.beitech.model.dao;

import com.beitech.model.CustomerForm;
import java.util.List;

/**
 *
 * @author Yeisd
 */
public interface CustomerDao {
    
    public CustomerForm getCustomerById(int id);
    public List getCustomersByPage(int amount, int page);
    
}
