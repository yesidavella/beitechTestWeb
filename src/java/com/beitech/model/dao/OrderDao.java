
package com.beitech.model.dao;

import com.beitech.model.OrderDetailForm;
import com.beitech.model.OrderForm;
import java.util.List;

/**
 *
 * @author Yesid
 */
public interface OrderDao {
    
    public int insertOrderAndDetail(OrderForm orderform, List<OrderDetailForm> details);
    
}
