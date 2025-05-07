/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.aziznrrn.brainmate.service;

import java.sql.*;
import java.util.*;

import com.github.aziznrrn.brainmate.connection.DBConnection;
import com.github.aziznrrn.brainmate.model.Customer;

/**
 * @author BMPC2024-8
 */
public class CustomerService {

  private static Connection conn = new DBConnection().connect();

  public static List<Customer> getAll() {
    List<Customer> list = new ArrayList<>();
    String sql = "SELECT * FROM customers";
    try (Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        list.add(
            new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("status")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<Customer> search(String keyword) {
    List<Customer> list = new ArrayList<>();
    String sql = "SELECT * FROM customers WHERE name LIKE ? OR email LIKE ? OR phone LIKE ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      String kw = "%" + keyword + "%";
      ps.setString(1, kw);
      ps.setString(2, kw);
      ps.setString(3, kw);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Customer c =
            new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("status"));
        list.add(c);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  public static void add(Customer c) {
    String sql =
        "INSERT INTO customers (name, address, phone, email, status) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, c.getName());
      ps.setString(2, c.getAddress());
      ps.setString(3, c.getPhone());
      ps.setString(4, c.getEmail());
      ps.setString(5, c.getStatus());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void update(Customer c) {
    String sql =
        "UPDATE customers SET name = ?, address = ?, phone = ?, email = ?, status = ? WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, c.getName());
      ps.setString(2, c.getAddress());
      ps.setString(3, c.getPhone());
      ps.setString(4, c.getEmail());
      ps.setString(5, c.getStatus());
      ps.setInt(6, c.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void delete(int id) {
    String sql = "DELETE FROM customers WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
