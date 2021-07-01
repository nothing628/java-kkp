package com.kkp.myapp.views.report;

import com.kkp.myapp.helper.ExcelFileFilter;
import com.kkp.myapp.helper.ReportHelper;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.models.Penilaian;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.text;
import com.mongodb.client.model.TextSearchOptions;
import com.mongodb.client.model.UnwindOptions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ReportInterview extends javax.swing.JFrame {

    TableModel t_model;

    public ReportInterview() {
        initComponents();
        createTableModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileDialog = new javax.swing.JFileChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEndAt = new org.jdesktop.swingx.JXDatePicker();
        txtStartAt = new org.jdesktop.swingx.JXDatePicker();
        btnCari = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        fileDialog.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileDialog.setFileFilter(getFileFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laporan Penilaian Kandidat");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel4.setText("Laporan Penilaian Kandidat");

        jLabel1.setText("Tanggal Mulai Interview");

        jLabel2.setText("Tanggal Selesai Interview");

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/search_file.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/download_file.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtStartAt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                                .addComponent(txtEndAt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                        .addGap(0, 193, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStartAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnExport))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        refreshData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        exportReport();
    }//GEN-LAST:event_btnExportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshData();
    }//GEN-LAST:event_formWindowOpened

    private void createTableModel() {
        DefaultTableModel new_model = new DefaultTableModel();
        new_model.addColumn("KTP");
        new_model.addColumn("Nama Kandidat");
        new_model.addColumn("No Telepon");
        new_model.addColumn("Email");
        new_model.addColumn("Posisi");
        new_model.addColumn("Penilai");
        new_model.addColumn("Nilai Antusiasme");
        new_model.addColumn("Nilai Gestur");
        new_model.addColumn("Nilai Keterampilan");
        new_model.addColumn("Nilai Pengalaman Kerja");
        new_model.addColumn("Nilai Role Play");
        new_model.addColumn("Nilai Tanya Jawab");
        new_model.addColumn("Catatan");
        new_model.addColumn("Status");

        this.t_model = new_model;
        this.tblData.setModel(new_model);
    }

    private ArrayList<Object[]> getData() {
        var filter = new ArrayList<Bson>();

        filter.add(lookup("kandidat", "kandidat_id", "_id", "kandidat"));
//        filter.add(lookup("request_manpower", "request_id", "_id", "request"));
        filter.add(unwind("$kandidat", new UnwindOptions().preserveNullAndEmptyArrays(true)));
//        filter.add(unwind("$request", new UnwindOptions().preserveNullAndEmptyArrays(true)));

        var iterator = DBConnector.penilaianCollection.aggregate(filter).iterator();
        ArrayList<Object[]> result = new ArrayList();

        while (iterator.hasNext()) {
            Document doc = iterator.next();
            Penilaian nilai = new Penilaian();
            nilai.setId(doc.getObjectId("_id"));
            nilai.load();

            Document kandidat = doc.get("kandidat", new Document());
            Document request_info = doc.get("request_info", new Document());
            ArrayList row = new ArrayList();

            row.add(kandidat.getString("ktp"));
            row.add(kandidat.getString("nama"));
            row.add(kandidat.getString("no_telepon"));
            row.add(kandidat.getString("email"));
            row.add(request_info.getString("posisi"));
            row.add(nilai.getPenilai());
            row.add(nilai.getNilaiAntusiasme());
            row.add(nilai.getNilaiGestur());
            row.add(nilai.getNilaiKeterampilan());
            row.add(nilai.getNilaiPengalaman());
            row.add(nilai.getNilaiRolePlay());
            row.add(nilai.getNilaiTanyaJawab());
            row.add(nilai.getNotes());
            row.add(nilai.getStatus().getStatus());

            result.add(row.toArray());
        }

        return result;
    }

    private void refreshData() {
        clearTable();

        DefaultTableModel t_m = (DefaultTableModel) this.t_model;
        var data = getData();

        data.forEach((Object[] row) -> {
            t_m.addRow(row);
        });
    }

    private void exportReport() {
        File target = openAndGetFilename();
        ReportHelper helper = new ReportHelper();

        helper.setHeader(new String[]{
            "KTP",
            "Nama Kandidat",
            "No Telepon",
            "Email",
            "Posisi",
            "Penilai",
            "Nilai Antusiasme",
            "Nilai Gestur",
            "Nilai Keterampilan",
            "Nilai Pengalaman Kerja",
            "Nilai Role Play",
            "Nilai Tanya Jawab",
            "Catatan",
            "Status",}
        );

        fillReportContent(helper);

        try {
            helper.save(target);
            
            showInfoMessage("Berhasil mengexport file, file berlokasi di " + target.getAbsolutePath());
        } catch (IOException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    private void fillReportContent(ReportHelper report) {
        int row_count = t_model.getRowCount();

        for (int i = 0; i < row_count; i++) {
            ArrayList<Object> row = new ArrayList<>();

            for (int j = 0; j < 14; j++) {
                row.add(t_model.getValueAt(i, j));
            }

            report.addRow(row);
        }
    }

    private File openAndGetFilename() {
        fileDialog.showSaveDialog(this);

        File file = fileDialog.getSelectedFile();

        return file;
    }

    private FileFilter getFileFilter() {
        FileFilter filter = new ExcelFileFilter();

        return filter;
    }

    private void clearTable() {
        DefaultTableModel t_m = (DefaultTableModel) this.t_model;
        t_m.setNumRows(0);
    }
    
    private void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Ooops, ada kesalahan", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Ooops, ada kesalahan", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(ReportInterview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportInterview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportInterview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportInterview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportInterview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnExport;
    private javax.swing.JFileChooser fileDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private org.jdesktop.swingx.JXDatePicker txtEndAt;
    private org.jdesktop.swingx.JXDatePicker txtStartAt;
    // End of variables declaration//GEN-END:variables
}
