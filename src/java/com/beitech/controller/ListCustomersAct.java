
package com.beitech.controller;

import com.beitech.model.dao.CustomerDao;
import com.beitech.model.dao.DAOFactory;
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
public class ListCustomersAct extends org.apache.struts.action.Action {

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
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        CustomerDao customerDAO = daoFactory.getCustomerDAO();
        List customers = customerDAO.getCustomersByPage(10, 10);
        
//        daoFactory.setXMLRepositoryType();
//        ReferenceDao referenceDao = daoFactory.getReferenceDAO();
//        ReferenceForm referenceForm = referenceDao.getReferenceById("USD");
//        daoFactory.setDBRepositoryType();
//        
//        referenceDao = daoFactory.getReferenceDAO();
//        boolean result = referenceDao.updateReference(referenceForm);
        
        
        request.setAttribute("customers", customers);
        
        return mapping.findForward(SUCCESS);
    }
}
