package com.kkp.myapp.views.form;

import com.kkp.myapp.enums.KandidatStatus;
import com.kkp.myapp.models.Kandidat;
import com.kkp.myapp.models.Penilaian;
import com.kkp.myapp.views.modals.ModalSearchPenilaian;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FormPenerimaanKandidat extends javax.swing.JFrame {

    public FormPenerimaanKandidat() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNamaPenilai = new javax.swing.JTextField();
        txtKTP = new javax.swing.JTextField();
        txtNamaKandidat = new javax.swing.JTextField();
        txtPosisi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNilaiPengalamanKerja = new javax.swing.JSpinner();
        txtNilaiGestur = new javax.swing.JSpinner();
        txtNilaiTanyaJawab = new javax.swing.JSpinner();
        txtNilaiAntusiasme = new javax.swing.JSpinner();
        txtNilaiKeterampilan = new javax.swing.JSpinner();
        txtNilaiRolePlay = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();
        btnTerima = new javax.swing.JButton();
        btnTolak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Penerimaan Kandidat");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel1.setText("Form Penerimaan Kandidat");
        jLabel1.setToolTipText("");

        txtID.setEditable(false);

        txtNamaPenilai.setEditable(false);

        txtKTP.setEditable(false);

        txtNamaKandidat.setEditable(false);

        txtPosisi.setEditable(false);

        jLabel2.setText("Kode Interview");

        jLabel3.setText("Nama Penilai");

        jLabel4.setText("No KTP");

        jLabel5.setText("Nama Kandidat");

        jLabel6.setText("Posisi yang dilamar");

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/search_file.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel7.setText("Hasil Penilaian");
        jLabel7.setToolTipText("");

        jLabel8.setText("Pengalaman Kerja");

        txtNilaiPengalamanKerja.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiPengalamanKerja.setEnabled(false);

        txtNilaiGestur.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiGestur.setEnabled(false);

        txtNilaiTanyaJawab.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiTanyaJawab.setEnabled(false);

        txtNilaiAntusiasme.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiAntusiasme.setEnabled(false);

        txtNilaiKeterampilan.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiKeterampilan.setEnabled(false);

        txtNilaiRolePlay.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtNilaiRolePlay.setEnabled(false);

        jLabel9.setText("Gestur");

        jLabel10.setText("Tanya Jawab");

        jLabel11.setText("Role Play");

        jLabel12.setText("Keterampilan");

        jLabel13.setText("Antusiasme");

        jLabel14.setText("Catatan Penilaian");

        txtNotes.setEditable(false);
        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane1.setViewportView(txtNotes);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cancel.png"))); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnTerima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/store_file.png"))); // NOI18N
        btnTerima.setText("Terima");
        btnTerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaActionPerformed(evt);
            }
        });

        btnTolak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/store_file.png"))); // NOI18N
        btnTolak.setText("Tolak");
        btnTolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTolakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNilaiTanyaJawab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNilaiGestur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNilaiPengalamanKerja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtNilaiRolePlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
                            .addComponent(txtNilaiKeterampilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNilaiAntusiasme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNamaKandidat)
                                            .addComponent(txtNamaPenilai)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtKTP)
                                            .addComponent(txtPosisi)))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 64, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTolak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPenilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNilaiPengalamanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(txtNilaiRolePlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNilaiGestur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNilaiKeterampilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNilaiTanyaJawab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNilaiAntusiasme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnTerima)
                    .addComponent(btnTolak))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        showSearchPenilaian();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        closeForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnTolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTolakActionPerformed
        confirmTolak();
    }//GEN-LAST:event_btnTolakActionPerformed

    private void btnTerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaActionPerformed
        confirmTerima();
    }//GEN-LAST:event_btnTerimaActionPerformed

    Kandidat kandidat;
    Penilaian nilai;

    private void closeForm() {
        this.setVisible(false);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void massageSuccessAndClose() {
        JOptionPane.showMessageDialog(this,
                "Berhasil mengubah data",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);

        closeForm();
    }

    private void showSearchPenilaian() {
        ModalSearchPenilaian frm = new ModalSearchPenilaian();
        frm.setVisible(true);

        if (frm.isSelected()) {
            var doc = frm.getDocument();

            setSelectedDocument(doc);
        }
    }

    private void confirmTerima() {
        var confirm = JOptionPane.showConfirmDialog(this,
                "Anda yakin ingin menerima kandidat ini?",
                "Tutup Aplikasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // 0 - Yes
        if (confirm == 0) {
            terimaKandidat();
        }
    }

    private void confirmTolak() {
        var confirm = JOptionPane.showConfirmDialog(this,
                "Anda yakin ingin menolak kandidat ini?",
                "Tutup Aplikasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // 0 - Yes
        if (confirm == 0) {
            tolakKandidat();
        }
    }

    private void terimaKandidat() {
        try {
            nilai.setStatus(KandidatStatus.DITERIMA);
            nilai.update();
            
            kandidat.setStatus(KandidatStatus.DITERIMA);
            kandidat.update();

            massageSuccessAndClose();
        } catch (Exception ex) {

        }
    }

    private void tolakKandidat() {
        try {
            nilai.setStatus(KandidatStatus.DITOLAK);
            nilai.update();
            
            kandidat.setStatus(KandidatStatus.DITOLAK);
            kandidat.update();

            massageSuccessAndClose();
        } catch (Exception ex) {

        }
    }

    private Kandidat loadKandidat(ObjectId kandidatId) {
        Kandidat _kandidat = new Kandidat();
        _kandidat.setId(kandidatId);
        _kandidat.load();

        return _kandidat;
    }

    private void setSelectedDocument(Document doc) {
        nilai = new Penilaian();
        nilai.setId(doc.getObjectId("_id"));
        nilai.load();
        
        kandidat = loadKandidat(nilai.getKandidatId());
        
        Document request = doc.get("request_info", new Document());

        txtID.setText(nilai.getId().toHexString());
        txtNamaPenilai.setText(nilai.getPenilai());
        txtNamaKandidat.setText(kandidat.getNama());
        txtKTP.setText(kandidat.getKtp());
        txtPosisi.setText(request.getString("posisi"));
        txtNotes.setText(nilai.getNotes());
        txtNilaiAntusiasme.setValue(nilai.getNilaiAntusiasme());
        txtNilaiGestur.setValue(nilai.getNilaiGestur());
        txtNilaiKeterampilan.setValue(nilai.getNilaiKeterampilan());
        txtNilaiPengalamanKerja.setValue(nilai.getNilaiPengalaman());
        txtNilaiRolePlay.setValue(nilai.getNilaiRolePlay());
        txtNilaiTanyaJawab.setValue(nilai.getNilaiTanyaJawab());
    }

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
            java.util.logging.Logger.getLogger(FormPenerimaanKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanKandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenerimaanKandidat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnTerima;
    private javax.swing.JButton btnTolak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKTP;
    private javax.swing.JTextField txtNamaKandidat;
    private javax.swing.JTextField txtNamaPenilai;
    private javax.swing.JSpinner txtNilaiAntusiasme;
    private javax.swing.JSpinner txtNilaiGestur;
    private javax.swing.JSpinner txtNilaiKeterampilan;
    private javax.swing.JSpinner txtNilaiPengalamanKerja;
    private javax.swing.JSpinner txtNilaiRolePlay;
    private javax.swing.JSpinner txtNilaiTanyaJawab;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtPosisi;
    // End of variables declaration//GEN-END:variables
}
