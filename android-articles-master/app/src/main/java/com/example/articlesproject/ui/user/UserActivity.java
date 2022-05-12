package com.example.articlesproject.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ImageView backbtn = findViewById(R.id.image_back_btn);
        TextView username  = findViewById(R.id.tv_username_profile);

        RecyclerView articlesRecycler = findViewById(R.id.rv_user_articles);

        String name = getIntent().getStringExtra("name");
        username.setText(name);

//        recycler
        List<Article> data = new ArrayList<>();
        data.add(new Article("Why the Last Week of the Year is Crucial to Our Success", "Rachella Angel", "14h", "Time Management", "50", R.drawable.rachella_cover_image, R.drawable.rachella_angel_profile, "I have always loved the last week of the year, the closing of one book leading to the opening of the next one. However, I’ve been pickier about using the time given in the past few years. While I try to make the best of every day, I focus on this week, maybe more than other weeks of the year. So here are three ways to make the best use of the transition period.", R.drawable.rachella_body_image));
        data.add(new Article("How to Read More as a Working Parent", "Alison McBain", "1h", "Reading", "20", R.drawable.alison_cover_image, R.drawable.alison_mcbain_profile, "A decade ago, I used to read a book a day. And now I’m wondering how I did it since there never seems to be enough time in the day to just breathe." +
                "Of course, that was before distractions such as kids, freelance working from home, streaming TV, and did I mention kids? Back then, my life was simpler and the sections of it were more compartmentalized— go to work, come home, read a book to relax." +
                "Many of the writers I know are procrastinators, and maybe that’s a part of my problem, too. When the kitchen could use cleaning, I work on my manuscript. When I have a deadline to write a story, I clean the kitchen. Eventually, everything gets done, but usually not in the order that I’m supposed to be doing it.", R.drawable.alison_body_image));
        data.add(new Article("Product Manager vs. Project Manager", "Julius Uy", "24h", "Product Management", "30", R.drawable.julius_body_image, R.drawable.julius_uy_profile, "A decade ago, I used to read a book a day. And now I’m wondering how I did it since there never seems to be enough time in the day to just breathe.\n" +
                "Of course, that was before distractions such as kids, freelance working from home, streaming TV, and did I mention kids? Back then, my life was simpler and the sections of it were more compartmentalized— go to work, come home, read a book to relax." +
                "Many of the writers I know are procrastinators, and maybe that’s a part of my problem, too. When the kitchen could use cleaning, I work on my manuscript. When I have a deadline to write a story, I clean the kitchen. Eventually, everything gets done, but usually not in the order that I’m supposed to be doing it.", R.drawable.julius_body_image));

UserArticlesAdapter articlesAdapter = new UserArticlesAdapter(data);

        articlesRecycler.setHasFixedSize(true);
        articlesRecycler.setLayoutManager(new LinearLayoutManager(this));
        articlesRecycler.setAdapter(articlesAdapter);





//back button click
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }


}