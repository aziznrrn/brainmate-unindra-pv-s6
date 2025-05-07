/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainmateapp.service;

import brainmateapp.model.Contact;
import brainmateapp.util.InMemoryDataStore;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author BMPC2024-8
 */
public class ContactService {
    public static List<Contact> getAll() {
        return new ArrayList<>(InMemoryDataStore.contacts);
    }

    /** Cari kontak berdasarkan customerId atau detail mengandung keyword */
    public static List<Contact> search(int customerId, String keyword) {
        String kw = keyword == null ? "" : keyword.toLowerCase();
        return InMemoryDataStore.contacts.stream()
            .filter(c ->
                (customerId == 0 || c.getCustomerId() == customerId) &&
                c.getDetail().toLowerCase().contains(kw)
            )
            .collect(Collectors.toList());
    }

    public static void add(Contact c) {
        c.setId(InMemoryDataStore.seqContact.getAndIncrement());
        InMemoryDataStore.contacts.add(c);
    }

    public static void update(Contact c) {
        for (int i = 0; i < InMemoryDataStore.contacts.size(); i++) {
            if (InMemoryDataStore.contacts.get(i).getId() == c.getId()) {
                InMemoryDataStore.contacts.set(i, c);
                return;
            }
        }
    }

    public static void delete(int id) {
        InMemoryDataStore.contacts.removeIf(c -> c.getId() == id);
    }

    /** Filter kontak antar dua tanggal (inklusif) */
    public static List<Contact> getBetween(Date from, Date to) {
        return InMemoryDataStore.contacts.stream()
            .filter(c -> !c.getDate().before(from) && !c.getDate().after(to))
            .collect(Collectors.toList());
    }
}

