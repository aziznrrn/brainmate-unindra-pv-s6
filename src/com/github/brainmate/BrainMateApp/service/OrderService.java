/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.service;

import java.util.*;
import java.util.stream.Collectors;

import com.github.brainmate.BrainMateApp.model.Order;
import com.github.brainmate.BrainMateApp.util.InMemoryDataStore;

/**
 * @author BMPC2024-8
 */
public class OrderService {
  public static List<Order> getAll() {
    return new ArrayList<>(InMemoryDataStore.orders);
  }

  /** Cari order berdasarkan customerId */
  public static List<Order> getByCustomer(int customerId) {
    return InMemoryDataStore.orders.stream()
        .filter(o -> o.getCustomerId() == customerId)
        .collect(Collectors.toList());
  }

  /** Filter order antar dua tanggal (inklusif) */
  public static List<Order> getBetween(Date from, Date to) {
    return InMemoryDataStore.orders.stream()
        .filter(o -> !o.getDate().before(from) && !o.getDate().after(to))
        .collect(Collectors.toList());
  }

  public static void add(Order o) {
    o.setId(InMemoryDataStore.seqOrder.getAndIncrement());
    InMemoryDataStore.orders.add(o);
  }

  public static void update(Order o) {
    for (int i = 0; i < InMemoryDataStore.orders.size(); i++) {
      if (InMemoryDataStore.orders.get(i).getId() == o.getId()) {
        InMemoryDataStore.orders.set(i, o);
        return;
      }
    }
  }

  public static void delete(int id) {
    InMemoryDataStore.orders.removeIf(o -> o.getId() == id);
  }
}
