package com.example.articlesproject.Model;

import java.util.ArrayList;
import java.util.List;

public class AuthModel {

    String message ;
    SecretInfo SecretInfo ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SecretInfo getSecretInfo() {
        return SecretInfo;
    }

    public void setSecretInfo(SecretInfo secretInfo) {
        this.SecretInfo = secretInfo;
    }

    public class  SecretInfo {
        String UserId;
        String FirstName;
        String LastName;
        String Email;
        String Phone;
        String Token ;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public String getToken() {
            return Token;
        }

        public void setToken(String token) {
            Token = token;
        }
    }


}