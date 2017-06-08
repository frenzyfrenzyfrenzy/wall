package com.svintsov.vk.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svintsov.vk.R;
import com.svintsov.vk.datamodel.VkWallReponse;
import com.svintsov.vk.wall.WallPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<VkWallReponse.Response> items;
    private Context context;
    private WallPresenter presenter;

    public PostsAdapter(Context context, List<VkWallReponse.Response> items, WallPresenter presenter) {
        this.items = items;
        this.context = context;
        this.presenter = presenter;
    }

    public void setItems(ArrayList<VkWallReponse.Response> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_post, parent, false);

        return new PostsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VkWallReponse.Response response = items.get(position);

        holder.textViewTitle.setText(response.getText());
        holder.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPostSelected(response);
            }
        });
        holder.textViewCommentary.setText(String.valueOf(response.getComments().getCount()));

        android.text.format.DateFormat df = new android.text.format.DateFormat();
        long seconds = response.getDate();
        long milliseconds = seconds * 1000;
        CharSequence date = df.format("yyyy-MM-dd hh:mm", new java.util.Date(milliseconds));
        holder.textViewDate.setText(date);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemview_post_text_view_text)
        TextView textViewTitle;

        @BindView(R.id.itemview_post_text_view_commentary)
        TextView textViewCommentary;

        @BindView(R.id.itemview_post_text_view_date)
        TextView textViewDate;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
