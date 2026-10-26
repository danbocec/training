package com.example.training.model;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String address;
    
    private Set<Client> clients = new HashSet<Client>();

    public Coach(String name, int age, String email, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // Adding client to the coach's client list 
    public void addClient(Client client) {
        if (clients.contains(client)) {
            System.out.println("Client " + client.getName() + " is already in Coach " + this.name + "'s client list.");
            return;
        }
        clients.add(client);
        System.out.println("Client " + client.getName() + " has been added to Coach " + this.name + "'s client list.");
    }
    // Get the list of clients
    public Set<Client> getClients() {
        for (Client client : clients) {
            System.out.println("Client: " + client.getName());
        }
        return clients;
        
    }
    // checks if coach already have an existing client
    public boolean hasClient(Client client) {
        return clients.contains(client);
    }


    // Remove a client from a coach's client list 
    public void removeClient(Client client) {
        if (clients.remove(client)) {
            System.out.println("Client " + client.getName() + " has been removed from Coach " + this.name + "'s client list.");
        } else {
            System.out.println("Client " + client.getName() + " was not found in Coach " + this.name + "'s client list.");
        }
    }




}