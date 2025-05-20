package com.demo.firebaseauth.models;

import com.google.firebase.Timestamp;

public class Journal {
    private String title;
    private  String content;
    private String userId;
    private Timestamp timestamp;

    public Journal() {}

    public Journal(String title, String content, String userId, Timestamp timestamp) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }
}
