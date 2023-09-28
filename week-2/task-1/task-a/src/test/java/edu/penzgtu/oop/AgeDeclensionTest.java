package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeDeclensionTest {
    @Test
    @DisplayName("Should output the endings of the age correctly")
    void testGetAgeDeclension() {
        AgeDeclension declension = new AgeDeclension();

        assertEquals("год", declension.getAgeDeclension(21));
        assertEquals("года", declension.getAgeDeclension(22));
        assertEquals("лет", declension.getAgeDeclension(18));
    }
}