/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainmateapp.util;

import brainmateapp.model.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
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

