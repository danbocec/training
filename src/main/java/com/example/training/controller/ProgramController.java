package com.example.training.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;
import com.example.training.repository.ProgramRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/program")
public class ProgramController {

// Lage API for å legge til, endre og fjerne øvelser i programmet 

// Lage API for å  hente og opprette en klients program
// /program/getClient/getProgram
// /program/getClient/postProgram

   private final ProgramRepository programRepository;
   public ProgramController(ProgramRepository programRepository) {
    this.programRepository = programRepository;
}



    // Henter ut alle programmene som er lagt til
    @GetMapping("/getPrograms")
    public List<Program> getPrograms () {
        return programRepository.getAllPrograms();
    }

    @PostMapping("/postProgram")
    public Program createProgram(@RequestBody Program program) {
        return programRepository.createNewProgram(program);
    }


    @GetMapping("/{programID}")
    public Program getProgramID  (@PathVariable ("programID") int programID) {
        return programRepository.getProgramID(programID);
    }

    
    @PostMapping("/{programID}/postExercise")
    public ProgramExercise addExerciseInProgram (@PathVariable ("programID") int programID, @RequestBody ProgramExercise programExercise) {
        return programRepository.addProgramExerciseToProgram(programID, programExercise.getExercise(), programExercise.getSets(), programExercise.getRepetitions());
    }





    
/* 
    @PostMapping("/getProgram/addExercise")
    public ExerciseProgram addExerciseToProgram(@RequestBody Program program, Exercise exercise) {
        return program.addExercise(exercise);
    }
        */




}
