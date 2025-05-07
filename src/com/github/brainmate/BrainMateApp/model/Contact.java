/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.model;

import java.util.Date;

/**
 * @author BMPC2024-8
 */
public class Contact {
  private int id;
  private int customerId;
  private Date date;
  private String detail;

  public Contact() {}

  public Contact(int id, int customerId, Date date, String detail) {
    this.id = id;
    this.customerId = customerId;
    this.date = date;
    this.detail = detail;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
