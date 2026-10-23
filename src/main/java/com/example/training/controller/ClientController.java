package com.example.training.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Client;
import com.example.training.model.Program;
import com.example.training.repository.ClientRepository;
import com.example.training.repository.ProgramRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/client")
public class ClientController {

    private final ProgramRepository programRepository;

    public ClientController(ProgramRepository programRepository) {
    this.programRepository = programRepository;
}

// First goal is to create an endpoint which retrives new clients and already existing ones 


    ClientRepository clientRepository = new ClientRepository();

    // Endpoint to retrieve all clients
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientRepository.getAllClients();
    }

 
    // Retrieve information of a client by name
    @GetMapping("/{clientName}")
    public Client getClient(@PathVariable("clientName") String clientName) {
        return clientRepository.getClient(clientName);

    }

    // Endpoint to create a new client
    @PostMapping("/postClient")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.createClient(client);
    }

    @PostMapping("/{clientName}/{programID}")
    public Client assignProgramToClient(@PathVariable("clientName") String clientName,
    @PathVariable("programID") int programID) {
        Client client = clientRepository.getClient(clientName);

        return clientRepository.assignProgramToClient(programRepository.getProgramID(programID), client);
    }
        





}