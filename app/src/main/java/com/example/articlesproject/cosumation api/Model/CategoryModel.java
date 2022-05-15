package com.example.articlesproject.Model;

import java.util.ArrayList;

public class CategoryModel {
    String message ;
    ArrayList <Category> CategoriesList ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Category> getCategoriesList() {
        return CategoriesList;
    }

    public void setCategoriesList(ArrayList<Category> categoriesList) {
        CategoriesList = categoriesList;
    }

    public class Category {
        String _id ;
        String name ;


        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
