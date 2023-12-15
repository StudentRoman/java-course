package edu.penzgtu.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("Сортировка слиянием для Integer");
        ArrayList<Integer> arrayIntegers = new ArrayList<>(Arrays.asList(72, 31, 80, 99, 66, 51, 27, 79, 86, 35, 98, 67, 69, 78, 29, 43, 83, 95, 71, 55, 87));
        MergeSort<Integer> integerMergeSort = new MergeSort<>();
        integerMergeSort.sortArray(arrayIntegers);
        System.out.println(arrayIntegers);

        System.out.println("Сортировка слиянием для Double");
        ArrayList<Double> arrayDoubles = new ArrayList<>(Arrays.asList(1.34, 8.0, 6.98, 7.89, 2.9, 4.3, 8.3, 6.67, 5.5, 8.7, 9.2, 7.6, 9.1, 3.3, 2.3, 0.59, 9.0));
        MergeSort<Double> doubleMergeSort = new MergeSort<>();
        doubleMergeSort.sortArray(arrayDoubles);
        System.out.println(arrayDoubles);

        System.out.println("Сортировка слиянием для String");
        ArrayList<String> arrayStrings = new ArrayList<>(Arrays.asList("Jane", "Harry", "Mike", "Emily", "Max", "Alice", "Bob", "Carol", "Tim", "Kate", "Sam", "Tom", "Laura", "Adam", "Olivia", "Paul", "Simon", "Jenny", "Josh", "Rita"));
        MergeSort<String> stringMergeSort = new MergeSort<>();
        stringMergeSort.sortArray(arrayStrings);
        System.out.println(arrayStrings);
    }
}
