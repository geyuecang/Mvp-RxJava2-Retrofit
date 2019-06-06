package com.c.myapplication.net;

import android.util.Log;

import com.c.myapplication.mvp.utils.App;
import com.c.myapplication.mvp.utils.AppUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * author : geyuecang
 * date   : 2019/6/5 17:18
 * desc   : desc
 */
public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!AppUtil.isNetworkConnected(App.get())) {
            throw new NetworkNotConnectedException();
        }
        String url = chain.request().url().toString();
        Log.d("net", url);
        Response response = chain.proceed(chain.request());
        if (response.isSuccessful()) {
            String result = response.body().toString();
            Log.d("gnet", url + ":::" + result);
        } else {
            Log.d("gnet", url + ":::" + response.toString());
        }
        return response;
    }
}
