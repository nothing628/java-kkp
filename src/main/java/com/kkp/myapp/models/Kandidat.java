package com.kkp.myapp.models;

import com.kkp.myapp.enums.KandidatStatus;
import java.util.Date;
import org.bson.Document;

public class Kandidat extends BaseModel {

    private String ktp;
    private String nama;
    private String tempat_lahir;
    private Date tgl_lahir;
    private String no_telepon;
    private String email;
    private String alamat;
    private String tingkat_pendidikan;
    private String nama_pendidikan;
    private String jurusan_pendidikan;
    private int lama_pengalaman;
    private String tempat_pengalaman;
    private String posisi_pengalaman;
    private String status_kandidat;
    private String status_nikah;
    private String agama;
    
    public String getKtp() {
        return ktp;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNoTelepon() {
        return no_telepon;
    }
    
    public String getTempatLahir() {
        return tempat_lahir;
    }
    
    public Date getTanggalLahir() {
        return tgl_lahir;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public String getTingkatPendidikan() {
        return tingkat_pendidikan;
    }
    
    public String getNamaPendidikan() {
        return nama_pendidikan;
    }
    
    public String getJurursanPendidikan() {
        return jurusan_pendidikan;
    }
    
    public int getLamaPengalaman() {
        return lama_pengalaman;
    }
    
    public String getTempatPengalaman() {
        return tempat_pengalaman;
    }
    
    public String getPosisiPengalaman() {
        return posisi_pengalaman;
    }
    
    public String getStatus() {
        return status_kandidat;
    }
    
    public String getStatusNikah() {
        return status_nikah;
    }
    
    public String getAgama() {
        return agama;
    }
    
    public void setKtp(String ktp) {
        this.ktp = ktp;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNoTelepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    
    public void setTempatLahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }
    
    public void setTanggalLahir(Date tanggal_lahir) {
        this.tgl_lahir = tanggal_lahir;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setTingkatPendidikan(String tingkat_pendidikan) {
        this.tingkat_pendidikan = tingkat_pendidikan;
    }
    
    public void setTempatPendidikan(String nama_pendidikan) {
        this.nama_pendidikan = nama_pendidikan;
    }
    
    public void setJurusanPendidikan(String jurusan_pendidikan) {
        this.jurusan_pendidikan = jurusan_pendidikan;
    }
    
    public void setLamaPengalaman(int lama_pengalaman) {
        this.lama_pengalaman = lama_pengalaman;
    }
    
    public void setTempatPengalaman(String tempat_pengalaman) {
        this.tempat_pengalaman = tempat_pengalaman;
    }
    
    public void setPosisiPengalaman(String posisi_pengalaman) {
        this.posisi_pengalaman = posisi_pengalaman;
    }
    
    public void setStatus(KandidatStatus status_kandidat) {
        this.status_kandidat = status_kandidat.getStatus();
    }
    
    public void setStatusNikah(String status_nikah) {
        this.status_nikah = status_nikah;
    }
    
    public void setAgama(String agama) {
        this.agama = agama;
    }

    public Kandidat() {
        this.myCollection = DBConnector.kandidatCollection;
    }

    @Override
    protected void fromDocument(Document document) {
        var pendidikan = document.get("pendidikan", new Document());
        var pengalaman = document.get("pengalaman", new Document());

        nama_pendidikan = pendidikan.getString("sekolah");
        jurusan_pendidikan = pendidikan.getString("jurusan");
        tingkat_pendidikan = pendidikan.getString("tingkat");
        
        lama_pengalaman = pengalaman.getInteger("lama");
        tempat_pengalaman = pengalaman.getString("tempat");
        posisi_pengalaman = pengalaman.getString("posisi");
        
        this.ktp = document.getString("ktp");
        this.nama = document.getString("nama");
        this.tempat_lahir = document.getString("tempat_lahir");
        this.tgl_lahir = document.getDate("tgl_lahir");
        this.no_telepon = document.getString("no_telepon");
        this.email = document.getString("email");
        this.alamat = document.getString("alamat");
        this.status_kandidat = document.getString("status");
        this.status_nikah = document.getString("status_nikah");
        this.agama = document.getString("agama");
    }

    @Override
    protected Document toDocument() {
        Document myDocument = new Document();
        Document pendidikan = new Document()
                .append("sekolah", nama_pendidikan)
                .append("jurusan", jurusan_pendidikan)
                .append("tingkat", tingkat_pendidikan);
        Document pengalaman = new Document()
                .append("lama", lama_pengalaman)
                .append("tempat", tempat_pengalaman)
                .append("posisi",posisi_pengalaman);
        myDocument
                .append("ktp", ktp)
                .append("email", email)
                .append("no_telepon", no_telepon)
                .append("nama", nama)
                .append("tempat_lahir", tempat_lahir)
                .append("tgl_lahir", tgl_lahir)
                .append("alamat", alamat)
                .append("status", status_kandidat)
                .append("status_nikah", status_nikah)
                .append("agama", agama)
                .append("pendidikan", pendidikan)
                .append("pengalaman", pengalaman);
        
        return myDocument;
    }

}
