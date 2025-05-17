/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.util;

import java.io.File;
import java.sql.Connection;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.github.brainmate.BrainMateApp.connection.DBConnection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author BMPC2024-8
 */
public class JasperUtil {

  public static void exportToPDF(String jrxmlPath, String title, Map<String, Object> parameters) {
    try {
      // Compile JRXML to Jasper
      JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);

      // Get database connection
      Connection conn = new DBConnection().connect();

      // Fill report with data
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

      // Show save dialog
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Save PDF Report");
      fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
      fileChooser.setSelectedFile(new File(title + ".pdf"));

      if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        if (!file.getName().toLowerCase().endsWith(".pdf")) {
          file = new File(file.getAbsolutePath() + ".pdf");
        }

        // Export to PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());

        // Show success message
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        javax.swing.JOptionPane.showMessageDialog(
            frame, "Report exported successfully to: " + file.getAbsolutePath());
      }

    } catch (Exception e) {
      e.printStackTrace();
      JFrame frame = new JFrame();
      frame.setAlwaysOnTop(true);
      javax.swing.JOptionPane.showMessageDialog(
          frame,
          "Error exporting report: " + e.getMessage(),
          "Error",
          javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }

  public static void previewReport(String jrxmlPath, Map<String, Object> parameters) {
    try {
      // Compile JRXML to Jasper
      JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);

      // Get database connection
      Connection conn = new DBConnection().connect();

      // Fill report with data
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

      // Preview report
      JasperViewer.viewReport(jasperPrint, false);

    } catch (Exception e) {
      e.printStackTrace();
      JFrame frame = new JFrame();
      frame.setAlwaysOnTop(true);
      javax.swing.JOptionPane.showMessageDialog(
          frame,
          "Error previewing report: " + e.getMessage(),
          "Error",
          javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }
}
