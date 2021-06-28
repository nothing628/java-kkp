package com.kkp.myapp.models;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public final class RejectReason extends BaseModel {
    protected Document _original;
    protected String _id;
    public String code;
    public String title;
    public String description;

    public RejectReason() {
        this.myCollection = DBConnector.rejectCollection;
    }

    public ObjectId getKey() {
        return new ObjectId(this._id);
    }
    
    @Override
    public void load() {
        try (MongoCursor<Document> findResult = this.myCollection.find(eq("_id", this.getKey())).limit(1).iterator()) {
            if (findResult.hasNext()) {
                Document result = findResult.next();
                
                this._original = result;
                this.code = result.getString("code");
                this.title = result.getString("title");
                this.description = result.getString("description");
            }
        }
    }

    @Override
    public void update() {
        Bson updateData = combine(set("title", this.title), set("description", this.description));

        this.myCollection.updateOne(eq("_id", this.getKey()), updateData);
        this.load();
    }

    @Override
    public void delete() {
        this.myCollection.deleteOne(eq("_id", this.getKey()));
        this._id = "";
        this._original = null;
    }

    @Override
    public void save() {
        Document saveDocument = new Document();
        saveDocument.append("code", this.code);
        saveDocument.append("title", this.title);
        saveDocument.append("description", this.description);

        InsertOneResult result = this.myCollection.insertOne(saveDocument);
        BsonValue insertId = result.getInsertedId();
        
        if (insertId != null && insertId.isObjectId()) {
            var val = insertId.asObjectId().getValue();
            this._id = val.toHexString();
            this.load();
        }
    }
}
