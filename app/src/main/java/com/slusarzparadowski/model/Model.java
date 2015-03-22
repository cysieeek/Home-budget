package com.slusarzparadowski.model;


import android.content.Context;

import com.slusarzparadowski.token.Token;

import java.util.List;

/**
 * Created by Dominik on 2015-03-22.
 */
public class Model {

    private Token token;
    private List<ElementList> income;
    private List<ElementList> outcome;

    public Model(Context context) {
        this.token = new Token(context);

    }
}