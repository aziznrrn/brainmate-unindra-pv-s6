/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainmateapp;

import brainmateapp.forms.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ezraa
 */
public class BrainMateGUIv2 extends javax.swing.JFrame {

    private final JDesktopPane desktopPane = new JDesktopPane();
    private final JLabel statusBar = new JLabel("Ready");
    private final Color PRIMARY_COLOR = new Color(0, 120, 215);
    private final Color SECONDARY_COLOR = new Color(240, 240, 240);
    private final Color BUTTON_HOVER = new Color(0, 90, 180);

    public BrainMateGUIv2() {
        super("BrainMate CRM");
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        desktopPane.setBackground(new Color(245, 245, 245));
        desktopPane.add(createLandingPanel());
        
        add(createHeader(), BorderLayout.NORTH);
        add(desktopPane, BorderLayout.CENTER);
        add(createStatusBar(), BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY_COLOR);
        header.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        JLabel title = new JLabel("BrainMate CRM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);

        // Exit button with black text
        JButton exitButton = createStyledButton("Exit", SECONDARY_COLOR);
        exitButton.setForeground(Color.BLACK); // Change text color to black
        exitButton.addActionListener(e -> System.exit(0));

        // Refresh button
        JButton refreshButton = createStyledButton("Refresh", SECONDARY_COLOR);
        refreshButton.setForeground(Color.BLACK); // Ensure consistency
        refreshButton.addActionListener(e -> {
            desktopPane.removeAll();
            desktopPane.add(createLandingPanel());
            desktopPane.revalidate();
            desktopPane.repaint();
            setStatus("Refreshed to main menu");
        });

        buttonPanel.add(refreshButton);
        buttonPanel.add(exitButton);
        header.add(title, BorderLayout.WEST);
        header.add(buttonPanel, BorderLayout.EAST);

        return header;
    }

    private JPanel createLandingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(0, 0, 1080, 720);
        panel.setBackground(SECONDARY_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Welcome title
        JLabel welcomeLabel = new JLabel("Welcome to BrainMate CRM", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        welcomeLabel.setForeground(PRIMARY_COLOR);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(2, 1, 4, 1));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons in center - now in a 2x2 grid with smaller buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 200, 300, 200));
        buttonPanel.setOpaque(false);

        JButton btnMaster = createMainMenuButton("Master Data");
        JButton btnTransaksi = createMainMenuButton("Transaksi");
        JButton btnLaporan = createMainMenuButton("Laporan");
        JButton btnPengaturan = createMainMenuButton("Pengaturan");

        btnMaster.addActionListener(e -> showSubMenu("Master Data", 
            new String[]{"Pelanggan", "Produk", "Marketing", "Kontak"}, (JButton)e.getSource()));
        btnTransaksi.addActionListener(e -> showSubMenu("Transaksi", 
            new String[]{"Pemesanan", "Feedback"}, (JButton)e.getSource()));
        btnLaporan.addActionListener(e -> showSubMenu("Laporan", 
            new String[]{"Pelanggan", "Penjualan", "Kinerja", "Feedback"}, (JButton)e.getSource()));
        btnPengaturan.addActionListener(e -> showSubMenu("Pengaturan", 
            new String[]{"Manajemen Pengguna", "Backup Data", "Analisis Bisnis"}, (JButton)e.getSource()));

        buttonPanel.add(btnMaster);
        buttonPanel.add(btnTransaksi);
        buttonPanel.add(btnLaporan);
        buttonPanel.add(btnPengaturan);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    private JButton createMainMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setFocusPainted(false);
        
        button.addMouseListener(new MouseAdapter() {
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

        // Add title to popup
        JMenuItem titleItem = new JMenuItem(category + " Menu");
        titleItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titleItem.setEnabled(false);
        popupMenu.add(titleItem);
        popupMenu.addSeparator();

        // Add menu items
        for (String option : options) {
            JMenuItem menuItem = new JMenuItem(option);
            menuItem.addActionListener(e -> {
                openSelectedForm(category, option);
                popupMenu.setVisible(false);
            });
            popupMenu.add(menuItem);
        }

        // Show the popup relative to the button that was clicked
        popupMenu.show(invoker, 0, invoker.getHeight());
    }

    private void openSelectedForm(String category, String option) {
        desktopPane.removeAll();
        
        switch (category) {
            case "Master Data":
                if (option.equals("Pelanggan")) openFrame(new PelangganFrame());
                else if (option.equals("Produk")) openFrame(new ProdukFrame());
                else if (option.equals("Marketing")) openFrame(new MarketingFrame());
                else if (option.equals("Kontak")) openFrame(new KontakFrame());
                break;
                
            case "Transaksi":
                if (option.equals("Pemesanan")) openFrame(new PemesananFrame());
                else if (option.equals("Feedback")) openFrame(new FeedbackFrame());
                break;
                
            case "Laporan":
                if (option.equals("Pelanggan")) openFrame(new LapPelangganFrame());
                else if (option.equals("Penjualan")) openFrame(new LapPenjualanFrame());
                else if (option.equals("Kinerja")) openFrame(new LapKinerjaFrame());
                else if (option.equals("Feedback")) openFrame(new LapFeedbackFrame());
                break;
                
            case "Pengaturan":
                if (option.equals("Manajemen Pengguna")) openFrame(new ManajemenPenggunaFrame());
                else if (option.equals("Backup Data")) openFrame(new BackupDataFrame());
                else if (option.equals("Analisis Bisnis")) openFrame(new AnalisisBisnisFrame());
                break;
        }
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        
        button.addMouseListener(new MouseAdapter() {
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
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(new Color(230, 230, 230));
        statusPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        statusBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusBar.setForeground(new Color(80, 80, 80));
        statusPanel.add(statusBar, BorderLayout.WEST);
        
        return statusPanel;
    }

    private void setStatus(String message) {
        statusBar.setText(message);
    }

    private void openFrame(JInternalFrame f) {
        desktopPane.add(f);
        f.setVisible(true);
        try {
            f.setSelected(true);
            setStatus("Opened: " + f.getTitle());
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BrainMateGUIv2 app = new BrainMateGUIv2();
            app.setVisible(true);
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

