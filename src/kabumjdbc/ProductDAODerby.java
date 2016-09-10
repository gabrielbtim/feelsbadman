/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabumjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timm
 */
public class ProductDAODerby implements ProductDAO{
    
    @Override
    public void insertProduct(Product p) throws ProductDAOException {
        String sql = "INSERT INTO PRODUCTS(PRODID,PRODTYPE,BRAND,MODEL,PRICE) values(?,?,?,?,?)";
        int result;
        try (Connection con = KDBDataSource.getDBConnection();) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, p.getProdID());
                statement.setString(2, p.getProdType());
                statement.setString(3, p.getBrand());
                statement.setString(4, p.getModel());
                statement.setDouble(5, p.getPrice());
                result = statement.executeUpdate();
                System.out.println(result+" record inserted.");
            }
        } catch (Exception e) {
            throw new ProductDAOException("Insertion Failed", e);
        }
    }
    
    @Override
    public List<Product> searchAll() throws ProductDAOException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        try (Connection con = KDBDataSource.getDBConnection();) {
            try (Statement statement = con.createStatement()) {
                try (ResultSet dataset = statement.executeQuery(sql)) {
                    while (dataset.next()) {
                        Product product = new Product(
                                dataset.getInt("PRODID"),
                                dataset.getString("PRODTYPE"),
                                dataset.getString("BRAND"),
                                dataset.getString("MODEL"),
                                dataset.getDouble("PRICE"));
                        productList.add(product);
                    }
                    return productList;
                }
            }
        } catch (Exception e) {
            throw new ProductDAOException("Search Failed", e);
        }
    }
    
     public void dropTable() throws ProductDAOException {
        String sql = "DROP TABLE PRODUCTS";
        try (Connection con = KDBDataSource.getDBConnection();) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (Exception e) {
            throw new ProductDAOException("Search Failed", e);
        }
     }
}
