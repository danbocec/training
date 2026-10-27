package com.example.training.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Client {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String address;
    private String membershipType;
    private Program program;
    private Coach coach;
    

    public Client(String name, int age, String email, String phoneNumber, String address, String membershipType, Coach coach) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipType = membershipType;
        this.coach = coach;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMembershipType() {
        return membershipType;
    }      

    @JsonIgnore 
    public Coach getCoach() {
        return coach;
    }

    public void  setCoach(Coach coach) {
        this.coach = coach;
    }

    public Program setProgram(Program program) {
        this.program = program;
        System.out.println("Program " + program.getProgramName() + " assigned to client " + this.name + ".");
        return program;
    }

    public Program getProgram() {
        if (program == null) {
            System.out.println("Client " + this.name + " has no program assigned.");
            return null;
        }
        System.out.println("Client " + this.name + " has the following program: " + program.getProgramName());
        return program;
    }
 
    public List<ProgramExercise> getExercises() {
        if (program == null) {
            System.out.println("Client " + this.name + " has no program assigned.");
            return null;
        }
        for (ProgramExercise exercise : program.getExercises()) {
            System.out.println("- " + exercise.getExercise().getExerciseName());
        }
        return program.getExercises();

        }
        
}





