/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.brainmate.BrainMateApp.forms.*;

/**
 * @author ezraa
 */
public class Main extends javax.swing.JFrame {

  private final JLabel statusBar = new JLabel("Ready");
  private final Color PRIMARY_COLOR = new Color(0, 120, 215);
  private final Color SECONDARY_COLOR = new Color(240, 240, 240);
  private final Color BUTTON_HOVER = new Color(0, 90, 180);

  private JPanel headerPanel;
  private JPanel landingPanel;
  private JPanel statusPanel;
  private JButton btnMaster;
  private JButton btnTransaksi;
  private JButton btnLaporan;
  private JButton btnPengaturan;

  public Main() {
    try {
      UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (Exception e) {
      e.printStackTrace();
    }
    initComponents();
    setupUI();
  }

  private void setupUI() {
    setSize(1080, 720);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    add(createHeader(), BorderLayout.NORTH);
    add(createLandingPanel(), BorderLayout.CENTER);
    add(createStatusBar(), BorderLayout.SOUTH);
  }

  private JPanel createHeader() {
    headerPanel = new JPanel(new BorderLayout());
    headerPanel.setBackground(PRIMARY_COLOR);
    headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

    JLabel title = new JLabel("BrainMate CRM");
    title.setFont(new Font("Segoe UI", Font.BOLD, 18));
    title.setForeground(Color.WHITE);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
    buttonPanel.setOpaque(false);

    JButton exitButton = createStyledButton("Exit", SECONDARY_COLOR);
    exitButton.setForeground(Color.BLACK);
    exitButton.addActionListener(e -> System.exit(0));

    buttonPanel.add(exitButton);
    headerPanel.add(title, BorderLayout.WEST);
    headerPanel.add(buttonPanel, BorderLayout.EAST);

    return headerPanel;
  }

  private JPanel createLandingPanel() {
    landingPanel = new JPanel(new BorderLayout());
    landingPanel.setBounds(0, 0, 1080, 720);
    landingPanel.setBackground(SECONDARY_COLOR);
    landingPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

    JLabel welcomeLabel = new JLabel("Welcome to BrainMate CRM", SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
    welcomeLabel.setForeground(PRIMARY_COLOR);
    welcomeLabel.setBorder(BorderFactory.createEmptyBorder(2, 1, 4, 1));
    landingPanel.add(welcomeLabel, BorderLayout.NORTH);

    JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 2, 2));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 200, 300, 200));
    buttonPanel.setOpaque(false);

    btnMaster = createMainMenuButton("Master Data");
    btnTransaksi = createMainMenuButton("Transaksi");
    btnLaporan = createMainMenuButton("Laporan");
    btnPengaturan = createMainMenuButton("Pengaturan");

    setupButtonListeners();

    buttonPanel.add(btnMaster);
    buttonPanel.add(btnTransaksi);
    buttonPanel.add(btnLaporan);
    buttonPanel.add(btnPengaturan);

    landingPanel.add(buttonPanel, BorderLayout.CENTER);

    return landingPanel;
  }

  private void setupButtonListeners() {
    btnMaster.addActionListener(
        e ->
            showSubMenu(
                "Master Data",
                new String[] {"Pelanggan", "Produk", "Marketing", "Kontak"},
                (JButton) e.getSource()));
    btnTransaksi.addActionListener(
        e ->
            showSubMenu(
                "Transaksi", new String[] {"Pemesanan", "Feedback"}, (JButton) e.getSource()));
    btnLaporan.addActionListener(
        e ->
            showSubMenu(
                "Laporan",
                new String[] {"Pelanggan", "Penjualan", "Kinerja", "Feedback"},
                (JButton) e.getSource()));
    btnPengaturan.addActionListener(
        e ->
            showSubMenu(
                "Pengaturan",
                new String[] {"Manajemen Pengguna", "Backup Data", "Analisis Bisnis"},
                (JButton) e.getSource()));
  }

  private JButton createMainMenuButton(String text) {
    JButton button = new JButton(text);
    button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    button.setFocusPainted(false);
    button.setBackground(PRIMARY_COLOR);
    button.setForeground(Color.WHITE);

    button.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            button.setBackground(BUTTON_HOVER);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            button.setBackground(PRIMARY_COLOR);
          }
        });

    return button;
  }

  private void showSubMenu(String category, String[] options, JButton invoker) {
    JPopupMenu popupMenu = new JPopupMenu();
    popupMenu.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

    JMenuItem titleItem = new JMenuItem(category + " Menu");
    titleItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
    titleItem.setEnabled(false);
    popupMenu.add(titleItem);
    popupMenu.addSeparator();

    for (String option : options) {
      JMenuItem menuItem = new JMenuItem(option);
      menuItem.addActionListener(
          e -> {
            openSelectedForm(category, option);
            popupMenu.setVisible(false);
          });
      popupMenu.add(menuItem);
    }

    popupMenu.show(invoker, 0, invoker.getHeight());
  }

  private void openSelectedForm(String category, String option) {
    JFrame frame = null;

    switch (category) {
      case "Master Data":
        if (option.equals("Pelanggan")) frame = new PelangganFrame();
        else if (option.equals("Produk")) frame = new ProdukFrame();
        else if (option.equals("Marketing")) frame = new MarketingFrame();
        else if (option.equals("Kontak")) frame = new KontakFrame();
        break;

      case "Transaksi":
        if (option.equals("Pemesanan")) frame = new PemesananFrame();
        else if (option.equals("Feedback")) frame = new FeedbackFrame();
        break;

      case "Laporan":
        if (option.equals("Pelanggan")) frame = new LapPelangganFrame();
        else if (option.equals("Penjualan")) frame = new LapPenjualanFrame();
        else if (option.equals("Kinerja")) frame = new LapKinerjaFrame();
        else if (option.equals("Feedback")) frame = new LapFeedbackFrame();
        break;

      case "Pengaturan":
        if (option.equals("Manajemen Pengguna")) frame = new ManajemenPenggunaFrame();
        else if (option.equals("Backup Data")) frame = new BackupDataFrame();
        else if (option.equals("Analisis Bisnis")) frame = new AnalisisBisnisFrame();
        break;
    }

    if (frame != null) {
      openFrame(frame);
    }
  }

  private JButton createStyledButton(String text, Color bgColor) {
    JButton button = new JButton(text);
    button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    button.setBackground(bgColor);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)));

    button.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            button.setBackground(BUTTON_HOVER);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            button.setBackground(bgColor);
          }
        });

    return button;
  }

  private JPanel createStatusBar() {
    statusPanel = new JPanel(new BorderLayout());
    statusPanel.setBackground(new Color(230, 230, 230));
    statusPanel.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    statusBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    statusBar.setForeground(new Color(80, 80, 80));
    statusPanel.add(statusBar, BorderLayout.WEST);

    return statusPanel;
  }

  private void setStatus(String message) {
    statusBar.setText(message);
  }

  private void openFrame(JFrame frame) {
    JDialog dialog = new JDialog(this, frame.getTitle(), true);
    dialog.setContentPane(frame.getContentPane());
    dialog.setSize(frame.getSize());
    dialog.setLocationRelativeTo(this);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    dialog.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
            frame.dispose();
          }
        });

    dialog.setVisible(true);
    setStatus("Opened: " + frame.getTitle());
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          Main app = new Main();
          app.setVisible(true);
        });
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("BrainMate CRM");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
