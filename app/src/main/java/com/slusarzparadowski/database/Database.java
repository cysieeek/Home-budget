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
    private static String urlGet = "http://slusarzparadowskiprojekt.esy.es/get.php";

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
            Log.d(String.valueOf(value), message);
            return message;
        } catch (JSONException e) {
            Log.e("Database:checkToken", e.toString());
            return "JSONException";
        }
    }

    static public boolean insertToken(String token){
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
            Log.d(String.valueOf(value), message);
            return true;
        } catch (JSONException e) {
            Log.e("Database:insertToken", e.toString());
            return false;
        }
    }

    static public boolean getSummary(String token){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("get_summary", token));

        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(urlGet, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            Log.d(String.valueOf(value), message);
            return true;
        } catch (JSONException e) {
            Log.e("Database:insertToken", e.toString());
            return false;
        }

    }

    static public Object[] getElement(int id){
        Object[] temp = new Object[2];

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("get_element_detail", String.valueOf(id)));

        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(urlGet, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            Log.d(String.valueOf(value), message);
            temp[0] = json.getInt("NAME");
            temp[1] = json.getInt("VALUE");
            return temp;
        } catch (JSONException e) {
            Log.e("Database:checkToken", e.toString());
        }
        return temp;
    }
    //dopisac
    public static Object[] getElementList(int id) {
        Object[] temp = new Object[2];

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("get_element_detail", String.valueOf(id)));

        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(urlGet, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            Log.d(String.valueOf(value), message);
            temp[0] = json.getInt("NAME");
            temp[1] = json.getInt("VALUE");
            return temp;
        } catch (JSONException e) {
            Log.e("Database:checkToken", e.toString());
        }
        return temp;
    }
}
