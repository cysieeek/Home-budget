package com.slusarzparadowski.token;

import android.content.Context;
import android.util.Log;
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

    public Token(Context context){
        this.context = context;
    }

    public void createToken() throws IOException {
        this.token = Long.toHexString(Double.doubleToLongBits(Math.random())) + Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    public void saveToken() throws IOException {
        FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
        fos.write(this.token.getBytes());
        fos.close();
    }

    public boolean loadToken() throws IOException {
        try {
            FileInputStream fin = context.openFileInput(FILENAME);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            this.token = temp;
            fin.close();
            return true;
        }catch(FileNotFoundException e){
            Log.e("FileNotFoundException", e.getMessage());
            return false;
        }
    }

}


