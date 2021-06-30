package com.kkp.myapp.models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class RequestManpower extends BaseModelWithTimestamp {
    private ObjectId klien_id;
    private String posisi;
    private String deskripsi;
    private String min_pendidikan;
    private int min_pengalaman;
    private int jml_permintaan;
    private boolean active;
    private String notes;
    
    public RequestManpower() {
        super();
        
        myCollection = DBConnector.requestCollection;
    }
    
    public void setKlienId(ObjectId klien_id) {
        this.klien_id = klien_id;
    }
    
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public void setMinPendidikan(String min_pendidikan) {
        this.min_pendidikan = min_pendidikan;
    }
    
    public void setMinPengalaman(int min_pengalaman) {
        this.min_pengalaman = min_pengalaman;
    }
    
    public void setJmlPermintaan(int jml_permintaan) {
        this.jml_permintaan = jml_permintaan;
    }
    
    public void setIsActive(boolean is_active) {
        this.active = is_active;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public ObjectId getKlienId() {
        return klien_id;
    }
    
    public String getPosisi() {
        return posisi;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public String getMinPendidikan() {
        return min_pendidikan;
    }
    
    public int getMinPengalaman() {
        return min_pengalaman;
    }
    
    public int getJmlPermintaan() {
        return jml_permintaan;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public String getNotes() {
        return notes;
    }
    
    @Override
    protected void fromDocument(Document document) {
        klien_id = document.getObjectId("klien_id");
        posisi = document.getString("posisi");
        deskripsi = document.getString("deskripsi");
        min_pendidikan = document.getString("min_pendidikan");
        min_pengalaman = document.getInteger("min_pengalaman");
        jml_permintaan = document.getInteger("jml_permintaan");
        active = document.getBoolean("is_active");
        notes = document.getString("notes");
    }

    @Override
    protected Document toDocument() {
        Document new_doc = new Document();
        
        new_doc.append("klien_id", klien_id)
                .append("posisi", posisi)
                .append("deskripsi", deskripsi)
                .append("notes", notes)
                .append("is_active", active)
                .append("min_pendidikan", min_pendidikan)
                .append("min_pengalaman", min_pengalaman)
                .append("jml_permintaan", jml_permintaan);
        
        return new_doc;
    }
}
