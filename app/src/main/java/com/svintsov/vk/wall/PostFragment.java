package com.svintsov.vk.wall;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostFragment extends Fragment {

    private VkWallReponse.Response post;

    @BindView(R.id.fragment_post_text_view_post)
    TextView textViewPost;

    public PostFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_post, container, false);

        ButterKnife.bind(this, fragmentView);

        if (post!=null)
            textViewPost.setText(post.getText());

        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void udpatePost(VkWallReponse.Response post) {
        this.post = post;
        textViewPost.setText(post.getText());
    }
}
