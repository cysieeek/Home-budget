package com.slusarzparadowski.model;


import android.content.Context;

import com.slusarzparadowski.database.Database;
import com.slusarzparadowski.token.Token;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dominik on 2015-03-22.
 */
public class Model {

    private Token token;
    private ArrayList<ElementList> income;
    private ArrayList<ElementList> outcome;

    public Model(Context context) throws IOException {
        this.token = new Token(context);
        this.loadOutcome();
        this.loadIncome();
    }

    public double getSummary(){
        return this.getIncomeSum() - this.getOutcomeSum();
    }

    public double getIncomeSum(){
        double sum = 0;
        for(ElementList el : this.income){
            for(Element e : el.getElementList()){
                sum += e.getValue();
            }
        }
        return sum;
    }

    public double getOutcomeSum(){
        double sum = 0;
        for(ElementList el : this.outcome){
            for(Element e : el.getElementList()){
                sum += e.getValue();
            }
        }
        return sum;
    }

    public void loadIncome(){
        this.setIncome(Database.getList(token.getToken(), "income"));
    }

    public void loadOutcome(){
        this.setOutcome(Database.getList(token.getToken(), "outcome"));
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