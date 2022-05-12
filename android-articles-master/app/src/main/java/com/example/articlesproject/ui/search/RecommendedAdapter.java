package com.example.articlesproject.ui.search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.model.Recomended;
import com.example.articlesproject.ui.bookmarks.CustomAdapter;
import com.example.articlesproject.ui.details.DetailsActivity;
import com.example.articlesproject.ui.user.UserActivity;

import org.json.JSONException;

import java.util.List;

public class RecommendedAdapter extends  RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    List<Article> data;

    public RecommendedAdapter(List<Article> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommended_blogs, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Article recomended = data.get(position);
        holder.rec_title.setText(recomended.getTitle());
        holder.rec_user_name.setText(recomended.getName());
        holder.rec_user_image.setImageResource(recomended.getProfileImage());
        holder.rec_cover.setImageResource(recomended.getCoverImage());


//       actions

        holder.rec_user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(holder.rec_title.getContext(), UserActivity.class);
                holder.rec_title.getContext().startActivity(profileIntent);
            }
        });

        holder.recommended_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailsIntent = new Intent(holder.rec_title.getContext(), DetailsActivity.class);
                try {
                    detailsIntent.putExtra("data", "" +  recomended.toJson());
                    holder.rec_title.getContext().startActivity(detailsIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
    private ImageView rec_user_image, rec_cover;
    private TextView rec_user_name, rec_title;
    private LinearLayoutCompat recommended_card;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        rec_user_image = itemView.findViewById(R.id.image_user_recommeded);
        rec_cover = itemView.findViewById(R.id.image_recommended_cover);
        rec_user_name = itemView.findViewById(R.id.tv_user_recommended);
        rec_title = itemView.findViewById(R.id.tv_recommended_title);
        recommended_card = itemView.findViewById(R.id.llc_recommended_card);



    }
}

}
