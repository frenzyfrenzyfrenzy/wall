package com.svintsov.vk.wall;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;
import com.svintsov.vk.global.StateHolder;
import com.svintsov.vk.utility.Parser;
import com.svintsov.vk.web.VkWebApi;
import com.svintsov.vk.web.VkWebClient;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallActivity extends AppCompatActivity {

    private final StateHolder stateHolder = new StateHolder(getSupportFragmentManager(), getClass().getSimpleName());;
    private WallPresenter presenter;

    private PostFragment postFragment;
    private WallFragment wallFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (stateHolder.firstTimeIn())
            initializeMvp(this);
        else
            reinitializeMvp(this);

        setContentView(R.layout.activity_wall);

        FragmentManager fragmentManager = getSupportFragmentManager();
        postFragment = (PostFragment) fragmentManager.findFragmentById(R.id.activity_wall_post_fragment);
        wallFragment = (WallFragment) fragmentManager.findFragmentById(R.id.activity_wall_wall_fragment);

        if (postFragment!=null) postFragment.setRetainInstance(true);

        wallFragment.initList(presenter.getAdapter());

        presenter.onLoadWall(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy(isChangingConfigurations());
    }

    public WallPresenter getPresenter() {
        return presenter;
    }

    /**********
     * VIEW OPS
     *********/

    void updateUiPostSelected(VkWallReponse.Response post) {
        if (postFragment != null) postFragment.udpatePost(post);
    }

    /********
     MVP INITIALIZATION
     *******/

    private void initializeMvp(WallActivity view) {
        presenter = new WallPresenter(getApplicationContext(), view);
        stateHolder.put(WallPresenter.class.getSimpleName(), presenter);
    }

    private void reinitializeMvp(WallActivity view) {
        presenter = stateHolder.get(WallPresenter.class.getSimpleName());
        if (presenter == null)
            initializeMvp(view);
        else
            presenter.onConfigurationChanged(view);
    }
}
