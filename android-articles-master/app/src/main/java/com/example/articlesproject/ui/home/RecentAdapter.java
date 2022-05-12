package com.example.articlesproject.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.ui.user.UserActivity;

import java.util.List;

public class RecentAdapter  extends RecyclerView.Adapter<RecentAdapter.ViewHolder>{

    List<Article> data;

    public RecentAdapter(List<Article> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_item, parent, false);
        RecentAdapter.ViewHolder viewHolder = new RecentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article pp = data.get(position);

        holder.profileImage.setImageResource(pp.getProfileImage());
        holder.coverImage.setImageResource(pp.getCoverImage());
        holder.title.setText(pp.getTitle());
        holder.name.setText(pp.getName());

        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(holder.title.getContext(), UserActivity.class);
                holder.title.getContext().startActivity(profileIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView coverImage, profileImage;
        public TextView name, title;
        public ViewHolder(@NonNull View item) {
            super(item);
            title = item.findViewById(R.id.tv_post_title_recent);
            name = item.findViewById(R.id.tv_username_recent);
            coverImage = item.findViewById(R.id.image_cover_recent);
            profileImage = item.findViewById(R.id.image_user_recent);
        }
    }
}
