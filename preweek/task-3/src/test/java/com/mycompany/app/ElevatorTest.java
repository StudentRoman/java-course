package com.mycompany.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorTest {
    @Test
    @DisplayName("Should get elevator id working correctly")
    void getId() {
        Elevator elevator = new Elevator(0);

        assertEquals(0, elevator.getId());
    }

    @Test
    @DisplayName("Should set elevator id working correctly")
    void setId() {
        Elevator elevator = new Elevator(0);

        elevator.setId(1);
        assertEquals(1, elevator.getId());
    }

    @Test
    @DisplayName("Should get elevator floor working correctly")
    void getCurrentFloor() {
        Elevator elevator = new Elevator(0);

        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Should set elevator floor working correctly")
    void setCurrentFloor() {
        Elevator elevator = new Elevator(0);

        elevator.setCurrentFloor(1);
        assertEquals(1, elevator.getCurrentFloor());
    }
}