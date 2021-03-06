/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.views.controls;

import com.kkp.myapp.enums.UserLevel;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.models.Users;
import com.kkp.myapp.views.events.DataActionType;
import com.kkp.myapp.views.events.DataEventListener;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author titan
 */
public class FormUser extends javax.swing.JPanel {

    /**
     * Creates new form FormUser
     */
    public FormUser() {
        initComponents();

        myCollection = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cmbLevel = new javax.swing.JComboBox<>();
        chkIsActive = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "HRD", "Manager" }));

        chkIsActive.setText("Aktifkan");

        jLabel1.setText("Email");

        jLabel2.setText("Nama Pengguna");

        jLabel3.setText("Password");

        jLabel4.setText("Akses");

        lblTitle.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        lblTitle.setText("Daftar Pengguna");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/store_file.png"))); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cancel.png"))); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(cmbLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(chkIsActive))
                                .addGap(0, 61, Short.MAX_VALUE)))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkIsActive)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (this.isEditMode()) {
            updateDocument();
        } else {
            saveDocument();
        }

        dispatchDataEvent(DataActionType.LIST, null);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispatchDataEvent(DataActionType.CANCEL_CREATE, null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private Document current;
    private MongoCollection<Document> myCollection;
    private final List<DataEventListener> listeners = new ArrayList<>();

    public void Init() {
        myCollection = DBConnector.klienCollection;
    }

    public void addListener(DataEventListener toAdd) {
        listeners.add(toAdd);
    }

    private void dispatchDataEvent(DataActionType action, Object data) {
        for (DataEventListener listener : listeners) {
            listener.actionPerformed(action, data);
        }
    }

    private boolean isEditMode() {
        return current != null;
    }

    private ObjectId id;

    private void saveDocument() {
        Users new_doc = new Users();
        StringBuilder password = new StringBuilder();
        String password_str = password.append(txtPassword.getPassword()).toString();
        String level = cmbLevel.getItemAt(cmbLevel.getSelectedIndex());

        new_doc.setUsername(txtUsername.getText());
        new_doc.setEmail(txtEmail.getText());
        new_doc.setPasswordHash(password_str);
        new_doc.setLevel(UserLevel.valueOf(level));
        new_doc.setIsActive(chkIsActive.isSelected());
        new_doc.save();
    }

    private void updateDocument() {
        Users new_doc = new Users();
        StringBuilder password = new StringBuilder();
        String password_str = password.append(txtPassword.getPassword()).toString();
        String level = cmbLevel.getItemAt(cmbLevel.getSelectedIndex());
        boolean is_password_empty = password_str.isEmpty();

        new_doc.setId(id);
        new_doc.load();
        
        new_doc.setUsername(txtUsername.getText());
        new_doc.setEmail(txtEmail.getText());

        new_doc.setLevel(UserLevel.valueOf(level));
        new_doc.setIsActive(chkIsActive.isSelected());

        if (!is_password_empty) {
            new_doc.setPasswordHash(password_str);
        }

        new_doc.update();
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void setCurrentData(Object data) {
        if (data == null) {
            this.clearForm();
            return;
        }

        current = (Document) data;
        id = current.getObjectId("_id");
        txtEmail.setText(current.getString("email"));
        txtUsername.setText(current.getString("username"));
        txtPassword.setText("");
        cmbLevel.setSelectedItem(current.getString("level"));
        chkIsActive.setSelected(current.getBoolean("is_active"));
    }

    private void clearForm() {
        current = null;

        id = new ObjectId();
        txtEmail.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cmbLevel.setSelectedIndex(0);
        chkIsActive.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkIsActive;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
