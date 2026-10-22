package com.example.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.model.Client;
import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;

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
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Program already exists with either similar " + existingProgram.getProgramName() + "  or " + existingProgram.getProgramID());
            }
        
        }
        programs.add(program);
        return program;

    }







    public List<ProgramExercise>  addExercisesToProgram (List<ProgramExercise> program, ProgramExercise exercise) {
        if (!program.contains(exercise)) {
            throw new Error("Exercise is already in program");
        }
        program.add(exercise);
        return program;
    } 
    
}
