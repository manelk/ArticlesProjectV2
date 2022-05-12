package com.example.articlesproject.ui.user;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.ui.details.DetailsActivity;

import org.json.JSONException;

import java.util.List;

public class UserArticlesAdapter extends  RecyclerView.Adapter<UserArticlesAdapter.ViewHolder>{
    List<Article> data;

    public UserArticlesAdapter(List<Article> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_article_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Article article = data.get(position);
        holder.title.setText(article.getTitle());
        holder.category.setText(article.getCategory());
        holder.stars.setText(article.getStars());
        holder.cover.setImageResource(article.getCoverImage());

        //actions
        holder.goToDetails(article);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cover;
        private TextView title, category, stars;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.image_user_article_cover);
            title = itemView.findViewById(R.id.tv_user_article_title);
            category = itemView.findViewById(R.id.tv_user_article_type);
            stars = itemView.findViewById(R.id.tv_user_article_stars);
        }


        public void goToDetails(Article selected){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailIntent = new Intent(cover.getContext() , DetailsActivity.class);
                    try {
                        detailIntent.putExtra("data", selected.toJson().toString());
                        cover.getContext().startActivity(detailIntent);

                    } catch (JSONException e) {
//                    e.printStackTrace();
                        Toast.makeText(cover.getContext(), "" + e, Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }

    }
}
