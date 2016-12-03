package com.erkanceylan.match_watcher_v_01.Querys;

import android.os.StrictMode;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Callback;
import okhttp3.ResponseBody;

/**
 * Created by ERL on 28.10.2016.
 */

public class QueryCreator
{
	private static final String xAuthToken="757f3cedfc534a7e8f728788cb8f6473";
	private static final String xResponseControl="minified";
	private static final String url="http://api.football-data.org";

	OkHttpClient client = new OkHttpClient();

	public void run(String parameters, final Callback callback) throws Exception
	{
		Request request = new Request.Builder()
				.url(url + parameters)
				.addHeader("X-Auth-Token",xAuthToken)
				.addHeader("X-Response-Control",xResponseControl)
				.build();
		client.newCall(request).enqueue(new Callback() {
			@Override public void onFailure(Call call, IOException e) {
				callback.onFailure(call, e);
			}

			@Override public void onResponse(Call call, Response response) throws IOException {
				//response 200(OK!) değilse on response a degilde on failure e düşsün.
				if(response.code() == 200)
					callback.onResponse(call, response);
				else
					callback.onFailure(call, new IOException());
			}
		});
	}

	public Response runSync(String parameters) throws Exception
	{
		Request request = new Request.Builder()
				.url(url + parameters)
				.addHeader("X-Auth-Token",xAuthToken)
				.addHeader("X-Response-Control",xResponseControl)
				.build();

		Response response = client.newCall(request).execute();
		Log.e("Response",response.body().string());
		return response;
	}
}
