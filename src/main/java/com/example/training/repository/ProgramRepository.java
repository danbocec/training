package com.example.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.model.Client;
import com.example.training.model.Exercise;
import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;

@Repository
public class ProgramRepository {

// Lage API for å legge til, endre og fjerne øvelser i programmet 
// Lage API for å  hente og opprette en klients program
// /program/getClient/getProgram
// /program/getClient/postProgram

    Program program1 = new Program("Upper Body", 1);
    Program program2 = new Program("Lower Body", 0);
    private final List<Program> programs = new ArrayList<>(List.of(program1, program2));


    // Retrives all programs
    public List<Program> getAllPrograms() {
        return programs;
    }

     // Create a new program
    public Program createNewProgram(Program program) {
        for (Program existingProgram : programs) {
            if (existingProgram.getProgramID() == program.getProgramID()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Program already exists with this id " + existingProgram.getProgramID());
            }
        
        }
        programs.add(program);
        return program;

    }


    public Program getProgramID (int programID) {
        for (Program program : programs) {
            if (program.getProgramID() == programID) {
                return program;
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find program with ID: " + programID);
    }



    // Add programExercise with valid sets, repetitions and exercise to selected program with programID  
    public ProgramExercise addProgramExerciseToProgram (int programID, Exercise exercise, int sets, int repetitions) {
        if (sets <= 0 || repetitions <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sets and repetitions must be greater than 0");
        }

        for (Program program : programs) {
            if (program.getProgramID() == programID) {
                ProgramExercise programExercise = new ProgramExercise(exercise, repetitions, sets);
                program.addExercise(programExercise);
                return programExercise;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find program with ID" + programID);

    }

    










    
    
}
