/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.model;

import java.util.Date;

/**
 * @author BMPC2024-8
 */
public class Order {
  private int id;
  private int customerId;
  private int productId;
  private int teamId;
  private Date date;
  private int quantity;

  public Order() {}

  public Order(int id, int customerId, int productId, int teamId, Date date, int quantity) {
    this.id = id;
    this.customerId = customerId;
    this.productId = productId;
    this.teamId = teamId;
    this.date = date;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
