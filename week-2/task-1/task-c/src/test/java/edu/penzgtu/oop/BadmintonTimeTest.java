package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadmintonTimeTest {
    @Test
    @DisplayName("Should output \"Yes\" if today is Sunday and the weather is good")
    void testIsGoodTimeForBadminton() {
        BadmintonTime badminton = new BadmintonTime();

        assertEquals("Yes", badminton.isGoodTime(true, false, false, "warm", "clear"));
    }

    @Test
    @DisplayName("Should output \"No\" if today is not Sunday and the weather is bad")
    void testIsBadTimeForBadminton() {
        BadmintonTime badminton = new BadmintonTime();

        assertEquals("No", badminton.isGoodTime(false, true, true, "cold", "snow"));
    }
}