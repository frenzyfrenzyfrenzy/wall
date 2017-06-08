package com.svintsov.vk.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkWebApi {

    @GET("method/wall.get")
    Call<ResponseBody> getWall(@Query("owner_id") int ownerId);
}
