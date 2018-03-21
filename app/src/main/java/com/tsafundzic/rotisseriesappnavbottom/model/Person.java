package com.tsafundzic.rotisseriesappnavbottom.model;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class Person {

    private final int id;
    private String name;
    private String surname;
    private String password;

    public Person(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

}