package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysInMonthTest {
    @Test
    @DisplayName("Should output the number of days of the month correctly")
    void testDaysInMonth() {
        DaysInMonth days = new DaysInMonth();

        assertEquals(31, days.getDaysInMonth(12, 2023));
        assertEquals(30, days.getDaysInMonth(6, 2023));
        assertEquals(28, days.getDaysInMonth(2, 2023));
    }

    @Test
    @DisplayName("Should output the number of days of the month in a leap year correctly")
    void testDaysInMonthTestInLeapYear() {
        DaysInMonth days = new DaysInMonth();

        assertEquals(29, days.getDaysInMonth(2, 2024));
    }
}

