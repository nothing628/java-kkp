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

        System.out.println("Mulai aplikasi");
        
        DBConnector.closeConnection();
    }
}
