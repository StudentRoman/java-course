package edu.penzgtu.oop;

public class MergeSort {

    private static void merge(int[] a, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                a[k++] = leftArray[i++];
            } else {
                a[k++] = rightArray[j++];
            }
        }

        while (i < left) {
            a[k++] = leftArray[i++];
        }

        while (j < right) {
            a[k++] = rightArray[j++];
        }
    }

    public void sortArray(int[] array) {
        int arrayLength = array.length;

        if (arrayLength < 2) {
            return;
        }

        int mid = arrayLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < arrayLength; i++) {
            rightArray[i - mid] = array[i];
        }

        sortArray(leftArray);
        sortArray(rightArray);

        merge(array, leftArray, rightArray, mid, arrayLength - mid);
    }
}
