package com.kkp.myapp.models;

import com.kkp.myapp.enums.UserLevel;
import com.kkp.myapp.helper.AppHelper;
import org.bson.Document;

public final class Users extends BaseModel {
    private String username;
    private String email;
    private String password;
    private UserLevel level;
    private boolean active;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String password) {
        this.password = AppHelper.hashPassword(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(boolean active) {
        this.active = active;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public UserLevel getLevel() {
        return level;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public Users() {
        this.myCollection = DBConnector.userCollection;
    }

    @Override
    protected void fromDocument(Document document) {
        this.username = document.getString("username");
        this.email = document.getString("email");
        this.password = document.getString("password");
        this.active = document.getBoolean("is_active");
        String userLevel = document.getString("level");

        this.level = UserLevel.valueOf(userLevel);
    }

    @Override
    protected Document toDocument() {
        Document myDocument = new Document();
        myDocument.append("username", username)
                .append("email", email)
                .append("password", password)
                .append("is_active", active)
                .append("level", level.getLevel());

        return myDocument;
    }
}
