/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainmateapp.service;

import brainmateapp.model.Marketing;
import brainmateapp.util.InMemoryDataStore;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author BMPC2024-8
 */
public class MarketingService {
    public static List<Marketing> getAll() {
        return new ArrayList<>(InMemoryDataStore.teamMembers);
    }

    public static List<Marketing> search(String keyword) {
        String kw = keyword == null ? "" : keyword.toLowerCase();
        return InMemoryDataStore.teamMembers.stream()
            .filter(t ->
                t.getName().toLowerCase().contains(kw) ||
                t.getArea().toLowerCase().contains(kw) ||
                t.getEmail().toLowerCase().contains(kw)
            )
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

