/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.service;

import java.util.*;
import java.util.stream.Collectors;

import com.github.brainmate.BrainMateApp.model.Feedback;
import com.github.brainmate.BrainMateApp.util.InMemoryDataStore;

/**
 * @author BMPC2024-8
 */
public class FeedbackService {
  public static List<Feedback> getAll() {
    return new ArrayList<>(InMemoryDataStore.feedbacks);
  }

  /** Cari feedback berdasarkan customerId */
  public static List<Feedback> getByCustomer(int customerId) {
    return InMemoryDataStore.feedbacks.stream()
        .filter(f -> f.getCustomerId() == customerId)
        .collect(Collectors.toList());
  }

  /** Filter feedback antar dua tanggal (inklusif) */
  public static List<Feedback> getBetween(Date from, Date to) {
    return InMemoryDataStore.feedbacks.stream()
        .filter(f -> !f.getDate().before(from) && !f.getDate().after(to))
        .collect(Collectors.toList());
  }

  public static void add(Feedback f) {
    f.setId(InMemoryDataStore.seqFeedback.getAndIncrement());
    InMemoryDataStore.feedbacks.add(f);
  }

  public static void update(Feedback f) {
    for (int i = 0; i < InMemoryDataStore.feedbacks.size(); i++) {
      if (InMemoryDataStore.feedbacks.get(i).getId() == f.getId()) {
        InMemoryDataStore.feedbacks.set(i, f);
        return;
      }
    }
  }

  public static void delete(int id) {
    InMemoryDataStore.feedbacks.removeIf(f -> f.getId() == id);
  }
}
