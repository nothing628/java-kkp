package com.kkp.myapp.views.controls;

import com.kkp.myapp.enums.KandidatStatus;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.models.Kandidat;
import com.kkp.myapp.views.events.DataActionType;
import com.kkp.myapp.views.events.DataEventListener;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FormKandidat extends javax.swing.JPanel {

    private Document current;
    private MongoCollection<Document> myCollection;
    private final List<DataEventListener> listeners = new ArrayList<>();
    
    public FormKandidat() {
        initComponents();
        
        myCollection = null;
    }
    
    public void Init() {
        myCollection = DBConnector.kandidatCollection;
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
    
    private void updateDocument() {
        ObjectId current_id = current.getObjectId("_id");
        
        Kandidat new_doc = new Kandidat();
        new_doc.setId(current_id);
        
        new_doc.setKtp(txtKTP.getText());
        new_doc.setNama(txtFullname.getText());
        new_doc.setTempatLahir(txtTempatLahir.getText());
        new_doc.setTanggalLahir(txtDOB.getDate());
        new_doc.setNoTelepon(txtPhoneNumber.getText());
        new_doc.setEmail(txtEmail.getText());
        new_doc.setAlamat(txtAddress.getText());
        new_doc.setTempatPendidikan(txtSchoolName.getText());
        new_doc.setJurusanPendidikan(txtEducationMajor.getText());
        new_doc.setTempatPengalaman(txtLatestCompanyName.getText());
        new_doc.setPosisiPengalaman(txtLatestPosition.getText());
        
        new_doc.setLamaPengalaman((int)txtLamaPengalaman.getValue());
        new_doc.setTingkatPendidikan(cmbEducational.getItemAt(cmbEducational.getSelectedIndex()));
        new_doc.setStatusNikah(cmbMariaggeStatus.getItemAt(cmbMariaggeStatus.getSelectedIndex()));
        new_doc.setAgama(cmbReligion.getItemAt(cmbReligion.getSelectedIndex()));
        new_doc.setStatus(KandidatStatus.MENUNGGU.getStatus());
        
        new_doc.update();
    }
    
    private void saveDocument() {
        Kandidat new_doc = new Kandidat();
        
        new_doc.setKtp(txtKTP.getText());
        new_doc.setNama(txtFullname.getText());
        new_doc.setTempatLahir(txtTempatLahir.getText());
        new_doc.setTanggalLahir(txtDOB.getDate());
        new_doc.setNoTelepon(txtPhoneNumber.getText());
        new_doc.setEmail(txtEmail.getText());
        new_doc.setAlamat(txtAddress.getText());
        new_doc.setTempatPendidikan(txtSchoolName.getText());
        new_doc.setJurusanPendidikan(txtEducationMajor.getText());
        new_doc.setTempatPengalaman(txtLatestCompanyName.getText());
        new_doc.setPosisiPengalaman(txtLatestPosition.getText());
        
        new_doc.setLamaPengalaman((int)txtLamaPengalaman.getValue());
        new_doc.setTingkatPendidikan(cmbEducational.getItemAt(cmbEducational.getSelectedIndex()));
        new_doc.setStatusNikah(cmbMariaggeStatus.getItemAt(cmbMariaggeStatus.getSelectedIndex()));
        new_doc.setAgama(cmbReligion.getItemAt(cmbReligion.getSelectedIndex()));
        new_doc.setStatus(KandidatStatus.MENUNGGU.getStatus());
        
        new_doc.save();
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void setCurrentData(Object data) {
        if (data == null) {
            this.clearForm();
            return;
        }

        current = (Document)data;
        var current_kandidat = new Kandidat();
        current_kandidat.setId(current.getObjectId("_id"));
        current_kandidat.load();
        
        txtKTP.setEnabled(false);
        
        txtKTP.setText(current_kandidat.getKtp());
        txtFullname.setText(current_kandidat.getNama());
        txtTempatLahir.setText(current_kandidat.getTempatLahir());
        txtDOB.setDate(current_kandidat.getTanggalLahir());
        txtPhoneNumber.setText(current_kandidat.getNoTelepon());
        txtEmail.setText(current_kandidat.getEmail());
        txtAddress.setText(current_kandidat.getAlamat());
        txtSchoolName.setText(current_kandidat.getNamaPendidikan());
        txtEducationMajor.setText(current_kandidat.getJurursanPendidikan());
        txtLatestCompanyName.setText(current_kandidat.getTempatPengalaman());
        txtLatestPosition.setText(current_kandidat.getPosisiPengalaman());
        
        txtLamaPengalaman.setValue(current_kandidat.getLamaPengalaman());
        cmbEducational.setSelectedItem(current_kandidat.getTingkatPendidikan());
        cmbMariaggeStatus.setSelectedItem(current_kandidat.getStatusNikah());
        cmbReligion.setSelectedItem(current_kandidat.getAgama());
    }
    
    private void clearForm() {
        current = null;
        txtPhoneNumber.setText("");
        txtEmail.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cmbMariaggeStatus = new javax.swing.JComboBox<>();
        cmbEducational = new javax.swing.JComboBox<>();
        cmbReligion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLamaPengalaman = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDOB = new org.jdesktop.swingx.JXDatePicker();
        txtFullname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTempatLahir = new javax.swing.JTextField();
        txtLatestCompanyName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtSchoolName = new javax.swing.JTextField();
        txtLatestPosition = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtEducationMajor = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtKTP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel14.setText("Agama");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/store_file.png"))); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cmbMariaggeStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Kawin", "Kawin", "Duda/Janda" }));

        cmbEducational.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMP", "SMA", "SMK", "S1", "S2", "S3" }));

        cmbReligion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Kristen", "Hindu", "Lainnya" }));

        jLabel2.setText("No KTP");

        jLabel3.setText("Nama Lengkap");

        jLabel4.setText("Tempat Tanggal Lahir");

        jLabel10.setText("Tahun di");

        jLabel5.setText("No Telepon");

        jLabel11.setText("Pengalaman Kerja");

        jLabel6.setText("Email");

        jLabel7.setText("Alamat");

        jLabel8.setText("Pendidikan");

        jLabel9.setText("Jurusan");

        jLabel12.setText("Pengalaman Kerja Sebagai");

        lblTitle.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        lblTitle.setText("Form Input Kandidat");
        lblTitle.setToolTipText("");

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cancel.png"))); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel13.setText("Status Pernikahan");

        jLabel15.setText("di");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEducationMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLamaPengalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLatestCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLatestPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMariaggeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 61, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbEducational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbEducational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEducationMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLamaPengalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtLatestCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLatestPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMariaggeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(41, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbEducational;
    private javax.swing.JComboBox<String> cmbMariaggeStatus;
    private javax.swing.JComboBox<String> cmbReligion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtAddress;
    private org.jdesktop.swingx.JXDatePicker txtDOB;
    private javax.swing.JTextField txtEducationMajor;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtKTP;
    private javax.swing.JSpinner txtLamaPengalaman;
    private javax.swing.JTextField txtLatestCompanyName;
    private javax.swing.JTextField txtLatestPosition;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSchoolName;
    private javax.swing.JTextField txtTempatLahir;
    // End of variables declaration//GEN-END:variables
}
