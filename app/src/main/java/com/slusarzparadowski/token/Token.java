package com.slusarzparadowski.token;

import android.content.Context;
import android.util.Log;

import com.slusarzparadowski.database.Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dominik on 2015-03-17.
 */
public class Token {

    private String token = "";
    private final String FILENAME = "hb_config";
    private Context context;

    public String getToken(){
        return this.token;
    }

    public Token(Context context) throws IOException {
        this.context = context;
        if(!this.loadToken()){
            while(true){
                this.createToken();
                if(Database.checkToken(this.token).equals("NOT_EXIST")){
                    this.saveToken();
                    if(Database.insertToken(this.token)){
                        break;
                    }
                }
            }
        }
        if(Database.checkToken(this.token).equals("NOT_EXIST")){
            Database.insertToken(this.token);
        }
    }

    private void createToken() throws IOException {
        this.token = Long.toHexString(Double.doubleToLongBits(Math.random())) + Long.toHexString(Double.doubleToLongBits(Math.random()));
        Log.d("Token:createToken", "Token  "+ this.token + " created");
    }

    private void saveToken() throws IOException {
        FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
        fos.write(this.token.getBytes());
        fos.close();
        Log.d("Token:saveToken", "Token  "+ this.token + " saved");
    }

    private boolean loadToken() throws IOException {
        try {
            FileInputStream fin = context.openFileInput(FILENAME);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            this.token = temp;
            fin.close();
            Log.d("Token:loadToken", "Token "+ this.token +" load from "+ FILENAME);
            return true;
        }catch(FileNotFoundException e){
            Log.e("Token:loadToken", e.toString());
            return false;
        }
    }

}


