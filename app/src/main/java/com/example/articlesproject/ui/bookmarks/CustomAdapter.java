package com.example.articlesproject.ui.bookmarks;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{


    private List<BookmarkModel> bookmarks = new ArrayList<>();



    public CustomAdapter(List<BookmarkModel> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookmark_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BookmarkModel bookmark = bookmarks.get(position);
        holder.title.setText(bookmark.getTitle());
        holder.author.setText(bookmark.getAuthor());
        holder.image.setImageResource(bookmark.getImage());
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView author, title;
        private final ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.ba_author_name);
            title = itemView.findViewById(R.id.ba_title);
            image = itemView.findViewById(R.id.ba_image);
        }
    }
}


class BookmarkModel{
    private String title, author;
    private int image;

    public BookmarkModel(String title, String author, int image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
