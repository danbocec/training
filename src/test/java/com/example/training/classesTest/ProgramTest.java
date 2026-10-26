package com.example.training.classesTest;


import java.util.List;
import org.junit.jupiter.api.Test;

import com.example.training.model.Client;
import com.example.training.model.Exercise;
import com.example.training.model.Program;
import com.example.training.model.ProgramExercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
    @Test
    void testAddExercise() {
        Program program = new Program("Upper Body Strength", 0);
        ProgramExercise exercise1 = new ProgramExercise(new Exercise("Push-ups"), 10, 3);
        ProgramExercise exercise2 = new ProgramExercise(new Exercise("Pull-ups"), 5, 3);

        program.addExercise(exercise1);
        program.addExercise(exercise2);

        List<ProgramExercise> exercises = program.getExercises();
        assertEquals(2, exercises.size());  

        assertTrue(exercises.contains(exercise1));
        assertTrue(exercises.contains(exercise2));
    }

    @Test
    void testRemoveExercise() {
        Program program = new Program("Upper Body Strength", 0);
        ProgramExercise exercise1 = new ProgramExercise(new Exercise("Push-ups"), 10, 3);
        ProgramExercise exercise2 = new ProgramExercise(new Exercise("Pull-ups"), 5, 3);

        program.addExercise(exercise1);
        program.addExercise(exercise2);

        program.removeExercise(exercise1);

        List<ProgramExercise> exercises = program.getExercises();
        assertEquals(1, exercises.size());

        assertFalse(exercises.contains(exercise1));
        assertTrue(exercises.contains(exercise2));
    }

    @Test
    void testGetExercisesFromClient() {
        Program program = new Program("Upper Body Strength", 0);
        ProgramExercise exercise1 = new ProgramExercise(new Exercise("Push-ups"), 10, 3);
        ProgramExercise exercise2 = new ProgramExercise(new Exercise("Pull-ups"), 5, 3);

        Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium", null);

        program.addExercise(exercise1);
        program.addExercise(exercise2);

        List<ProgramExercise> exercises = program.getExercises();
        client1.setProgram(program);

        assertEquals(program, client1.getProgram());
    }

    
    @Test
void testNegativeRepetitionsAreRejected() {
    assertThrows(IllegalArgumentException.class, () -> {
        new ProgramExercise(new Exercise("Push-ups"), -10, 3);
    });
}

 @Test
void testNegativeSetsAreRejected() {
    assertThrows(IllegalArgumentException.class, () -> {
        new ProgramExercise(new Exercise("Push-ups"), 10, -3);
    });



}

}