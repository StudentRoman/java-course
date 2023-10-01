package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeronTest {
    @Test
    @DisplayName("Should calculate the square root correctly")
    void testHeronSqrt() {
        Heron heron = new Heron();

        double current = 16;
        double expected = Math.sqrt(current);

        assertEquals(expected, heron.heronSqrt(16));
    }

    @Test
    @DisplayName("Should calculating the square root of a number that is not a perfect square correctly")
    void testHeronSqrtNotPerfectSquare() {
        Heron heron = new Heron();

        double current = 3;
        double expected = Math.sqrt(current);

        assertEquals(expected, heron.heronSqrt(3));
    }

    @Test
    @DisplayName("Should correctly process a special cases")
    void testHeronSqrtNegativeNumber() {
        Heron heron = new Heron();

        assertEquals(Math.sqrt(0), heron.heronSqrt(0));
        assertEquals(Math.sqrt(-0), heron.heronSqrt(-0));
        assertEquals(Math.sqrt(-4), heron.heronSqrt(-4));
        assertEquals(Math.sqrt(Double.POSITIVE_INFINITY), heron.heronSqrt(Double.POSITIVE_INFINITY));
        assertEquals(Math.sqrt(Double.NEGATIVE_INFINITY), heron.heronSqrt(Double.NEGATIVE_INFINITY));
        assertEquals(Math.sqrt(Double.NaN), heron.heronSqrt(Double.NaN));
    }
}