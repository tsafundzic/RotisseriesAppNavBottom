package com.tsafundzic.rotisseriesappnavbottom.model;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class ProductAmount extends Product {
    private int amountOfProduct;

    public ProductAmount(int productID, String productName, double productPrice, int amountOfProduct) {
        super(productID, productName, productPrice);
        this.amountOfProduct = amountOfProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }
}
