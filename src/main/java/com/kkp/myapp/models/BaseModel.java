/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.models;

/**
 *
 * @author titan
 */
public abstract class BaseModel {
    protected abstract void refreshSelf();
    abstract void update();
    abstract void delete();
    abstract void save();
}
