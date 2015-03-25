package com.slusarzparadowski.model;

import com.slusarzparadowski.database.Database;

import java.util.List;

/**
 * Created by Dominik on 2015-03-22.
 */
public class ElementList {

    private List<Element> elementList;
    private int id;
    private String name;
    private String type;

    public ElementList(int id){
        this.id = id;
        Database.getElementList(this.id);

    }

    public ElementList(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;

    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
