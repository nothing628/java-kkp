package com.kkp.myapp;

import com.kkp.myapp.helper.AuthHelper;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.Login;
import com.kkp.myapp.views.MainMenu;
import com.kkp.myapp.views.form.FormPengaturan;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
            System.out.println(e.getMessage());
        }

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
