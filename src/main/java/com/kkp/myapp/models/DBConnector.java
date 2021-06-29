package com.kkp.myapp.models;

import com.kkp.myapp.Configuration;
import com.kkp.myapp.enums.UserLevel;
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
    public static MongoCollection<Document> klienCollection;
    public static MongoCollection<Document> userCollection;
    public static MongoClient client;
    
    // Use this only for development reason
//    static {
//        if (DBConnector.client == null) {
//            openConnection();
//        }
//    }

    public static void closeConnection() {
        if (client != null) {
            client.close();
        }
    }

    public static void openConnection() {
        var config = Configuration.current;
        DBConnectionInfo connInfo = config.toConnectionInfo();
        ConnectionString conn = connInfo.getConnectionString();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(conn)
                .build();

        try {
            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase(connInfo.getDbName());

            DBConnector.client = mongoClient;
            DBConnector.klienCollection = database.getCollection("klien");
            DBConnector.rejectCollection = database.getCollection("reject_reason");
            DBConnector.userCollection = database.getCollection("users");

            DBConnector.checkAndCreateIndex();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void testConnection(DBConnectionInfo connInfo) {
        ConnectionString conn = connInfo.getConnectionString();

        try {
            try (MongoClient mongoClient = MongoClients.create(conn)) {
                var db_names = mongoClient.listDatabaseNames().iterator();
                while (db_names.hasNext()) {
                    String dbname = db_names.next();

                    System.out.println(dbname);
                }

                var database = mongoClient.getDatabase(connInfo.getDbName());
                var coll_names = database.listCollectionNames().iterator();
                while (coll_names.hasNext()) {
                    String col_name = coll_names.next();

                    System.out.println(col_name);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void seedUsers() {
        Users user = new Users();
        
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPasswordHash("12345678");
        user.setIsActive(true);
        user.setLevel(UserLevel.Administrator);
        user.save();
    }
    
    protected static void checkAndCreateIndex() {
        DBConnector.klienCollection.createIndex(Indexes.text("nama"), new IndexOptions().name("nama_1"));
        DBConnector.klienCollection.createIndex(Indexes.ascending("kode"), new IndexOptions().unique(true).name("kode_1"));
        DBConnector.rejectCollection.createIndex(Indexes.ascending("code"), new IndexOptions().unique(true).name("code_1"));
        DBConnector.userCollection.createIndex(Indexes.ascending("email"), new IndexOptions().unique(true).name("email_1"));
    }
}
