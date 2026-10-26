package com.example.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.training.model.Client;
import com.example.training.model.Coach;
import com.example.training.repository.CoachRepository;


@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);

		Coach coach = new Coach("Bjarne Myr", 18, "bjarne@outlook.com", "1902", "Bjørnestien 19");
		CoachRepository coachRepository = new CoachRepository();
		Client client1 = new Client("Cecilie", 240, "ceciliedanbolt@outlook.com", "94891902", "Kanatareleln 5 ", "Premimum", null);
		Client client2 = new Client("Alba", 240, "ceciliedanbolt@outlook.com", "94891902", "Kanatareleln 5 ", "Premimum", null);

		coachRepository.assignClientToACoach(client1, coach);
		coachRepository.assignClientToACoach(client2, coach);
		System.out.println(coach.getClients());
		coachRepository.removeAClientFromACoach(client1, coach);

		System.out.println(coach.getClients());

	}

}
