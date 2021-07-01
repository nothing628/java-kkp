package com.kkp.myapp.models;

import com.kkp.myapp.enums.KandidatStatus;
import com.mongodb.client.result.InsertOneResult;
import java.util.Date;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Penilaian extends BaseModelWithTimestamp {

    private ObjectId kandidat_id;
    private ObjectId request_id;
    private int nilai_pengalaman;
    private int nilai_gestur;
    private int nilai_tanyajawab;
    private int nilai_role_play;
    private int nilai_keterampilan;
    private int nilai_antusiasme;
    private String notes;
    private String penilai;
    private String status;

    public Penilaian() {
        myCollection = DBConnector.penilaianCollection;
    }

    public void setStatus(KandidatStatus status) {
        this.status = status.getStatus();
    }

    public void setKandidatId(ObjectId kandidat_id) {
        this.kandidat_id = kandidat_id;
    }

    public void setRequestId(ObjectId request_id) {
        this.request_id = request_id;
    }

    public void setNilaiPengalaman(int nilai_pengalaman) {
        this.nilai_pengalaman = nilai_pengalaman;
    }

    public void setNilaiGestur(int nilai_gestur) {
        this.nilai_gestur = nilai_gestur;
    }

    public void setNilaiTanyaJawab(int nilai_tanyajawab) {
        this.nilai_tanyajawab = nilai_tanyajawab;
    }

    public void setNilaiRolePlay(int nilai_role_play) {
        this.nilai_role_play = nilai_role_play;
    }

    public void setNilaiKeterampilan(int nilai_keterampilan) {
        this.nilai_keterampilan = nilai_keterampilan;
    }

    public void setNilaiAntusiasme(int nilai_antusiasme) {
        this.nilai_antusiasme = nilai_antusiasme;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPenilai(String penilai) {
        this.penilai = penilai;
    }

    public KandidatStatus getStatus() {
        if (status == null) {
            return KandidatStatus.MENUNGGU;
        }

        return KandidatStatus.valueOf(status);
    }

    public ObjectId getKandidatId() {
        return kandidat_id;
    }

    public ObjectId getRequestId() {
        return request_id;
    }

    public int getNilaiPengalaman() {
        return nilai_pengalaman;
    }

    public int getNilaiGestur() {
        return nilai_gestur;
    }

    public int getNilaiTanyaJawab() {
        return nilai_tanyajawab;
    }

    public int getNilaiRolePlay() {
        return nilai_role_play;
    }

    public int getNilaiKeterampilan() {
        return nilai_keterampilan;
    }

    public int getNilaiAntusiasme() {
        return nilai_antusiasme;
    }

    public String getNotes() {
        return notes;
    }

    public String getPenilai() {
        return penilai;
    }

    private Document getRequestDocument() {
        RequestManpower manPower = new RequestManpower();

        manPower.setId(request_id);
        manPower.load();

        return manPower.toDocument();
    }

    @Override
    public void save() {
        Document saveDocument = toDocument();
        Document requestDocument = getRequestDocument();

        saveDocument.replace("status", KandidatStatus.MENUNGGU.getStatus());
        saveDocument.append("createdAt", new Date());
        saveDocument.append("updatedAt", new Date());
        saveDocument.append("request_info", requestDocument);

        InsertOneResult result = this.myCollection.insertOne(saveDocument);
        BsonValue insertId = result.getInsertedId();

        if (insertId != null && insertId.isObjectId()) {
            var val = insertId.asObjectId().getValue();

            this.id = val;
            this.load();
        }
    }

    @Override
    protected void fromDocument(Document document) {
        notes = document.getString("notes");
        penilai = document.getString("penilai");
        status = document.getString("status");
        nilai_antusiasme = document.getInteger("nilai_antusiasme");
        nilai_keterampilan = document.getInteger("nilai_keterampilan");
        nilai_role_play = document.getInteger("nilai_roleplay");
        nilai_tanyajawab = document.getInteger("nilai_tanyajawab");
        nilai_gestur = document.getInteger("nilai_gestur");
        nilai_pengalaman = document.getInteger("nilai_pengalaman");
        request_id = document.getObjectId("request_id");
        kandidat_id = document.getObjectId("kandidat_id");
    }

    @Override
    protected Document toDocument() {
        Document new_doc = new Document();

        new_doc.append("notes", notes)
                .append("status", status)
                .append("penilai", penilai)
                .append("nilai_antusiasme", nilai_antusiasme)
                .append("nilai_keterampilan", nilai_keterampilan)
                .append("nilai_roleplay", nilai_role_play)
                .append("nilai_tanyajawab", nilai_tanyajawab)
                .append("nilai_gestur", nilai_gestur)
                .append("nilai_pengalaman", nilai_pengalaman)
                .append("request_id", request_id)
                .append("kandidat_id", kandidat_id);

        return new_doc;
    }

}
