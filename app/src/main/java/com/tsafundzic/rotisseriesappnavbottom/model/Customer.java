package com.tsafundzic.rotisseriesappnavbottom.model;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class Customer extends Person{
    private double balance;

    public Customer(int id, String name, String surname, String password, double balance) {
        super(id, name, surname, password);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
