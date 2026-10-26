package com.example.training.classesTest;

import org.junit.jupiter.api.Test;

import com.example.training.model.Client;
import com.example.training.model.Coach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoachTest {
    @Test
    void testAddClient() {
        Coach coach1 = new Coach("Mike Johnson", 40, "mike.johnson@example.com", "555-1234", "789 Pine Rd");
        Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium", null);

        coach1.addClient(client1);
        assertTrue(coach1.getClients().contains(client1));

    }
    @Test 
    void testRemoveClient() {
         Coach coach1 = new Coach("Mike Johnson", 40, "mike.johnson@example.com", "555-1234", "789 Pine Rd");
        Client client1 = new Client("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St", "Premium", null);
         Client client2 = new Client("Jane Smith", 25, "jane.smith@example.com", "098-765-4321", "456 Oak Ave", "Basic", null);

        coach1.addClient(client1);
        coach1.addClient(client2);
        
        coach1.removeClient(client1);
        assertFalse(coach1.getClients().contains(client1));
        assertTrue(coach1.getClients().contains(client2));
        assertEquals(1, coach1.getClients().size());  


    }
}