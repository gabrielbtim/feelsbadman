/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabumjdbc;

import java.util.List;

/**
 *
 * @author Timm
 */
public interface ProductDAO {
    void insertProduct(Product p) throws ProductDAOException;
    List<Product> searchAll() throws ProductDAOException;
}
