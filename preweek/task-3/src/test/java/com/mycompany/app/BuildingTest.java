package com.mycompany.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BuildingTest {
    @Test
    @DisplayName("Should calling the elevator to the floor")
    void testCallElevator() {
        Building building = new Building(14, 3);

        assertEquals("Elevator 1 arrived at 14 floor", building.callElevator(14));
        assertEquals("Elevator 3 arrived at 7 floor", building.callElevator(7));
        assertEquals("Elevator 3 arrived at 2 floor", building.callElevator(2));
    }

    @Test
    @DisplayName("Should return null if calling an elevator to a non-existent floor")
    void testCallElevatorNonExistentFloor() {
        Building building = new Building(14, 3);

        assertNull(building.callElevator(16));
    }

    @Test
    @DisplayName("Should calling the elevator to the floor without a constructor with parameters")
    void testCallElevatorWithoutParameters() {
        Building building = new Building();

        assertEquals("Elevator 1 arrived at 5 floor", building.callElevator(5));
        assertEquals("Elevator 1 arrived at 9 floor", building.callElevator(9));
        assertEquals("Elevator 3 arrived at 3 floor", building.callElevator(3));
    }
}