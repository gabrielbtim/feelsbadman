/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabumjdbc;

public class KabumJDBC {
    public static void main(String[] args) throws Exception{
        //KDBDataSource.createDB();
//        Product p1 = new Product(67461, "Graphics Card", "Gigabyte", "GT 420 2GB DDR3 128-bits", 191.90);
//        Product p2 = new Product(60416, "Graphics Card", "Asus", "GTX 970 OC 4GB DDR5 256-bits", 1229.90);
//        Product p3 = new Product(63596, "Graphics Card", "Gigabyte", "GTX 750 Ti 2GB OC DDR5 128-bits", 564.90);
//        Product p4 = new Product(50097, "Graphics Card", "EVGA", "GTX 750 Ti 2GB DDR5 128-bits", 550.90);
//        Product p5 = new Product(77165, "Graphics Card", "Asus", "R7 360 2GB OC DDR5 128-bits", 449.85);
        
        ProductDAODerby products = new ProductDAODerby();
//        products.insertProduct(p1);
//        products.insertProduct(p2);
//        products.insertProduct(p3);
//        products.insertProduct(p4);
//        products.insertProduct(p5);
        //products.dropTable();
        System.out.println(products.searchAll().toString());
    }
}
