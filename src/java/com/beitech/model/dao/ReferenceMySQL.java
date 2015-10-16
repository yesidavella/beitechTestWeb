package com.beitech.model.dao;

import com.beitech.model.ReferenceForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yesid
 */
public class ReferenceMySQL extends RelationDBUtility implements ReferenceDao {

    @Override
    public ReferenceForm getReferenceById(String reference) {

        ReferenceForm referenceForm = null;

        try {
            // the mysql insert statement
            String sql = "SELECT * FROM " + DB_NAME + ".REFERENCE WHERE reference=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = prepareStmnToSelect(sql);
            preparedStmt.setString(1, reference);

            ResultSet resultSet = preparedStmt.executeQuery();

            if (resultSet.next()) {
                referenceForm = new ReferenceForm();
                referenceForm.setReference(resultSet.getString("reference"));
                referenceForm.setRate(resultSet.getDouble("rate"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CatalogMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return referenceForm;
    }

    @Override
    public boolean updateReference(ReferenceForm referenceForm) {
        
        try {
            // the mysql insert statement
            String sql = "UPDATE "+DB_NAME+".REFERENCE SET rate=? WHERE reference=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = prepareStmn(sql);

            preparedStmt.setDouble(1, referenceForm.getRate());
            preparedStmt.setString(2, referenceForm.getReference());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 1) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

}
