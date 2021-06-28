package com.kkp.myapp.models;

import com.kkp.myapp.helper.AppHelper;
import org.bson.types.ObjectId;

public final class Users extends BaseModel {
    private ObjectId id;
    private String username;
    private String email;
    private String password;
    private boolean active;

    public Users() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setPasswordHash(final String password) {
        this.password = AppHelper.hashPassword(password);
    }
    
    public boolean getIsActive() {
        return active;
    }
    
    public void setIsActive(final boolean is_active) {
        this.active = is_active;
    }

    @Override
    protected void refreshSelf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
