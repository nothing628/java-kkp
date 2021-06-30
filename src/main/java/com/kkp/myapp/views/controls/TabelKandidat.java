package com.kkp.myapp.views.controls;

import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.events.DataActionType;
import com.kkp.myapp.views.events.DataEventListener;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.bson.Document;

public class TabelKandidat extends javax.swing.JPanel {

    private MongoCollection<Document> myCollection;
    private final List<DataEventListener> listeners = new ArrayList<>();
    TableModel t_model;
    
    public TabelKandidat() {
        initComponents();
        createTableModel();
        
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
    
    private Document getSelectedDocument(String kode) {
        try {
            Document queryResult = myCollection.find(eq("ktp", kode)).first();

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
    
    private void getSelectedAndDispatch(DataActionType action) {
        int row_idx = tblData.getSelectedRow();
        boolean is_selected = row_idx > -1;

        if (is_selected) {
            String kode = (String) t_model.getValueAt(row_idx, 0);
            var document = this.getSelectedDocument(kode);
            var is_empty = document == null;

            if (is_empty) {
                return;
            }

            dispatchDataEvent(action, document);
        }
    }

    private void createTableModel() {
        DefaultTableModel new_model = new DefaultTableModel();
        new_model.addColumn("KTP");
        new_model.addColumn("Nama Lengkap");
        new_model.addColumn("Telp");
        new_model.addColumn("Email");
        new_model.addColumn("Pendidikan");
        new_model.addColumn("Pengalaman");
        new_model.addColumn("Status");

        this.t_model = new_model;
        this.tblData.setModel(new_model);
    }
    
    private ArrayList<Object[]> getData() {
        String keyword = txtKeyword.getText();
        Date start_date = dtStart.getDate();
        Date end_date = dtEnd.getDate();
        String status = cmbStatus.getItemAt(cmbStatus.getSelectedIndex());
        
        var is_keyword_empty = keyword.length() == 0;
        var iterator = myCollection.find(!is_keyword_empty ? Filters.text(keyword) : new Document()).iterator();
        ArrayList<Object[]> result = new ArrayList();

        while (iterator.hasNext()) {
            Document doc = iterator.next();
            Document pengalaman = doc.get("pengalaman", new Document());
            Document pendidikan = doc.get("pendidikan", new Document());
            ArrayList row = new ArrayList();

            row.add(doc.getString("ktp"));
            row.add(doc.getString("nama"));
            row.add(doc.getString("no_telepon"));
            row.add(doc.getString("email"));
            row.add(pendidikan.getString("tingkat"));
            row.add(pengalaman.getInteger("lama"));
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

    private void ExportTable() {
        // Do Nothing
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        dtEnd = new org.jdesktop.swingx.JXDatePicker();
        dtStart = new org.jdesktop.swingx.JXDatePicker();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel4.setText("Daftar Kandidat");

        jLabel1.setText("Tanggal Mulai");

        jLabel2.setText("Tanggal Selesai");

        jLabel3.setText("Status Kandidat");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Diterima", "Ditolak", "Menunggu" }));

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/search_file.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.setToolTipText("");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/download_file.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setToolTipText("");
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

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/file.png"))); // NOI18N
        btnNew.setText("Tambah");
        btnNew.setToolTipText("");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/edit_file.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setToolTipText("");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/delete_file.png"))); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.setToolTipText("");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Kata Kunci");

        txtKeyword.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnNew)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnExport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        dispatchDataEvent(DataActionType.CREATE, null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        getSelectedAndDispatch(DataActionType.UPDATE);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        getSelectedAndDispatch(DataActionType.DELETE);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        RefreshTable();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        ExportTable();
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cmbStatus;
    private org.jdesktop.swingx.JXDatePicker dtEnd;
    private org.jdesktop.swingx.JXDatePicker dtStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}