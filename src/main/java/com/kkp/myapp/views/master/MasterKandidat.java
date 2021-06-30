/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.views.master;

import com.kkp.myapp.models.Klien;
import com.kkp.myapp.views.events.DataActionType;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author titan
 */
public class MasterKandidat extends javax.swing.JFrame {

    /**
     * Creates new form MasterKandidat
     */
    public MasterKandidat() {
        initComponents();
    }
    
    private void InitForm() {
        tblKandidat.Init();
        frmKandidat.Init();
        tblKandidat.addListener((DataActionType action, Object data) -> {
            this.ProcessData(action, data);
        });
        frmKandidat.addListener((DataActionType action, Object data) -> {
            this.ProcessData(action, data);
        });
    }
    
    private void ProcessData(DataActionType action, Object data) {
        switch (action) {
            case CREATE:
                showFormCreate();
                break;
            case UPDATE:
                showFormEdit(data);
                break;
            case DELETE:
                confirmDeleteData(data);
                tblKandidat.RefreshTable();
                break;
            case LIST:
            case CANCEL_CREATE:
            case CANCEL_UPDATE:
                showTable();
                break;
        }
    }
    
    private void confirmDeleteData(Object data) {
        var confirm = JOptionPane.showConfirmDialog(this,
                "Anda yakin ingin menghapus Data?",
                "Hapus data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        // 0 - Yes
        if (confirm == 0) {
            deleteData(data);
        }
    }
    
    private void deleteData(Object data) {
        Document document = (Document) data;
        ObjectId document_id = document.getObjectId("_id");
        Klien newKlien = new Klien();
        newKlien.setId(document_id);
        newKlien.delete();
    }
    
    private void showTable() {
        jTabbedPane1.setSelectedIndex(0);
        tblKandidat.RefreshTable();
    }
    
    private void showFormCreate() {
        jTabbedPane1.setSelectedIndex(1);
        frmKandidat.setTitle("Tambah Klien");
        frmKandidat.setCurrentData(null);
    }
    
    private void showFormEdit(Object current_data) {
        jTabbedPane1.setSelectedIndex(1);
        frmKandidat.setTitle("Edit Klien");
        frmKandidat.setCurrentData(current_data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tblKandidat = new com.kkp.myapp.views.master.TabelKandidat();
        frmKandidat = new com.kkp.myapp.views.master.FormKandidat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Kandidat");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setEnabled(false);
        jTabbedPane1.addTab("Table", tblKandidat);
        jTabbedPane1.addTab("Form", frmKandidat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.InitForm();
        tblKandidat.RefreshTable();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MasterKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterKandidat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.kkp.myapp.views.master.FormKandidat frmKandidat;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.kkp.myapp.views.master.TabelKandidat tblKandidat;
    // End of variables declaration//GEN-END:variables
}
