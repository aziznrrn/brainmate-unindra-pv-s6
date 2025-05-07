/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.aziznrrn.brainmate.forms;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.github.aziznrrn.brainmate.model.Customer;
import com.github.aziznrrn.brainmate.service.CustomerService;

public class PelangganFrame extends javax.swing.JFrame {

  public PelangganFrame() {
    initComponents();
    btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
    btnUbah.addActionListener(e -> btnUbahActionPerformed(e));
    btnHapus.addActionListener(e -> btnHapusActionPerformed(e));
    btnRefresh.addActionListener(e -> btnRefreshActionPerformed(e));
    btnTutup.addActionListener(e -> btnTutupActionPerformed(e));

    String[] columnNames = {"ID", "No", "Name", "Email", "Phone", "Address", "Status"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    tblPelanggan.setModel(model);
    tblPelanggan.getColumnModel().getColumn(0).setMinWidth(0);
    tblPelanggan.getColumnModel().getColumn(0).setMaxWidth(0);

    loadAll();
  }

  private void loadSearch() {
    DefaultTableModel m = (DefaultTableModel) tblPelanggan.getModel();
    m.setRowCount(0);
    String kw = txtSearch.getText().trim();
    int index = 1;
    for (Customer c : CustomerService.search(kw)) {
      m.addRow(
          new Object[] {
            c.getId(),
            index++,
            c.getName(),
            c.getEmail(),
            c.getPhone(),
            c.getAddress(),
            c.getStatus()
          });
    }
  }

  private void loadAll() {
    DefaultTableModel m = (DefaultTableModel) tblPelanggan.getModel();
    m.setRowCount(0);
    int index = 1;
    for (Customer c : CustomerService.getAll()) {
      m.addRow(
          new Object[] {
            c.getId(),
            index++,
            c.getName(),
            c.getEmail(),
            c.getPhone(),
            c.getAddress(),
            c.getStatus()
          });
    }
  }

  private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
    loadSearch();
  }

  private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
    txtSearch.setText("");
    loadAll();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtSearch = new javax.swing.JTextField();
    btnSearch = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblPelanggan = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    btnTambah = new javax.swing.JButton();
    btnUbah = new javax.swing.JButton();
    btnHapus = new javax.swing.JButton();
    btnRefresh = new javax.swing.JButton();
    btnTutup = new javax.swing.JButton();

    jLabel1.setText("Cari:");

    btnSearch.setText("Cari");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        jLabel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        36,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtSearch,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        270,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSearch)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(
                                        txtSearch,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch))
                            .addComponent(jLabel1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    tblPelanggan.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"Title 1", "Title 2", "Title 3", "Title 4"}));
    jScrollPane1.setViewportView(tblPelanggan);

    btnTambah.setText("Tambah");
    btnTambah.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnTambahActionPerformed(evt);
          }
        });

    btnUbah.setText("Ubah");

    btnHapus.setText("Hapus");
    btnHapus.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHapusActionPerformed(evt);
          }
        });

    btnRefresh.setText("Refresh");

    btnTutup.setText("Tutup");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnTambah)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnUbah)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnHapus)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnRefresh)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnTutup)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnTutup)
                            .addComponent(btnRefresh)
                            .addComponent(btnHapus)
                            .addComponent(btnUbah)
                            .addComponent(btnTambah))
                    .addContainerGap(17, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jPanel1,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                0,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                jPanel2,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                401,
                                                Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        285,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jPanel2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void btnTambahActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnTambahActionPerformed
    // Form input components
    JTextField nameField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField phoneField = new JTextField(20);
    JTextField addressField = new JTextField(20);

    JRadioButton activeBtn = new JRadioButton("Active");
    JRadioButton inactiveBtn = new JRadioButton("Inactive");
    ButtonGroup statusGroup = new ButtonGroup();
    statusGroup.add(activeBtn);
    statusGroup.add(inactiveBtn);
    activeBtn.setSelected(true); // default

    // Layout panel
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Email:"));
    panel.add(emailField);
    panel.add(new JLabel("Phone:"));
    panel.add(phoneField);
    panel.add(new JLabel("Address:"));
    panel.add(addressField);
    panel.add(new JLabel("Status:"));
    panel.add(activeBtn);
    panel.add(inactiveBtn);

    // Show dialog
    int result =
        JOptionPane.showConfirmDialog(
            this, panel, "Add Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
      String name = nameField.getText().trim();
      String email = emailField.getText().trim();
      String phone = phoneField.getText().trim();
      String address = addressField.getText().trim();
      String status = activeBtn.isSelected() ? "Active" : "Inactive";

      if (name.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Name is required.");
        return;
      }

      if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email is required.");
        return;
      }

      if (phone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Phone is required.");
        return;
      }

      if (address.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Address is required.");
        return;
      }

      CustomerService.add(new Customer(0, name, address, phone, email, status));
      loadAll();
    }
  } // GEN-LAST:event_btnTambahActionPerformed

  private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {
    int sel = tblPelanggan.getSelectedRow();
    if (sel < 0) {
      JOptionPane.showMessageDialog(this, "Pilih pelanggan terlebih dahulu.");
      return;
    }

    DefaultTableModel m = (DefaultTableModel) tblPelanggan.getModel();

    int index = 0;
    int rowIdx = sel;
    for (Customer c : CustomerService.getAll()) {
      if (index == rowIdx) {
        // Input fields prefilled with current values
        JTextField nameField = new JTextField(c.getName());
        JTextField emailField = new JTextField(c.getEmail());
        JTextField phoneField = new JTextField(c.getPhone());
        JTextField addressField = new JTextField(c.getAddress());

        JRadioButton activeBtn = new JRadioButton("Active");
        JRadioButton inactiveBtn = new JRadioButton("Inactive");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(activeBtn);
        statusGroup.add(inactiveBtn);
        if ("Active".equalsIgnoreCase(c.getStatus())) activeBtn.setSelected(true);
        else inactiveBtn.setSelected(true);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Status:"));
        panel.add(activeBtn);
        panel.add(inactiveBtn);

        int result =
            JOptionPane.showConfirmDialog(
                this,
                panel,
                "Edit Customer",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
          String name = nameField.getText().trim();
          String email = emailField.getText().trim();
          String phone = phoneField.getText().trim();
          String address = addressField.getText().trim();
          String status = activeBtn.isSelected() ? "Active" : "Inactive";

          if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required.");
            return;
          }

          CustomerService.update(new Customer(c.getId(), name, address, phone, email, status));
          loadAll();
        }
        break;
      }
      index++;
    }
  }

  private void btnHapusActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnHapusActionPerformed
    int sel = tblPelanggan.getSelectedRow();
    if (sel < 0) return;
    if (JOptionPane.showConfirmDialog(
            this, "Hapus pelanggan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION)
        == JOptionPane.YES_OPTION) {
      DefaultTableModel m = (DefaultTableModel) tblPelanggan.getModel();
      CustomerService.delete((int) m.getValueAt(sel, 0));
      loadAll();
    }
  } // GEN-LAST:event_btnHapusActionPerformed

  private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {
    dispose();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnHapus;
  private javax.swing.JButton btnRefresh;
  private javax.swing.JButton btnSearch;
  private javax.swing.JButton btnTambah;
  private javax.swing.JButton btnTutup;
  private javax.swing.JButton btnUbah;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblPelanggan;
  private javax.swing.JTextField txtSearch;
  // End of variables declaration//GEN-END:variables
}
