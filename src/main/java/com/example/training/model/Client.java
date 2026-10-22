package com.example.training.model;

import java.util.List;

public class Client {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String address;
    private String membershipType;
    private Program program;
    

    public Client(String name, int age, String email, String phoneNumber, String address, String membershipType) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipType = membershipType;

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

    public void setProgram(Program program) {
        this.program = program;
        System.out.println("Program " + program.getProgramName() + " assigned to client " + this.name + ".");
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





