package com.beitech.model.dao;

import java.util.ResourceBundle;

/**
 *
 * @author yesid
 */
public class DAOFactory {

    private static DAOFactory daoFactory = new DAOFactory();

    private ResourceBundle property;
    private String db_type;
    private String db_engine;

//    Repository types
    private final String db_type_relational = "relational";
    private final String db_type_xml = "xml";
//    Databeses engines
    private final String mySql = "mysql";
    private final String postgresql = "postgresql";

    //Problem inserting
    public final int PROBLEM_INSERTING = -1;

    private DAOFactory() {

        this.property = ResourceBundle.getBundle("com.beitech.view.ApplicationResource");
        db_type = property.getString("DB_TYPE");

        if (db_type.equalsIgnoreCase(db_type_relational)) {
            db_engine = property.getString("DB_ENGINE");
        }
    }

    public static DAOFactory getInstance() {

        return daoFactory;
    }

    public void setXMLRepositoryType() {

        db_type = property.getString("XML");

    }

    public void setDBRepositoryType() {

        db_type = property.getString("DB_TYPE");

    }

    public ResourceBundle getProperty() {
        return property;
    }

    public void setProperty(ResourceBundle property) {
        this.property = property;
    }

    public CustomerDao getCustomerDAO() {

        if (db_type.equalsIgnoreCase(db_type_relational)) {

            if (db_engine.equalsIgnoreCase(mySql)) {
                return new CustomerMySQL();
            }
        }

        return null;
    }

    public ProductDao getProductDAO() {

        if (db_type.equalsIgnoreCase(db_type_relational)) {

            if (db_engine.equalsIgnoreCase(mySql)) {
                return new ProductMySQL();
            }
        }
        return null;
    }

    public OrderDao getOrderDAO() {

        if (db_type.equalsIgnoreCase(db_type_relational)) {

            if (db_engine.equalsIgnoreCase(mySql)) {
                return new OrderMySQL();
            }
        }
        return null;
    }

    public CatalogDao getCatalogDAO() {

        if (db_type.equalsIgnoreCase(db_type_relational)) {

            if (db_engine.equalsIgnoreCase(mySql)) {
                return new CatalogMySQL();
            }
        }
        return null;
    }

    public ReferenceDao getReferenceDAO() {

        if (db_type.equalsIgnoreCase(db_type_relational)) {

            if (db_engine.equalsIgnoreCase(mySql)) {
                return new ReferenceMySQL();
            }
        } else if (db_type.equalsIgnoreCase(db_type_xml)) {
            return new ReferenceXML();
        }
        return null;
    }

}
