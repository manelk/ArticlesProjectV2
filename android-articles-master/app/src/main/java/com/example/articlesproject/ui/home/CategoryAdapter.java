package com.example.articlesproject.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articlesproject.R;
import com.example.articlesproject.ui.bookmarks.CustomAdapter;
import com.google.android.material.chip.Chip;

import java.util.List;

public class CategoryAdapter  extends  RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    List<String> categories;

    public CategoryAdapter(List<String> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.chip.setText(categories.get(position));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        public Chip chip;
        public ViewHolder(@NonNull View item) {
            super(item);
            chip = item.findViewById(R.id.cat_chip);
        }
    }

}
