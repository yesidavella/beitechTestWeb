
package com.beitech.model.dao;

import com.beitech.model.ProductForm;

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
public class ProductMySQL extends RelationDBUtility implements ProductDao {

    @Override
    public ProductForm findtProductById(int id) {

        ProductForm product = null;

//        openConnetion();

        try {

            ResultSet resultSet = executeQuery("SELECT * FROM " + DB_NAME + ".PRODUCT;");

            if (resultSet.next()) {
                product = new ProductForm();
                product.setId(resultSet.getInt("id_product"));
                product.setPriceEU(resultSet.getInt("price_eu"));
                product.setPriceUSD(resultSet.getInt("price_usd"));
                product.setName(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        closeConnetion();

        return product;

    }

    @Override
    public List findProductsByPage(int amount, int page) {

//        openConnetion();

        List<ProductForm> products = new ArrayList<>();

        try {

            ResultSet resultSet = executeQuery("SELECT * FROM " + DB_NAME + ".PRODUCT LIMIT 0,20");

            while (resultSet.next()) {
                ProductForm product = new ProductForm();

                product.setId(resultSet.getInt("id_product"));
                product.setPriceEU(resultSet.getInt("price_eu"));
                product.setPriceUSD(resultSet.getInt("price_usd"));
                product.setName(resultSet.getString("name"));

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        closeConnetion();

        return products;

    }

    @Override
    public List findProductsByCustomerByPage(int idCustomer, int amount, int page) {

//        openConnetion();

        List<ProductForm> products = new ArrayList<>();

        String sql = "SELECT P.* "
                + "FROM "
                + "(SELECT ID_PRODUCT FROM CATALOG WHERE ID_CUSTOMER=" + idCustomer + ") AS CATALOG "
                + "INNER JOIN PRODUCT AS P ON (CATALOG.ID_PRODUCT=P.ID_PRODUCT);";

        try {

            ResultSet resultSet = executeQuery(sql);

            while (resultSet.next()) {
                ProductForm product = new ProductForm();

                product.setId(resultSet.getInt("id_product"));
                product.setPriceEU(resultSet.getInt("price_eu"));
                product.setPriceUSD(resultSet.getInt("price_usd"));
                product.setName(resultSet.getString("name"));

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        closeConnetion();

        return products;
    }

}