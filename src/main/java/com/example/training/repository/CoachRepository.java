package com.example.training.repository;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.entity.Client;
import com.example.training.entity.Coach;
import com.example.training.entity.Program;


@Repository 
public class CoachRepository {
    
    private final Coach coach = new Coach("Bjarne Myr", 18, "bjarne@outlook.com", "1902", "Bjørnestien 19");

    public Set<Client> getClients() {
    return coach.getClients();
}

    // Assign a client to a coach
    public Coach assignClientToACoach(Client client) { 
        if (client.getCoach() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client is already assigned coach"); 
        }

        if (!coach.hasClient(client)) {
            coach.addClient(client);
            client.setCoach(coach);
        } else {
            System.out.println("Couldnt add klient to coach");
            return coach;
        }

        return coach;

    }



    // View client's program from coach 
    public Program getProgramFromClient(Client client, Coach coach) {
        if (!coach.hasClient(client)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client doesen't belong to coach"); 
        }
        return client.getProgram();
        
    }
    //Assign progrom to client from coach
    public Program assignProgramToClientFromCoach (Client client, Program program, Coach coach) {
         if (!coach.hasClient(client)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client doesen't belong to coach"); 
        }
        client.setProgram(program);
        return client.getProgram();
    }



    // Remove a client from a coach
    public Coach removeAClientFromACoach(Client client) {
        if (!coach.hasClient(client)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client is already removed from coach"); 
        }
        coach.removeClient(client);
        client.setCoach(null);
        return coach;
    }

}
