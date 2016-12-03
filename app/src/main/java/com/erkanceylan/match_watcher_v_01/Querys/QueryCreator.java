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

public class SoundCloudApi
{
	OkHttpClient client = new OkHttpClient();

	public void run(String url, HashMap<String, String> parameters, final Callback callback) throws Exception {

		StringBuilder queryStr = new StringBuilder();
		for (Object key : parameters.keySet()) {
			Object value = parameters.get(key);
			queryStr.append(key + "=" + value);
			queryStr.append("&");
		}

		url = url + "?" + queryStr.toString();

		Request request = new Request.Builder()
				.url(url)
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

	public Response runSync(String url, HashMap<String, String> parameters) throws Exception{
		StringBuilder queryStr = new StringBuilder();
		for (Object key : parameters.keySet()) {
			Object value = parameters.get(key);
			queryStr.append(key + "=" + value);
			queryStr.append("&");
		}

		url = url + "?" + queryStr.toString();

		Request request = new Request.Builder()
				.url(url)
				.build();

		Response response = client.newCall(request).execute();
		return response;
	}
}
