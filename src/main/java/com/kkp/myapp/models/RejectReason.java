package com.kkp.myapp.models;

import org.bson.Document;

public final class RejectReason extends BaseModel {

    public String code;
    public String title;
    public String description;

    public RejectReason() {
        this.myCollection = DBConnector.rejectCollection;
    }

    @Override
    protected void fromDocument(Document document) {
        this.code = document.getString("code");
        this.title = document.getString("title");
        this.description = document.getString("description");
    }

    @Override
    protected Document toDocument() {
        Document myDocument = new Document();
        myDocument.append("code", this.code)
                .append("title", this.title)
                .append("description", this.description);

        return myDocument;
    }
}
