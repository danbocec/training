package com.example.training.controller;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.model.Exercise;
import com.example.training.repository.ExerciseRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/exercise")

public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    public ExerciseController (ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


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
