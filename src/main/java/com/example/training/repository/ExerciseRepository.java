package com.example.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.training.model.Exercise;

public class ExerciseRepository {

    Exercise exercise1 = new Exercise("Knebøy");
    Exercise exercise2 = new Exercise("Benkpress");

    private final List<Exercise> exerciseList = new ArrayList<>(List.of(exercise1, exercise2));


    // Finds already existing exercise
    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public List<Exercise> createNewExercise (Exercise exercise) {
        for (Exercise existingExercise : exerciseList) {
            if (existingExercise.getExerciseName().equalsIgnoreCase(exercise.getExerciseName())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Exercise already exists " + existingExercise.getExerciseName());
            }
        }
        exerciseList.add(exercise);
        return exerciseList;

    }



}
