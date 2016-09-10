/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabumjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

/**
 *
 * @author Timm
 */
public class KDBDataSource {
    public static String DB_CONN_STRING = "jdbc:derby://localhost:1527/KPDB";
    public static String DB_NAME = "KPDB";
    public static String USER_NAME = "timm";
    public static String PASSWORD = "admin";
    private static DataSource dataSource;

    private static DataSource createDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create"); 
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }

    public static void createDB() throws Exception {
        try (Connection con = createDataSource().getConnection();
            Statement sta = con.createStatement()) {
            String sqlProducts = "CREATE TABLE PRODUCTS("
                    + "PRODID int PRIMARY KEY NOT NULL,"
                    + "PRODTYPE varchar(100) NOT NULL,"
                    + "BRAND varchar(100) NOT NULL,"
                    + "MODEL varchar(100) NOT NULL,"
                    + "PRICE double NOT NULL)";
            sta.executeUpdate(sqlProducts);
        }
    }

    public static Connection getDBConnectionString() throws Exception {
        return DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
    }
    
    public static Connection getDBConnection() throws Exception {
        return createDataSource().getConnection();
    }
}
