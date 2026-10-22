package com.example.training.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Client;
import com.example.training.model.Exercise;
import com.example.training.model.Program;
import com.example.training.repository.ClientRepository;
import com.example.training.repository.ExerciseRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

@RequestMapping("/exercise")

public class ExerciseController {

    ExerciseRepository exerciseRepository = new ExerciseRepository();


    // Henter ut alle programmene som er lagt til
    @GetMapping("/getExercises")
    public List <Exercise> getExercise () {
        return exerciseRepository.getExerciseList();
    }

    // Posts new exercise
     @PostMapping("/postNewExercise")
    public List<Exercise> createNewExercise(@RequestBody Exercise exercise) {
        return exerciseRepository.createNewExercise(exercise);
    }
        
    
}
