/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabumjdbc;

/**
 *
 * @author Timm
 */
class ProductDAOException extends Exception {
    public ProductDAOException(String message, Throwable e) {
		super(message, e);
	}
}
