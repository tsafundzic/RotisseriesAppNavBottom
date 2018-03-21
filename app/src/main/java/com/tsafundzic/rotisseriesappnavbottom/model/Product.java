package com.tsafundzic.rotisseriesappnavbottom.model;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class Product {
    private final int productID;
    private String productName;
    private double productPrice;

    public Product(int productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
