package com.kkp.myapp.models;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

public class DBConnector {

    public static MongoCollection<Document> rejectCollection;
    public static MongoCollection<Document> userCollection;
    public static MongoClient client;
    
    static {
        openConnection();
    }

    public static void closeConnection() {
        if (client != null) {
            client.close();
        }
    }

    public static void openConnection() {
        MongoClientSettings settings = MongoClientSettings.builder()
                
                .applyConnectionString(new ConnectionString("mongodb://kkpuser:secret@localhost:27002"))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("kkp");

        DBConnector.client = mongoClient;
        DBConnector.rejectCollection = database.getCollection("reject_reason");
        DBConnector.userCollection = database.getCollection("users");

        DBConnector.checkAndCreateIndex();
    }

    protected static void checkAndCreateIndex() {
        DBConnector.rejectCollection.createIndex(Indexes.ascending("code"), new IndexOptions().unique(true).name("code_1"));
        DBConnector.userCollection.createIndex(Indexes.ascending("email"), new IndexOptions().unique(true).name("email_1"));
    }
}
