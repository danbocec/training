package com.example.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.model.Client;
import com.example.training.model.Program;

public class ClientRepository {

    

    Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium");
    Client client2 = new Client("Jane Doe", 25, "jane.doe@example.com", "098-765-4321", "456 Oak Ave", "Standard");
    private final List<Client> clients = new ArrayList<>(List.of(client1, client2));


    // Retrieve all clients from ClientController 
    public List<Client> getAllClients() {
        return clients;
    }

    // Retrieve one client from ClientController 
    public Client getClient(String clientName) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                return client;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found: " + clientName);  
}

    // Create a new client from ClientController
    public Client createClient(Client client) {
        for (Client existingClient : clients) {
            if (existingClient.getName().equalsIgnoreCase(client.getName()) || existingClient.getEmail().equalsIgnoreCase(client.getEmail())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Client already exists: " + client.getName());
            }
        }
        clients.add(client);
            return client;
            
    }


    
   // Assign an already existing program to a client 
    public Client assignProgramToClient (Program program, Client client) {
        client.setProgram(program);
        return client;
    }
 


}
