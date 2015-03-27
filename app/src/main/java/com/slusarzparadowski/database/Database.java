package com.slusarzparadowski.database;

import android.util.Log;

import com.slusarzparadowski.model.Element;
import com.slusarzparadowski.model.ElementList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
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
    private static String urlUpdate = "http://slusarzparadowskiprojekt.esy.es/update.php";

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

    static public ArrayList<Element> getElement(String token, int id){
        ArrayList<Element> returnList = new ArrayList<>();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("get_element_detail", token));
        params.add(new BasicNameValuePair("get_element_id", String.valueOf(id)));

        // getting JSON Object
        JSONObject json = jsonParser.makeHttpRequest(urlGet, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);

            Log.d(String.valueOf(value), message);
            JSONObject listId = json.getJSONObject("response_array_id");
            JSONObject listName = json.getJSONObject("response_array_name");
            JSONObject listValue = json.getJSONObject("response_array_element_value");
            if(listId.length() != listName.length()){
                return null;
            }
            for(int i = 0; i < listId.length(); i++){
                Log.e("Database:getElement", "Element created Element("+listId.getInt("id["+i+"]")+", "+ listName.getString("name["+i+"]")+","+listValue.getDouble("value["+i+"]")+")");
                returnList.add(new Element(listId.getInt("id["+i+"]"), listName.getString("name["+i+"]"), listValue.getDouble("value["+i+"]")));
            }
            return returnList;
        } catch (JSONException e) {
            Log.e("Database:getElement", e.toString());
        }
        return null;
    }

    public static ArrayList<ElementList> getList(String token, String type) {
        ArrayList<ElementList> returnList = new ArrayList<>();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("get_element", token));
        params.add(new BasicNameValuePair("get_element_type", type));
        // getting JSON Object
        JSONObject json = jsonParser.makeHttpRequest(urlGet, "POST", params);

        // check log cat fro response
        Log.d("Create Response", json.toString());

        // check for success tag
        try {
            int value = json.getInt(TAG_VALUE);
            String message = json.getString(TAG_MESSAGE);
            JSONObject listId = json.getJSONObject("response_array_id");
            JSONObject listName = json.getJSONObject("response_array_name");
            if(listId.length() != listName.length()){
                return null;
            }
            for(int i = 0; i < listId.length(); i++){
                Log.e("Database:getList", "ElementList created ElementList("+listId.getInt("id["+i+"]")+", "+listName.getString("name["+i+"]")+")");
                returnList.add(new ElementList(listId.getInt("id["+i+"]"), listName.getString("name["+i+"]"), type));
            }
            for(ElementList el : returnList){
                el.setElementList(Database.getElement(token, el.getId()));
            }
            Log.d(String.valueOf(value), message);
            return returnList;
        } catch (JSONException e) {
            Log.e("Database:getList", e.toString());
        }
        return null;
    }
}
