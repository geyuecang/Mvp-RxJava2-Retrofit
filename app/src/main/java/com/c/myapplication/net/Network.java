package com.c.myapplication.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : geyuecang
 * date   : 2019/6/5 17:13
 * desc   : desc
 */
public class Network {
    private static Network instance;
    private static int TIME_OUT = 60 * 5;
    private Interceptor networkInterceptor = new NetworkInterceptor();
    private final OkHttpClient client;
    private GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private RxJava2CallAdapterFactory callAdapterFactory = RxJava2CallAdapterFactory.create();

    private Network() {
        client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(networkInterceptor).build();
    }

    public static Network getInstance() {
        if (instance == null) {
            synchronized (Network.class) {
                if (instance == null) {
                    instance = new Network();
                }
            }
        }
        return instance;
    }

    public <T> T getApiService(Class<T> api, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
        return retrofit.create(api);
    }
}
