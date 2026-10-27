package com.example.training;

import com.example.training.controller.ProgramController;
import com.example.training.entity.Client;
import com.example.training.entity.Coach;
import com.example.training.entity.Program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.training.repository.CoachRepository;
import com.example.training.repository.ProgramRepository;


@SpringBootApplication
public class TrainingApplication {

	private final ProgramController programController;
    private final ProgramRepository programRepository;

    TrainingApplication(ProgramRepository programRepository, ProgramController programController) {
        this.programRepository = programRepository;
        this.programController = programController;
    }

    public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);


	}

}
