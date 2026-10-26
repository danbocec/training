package com.example.training.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.model.Client;
import com.example.training.model.Coach;

public class CoachRepository {


    // Assign a client to a coach
    public Coach assignClientToACoach(Client client, Coach coach) { 
        if (client.getCoach() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client is already assigned coach"); 
        }
        if (!coach.hasClient(client)) {
            coach.addClient(client);
        } else {
            System.out.println("Couldnt add klient to coach");
            return coach;
        }

        return coach;

    }



    // Remove a client from a coach
    public Coach removeAClientFromACoach(Client client, Coach coach) {
        if (!coach.hasClient(client)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client is already removed from coach"); 
        }
        coach.removeClient(client);
        return coach;
    }

}
