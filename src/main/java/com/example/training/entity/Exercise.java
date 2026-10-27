package com.example.training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String exerciseName;

    protected Exercise() {
    }

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Long getId() {
        return id;
    }
    

    public String getExerciseName() {
        return exerciseName;
    }


}
