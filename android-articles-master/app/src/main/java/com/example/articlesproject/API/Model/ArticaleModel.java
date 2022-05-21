package com.example.articlesproject.API.Model;

import java.util.ArrayList;

public class ArticaleModel {
    String message;
    ArrayList<Article> ArticalesList ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Article> getArticalesList() {
        return ArticalesList;
    }

    public void setArticalesList(ArrayList<Article> articalesList) {
        ArticalesList = articalesList;
    }

    public class Article {
        String _id ;
        String title ;
        String description ;
        Category categorie ;
        Integer nb_starts;
        String url_img;
        User user ;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Category getCategorie() {
            return categorie;
        }

        public void setCategorie(Category categorie) {
            this.categorie = categorie;
        }

        public Integer getNb_starts() {
            return nb_starts;
        }

        public void setNb_starts(Integer nb_starts) {
            this.nb_starts = nb_starts;
        }

        public String getUrl_img() {
            return url_img;
        }

        public void setUrl_img(String url_img) {
            this.url_img = url_img;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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

        public class User {
            String _id ;
            String firstName ;
            String lastName ;
            String phone ;
            String email ;
            String password ;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }
    }
}
