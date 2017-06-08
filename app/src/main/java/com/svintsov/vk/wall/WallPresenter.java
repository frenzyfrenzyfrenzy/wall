package com.svintsov.vk.wall;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svintsov.vk.adapters.PostsAdapter;
import com.svintsov.vk.datamodel.VkWallReponse;
import com.svintsov.vk.utility.Parser;
import com.svintsov.vk.web.VkWebApi;
import com.svintsov.vk.web.VkWebClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallPresenter {

    private List<VkWallReponse.Response> items;
    private PostsAdapter adapter;

    private WallActivity view;
    private Context context;

    WallPresenter(Context context, WallActivity view) {
        this.view = view;
        this.context = context;

        items = new ArrayList<>();
        adapter = new PostsAdapter(context, items, this);
    }

    void onConfigurationChanged(WallActivity view) {
        this.view = view;
    }

    void onDestroy(boolean isChangingConfig) {
        view = null;
    }

    PostsAdapter getAdapter() {
        return adapter;
    }

    private void updateItems(List<VkWallReponse.Response> items) {
        this.items.clear();
        this.items.addAll(items);
        adapter.notifyDataSetChanged();
    }

    /**********
     * PRESENTER OPS
     *********/

    void onLoadWall(int ownerId) {
        VkWebApi vkWebApi = VkWebClient.getInstance(context);
        vkWebApi.getWall(ownerId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                try {
                    String jsonString = Parser.removeNumberOfPosts(responseBody.string());
                    Gson gson = new GsonBuilder().create();
                    VkWallReponse vkWallReponse = gson.fromJson(jsonString, VkWallReponse.class);

                    updateItems(vkWallReponse.getResponse());
                } catch (Exception e) {
                    e.printStackTrace();
                    updateItems(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                updateItems(null);
            }
        });
    }

    public void onPostSelected(VkWallReponse.Response post) {
        view.updateUiPostSelected(post);
    }
}
