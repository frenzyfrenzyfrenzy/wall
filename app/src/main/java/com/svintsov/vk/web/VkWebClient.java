package com.svintsov.vk.web;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VkWebClient {

    private static VkWebClient instance;

    private VkWebApi vkWebApi;

    private VkWebClient(Context context) {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        vkWebApi = retrofit.create(VkWebApi.class);
    }

    public static VkWebApi getInstance(Context context) {
        if (instance == null) {
            instance = new VkWebClient(context);
        }
        return instance.vkWebApi;
    }
}
