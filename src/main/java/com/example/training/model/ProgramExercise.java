package com.example.training.model;

public class ProgramExercise {
    private final Exercise exerciseName;
    private final int repetitions;
    private final int sets;

    public ProgramExercise(Exercise exerciseName, int repetitions, int sets) {
        if (repetitions < 0) {
            throw new IllegalArgumentException("Repetitions cannot be negative");
        }
        if (sets < 0) {
            throw new IllegalArgumentException("Sets cannot be negative");
        }
        this.exerciseName = exerciseName;
        this.repetitions = repetitions;
        this.sets = sets;
    }

    // Getters and Setters
    public Exercise getExercise() {
        return exerciseName;
    }

    public int setRepetitions() {
        return this.repetitions;
    }

    public int getRepetitions() {
        return repetitions;
    }

     public int setSets() {
        return this.sets;
    }

    public int getSets() {
        return sets;
    }

}
