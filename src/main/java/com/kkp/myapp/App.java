package com.kkp.myapp;

import com.kkp.myapp.helper.AuthHelper;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.Login;
import com.kkp.myapp.views.MainMenu;
import com.kkp.myapp.views.form.FormPengaturan;
import java.awt.Dialog;

public class App {
    public static void main(String[] args) {
        boolean isInstalled = Configuration.current.isInstalled();
        
        if (!isInstalled) {
            FormPengaturan form = new FormPengaturan();
            form.setVisible(true);
            
            return;
        }

        DBConnector.openConnection();
        
        System.out.println("Mulai aplikasi");
        
        Login formLogin = new Login();
        formLogin.setVisible(true);
        
        if (AuthHelper.isLoggedIn()) {
            // Show Main Menu
            MainMenu formMainMenu = new MainMenu();
            formMainMenu.setVisible(true);
        }
        
        DBConnector.closeConnection();
    }
}
