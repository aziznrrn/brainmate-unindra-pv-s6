/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.github.brainmate.BrainMateApp.model.*;

/**
 * @author BMPC2024-8
 */
public class InMemoryDataStore {

  public static final List<Customer> customers = new ArrayList<>();
  public static final List<Product> products = new ArrayList<>();
  public static final List<Marketing> teamMembers = new ArrayList<>();
  public static final List<Contact> contacts = new ArrayList<>();
  public static final List<Order> orders = new ArrayList<>();
  public static final List<Feedback> feedbacks = new ArrayList<>();

  public static final AtomicInteger seqCustomer = new AtomicInteger(1);
  public static final AtomicInteger seqProduct = new AtomicInteger(1);
  public static final AtomicInteger seqTeam = new AtomicInteger(1);
  public static final AtomicInteger seqContact = new AtomicInteger(1);
  public static final AtomicInteger seqOrder = new AtomicInteger(1);
  public static final AtomicInteger seqFeedback = new AtomicInteger(1);
}
