package com.kkp.myapp.views.master;

import com.kkp.myapp.models.Users;
import com.kkp.myapp.views.events.DataActionType;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MasterUser extends javax.swing.JFrame {
    public MasterUser() {
        initComponents();
    }
    
    private void InitForm() {
        tabelUser1.Init();
        formUser1.Init();
        tabelUser1.addListener((DataActionType action, Object data) -> {
            this.ProcessData(action, data);
        });
        formUser1.addListener((DataActionType action, Object data) -> {
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
                tabelUser1.RefreshTable();
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
        Document doc = (Document) data;
        ObjectId doc_id = doc.getObjectId("_id");
        Users user = new Users();
        user.setId(doc_id);
        user.delete();
    }
    
    private void showTable() {
        jTabbedPane1.setSelectedIndex(0);
        tabelUser1.RefreshTable();
    }
    
    private void showFormCreate() {
        jTabbedPane1.setSelectedIndex(1);
        formUser1.setTitle("Tambah Pengguna");
        formUser1.setCurrentData(null);
    }
    
    private void showFormEdit(Object current_data) {
        jTabbedPane1.setSelectedIndex(1);
        formUser1.setTitle("Ubah Pengguna");
        formUser1.setCurrentData(current_data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabelUser1 = new com.kkp.myapp.views.controls.TabelUser();
        formUser1 = new com.kkp.myapp.views.controls.FormUser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.addTab("Table", tabelUser1);
        jTabbedPane1.addTab("Form", formUser1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InitForm();
        tabelUser1.RefreshTable();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(MasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.kkp.myapp.views.controls.FormUser formUser1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.kkp.myapp.views.controls.TabelUser tabelUser1;
    // End of variables declaration//GEN-END:variables
}
