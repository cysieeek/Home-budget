package com.slusarzparadowski.model;


import android.content.Context;

import com.slusarzparadowski.database.Database;
import com.slusarzparadowski.token.Token;

import java.util.ArrayList;

/**
 * Created by Dominik on 2015-03-22.
 */
public class Model {

    private Token token;
    private ArrayList<ElementList> income;
    private ArrayList<ElementList> outcome;

    public Model(Context context) {
        this.token = new Token(context);
        // pobierz wszystkie element o tokenie i typei income
        //dla każdego elementu w liscie pobierz wszystkie element_detail o id tokenie
    }

    public void loadIncome(){
        this.setIncome(Database.getList(token.getToken(), "income"));
    }

    public void loadOutcome(){
        this.setIncome(Database.getList(token.getToken(), "outcome"));
    }

    public Token getToken(){
        return this.token;
    }

    public ArrayList<ElementList> getIncome() {
        return income;
    }

    public void setIncome(ArrayList<ElementList> income) {
        this.income = income;
    }

    public ArrayList<ElementList> getOutcome() {
        return outcome;
    }

    public void setOutcome(ArrayList<ElementList> outcome) {
        this.outcome = outcome;
    }
}