package com.example.training.classesTest;

import org.junit.jupiter.api.Test;

import com.example.training.entity.Client;
import com.example.training.entity.Exercise;
import com.example.training.entity.Program;
import com.example.training.entity.ProgramExercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;



class ExerciseTest {

    @Test
    void testProgramExerciseCanHaveDifferentSetsAndRepetitions() {
        Exercise exercise = new Exercise("Push-ups");

        ProgramExercise programExercise1 = new ProgramExercise(exercise, 10, 3);
        ProgramExercise programExercise2 = new ProgramExercise(exercise, 5, 5);

        assertSame(exercise, programExercise1.getExercise());
        assertSame(exercise, programExercise2.getExercise());
        
        assertEquals(10, programExercise1.getRepetitions());
        assertEquals(5, programExercise2.getRepetitions());

        assertEquals(3, programExercise1.getSets());
        assertEquals(5, programExercise2.getSets());

    }
    @Test 
    void testIfClientsCanUseSameProgrameExerciseInProgram() {
        Exercise exercise = new Exercise("Push-ups");
        ProgramExercise programExercise1 = new ProgramExercise(exercise, 10, 3);
        ProgramExercise programExercise2 = new ProgramExercise(exercise, 5, 5);

        Program program1 = new Program("Upper Body Strength", 0);
        Program program2 = new Program("Upper Fit Body", 1);

        program1.addExercise(programExercise1);
        program2.addExercise(programExercise2);

       Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium", null);

       Client client2 = new Client("Jane Smith", 25, "jane.smith@example.com", "098-765-4321", "456 Oak Ave", "Premium", null);

       client1.setProgram(program1);
       client2.setProgram(program2);

       // Verify that both clients have their respective programs and exercises
        assertSame(program1, client1.getProgram());
        assertSame(program2, client2.getProgram());

        /* 

        ProgramExercise client1Exercise = client1.getProgram().getExercises();
        ProgramExercise client2Exercise = client2.getExercises().get(0);

        assertSame(programExercise1, client1Exercise);
        assertSame(programExercise2, client2Exercise);  

        assertSame(exercise, client1Exercise.getExercise());
        assertSame(exercise, client2Exercise.getExercise());

       assertEquals(10, client1Exercise.getRepetitions());
       assertEquals(3, client1Exercise.getSets());  
       
       assertEquals(5, client2Exercise.getRepetitions());
       assertEquals(5, client2Exercise.getSets());
       */
    

    }



}
