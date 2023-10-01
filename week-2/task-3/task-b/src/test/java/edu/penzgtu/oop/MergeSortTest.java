package edu.penzgtu.oop;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    @DisplayName("Should sorting correctly")
    void testMergeSort() {
        int[] current = {4, 1, -2, 3, 5};
        int[] expected = {-2, 1, 3, 4, 5};

        MergeSort sort = new MergeSort();
        sort.sortArray(current);

        assertArrayEquals(expected, current);
    }

    @Test
    @DisplayName("Should sorting correctly with sorting list")
    void testSortingMergeSort() {
        int[] current = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};

        MergeSort sort = new MergeSort();
        sort.sortArray(current);

        assertArrayEquals(expected, current);
    }

    @Test
    @DisplayName("Should sorting correctly with reversed sorting list")
    void testReverseMergeSort() {
        int[] current = {4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4};

        MergeSort sort = new MergeSort();
        sort.sortArray(current);

        assertArrayEquals(expected, current);
    }

    @Test
    @DisplayName("Should sorting correctly with recurring element list")
    void testRecurringMergeSort() {
        int[] current = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};

        MergeSort sort = new MergeSort();
        sort.sortArray(current);

        assertArrayEquals(expected, current);
    }
}