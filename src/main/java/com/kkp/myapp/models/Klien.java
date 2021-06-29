package com.kkp.myapp.models;

import com.kkp.myapp.enums.UserLevel;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class Klien extends BaseModel {

    private ObjectId id;
    private String kode;
    private String nama_perusahaan;
    private String no_telepon;
    private String email;
    private String alamat;
    private boolean is_active;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNamaPerusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }

    public void setNoTelepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setIsActive(boolean is_active) {
        this.is_active = is_active;
    }

    public ObjectId getId() {
        return id;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaPerusahaan() {
        return nama_perusahaan;
    }

    public String getNoTelepon() {
        return no_telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public boolean isActive() {
        return is_active;
    }

    public Klien() {
        this.myCollection = DBConnector.klienCollection;
    }

    @Override
    public void update() {
        Bson updateData = combine(
                set("kode", kode),
                set("email", email),
                set("nama", nama_perusahaan),
                set("is_active", is_active),
                set("alamat", alamat),
                set("no_telepon", no_telepon)
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
        saveDocument.append("kode", kode)
                .append("email", email)
                .append("no_telepon", no_telepon)
                .append("nama", nama_perusahaan)
                .append("is_active", is_active)
                .append("alamat", alamat);

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

                this.kode = result.getString("kode");
                this.email = result.getString("email");
                this.nama_perusahaan = result.getString("nama");
                this.is_active = result.getBoolean("is_active");
                this.alamat = result.getString("alamat");
                this.no_telepon = result.getString("no_telepon");
            }
        }
    }
}
