
package com.beitech.model.dao;

import com.beitech.model.CustomerForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yesid
 */
public class CustomerMySQL extends RelationDBUtility implements CustomerDao {

    @Override
    public CustomerForm getCustomerById(int id) {

        CustomerForm customer = null;

//        openConnetion();

        try {

            ResultSet resultSet = executeQuery("SELECT * FROM " + DB_NAME + ".CUSTOMER;");

            if (resultSet.next()) {
                customer = new CustomerForm();
                customer.setId(resultSet.getInt("id_customer"));
                customer.setEmail(resultSet.getString("email"));
                customer.setName(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        closeConnetion();

        return customer;

    }

    @Override
    public List getCustomersByPage(int amount, int page) {

//        openConnetion();

        List<CustomerForm> customers = new ArrayList<CustomerForm>();

        try {

            ResultSet resultSet = executeQuery("SELECT * FROM " + DB_NAME + ".CUSTOMER LIMIT 0,10");

            while (resultSet.next()) {
                CustomerForm customer = new CustomerForm();
                customer.setId(resultSet.getInt("id_customer"));
                customer.setEmail(resultSet.getString("email"));
//                customer.setIdSubscription(resultSet.getInt("id_subscription"));
                customer.setName(resultSet.getString("name"));

                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        closeConnetion();

        return customers;

    }
}