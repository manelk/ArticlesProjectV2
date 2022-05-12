package com.example.articlesproject.model;

public  class Bookmark {
    private String title, author;
    private int image;

    public Bookmark(String title, String author, int image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getImage() {
        return image;
    }
}
