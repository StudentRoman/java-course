package edu.penzgtu.oop;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> {
    private void merge(ArrayList<T> array, ArrayList<T> leftArray, ArrayList<T> rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                array.set(k++, leftArray.get(i++));
            } else {
                array.set(k++, rightArray.get(j++));
            }
        }

        while (i < left) {
            array.set(k++, leftArray.get(i++));
        }

        while (j < right) {
            array.set(k++, rightArray.get(j++));
        }
    }

    public void sortArray(ArrayList<T> array) {
        int arrayLength = array.size();

        if (arrayLength < 2) {
            return;
        }

        int mid = arrayLength / 2;
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftArray.add(array.get(i));
        }

        for (int i = mid; i < arrayLength; i++) {
            rightArray.add(array.get(i));
        }

        sortArray(leftArray);
        sortArray(rightArray);

        merge(array, leftArray, rightArray, mid, arrayLength - mid);
    }
}
