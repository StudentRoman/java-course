package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EratosthenesSieveTest {
    @Test
    @DisplayName("Should correctly identify prime numbers")
    void testIsGoodTimeForBadminton() {
        EratosthenesSieve sieve = new EratosthenesSieve();
        boolean[] correctOutput = {false, false, true, true, false, true};

        assertArrayEquals(correctOutput, sieve.getEratosthenesSieve(5));
    }
}