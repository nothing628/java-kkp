package com.kkp.myapp;

import com.kkp.myapp.helper.AuthHelper;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.Login;
import com.kkp.myapp.views.MainMenu;
import com.kkp.myapp.views.form.FormPengaturan;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
            java.awt.EventQueue.invokeLater(() -> {
                new MainMenu().setVisible(true);
            });
        }
    }
}
