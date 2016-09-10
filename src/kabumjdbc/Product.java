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
public class Product {
    private int prodID;
    private String prodType;
    private String brand;
    private String model;
    private double price;

    public Product(int prodID, String prodType, String brand, String model, double price) {
        this.prodID = prodID;
        this.prodType = prodType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getProdID() {
        return prodID;
    }

    public String getProdType() {
        return prodType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "prodID=" + prodID + ", prodType=" + prodType + ", brand=" + brand + ", model=" + model + ", price=" + price + '}';
    }
}
