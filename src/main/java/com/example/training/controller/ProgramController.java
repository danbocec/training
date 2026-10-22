package com.example.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Client;
import com.example.training.model.Exercise;
import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;
import com.example.training.repository.ClientRepository;
import com.example.training.repository.ProgramRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

@RequestMapping("/program")
public class ProgramController {

// Lage API for å legge til, endre og fjerne øvelser i programmet 

// Lage API for å  hente og opprette en klients program
// /program/getClient/getProgram
// /program/getClient/postProgram

    ProgramRepository programRepository = new ProgramRepository();


    // Henter ut alle programmene som er lagt til
    @GetMapping("/getPrograms")
    public List<Program> getPrograms () {
        return programRepository.getAllPrograms();
    }

    @PostMapping("/postProgram")
    public Program createProgram(@RequestBody Program program) {
        return programRepository.createNewProgram(program);
    }


}
    /* 
 
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
        */
