/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.models;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author titan
 */
public abstract class BaseModel {

    public MongoCollection<Document> myCollection;

    public abstract void update();

    public abstract void delete();

    public abstract void save();

    public abstract void load();
}
