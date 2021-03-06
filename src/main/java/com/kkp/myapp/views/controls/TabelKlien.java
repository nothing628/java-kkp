package com.kkp.myapp.views.controls;

import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.views.events.DataActionType;
import com.kkp.myapp.views.events.DataEventListener;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.bson.Document;

public class TabelKlien extends javax.swing.JPanel {

    private MongoCollection<Document> myCollection;
    private final List<DataEventListener> listeners = new ArrayList<>();
    TableModel t_model;

    public TabelKlien() {
        initComponents();
        createTableModel();
        
        myCollection = null;
    }
    
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

    private Document getSelectedDocument(String kode) {
        try {
            Document queryResult = myCollection.find(eq("kode", kode)).first();

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
        new_model.addColumn("Kode");
        new_model.addColumn("Nama Perusahaan");
        new_model.addColumn("Telp");
        new_model.addColumn("Email");
        new_model.addColumn("Aktif");

        this.t_model = new_model;
        this.tblData.setModel(new_model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        txtKeyword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/search_file.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.setToolTipText("");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

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

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/download_file.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setToolTipText("");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        txtKeyword.setToolTipText("");

        jLabel1.setText("Kata Kunci");

        jLabel4.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 18)); // NOI18N
        jLabel4.setText("Daftar Klien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExport)
                            .addComponent(btnCari)
                            .addComponent(btnNew)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnCari.getAccessibleContext().setAccessibleName("115");
        btnNew.getAccessibleContext().setAccessibleName("115");
        btnEdit.getAccessibleContext().setAccessibleName("115");
        btnDelete.getAccessibleContext().setAccessibleName("115");
        btnExport.getAccessibleContext().setAccessibleName("115");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        RefreshTable();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        dispatchDataEvent(DataActionType.CREATE, null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        getSelectedAndDispatch(DataActionType.UPDATE);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        getSelectedAndDispatch(DataActionType.DELETE);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        ExportTable();
    }//GEN-LAST:event_btnExportActionPerformed

    private ArrayList<Object[]> getData() {
        String keyword = txtKeyword.getText();
        var is_keyword_empty = keyword.length() == 0;
        var iterator = myCollection.find(!is_keyword_empty ? Filters.text(keyword) : new Document()).iterator();
        ArrayList<Object[]> result = new ArrayList();

        while (iterator.hasNext()) {
            Document doc = iterator.next();
            ArrayList row = new ArrayList();

            row.add(doc.getString("kode"));
            row.add(doc.getString("nama"));
            row.add(doc.getString("no_telepon"));
            row.add(doc.getString("email"));
            row.add(doc.getBoolean("is_active") ? "Ya" : "Tidak");

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
