package com.beitech.model.dao;

import com.beitech.model.OrderDetailForm;
import com.beitech.model.OrderForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yesid
 */
public class OrderMySQL extends RelationDBUtility implements OrderDao {

    @Override
    public int insertOrderAndDetail(OrderForm orderForm, List<OrderDetailForm> details) {

        try {
            // the mysql insert statement
            String sql = "INSERT INTO " + DB_NAME + ".ORDER (id_customer,delivery_address,currency_rate,total_price_eu,total_price_usd,date,reference)"
                    + " VALUES (?, ?, ?, ?, ?, ?,'USD')";

            setAutoCommit(false);

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = prepareStmn(sql);

            preparedStmt.setInt(1, orderForm.getIdCustomer());
            preparedStmt.setString(2, orderForm.getDeliveryAddress());
            preparedStmt.setDouble(3, orderForm.getCurrencyRate());
            preparedStmt.setDouble(4, orderForm.getEuTotalPrice());
            preparedStmt.setDouble(5, orderForm.getUsdTotalPrice());
            preparedStmt.setTimestamp(6, orderForm.getDate());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows < 1) {
                return DAOFactory.getInstance().PROBLEM_INSERTING;
            }

            ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
            generatedKeys.next();
            int idNewOrder = generatedKeys.getInt(1);

            sql = null;
            preparedStmt = null;
            for (OrderDetailForm detail : details) {

                sql = "INSERT INTO " + DB_NAME + ".ORDER_DETAIL (id_order,id_product,product_description,price_usd,amount)"
                        + " VALUES (?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                preparedStmt = prepareStmn(sql);

                preparedStmt.setInt(1, idNewOrder);
                preparedStmt.setInt(2, detail.getIdProduct());
                preparedStmt.setString(3, detail.getProductDescription());
                preparedStmt.setDouble(4, detail.getUsdPrice());
                preparedStmt.setInt(5, detail.getAmount());

                affectedRows = preparedStmt.executeUpdate();
                
                if(affectedRows!=1){
                    return DAOFactory.getInstance().PROBLEM_INSERTING;
                }
            }

            commit();
            setAutoCommit(true);

            return affectedRows;
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderMySQL.class.getName()).log(Level.SEVERE, null, ex);
            rollback();
        }

        return 0;
    }

}
