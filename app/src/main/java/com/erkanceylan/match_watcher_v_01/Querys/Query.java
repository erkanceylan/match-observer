package com.erkanceylan.match_watcher_v_01.Querys;

import android.os.AsyncTask;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by ERKAN on 20.11.2016.
 */

public class Query
{
    private static final String xAuthToken="757f3cedfc534a7e8f728788cb8f6473";
    private static final String xResponseControl="minified";
    private static final String url="http://api.football-data.org";

    public String GET(String queryString)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url+queryString).addHeader("X-Auth-Token",xAuthToken)
                .addHeader("X-Response-Control",xResponseControl)
                .build();

        Response response = null;
        try
        {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
