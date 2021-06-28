package com.kkp.myapp.models;

import com.kkp.myapp.enums.UserLevel;
import com.kkp.myapp.helper.AppHelper;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
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

    public Users() {
        this.myCollection = DBConnector.userCollection;
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

    @Override
    public void load() {
        try (MongoCursor<Document> findResult = this.myCollection.find(eq("_id", this.getId())).limit(1).iterator()) {
            if (findResult.hasNext()) {
                Document result = findResult.next();
                
                this.username = result.getString("username");
            }
        }
    }
}
