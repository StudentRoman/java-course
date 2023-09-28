package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeronTest {
    @Test
    @DisplayName("Should calculate the square root correctly")
    void testHeronSqrt() {
        Heron heron = new Heron();

        assertEquals(1.7320508075688772, heron.heronSqrt(3));
        assertEquals(2.23606797749979, heron.heronSqrt(5));
        assertEquals(4, heron.heronSqrt(16));
        assertEquals(10, heron.heronSqrt(100));
    }

    @Test
    @DisplayName("Should correctly process a negative number")
    void testHeronSqrtNegativeNumber() {
        Heron heron = new Heron();

        assertEquals(-1, heron.heronSqrt(-3));
    }
}