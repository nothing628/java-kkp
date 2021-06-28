package com.kkp.myapp;

import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.models.Users;

public class App {

    public static void seedUser() {
        try {
            Users user = new Users();
            user.setEmail("yogyphang@gmail.com");
            user.setPasswordHash("12345678");
            user.setIsActive(true);
            user.setUsername("Yogy P");
            user.save();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public static void main(String[] args) {
        DBConnector.openConnection();

//        seedUser();         // Only for seed one user
        System.out.println("Test");
        
        DBConnector.closeConnection();
    }
}
