package com.slusarzparadowski.database;

import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 2015-03-17.
 */
public class Database {

    private static final String TAG_VALUE = "response_value";
    private static final String TAG_MESSAGE = "response_message";

    private static String urlInsert = "http://slusarzparadowskiprojekt.esy.es/insert.php";
    private static String urlCheck = "http://slusarzparadowskiprojekt.esy.es/check.php";

    static JSONParser jsonParser = new JSONParser();

    static public String checkToken(String token){

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("check_token", token));

        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(urlCheck, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            if (value == 1) {
                Log.d(String.valueOf(value), message);
                return message;
            }
            else if(value == 0){
                Log.e(String.valueOf(value), message);
                return message;
            }
            else {
                Log.d(String.valueOf(value), message);
                return message;
            }
        } catch (JSONException e) {
            Log.e("JSONException", e.getMessage());
            return "JSONException";
        }
    }

    static public String insertToken(String token){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("insert_token", token));

        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(urlInsert, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            if (value == 1) {
                Log.d(String.valueOf(value), message);
                return message;
            } else {
                Log.e(String.valueOf(value), message);
                return message;
            }
        } catch (JSONException e) {
            Log.e("JSONException", e.getMessage());
            return "JSONException";
        }
    }
}
