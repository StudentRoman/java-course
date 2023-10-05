package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Sensor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите показания: ");
        String userInput = scanner.nextLine();

        System.out.println("Сортировка по возрастанию 1 - id; 2 - средняя температура: ");
        int option = scanner.nextInt();

        double[][] dataArray = transformData(userInput);

        if (option == 1) {
            Arrays.sort(dataArray, Comparator.comparingDouble(a -> a[0]));
            outputData(dataArray);
        } else {
            Arrays.sort(dataArray, Comparator.comparingDouble(a -> a[1]));
            outputData(dataArray);
        }
    }

    private static void outputData(double[][] array) {
        for (double[] element : array) {
            if (element[0] != 0) {
                System.out.printf("%.0f %.1f \n", element[0], element[1]);
            }
        }
    }

    public static double[][] transformData(String str) {
        String[] stringsArray = str.split("@");
        double[][] resultArray = new double[stringsArray.length][2];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i][0] = Double.parseDouble(stringsArray[i].substring(0, 2));
            resultArray[i][1] = Double.parseDouble(stringsArray[i].substring(2));
        }

        averageData(resultArray);

        return resultArray;
    }

    public static void averageData(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 1;

            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i][0] == array[j][0]) {
                    array[i][1] += array[j][1];
                    sum++;
                    array[j][0] = 0;
                }
            }

            array[i][1] /= sum;
        }
    }
}