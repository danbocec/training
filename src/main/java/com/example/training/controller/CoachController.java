package com.example.training.controller;

import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Client;
import com.example.training.model.Coach;
import com.example.training.model.Program;
import com.example.training.repository.ClientRepository;
import com.example.training.repository.CoachRepository;
import com.example.training.repository.ProgramRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/coach")
public class CoachController {
   
    private final ClientRepository clientRepository;

    public CoachController(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
}

    CoachRepository coachRepository = new CoachRepository();

    // Endpoint to retrieve all clients on coach
    @GetMapping("/{name}/clients")
    public Set<Client> getClientsFromCoach(@PathVariable ("name") String coachName) {
        return coachRepository.getClients();
    }

    // Post a new client to the coach
     @PostMapping("/postClient")
    public Coach postClientToCoach (@RequestBody Client client ) {
        Client registredClient = clientRepository.createClient(client);
        return coachRepository.assignClientToACoach(registredClient);
    }

    // Deletes a client from coach
    @DeleteMapping("/deleteClient") 
        public Coach deleteClient (@RequestBody  Client client) {
            Client existingClient = clientRepository.getClient(client.getName());

            return coachRepository.removeAClientFromACoach(existingClient);
        }
    }






 
/* 

    // Retrieve information of a client by name
    @GetMapping("/{clientName}")
    public Coach getClient(@PathVariable("clientName") String clientName) {
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
    */
    

