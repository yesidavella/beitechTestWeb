package com.beitech.model.dao;

import com.beitech.model.CatalogForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yesid
 */
public class CatalogMySQL extends RelationDBUtility implements CatalogDao {

    @Override
    public boolean insertProductInCatalog(CatalogForm catalogForm) {

        try {
            // the mysql insert statement
            String sql = "INSERT INTO " + DB_NAME + ".CATALOG (id_product,id_customer)"
                    + " VALUES (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = prepareStmn(sql);

            preparedStmt.setInt(1, catalogForm.getIdProduct());
            preparedStmt.setInt(2, catalogForm.getIdCustomer());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows != 1) {
                return false;
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CatalogMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean deleteProductInCatalog(CatalogForm catalogForm) {

        try {
            // the mysql insert statement
            String sql = "DELETE FROM " + DB_NAME + ".CATALOG  WHERE id_product=? AND id_customer=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = prepareStmn(sql);

            preparedStmt.setInt(1, catalogForm.getIdProduct());
            preparedStmt.setInt(2, catalogForm.getIdCustomer());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows != 1) {
                return false;
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CatalogMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

}
