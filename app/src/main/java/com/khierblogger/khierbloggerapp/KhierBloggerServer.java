package com.khierblogger.khierbloggerapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.khierblogger.khierbloggerapp.Intefaces.EventResponseCallback;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationsResponseCallback;
import com.khierblogger.khierbloggerapp.Intefaces.UserAuthenticationCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Event;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class that wraps all communication to the Khier Blogger server.<br/>
 * No network calls should be done outside the scope this wrapper.
 */

public class KhierBloggerServer {

    private static final OkHttpClient client = new OkHttpClient();

    //Server is running on localhost
    //TODO: update the base url
    private static final String baseUrl = "http://127.0.0.1:8080";

    //Private constructor ensures only static access to this class
    private KhierBloggerServer(){}

    /**
     * Authenticate a user with the sever database
     * @param email email of the user
     * @param password password of the user
     * @param callback callback to pass the results to
     */

    public static void authenticateUser(String email , String password , final UserAuthenticationCallback callback){
        //TODO : Add parameters to the request
        Request request = new Request.Builder()
                .url(baseUrl).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    callback.authenticationSuccessful();
                }else
                    callback.onError("Bad response from the server");
            }
        });
    }


    /**
     * Gets all organizations on the server
     * @param callback callback to return the results to
     */

    public static void getAllOrganizations(final OrganizationsResponseCallback callback){
        final Request request = new Request.Builder()
                .url(baseUrl + "/api/organization").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                    JsonParser parser = new JsonParser();
                    JsonArray jArray = parser.parse(response.body().string()).getAsJsonArray();

                    ArrayList<Organization> organizations = new ArrayList<>(jArray.size());
                    for (JsonElement element : jArray)
                        organizations.add(gson.fromJson(element , Organization.class));

                    callback.onOrganizationFetched(organizations);
                }else
                    callback.onError("Bad response from server");
            }
        });
    }
    /**
     * Gets all Events on the server
     * @param callback callback to return the results to
     */

    public static void getAllEvents(final EventResponseCallback callback){
        final Request request = new Request.Builder()
                .url(baseUrl + "/api/event").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")
                            .create();

                    JsonParser parser = new JsonParser();
                    JsonArray jArray = parser.parse(response.body().string()).getAsJsonArray();

                    ArrayList<Event> events  = new ArrayList<>(jArray.size());
                    for (JsonElement element : jArray)
                        events.add(gson.fromJson(element , Event.class));

                    callback.onEventFetched(events);
                }else
                    callback.onError("Bad response from server");
            }
        });
    }
}
