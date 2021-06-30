package com.kkp.myapp.models;

import org.bson.Document;

public class Klien extends BaseModel {

    private String kode;
    private String nama_perusahaan;
    private String no_telepon;
    private String email;
    private String alamat;
    private boolean is_active;

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
    protected void fromDocument(Document document) {
        this.kode = document.getString("kode");
        this.email = document.getString("email");
        this.nama_perusahaan = document.getString("nama");
        this.is_active = document.getBoolean("is_active");
        this.alamat = document.getString("alamat");
        this.no_telepon = document.getString("no_telepon");
    }

    @Override
    protected Document toDocument() {
        Document myDocument = new Document();
        myDocument
                .append("kode", kode)
                .append("email", email)
                .append("no_telepon", no_telepon)
                .append("nama", nama_perusahaan)
                .append("is_active", is_active)
                .append("alamat", alamat);

        return myDocument;
    }
}
