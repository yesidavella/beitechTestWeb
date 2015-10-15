package com.beitech.controller;

import com.beitech.model.OrderDetailForm;
import com.beitech.model.OrderForm;
import com.beitech.model.ReferenceForm;
import com.beitech.model.dao.DAOFactory;
import com.beitech.model.dao.OrderDao;
import com.beitech.model.dao.ProductDao;
import com.beitech.model.dao.ReferenceDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Yesid
 */
public class CreateOrderAct extends org.apache.struts.action.Action {

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

        OrderForm orderForm = (OrderForm) form;
        int idNewOrder = -1;

        if (request.getParameter("id_customer") != null) {
            orderForm.setIdCustomer(Integer.parseInt(request.getParameter("id_customer")));
        }

        DAOFactory daoFactory = DAOFactory.getInstance();

        //Examinamos el map de parametros a ver si existe params con el formulario diligenciado de productos
        Map paramsMap = request.getParameterMap();
        List<OrderDetailForm> orderDetails = findOrderDetailToSave(paramsMap);

        //Salvar la orden en bd
        if (!orderDetails.isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp currentTmstamp = new java.sql.Timestamp(calendar.getTime().getTime());
            orderForm.setDate(currentTmstamp);

            OrderDao orderDao = daoFactory.getOrderDAO();
            idNewOrder = orderDao.insertOrderAndDetail(orderForm, orderDetails);
        }

        ProductDao productDAO = daoFactory.getProductDAO();
        List availableProducts = productDAO.findProductsByCustomerByPage(orderForm.getIdCustomer(), 10, 10);
        
        //Buscamos la tasa de cambio del dia mas actual
        ReferenceDao referenceDao = daoFactory.getReferenceDAO();
        ReferenceForm referenceForm = referenceDao.getReferenceById("USD");

//        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String formattedCurrtTime = dateFormater.format(currentTmstamp);
//        request.setAttribute("id_customer",idCustomer );
        request.setAttribute("available_products", availableProducts);
        request.setAttribute("reference", referenceForm);

        return mapping.findForward(SUCCESS);
    }

    private List<OrderDetailForm> findOrderDetailToSave(Map paramsMap) {

        List details = new ArrayList();

        int i = 0;
        String[] paramArray = null;

        while (paramsMap.containsKey("available_product[" + i + "].id")) {

            OrderDetailForm orderDetail = new OrderDetailForm();

            paramArray = (String[]) paramsMap.get("available_product[" + i + "].amount");
            int productAmount = Integer.parseInt(paramArray[0]);

            if (productAmount > 0) {

                paramArray = (String[]) paramsMap.get("available_product[" + i + "].id");
                int idProduct = Integer.parseInt(paramArray[0]);

                paramArray = (String[]) paramsMap.get("available_product[" + i + "].name");
                String productDescription = paramArray[0];

                paramArray = (String[]) paramsMap.get("available_product[" + i + "].priceUSD");
                double productUSDPrice = Double.parseDouble(paramArray[0]);

                paramArray = (String[]) paramsMap.get("available_product[" + i + "].priceEU");
                double productEUPrice = Double.parseDouble(paramArray[0]);

                orderDetail.setIdProduct(idProduct);
                orderDetail.setProductDescription(productDescription);
                orderDetail.setUsdPrice(productUSDPrice);
                orderDetail.setEuPrice(productEUPrice);
                orderDetail.setAmount(productAmount);

                details.add(orderDetail);
            }

            i++;
        }

        paramArray = null;

        return details;
    }
}
