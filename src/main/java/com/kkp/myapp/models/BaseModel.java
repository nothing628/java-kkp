/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author titan
 */
public abstract class BaseModel {

    protected ObjectId id;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public MongoCollection<Document> myCollection;

    public void update() {
        Bson updateDocument = toUpdateComposite();

        this.myCollection.updateOne(eq("_id", getId()), updateDocument);
        this.load();
    }

    private Bson toUpdateComposite() {
        var listUpdate = new ArrayList<Bson>();
        var document = toDocument();
        var keyIterator = document.keySet().iterator();

        while (keyIterator.hasNext()) {
            var key = keyIterator.next();
            var val = document.get(key);
            
            listUpdate.add(set(key, val));
        }

        return combine(listUpdate);
    }

    public void delete() {
        this.myCollection.deleteOne(eq("_id", getId()));
        this.id = null;
    }

    public void save() {
        Document saveDocument = toDocument();

        InsertOneResult result = this.myCollection.insertOne(saveDocument);
        BsonValue insertId = result.getInsertedId();

        if (insertId != null && insertId.isObjectId()) {
            var val = insertId.asObjectId().getValue();

            this.id = val;
            this.load();
        }
    }

    public void load() {
        var query = this.myCollection.find(eq("_id", this.getId())).limit(1);
        try (MongoCursor<Document> findResult = query.iterator()) {
            if (findResult.hasNext()) {
                Document result = findResult.next();

                fromDocument(result);
            }
        }
    }

    protected abstract void fromDocument(Document document);

    protected abstract Document toDocument();
}
