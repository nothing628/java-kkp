package com.kkp.myapp;

import com.kkp.myapp.models.DBConnector;

public class App {
    public static void main(String[] args) {
        System.out.println("Test");
        
        DBConnector.closeConnection();
    }
}
