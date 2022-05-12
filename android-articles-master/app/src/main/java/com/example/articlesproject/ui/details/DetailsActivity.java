package com.example.articlesproject.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.articlesproject.MainActivity;
import com.example.articlesproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_details);

//
        ImageView coverImage = findViewById(R.id.image_details_cover);
        ImageView userImage = findViewById(R.id.image_details_user);
        TextView userName = findViewById(R.id.tv_details_username);
        TextView title = findViewById(R.id.tv_details_title);
        TextView detailsDescription = findViewById(R.id.tv_details_description);
        ImageView detailsImage = findViewById(R.id.image_details);

        String data = getIntent().getStringExtra("data");

        Log.e("data ==>", data);
//        data['title']

        try {
            JSONObject json = new JSONObject(data);
           coverImage.setImageResource(json.getInt("coverImage"));
            userImage.setImageResource(json.getInt("profileImage"));
            userName.setText(json.getString("name"));
            title.setText(json.getString("title"));
            detailsDescription.setText(json.getString("description"));
            detailsImage.setImageResource(json.getInt("articleImage"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        ImageButton back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(view -> {
              onBackPressed();

            });

    }
}