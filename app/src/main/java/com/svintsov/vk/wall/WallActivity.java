package com.svintsov.vk.wall;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;
import com.svintsov.vk.global.StateHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallActivity extends AppCompatActivity {

    private final StateHolder stateHolder = new StateHolder(getSupportFragmentManager(), getClass().getSimpleName());
    ;
    private WallPresenter presenter;

    private PostFragment postFragment;
    private WallFragment wallFragment;

    @Nullable
    @BindView(R.id.activity_wall_layout_post)
    FrameLayout layoutPost;

    @BindView(R.id.activity_wall_layout_wall)
    FrameLayout layoutWall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (stateHolder.firstTimeIn())
            initializeMvp(this);
        else
            reinitializeMvp(this);

        setContentView(R.layout.activity_wall);

        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        postFragment = (PostFragment) fragmentManager.findFragmentByTag(PostFragment.class.getSimpleName());
        wallFragment = (WallFragment) fragmentManager.findFragmentByTag(WallFragment.class.getSimpleName());

        if ((wallFragment == null) && (layoutWall != null)) {
            wallFragment = WallFragment.newInstance(presenter.getAdapter());
            fragmentManager
                    .beginTransaction()
                    .add(R.id.activity_wall_layout_wall, wallFragment, WallFragment.class.getSimpleName())
                    .commit();
        }

        if ((postFragment == null) && (layoutPost != null)
                && (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)) {
            postFragment = PostFragment.getInstance(null);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.activity_wall_layout_post, postFragment, PostFragment.class.getSimpleName())
                    .commit();
        }

        presenter.onLoadWall(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy(isChangingConfigurations());
    }

    @Override
    public void onBackPressed() {
        if ((postFragment != null)
                && (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations( R.anim.enter_from_bottom, R.anim.exit_to_bottom)
                    .remove(postFragment)
                    .commit();
            postFragment = null;
        }
        else super.onBackPressed();
    }

    public WallPresenter getPresenter() {
        return presenter;
    }

    /**********
     * VIEW OPS
     *********/

    void updateUiPostSelected(VkWallReponse.Response post) {
        if (postFragment != null) postFragment.udpatePost(post);
        else {
            postFragment = PostFragment.getInstance(post);
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations( R.anim.enter_from_bottom, R.anim.exit_to_bottom)
                    .add(R.id.activity_wall_layout_post, postFragment, PostFragment.class.getSimpleName())
                    .commit();
        }
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
