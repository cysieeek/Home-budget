package com.slusarzparadowski.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.slusarzparadowski.database.Database;
import com.slusarzparadowski.homebudget.MainActivity;
import com.slusarzparadowski.token.Token;

import java.io.IOException;

/**
 * Created by Dominik on 2015-03-21.
 */
/*
class CheckToken extends AsyncTask<Token, String, Void> {

    ProgressDialog pDialog;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(null);
        pDialog.setMessage("Checking token..");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    protected Void doInBackground(Token... args) {
        Token token = args[0];
        try {
            if(!token.loadToken()){
                while(true){
                    token.createToken();
                    if(Database.checkToken(token.getToken()).equals("NOT_EXIST")){
                        token.saveToken();
                        if(Database.insertToken(token.getToken()).equals("")){
                            Log.e("Error ", "Token insert error");
                        }
                        Log.d("Token created", token.getToken());
                    }
                }
            }
            Log.d("Token loaded", token.getToken());
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
        return null;
    }
    protected void onPostExecute(String file_url) {
        // dismiss the dialog once done
        if(pdo)pDialog.dismiss();
    }

}
*/
