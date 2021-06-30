package com.kkp.myapp.views.modals;

import com.kkp.myapp.models.DBConnector;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.text;
import com.mongodb.client.model.TextSearchOptions;
import com.mongodb.client.model.UnwindOptions;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ModalSearchPenilaian extends javax.swing.JDialog {

    TableModel t_model;

    private Document penilaian;
    private MongoCollection<Document> myCollection;

    public boolean isSelected() {
        return penilaian != null;
    }

    public Document getDocument() {
        return penilaian;
    }

    public ModalSearchPenilaian() {
        initComponents();
        createTableModel();

        myCollection = null;
    }

    private void Init() {
        myCollection = DBConnector.kandidatCollection;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnPilih = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari Hasil Penilaian");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblData);

        jLabel5.setText("Kata Kunci");

        jLabel4.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel4.setText("Daftar Kandidat");

        txtKeyword.setToolTipText("");

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/search_file.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.setToolTipText("");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/upload_file.png"))); // NOI18N
        btnPilih.setText("Pilih");
        btnPilih.setToolTipText("");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 688, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnPilih)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        RefreshTable();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        var doc = getSelected();

        if (doc != null) {
            storeDocumentAndClose(doc);
        }
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        closeForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Init();

        RefreshTable();
    }//GEN-LAST:event_formWindowOpened

    private void storeDocumentAndClose(Object data) {
        Document doc = (Document) data;

        penilaian = doc;
        closeForm();
    }

    private void closeForm() {
        this.setVisible(false);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private Document getSelectedDocument(String kode) {
        try {
            Document queryResult = DBConnector.penilaianCollection.find(eq("_id", new ObjectId(kode))).first();

            return queryResult;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Ooops, ada kesalahan",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }

    private Document getSelected() {
        int row_idx = tblData.getSelectedRow();
        boolean is_selected = row_idx > -1;

        if (is_selected) {
            String kode = (String) t_model.getValueAt(row_idx, 0);
            var document = this.getSelectedDocument(kode);
            var is_empty = document == null;

            if (is_empty) {
                return null;
            }

            return document;
        }

        return null;
    }

    private void createTableModel() {
        DefaultTableModel new_model = new DefaultTableModel();
        new_model.addColumn("KTP");
        new_model.addColumn("Nama Lengkap");
        new_model.addColumn("Telp");
        new_model.addColumn("Email");
        new_model.addColumn("Posisi Lamaran");
        new_model.addColumn("Nama Penilai");
        new_model.addColumn("Status");

        this.t_model = new_model;
        this.tblData.setModel(new_model);
    }

    private ArrayList<Object[]> getData() {
        String keyword = txtKeyword.getText();

        var is_keyword_empty = keyword.length() == 0;
        var filter = new ArrayList<Bson>();

        if (!is_keyword_empty) {
            filter.add(match(text(keyword, new TextSearchOptions().caseSensitive(false))));
        }

        filter.add(lookup("penilaian", "_id", "kandidat_id", "penilaian"));
        filter.add(unwind("$penilaian", new UnwindOptions().preserveNullAndEmptyArrays(false)));

        var iterator = myCollection.aggregate(filter).iterator();
        ArrayList<Object[]> result = new ArrayList();

        while (iterator.hasNext()) {
            Document doc = iterator.next();
            Document _penilaian = doc.get("penilaian", new Document());
            Document request_info = _penilaian.get("request_info", new Document());
            ArrayList row = new ArrayList();

            row.add(_penilaian.getObjectId("_id").toHexString());
            row.add(doc.getString("nama"));
            row.add(doc.getString("no_telepon"));
            row.add(doc.getString("email"));
            row.add(request_info.getString("posisi"));
            row.add(_penilaian.getString("penilai"));
            row.add(doc.getString("status"));

            result.add(row.toArray());
        }

        return result;
    }

    public void RefreshTable() {
        ClearTable();

        DefaultTableModel t_m = (DefaultTableModel) this.t_model;
        var data = getData();

        data.forEach((Object[] row) -> {
            t_m.addRow(row);
        });
    }

    private void ClearTable() {
        DefaultTableModel t_m = (DefaultTableModel) this.t_model;
        t_m.setNumRows(0);
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
            java.util.logging.Logger.getLogger(ModalSearchPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalSearchPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalSearchPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalSearchPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModalSearchPenilaian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
