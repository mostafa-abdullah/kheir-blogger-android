package com.khierblogger.khierbloggerapp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class KhierBloggerServer {
    private final OkHttpClient client = new OkHttpClient();

    //TODO: update the base url
    private final String baseUrl = "";

    public void authenticateUser(String email , String password , final UserAuthenticationCallback callback){
        //TODO : Add parameters to the request
        Request request = new Request.Builder()
                .url(baseUrl).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.authenticationFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    callback.authenticationSuccessful();
                }
            }
        });
    }



    public interface UserAuthenticationCallback{
        void authenticationSuccessful();
        void authenticationFailed();
    }
}
