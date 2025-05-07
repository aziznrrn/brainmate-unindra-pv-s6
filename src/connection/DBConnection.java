/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ezraa
 */
public class DBConnection {
    private Connection koneksi;

    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ditemukan...");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex);
        }

        String url = "jdbc:mysql://localhost:3306/crm?useSSL=false";
        try {
            koneksi = DriverManager.getConnection(url, "root", "");
//            JOptionPane.showMessageDialog(null, "Berhasil koneksi ke database!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal koneksi ke database: " + ex);
        }
        return koneksi;
    }
}
