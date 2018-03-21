package com.tsafundzic.rotisseriesappnavbottom.model;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class Worker extends Person {
    private double salary;

    public Worker(int id, String name, String surname, String password, double salary) {
        super(id, name, surname, password);
        this.salary = salary;
    }

}