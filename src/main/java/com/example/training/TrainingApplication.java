package com.example.training;

import com.example.training.controller.ProgramController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.training.model.Client;
import com.example.training.model.Coach;
import com.example.training.model.Program;
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
