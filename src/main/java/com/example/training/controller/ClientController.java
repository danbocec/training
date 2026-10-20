package com.example.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.classes.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@RestController

@RequestMapping("/program")
public class ClientController {

// First goal is to create an endpoint which retrives new clients and already existing ones 

    Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium");

    Client client2 = new Client("Jane Doe", 25, "jane.doe@example.com", "098-765-4321", "456 Oak Ave", "Standard");

    private final List<Client> clients = new ArrayList<>(List.of(client1, client2));


    // Endpoint to retrieve all clients
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clients;
    }

    // Retrieve information of a client by name
    @GetMapping("/client/{clientName}")
    public Client getClient(@PathVariable("clientName") String clientName) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                return client;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found: " + clientName);


    }

    // Endpoint to create a new client
    @PostMapping("/postClient")
    public Client createClient(@RequestBody Client client) {
        clients.add(client);
        return client;
    }

    
    


    
}