
package com.beitech.controller;

import com.beitech.model.dao.DAOFactory;
import com.beitech.model.dao.ProductDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Yesid
 */
public class ListConfigureProductAct extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String idCustomer = request.getParameter("id_customer");
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        ProductDao productDAO = daoFactory.getProductDAO();
        
        List allProducts = productDAO.findProductsByPage(20, 20);
        List activeProducts = productDAO.findProductsByCustomerByPage(Integer.parseInt(idCustomer) , 10, 10);
        
        request.setAttribute("all_products", allProducts);
        request.setAttribute("active_products", activeProducts);
        request.setAttribute("id_customer", idCustomer );
        
        return mapping.findForward(SUCCESS);
    }
}