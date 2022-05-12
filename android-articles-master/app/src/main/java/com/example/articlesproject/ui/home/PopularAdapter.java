package com.example.articlesproject.ui.home;

import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.ui.details.DetailsActivity;
import com.example.articlesproject.ui.user.UserActivity;

import org.json.JSONException;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    List<Article> data;

    public PopularAdapter(List<Article> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_article_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article pp = data.get(position);

        holder.profileImage.setImageResource(pp.getProfileImage());
        holder.coverImage.setImageResource(pp.getCoverImage());
        holder.title.setText(pp.getTitle());
        holder.name.setText(pp.getName());
        holder.createdAt.setText(pp.getCreatedAt());
        holder.category.setText(pp.getCategory());
        holder.stars.setText(pp.getStars());

//        Actions
        holder.popularCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailIntent = new Intent(holder.popularCard.getContext() , DetailsActivity.class);

                try {
                    detailIntent.putExtra("data", pp.toJson().toString());
                    holder.popularCard.getContext().startActivity(detailIntent);

                } catch (JSONException e) {
//                    e.printStackTrace();
                    Toast.makeText(holder.popularCard.getContext(), "" + e, Toast.LENGTH_SHORT).show();
                }




            }
        });
        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(holder.title.getContext(), UserActivity.class);

                profileIntent.putExtra("name", pp.getName());

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
        public TextView name, title, createdAt, category, stars;

        public ConstraintLayout popularCard;

        public ViewHolder(@NonNull View item) {
            super(item);
            popularCard = item.findViewById(R.id.popular_card);

            stars = item.findViewById(R.id.tv_post_likes);
            category = item.findViewById(R.id.tv_post_type);
            createdAt = item.findViewById(R.id.tv_post_date);
            title = item.findViewById(R.id.tv_post_title);
            name = item.findViewById(R.id.tv_username_popular);
            coverImage = item.findViewById(R.id.image_cover_popular);
            profileImage = item.findViewById(R.id.image_user_popular);
        }
    }
}




