package com.kkp.myapp;

import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.form.FormPengaturan;

public class App {
    public static void main(String[] args) {
        boolean isInstalled = Configuration.current.isInstalled();
        
        if (!isInstalled) {
            FormPengaturan form = new FormPengaturan();
            form.setVisible(true);
            
            return;
        }

        String host = Configuration.current.getHost();
        
        System.out.println("Test");
        System.out.println(host);
        
        Configuration.current.setHost("localhost");
        Configuration.current.setPort(27017);
        Configuration.current.setUser("kkp");
        Configuration.current.setPassword("secret");
        Configuration.current.Save();
        
        DBConnector.closeConnection();
    }
}
