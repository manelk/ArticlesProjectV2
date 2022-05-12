package com.example.articlesproject.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Article {

    private String title, name, createdAt, category, stars, description;
    private int coverImage, profileImage, articleImage;

    public Article(String title, String name, String createdAt, String category, String stars, int coverImage, int profileImage, String description, int articleImage) {
        this.title = title;
        this.name = name;
        this.createdAt = createdAt;
        this.category = category;
        this.stars = stars;
        this.coverImage = coverImage;
        this.profileImage = profileImage;
        this.description = description;
        this.articleImage = articleImage;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCategory() {
        return category;
    }

    public String getStars() {
        return stars;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public int getProfileImage() {
        return profileImage;
    }
    public String getDescription() {
        return description;
    }

    public int getArticleImage() {
        return articleImage;
    }

    public JSONObject toJson() throws JSONException {

        JSONObject json = new JSONObject();
        json.put("title", this.title);
        json.put("name", this.name);
        json.put("createdAt", this.createdAt);
        json.put("category", this.category);
        json.put("stars", this.stars);
        json.put("coverImage", this.coverImage);
        json.put("profileImage", this.profileImage);
        json.put("description", this.description);
        json.put("articleImage", this.articleImage);

        return json;
    }
}

