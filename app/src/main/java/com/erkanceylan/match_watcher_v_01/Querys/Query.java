package com.erkanceylan.match_watcher_v_01.Querys;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by ERKAN on 20.11.2016.
 */

public class Query
{
    public static final String xAuthToken="757f3cedfc534a7e8f728788cb8f6473";
    public static final String xResponseControl="minified";
    public static final String url="http://api.football-data.org";

    public static String GET(String queryString)throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url+queryString).addHeader("x-Auth-Token",xAuthToken)
                .addHeader("x-Response-Control",xResponseControl)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
