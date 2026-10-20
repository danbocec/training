package com.example.training.classes;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String programName;
    private List<ProgramExercise> workout = new ArrayList<ProgramExercise>();


    public Program(String ProgramName) {
        this.programName = ProgramName;
    }

    // Getters and Setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<ProgramExercise> getExercises() {
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
