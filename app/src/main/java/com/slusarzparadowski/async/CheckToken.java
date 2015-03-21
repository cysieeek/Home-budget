package com.paradowski.slusarz.homebudget.async;


/**
 * Created by Dominik on 2015-03-21.
 */
/*
class CheckToken extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Checking token..");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    protected String doInBackground(String... args) {
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
                        return "Token created " + token.getToken();
                    }
                }
            }
            Log.d("Token loaded", token.getToken());
            return "Token loaded " + token.getToken();
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
            return "IOException " + e.getMessage();
        }

    }
    protected void onPostExecute(String file_url) {
        // dismiss the dialog once done
        pDialog.dismiss();
    }

}
*/