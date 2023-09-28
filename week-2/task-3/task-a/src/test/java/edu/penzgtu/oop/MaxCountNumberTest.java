package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxCountNumberTest {
    @Test
    @DisplayName("Should correctly count the number of maximum numbers")
    void testCountMaxNumber() {
        MaxCountNumber numbers = new MaxCountNumber();
        int[] array = {1, 5, 10, 10, 0, -10};

        assertEquals(2, numbers.getCountMaxNumber(array));
    }
}