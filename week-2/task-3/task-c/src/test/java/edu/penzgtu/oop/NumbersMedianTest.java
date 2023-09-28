package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersMedianTest {
    @Test
    @DisplayName("Should correctly identify prime numbers")
    void testNumbersMedian() {
        NumbersMedian median = new NumbersMedian();
        int[] numbers = {1, 2, 3, 4};

        assertEquals(2.5, median.getArrayMedian(numbers));
    }
}