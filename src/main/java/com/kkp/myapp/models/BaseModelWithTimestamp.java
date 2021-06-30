package com.kkp.myapp.models;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import java.util.Date;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;

public abstract class BaseModelWithTimestamp extends BaseModel {
    @Override
    public void update() {
        Bson updateDocument = combine(
                toUpdateComposite(),
                set("updatedAt", new Date())
        );
        
        this.myCollection.updateOne(eq("_id", getId()), updateDocument);
        this.load();
    }
    
    @Override
    public void save() {
        Document saveDocument = toDocument();
        
        saveDocument.append("createdAt", new Date());
        saveDocument.append("updatedAt", new Date());

        InsertOneResult result = this.myCollection.insertOne(saveDocument);
        BsonValue insertId = result.getInsertedId();

        if (insertId != null && insertId.isObjectId()) {
            var val = insertId.asObjectId().getValue();

            this.id = val;
            this.load();
        }
    }
}
