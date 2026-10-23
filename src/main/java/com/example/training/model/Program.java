package com.example.training.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Program {
    private String programName;
    private final int id;
    private List<ProgramExercise> workout = new ArrayList<ProgramExercise>();


    public Program(String programName, @JsonProperty("programID") int id) {
        this.programName = programName;
        this.id = id;

    }

    // Getters and Setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getProgramID () {
        return this.id;
    }

    public List<ProgramExercise> getExercises() {
        System.out.println("The program exercise consist of following workout: " + workout);
        return workout;
    }

    public void addExercise(ProgramExercise exercise) {
        if (workout.contains(exercise)) {
            return;

        }
        workout.add(exercise);
    }

    public void removeExercise(ProgramExercise exercise) {
        if (workout.remove(exercise)) {
            System.out.println("Exercise " + exercise.getExercise().getExerciseName() + " removed from the program.");
        } else {
            System.out.println("Exercise " + exercise.getExercise().getExerciseName() + " is not in the program.");
        }
    }
    
}
