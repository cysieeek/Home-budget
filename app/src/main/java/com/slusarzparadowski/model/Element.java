package com.slusarzparadowski.model;

import com.slusarzparadowski.database.Database;

/**
 * Created by Dominik on 2015-03-22.
 */
public class Element {

    private int id;
    private String name;
    private double value;

    public Element(int id){
        this.id = id;
        Object[] temp;
        temp = Database.getElement(this.id);
        this.name = (String)temp[0];
        this.value = (int)temp[1];
    }

    public Element(int id, String name, double value){
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
