package com.svintsov.vk.wall;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostFragment extends Fragment {

    private final static String postKey = "POST_KEY_BUNDLE";

    private VkWallReponse.Response post;

    @BindView(R.id.fragment_post_text_view_post)
    TextView textViewPost;

    public PostFragment() {
    }

    public static PostFragment getInstance(VkWallReponse.Response post) {
        PostFragment fragment = new PostFragment();
        fragment.post = post;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_post, container, false);

        ButterKnife.bind(this, fragmentView);

        if (savedInstanceState != null)
            post = Parcels.unwrap(savedInstanceState.getParcelable(postKey));
        if (post!=null)
            textViewPost.setText(Html.fromHtml(post.getText()));

        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(postKey, Parcels.wrap(VkWallReponse.Response.class, post));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void udpatePost(VkWallReponse.Response post) {
        this.post = post;
        textViewPost.setText(Html.fromHtml(post.getText()));
    }
}
