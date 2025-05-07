/*
 * Copyright (c) 2025 BrainMateApp
 * All rights reserved.
 */
package com.github.brainmate.BrainMateApp.service;

import java.util.*;
import java.util.stream.Collectors;

import com.github.brainmate.BrainMateApp.model.Marketing;
import com.github.brainmate.BrainMateApp.util.InMemoryDataStore;

/**
 * @author BMPC2024-8
 */
public class MarketingService {
  public static List<Marketing> getAll() {
    return new ArrayList<>(InMemoryDataStore.teamMembers);
  }

  public static List<Marketing> search(String keyword) {
    String kw = keyword == null ? "" : keyword.toLowerCase();
    return InMemoryDataStore.teamMembers.stream()
        .filter(
            t ->
                t.getName().toLowerCase().contains(kw)
                    || t.getArea().toLowerCase().contains(kw)
                    || t.getEmail().toLowerCase().contains(kw))
        .collect(Collectors.toList());
  }

  public static void add(Marketing t) {
    t.setId(InMemoryDataStore.seqTeam.getAndIncrement());
    InMemoryDataStore.teamMembers.add(t);
  }

  public static void update(Marketing t) {
    for (int i = 0; i < InMemoryDataStore.teamMembers.size(); i++) {
      if (InMemoryDataStore.teamMembers.get(i).getId() == t.getId()) {
        InMemoryDataStore.teamMembers.set(i, t);
        return;
      }
    }
  }

  public static void delete(int id) {
    InMemoryDataStore.teamMembers.removeIf(t -> t.getId() == id);
  }
}
