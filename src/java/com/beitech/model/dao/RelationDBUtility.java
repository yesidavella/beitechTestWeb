package com.beitech.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yesid
 */
public class RelationDBUtility {

    ResourceBundle property;
    private final String USER;
    private final String PASS;
    protected final String DB_NAME;
    private final String DB_PORT;
    private final String IP;
    private final String JDBC_DRIVER;
    private final String DB_ENGINE;
    private final String DB_URL;

    private static Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    public RelationDBUtility() {
        this.property = DAOFactory.getInstance().getProperty();

        this.DB_ENGINE = property.getString("DB_ENGINE");
        this.JDBC_DRIVER = property.getString("JDBC_DRIVER");
        this.DB_PORT = property.getString("DB_PORT");
        this.DB_NAME = property.getString("DB_NAME");
        this.PASS = property.getString("PASS");
        this.USER = property.getString("USER");
        this.IP = property.getString("IP");
        this.DB_URL = "jdbc:" + DB_ENGINE + "://" + IP + ":" + DB_PORT + "/" + DB_NAME;

        if (conn == null) {
            openConnetion();
        }
    }

    protected boolean execute(PreparedStatement preparedStmt) {

        boolean state = false;

        try {
            // execute the preparedstatement
            state = preparedStmt.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return state;
    }

    public PreparedStatement prepareStmn(String sql) throws SQLException {

        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public PreparedStatement prepareStmnToSelect(String sql) throws SQLException {

        return conn.prepareStatement(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {

        conn.setAutoCommit(autoCommit);

    }

    public void commit() throws SQLException {
        conn.commit();
    }

    public void rollback() {

        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException se2) {
            se2.printStackTrace();
        }

    }

    public String getDB_ENGINE() {
        return DB_ENGINE;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public String getDB_PORT() {
        return DB_PORT;
    }

    public String getIP() {
        return IP;
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    protected void openConnetion() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to DB " + DB_ENGINE + "...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    protected ResultSet executeQuery(String querySQL) {

        try {

            //STEP 4: Execute a query
            System.out.println("Creating DB " + DB_ENGINE + " statement...");
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(querySQL);

//            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return rs;
    }

    protected void closeConnetion() {

        try {
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println("Closed connetion to DB" + DB_ENGINE + "...!");
    }

}
