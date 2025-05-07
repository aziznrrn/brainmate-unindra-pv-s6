/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainmateapp.service;

import brainmateapp.model.Order;
import brainmateapp.util.InMemoryDataStore;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
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

