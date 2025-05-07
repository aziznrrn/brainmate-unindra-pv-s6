/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.aziznrrn.brainmate.util;

import java.io.*;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * @author BMPC2024-8
 */
public class ExportUtil {
  public static void exportTableToCSV(JTable table, JFrame parent) {
    JFileChooser fc = new JFileChooser();
    if (fc.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
      File f = fc.getSelectedFile();
      try (PrintWriter pw = new PrintWriter(f)) {
        TableModel m = table.getModel();
        // header
        for (int c = 0; c < m.getColumnCount(); c++) {
          pw.print(m.getColumnName(c));
          if (c < m.getColumnCount() - 1) pw.print(",");
        }
        pw.println();
        // rows
        for (int r = 0; r < m.getRowCount(); r++) {
          for (int c = 0; c < m.getColumnCount(); c++) {
            Object v = m.getValueAt(r, c);
            pw.print(v == null ? "" : v.toString());
            if (c < m.getColumnCount() - 1) pw.print(",");
          }
          pw.println();
        }
        JOptionPane.showMessageDialog(parent, "Export berhasil: " + f.getAbsolutePath());
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(parent, "Error export: " + ex.getMessage());
      }
    }
  }
}
