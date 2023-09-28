package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {
    @Test
    @DisplayName("Should build a pyramid correctly")
    void testGetAgeDeclension() {
        Pyramid pyramid = new Pyramid();

        assertEquals("  #  #\n ##  ##\n###  ###\n", pyramid.pyramidBuilder(3, "#"));
    }
}