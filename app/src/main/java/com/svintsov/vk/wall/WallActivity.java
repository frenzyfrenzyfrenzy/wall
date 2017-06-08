package com.svintsov.vk.wall;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;
import com.svintsov.vk.global.StateHolder;
import com.svintsov.vk.web.VkWallResponseCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class WallActivity extends AppCompatActivity {

    private final StateHolder stateHolder = new StateHolder(getSupportFragmentManager(), getClass().getSimpleName());
    private WallPresenter presenter;

    private PostFragment postFragment;
    private WallFragment wallFragment;

    @Nullable
    @BindView(R.id.activity_wall_layout_post)
    ScrollView layoutPost;

    @BindView(R.id.activity_wall_layout_wall)
    FrameLayout layoutWall;

    @BindView(R.id.activity_wall_edit_text_id)
    EditText editTextId;

    @BindView(R.id.activity_wall_progress_bar)
    ProgressBar progressBar;

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
                    .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom)
                    .remove(postFragment)
                    .commit();
            postFragment = null;
        } else super.onBackPressed();
    }

    public WallPresenter getPresenter() {
        return presenter;
    }

    /**********
     * VIEW-ONLY OPS
     *********/

    @OnClick(R.id.activity_wall_button_load)
    public void onButtonLoadClick() {
        int ownerId;
        try {
            ownerId = Integer.parseInt(editTextId.getText().toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Incorrect id, try again...",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.onLoadWall(ownerId);
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
                    .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom)
                    .add(R.id.activity_wall_layout_post, postFragment, PostFragment.class.getSimpleName())
                    .commit();
        }
    }

    void updateUiWallLoadStarted() {
        progressBar.setVisibility(View.VISIBLE);
    }

    void updateUiWallLoadFinihsed(VkWallResponseCode code) {
        progressBar.setVisibility(View.INVISIBLE);

        switch (code) {
            case SUCCESS:
                break;

            case FAIL:
                Toast.makeText(this, "Error loading wall with current id, try another id...",
                        Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
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
