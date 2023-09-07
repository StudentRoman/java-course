package com.mycompany.app;

import java.util.Arrays;

public class Main {
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int key = array[i];

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 6, 4, 1, 15, 10};
        insertionSort(array); // О(n2)

        System.out.print(Arrays.toString(array));
    }
}