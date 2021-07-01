/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kkp.myapp.views;

import com.kkp.myapp.helper.AuthHelper;
import com.kkp.myapp.views.form.FormInputKandidat;
import com.kkp.myapp.views.form.FormPenerimaanKandidat;
import com.kkp.myapp.views.form.FormPengaturan;
import com.kkp.myapp.views.form.FormPenilaianInterview;
import com.kkp.myapp.views.form.FormPermintaanManpower;
import com.kkp.myapp.views.master.MasterKandidat;
import com.kkp.myapp.views.master.MasterKlien;
import com.kkp.myapp.views.master.MasterUser;
import com.kkp.myapp.views.report.ReportEmployee;
import com.kkp.myapp.views.report.ReportInterview;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author titan
 */
public class MainMenu extends javax.swing.JFrame {

    /** Creates new form MainMenu */
    public MainMenu() {
        initComponents();
        this.imagePanel1.setImage("/com/kkp/myapp/assets/aseanindo.png");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMasterKlien = new javax.swing.JButton();
        btnMasterKandidat = new javax.swing.JButton();
        btnLaporanInterview = new javax.swing.JButton();
        btnFormPermintaanKlien = new javax.swing.JButton();
        btnFormInputKandidat = new javax.swing.JButton();
        btnSysUsers = new javax.swing.JButton();
        btnInterview = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        imagePanel1 = new com.kkp.myapp.views.controls.ImagePanel();
        btnSysUsers1 = new javax.swing.JButton();
        btnLaporanKandidat = new javax.swing.JButton();
        btnPenerimaan = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPengguna = new javax.swing.JMenuItem();
        menuKandidat = new javax.swing.JMenuItem();
        menuMasterKlien = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuPermintaanManpower = new javax.swing.JMenuItem();
        menuInputKandidat = new javax.swing.JMenuItem();
        menuPenilaianInterview = new javax.swing.JMenuItem();
        menuPernerimaanKandidat = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        laporanInterview = new javax.swing.JMenuItem();
        laporanKandidat = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Administrasi Calon Karyawan PT Aseanindo Networks Solutions");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnMasterKlien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cabinet48.png"))); // NOI18N
        btnMasterKlien.setText("Master Klien");
        btnMasterKlien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMasterKlien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMasterKlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterKlienActionPerformed(evt);
            }
        });

        btnMasterKandidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/cabinet48.png"))); // NOI18N
        btnMasterKandidat.setText("Master Kandidat");
        btnMasterKandidat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMasterKandidat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMasterKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterKandidatActionPerformed(evt);
            }
        });

        btnLaporanInterview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/chart48.png"))); // NOI18N
        btnLaporanInterview.setText("Laporan Interview");
        btnLaporanInterview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaporanInterview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLaporanInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanInterviewActionPerformed(evt);
            }
        });

        btnFormPermintaanKlien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/documents48.png"))); // NOI18N
        btnFormPermintaanKlien.setText("<html>\n<center>Form <br /> Permintaan Manpower</center></html>");
        btnFormPermintaanKlien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFormPermintaanKlien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFormPermintaanKlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormPermintaanKlienActionPerformed(evt);
            }
        });

        btnFormInputKandidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/documents48.png"))); // NOI18N
        btnFormInputKandidat.setText("<html><center>Form<br />Input Kandidat</center></html>");
        btnFormInputKandidat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFormInputKandidat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFormInputKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormInputKandidatActionPerformed(evt);
            }
        });

        btnSysUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/users48.png"))); // NOI18N
        btnSysUsers.setText("Pengguna Sistem");
        btnSysUsers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSysUsers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSysUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSysUsersActionPerformed(evt);
            }
        });

        btnInterview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/checklist48.png"))); // NOI18N
        btnInterview.setText("<html>\n<center>Interview<br>Kandidat</center></html>");
        btnInterview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInterview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterviewActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/logout48.png"))); // NOI18N
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setLabel("Keluar");
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        btnSysUsers1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/setting48.png"))); // NOI18N
        btnSysUsers1.setText("Pengaturan");
        btnSysUsers1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSysUsers1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSysUsers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSysUsers1ActionPerformed(evt);
            }
        });

        btnLaporanKandidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/chart48.png"))); // NOI18N
        btnLaporanKandidat.setText("Laporan Kandidat");
        btnLaporanKandidat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaporanKandidat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLaporanKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanKandidatActionPerformed(evt);
            }
        });

        btnPenerimaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kkp/myapp/assets/checklist48.png"))); // NOI18N
        btnPenerimaan.setText("<html>\n<center>Status<br/>Penerimaan <br/>Kandidat</center></html>");
        btnPenerimaan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenerimaan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenerimaanActionPerformed(evt);
            }
        });

        lblWelcome.setText("Selamat Datang ");

        jMenu1.setText("Master");

        menuPengguna.setText("Master Pengguna");
        menuPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenggunaActionPerformed(evt);
            }
        });
        jMenu1.add(menuPengguna);

        menuKandidat.setText("Master Kandidat");
        menuKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKandidatActionPerformed(evt);
            }
        });
        jMenu1.add(menuKandidat);

        menuMasterKlien.setText("Master Klien");
        menuMasterKlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMasterKlienActionPerformed(evt);
            }
        });
        jMenu1.add(menuMasterKlien);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Form");

        menuPermintaanManpower.setText("Form Permintaan Manpower");
        menuPermintaanManpower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPermintaanManpowerActionPerformed(evt);
            }
        });
        jMenu2.add(menuPermintaanManpower);

        menuInputKandidat.setText("Form Input Kandidat");
        menuInputKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInputKandidatActionPerformed(evt);
            }
        });
        jMenu2.add(menuInputKandidat);

        menuPenilaianInterview.setText("Form Penilaian Interview");
        menuPenilaianInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenilaianInterviewActionPerformed(evt);
            }
        });
        jMenu2.add(menuPenilaianInterview);

        menuPernerimaanKandidat.setText("Form Penerimaan Kandidat");
        menuPernerimaanKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPernerimaanKandidatActionPerformed(evt);
            }
        });
        jMenu2.add(menuPernerimaanKandidat);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Laporan");

        laporanInterview.setText("Laporan Interview");
        laporanInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanInterviewActionPerformed(evt);
            }
        });
        jMenu3.add(laporanInterview);

        laporanKandidat.setText("Laporan Kandidat");
        laporanKandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanKandidatActionPerformed(evt);
            }
        });
        jMenu3.add(laporanKandidat);

        jMenuBar1.add(jMenu3);

        menuClose.setText("Tutup");
        menuClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCloseMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuClose);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSysUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSysUsers1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFormInputKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFormPermintaanKlien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInterview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMasterKlien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMasterKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLaporanInterview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLaporanKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblWelcome)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMasterKlien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasterKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaporanInterview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaporanKandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnInterview, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnFormInputKandidat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnPenerimaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnFormPermintaanKlien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSysUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSysUsers1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeApplication() {
        var confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menutup Aplikasi?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        // 0 - Yes
        if (confirm == 0) {
            this.setVisible(false);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
    
    private void btnFormInputKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormInputKandidatActionPerformed
        showInputKandidat();
    }//GEN-LAST:event_btnFormInputKandidatActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        closeApplication();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void menuCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCloseMouseClicked
        closeApplication();
    }//GEN-LAST:event_menuCloseMouseClicked

    private void btnMasterKlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterKlienActionPerformed
        showMasterKlien();
    }//GEN-LAST:event_btnMasterKlienActionPerformed

    private void btnMasterKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterKandidatActionPerformed
        showMasterKandidat();
    }//GEN-LAST:event_btnMasterKandidatActionPerformed

    private void btnLaporanInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanInterviewActionPerformed
        showLaporanInterview();
    }//GEN-LAST:event_btnLaporanInterviewActionPerformed

    private void btnLaporanKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanKandidatActionPerformed
        showLaporanKandidat();
    }//GEN-LAST:event_btnLaporanKandidatActionPerformed

    private void btnFormPermintaanKlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormPermintaanKlienActionPerformed
        showInputManpower();
    }//GEN-LAST:event_btnFormPermintaanKlienActionPerformed

    private void btnInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterviewActionPerformed
        showInputPenilaian();
    }//GEN-LAST:event_btnInterviewActionPerformed

    private void btnPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenerimaanActionPerformed
        showPenerimaanKandidat();
    }//GEN-LAST:event_btnPenerimaanActionPerformed

    private void btnSysUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSysUsersActionPerformed
        showMasterUser();
    }//GEN-LAST:event_btnSysUsersActionPerformed

    private void btnSysUsers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSysUsers1ActionPerformed
        showFormPengaturan();
    }//GEN-LAST:event_btnSysUsers1ActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        showMasterUser();
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKandidatActionPerformed
        showMasterKandidat();
    }//GEN-LAST:event_menuKandidatActionPerformed

    private void laporanKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanKandidatActionPerformed
        showLaporanKandidat();
    }//GEN-LAST:event_laporanKandidatActionPerformed

    private void laporanInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanInterviewActionPerformed
        showLaporanInterview();
    }//GEN-LAST:event_laporanInterviewActionPerformed

    private void menuMasterKlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMasterKlienActionPerformed
        showMasterKlien();
    }//GEN-LAST:event_menuMasterKlienActionPerformed

    private void menuPermintaanManpowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPermintaanManpowerActionPerformed
        showInputManpower();
    }//GEN-LAST:event_menuPermintaanManpowerActionPerformed

    private void menuInputKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInputKandidatActionPerformed
        showInputKandidat();
    }//GEN-LAST:event_menuInputKandidatActionPerformed

    private void menuPenilaianInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenilaianInterviewActionPerformed
        showInputPenilaian();
    }//GEN-LAST:event_menuPenilaianInterviewActionPerformed

    private void menuPernerimaanKandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPernerimaanKandidatActionPerformed
        showPenerimaanKandidat();
    }//GEN-LAST:event_menuPernerimaanKandidatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showWelcomeMesasge();
    }//GEN-LAST:event_formWindowOpened

    private void showWelcomeMesasge() {
        lblWelcome.setText("Selamat datang, " + AuthHelper.activeUser.getUsername());
    }
    
    private void showFormPengaturan() {
        FormPengaturan frm = new FormPengaturan();
        frm.setVisible(true);
    }
    
    private void showLaporanKandidat() {
        ReportEmployee frm = new ReportEmployee();
        frm.setVisible(true);
    }
    
    private void showLaporanInterview() {
        ReportInterview frm = new ReportInterview();
        frm.setVisible(true);
    }
    
    private void showMasterKandidat() {
        MasterKandidat frm = new MasterKandidat();
        frm.setVisible(true);
    }
    
    private void showMasterKlien() {
       MasterKlien frm = new MasterKlien();
       frm.setVisible(true);
    }
    
    private void showMasterUser() {
        MasterUser frm = new MasterUser();
        frm.setVisible(true);
    }
    
    private void showInputKandidat() {
        FormInputKandidat frm = new FormInputKandidat();
        frm.setVisible(true);
    }
    
    private void showInputManpower() {
        FormPermintaanManpower frm = new FormPermintaanManpower();
        frm.setVisible(true);
    }
    
    private void showInputPenilaian() {
        FormPenilaianInterview frm = new FormPenilaianInterview();
        frm.setVisible(true);
    }
    
    private void showPenerimaanKandidat() {
        FormPenerimaanKandidat frm = new FormPenerimaanKandidat();
        frm.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFormInputKandidat;
    private javax.swing.JButton btnFormPermintaanKlien;
    private javax.swing.JButton btnInterview;
    private javax.swing.JButton btnLaporanInterview;
    private javax.swing.JButton btnLaporanKandidat;
    private javax.swing.JButton btnMasterKandidat;
    private javax.swing.JButton btnMasterKlien;
    private javax.swing.JButton btnPenerimaan;
    private javax.swing.JButton btnSysUsers;
    private javax.swing.JButton btnSysUsers1;
    private com.kkp.myapp.views.controls.ImagePanel imagePanel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem laporanInterview;
    private javax.swing.JMenuItem laporanKandidat;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JMenu menuClose;
    private javax.swing.JMenuItem menuInputKandidat;
    private javax.swing.JMenuItem menuKandidat;
    private javax.swing.JMenuItem menuMasterKlien;
    private javax.swing.JMenuItem menuPengguna;
    private javax.swing.JMenuItem menuPenilaianInterview;
    private javax.swing.JMenuItem menuPermintaanManpower;
    private javax.swing.JMenuItem menuPernerimaanKandidat;
    // End of variables declaration//GEN-END:variables

}
