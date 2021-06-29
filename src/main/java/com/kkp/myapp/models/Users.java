package com.kkp.myapp.models;

import com.kkp.myapp.enums.UserLevel;
import com.kkp.myapp.helper.AppHelper;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public final class Users extends BaseModel {
    private ObjectId id;
    private String username;
    private String email;
    private String password;
    private UserLevel level;
    private boolean active;
    
    public ObjectId getId()
    {
        return id;
    }
    
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username= username;
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
    public void update() {
        Bson updateData = combine(
                set("username", username),
                set("email", email),
                set("password", password),
                set("is_active", active),
                set("level", level.getLevel())
        );
        
        this.myCollection.updateOne(eq("_id", getId()), updateData);
        this.load();
    }

    @Override
    public void delete() {
        this.myCollection.deleteOne(eq("_id", getId()));
        this.id = null;
    }

    @Override
    public void save() {
        Document saveDocument = new Document();
        saveDocument.append("username", username)
                .append("email", email)
                .append("password", password)
                .append("is_active", active)
                .append("level", level.getLevel());
        
        InsertOneResult result = this.myCollection.insertOne(saveDocument);
        BsonValue insertId = result.getInsertedId();
        
        if (insertId != null && insertId.isObjectId()) {
            var val = insertId.asObjectId().getValue();
            
            this.id = val;
            this.load();
        }
    }

    @Override
    public void load() {
        var query = this.myCollection.find(eq("_id", this.getId())).limit(1);
        try (MongoCursor<Document> findResult = query.iterator()) {
            if (findResult.hasNext()) {
                Document result = findResult.next();
                
                this.username = result.getString("username");
                this.email = result.getString("email");
                this.password = result.getString("password");
                this.active = result.getBoolean("is_active");
                String userLevel = result.getString("level");
                
                this.level = UserLevel.valueOf(userLevel);
            }
        }
    }
}
