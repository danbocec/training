package com.example.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.training.model.Client;
import com.example.training.model.Exercise;
import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);

		Exercise exercise = new Exercise("Knebøy");

		ProgramExercise programExercise = new ProgramExercise(exercise, 10, 10);


		Program program = new Program("Lower Body", 1);
		

		
		program.addExercise(programExercise);

		Client client1 = new Client("Cecilie", 240, "ceciliedanbolt@outlook.com", "94891902", "Kanatareleln 5 ", "Premimum");

		client1.setProgram(program);


		for (ProgramExercise item: program.getExercises()) {
			System.out.println(item.getExercise().getExerciseName());
		}
		


	}

}
